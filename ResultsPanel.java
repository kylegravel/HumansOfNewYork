import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ResultsPanel extends JPanel
{

    //Instance Variables
    public final JComboBox<String> genderBox;
    public final JComboBox<String> ageBox;
    public final JComboBox<String> emotionBox;

    JOptionPane JOptionPane;

    final PicturePanel picturePanel;

    private int MAX_NUM = 6;    //Represents max images for slide show
    private int MIN_NUM = 0;

    private String filterGender;
    private String filterAge;
    private String filterEmotion;

    private int numberOfPictures = 0;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;

    private boolean connected = false;

    public ResultsPanel(final PicturePanel picturePanel)
    {
        this.picturePanel = picturePanel;

        // create connection to database
        try {
            connection = DriverManager.getConnection("jdbc:derby:humans", null, null);
            connected = true;



            filterAge = "0-10";
            filterGender = "Female";
            filterEmotion = "Ambiguous";
            runSQL();
            updatePictures();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                e.getMessage(), "Database error",
                JOptionPane.ERROR_MESSAGE);
            disconnect();
        }

        super.setLayout(new BorderLayout());

        //Handles JComboBoxes and Submit Button
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(1, 3));

        //picture panel
        JPanel arrayIndexPanel = new JPanel();

        //For next and previous buttons
        JPanel controlPanel = new JPanel();

        //3 comboboxes for data tables
        genderBox = new JComboBox<String>(new String[]{"Male", "Female", "Ambiguous"});
        ageBox = new JComboBox<String>(new String[]{"0-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "70+"});
        emotionBox = new JComboBox<String>(new String[]{"Happy", "Angry", "Sad", "Ambiguous"});

        //JButton submitButton = new JButton("Submit");

        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Previous");

        final JLabel arrayNum = new JLabel("Picture Number: 1" + "     " + " Out Of: " + numberOfPictures);

        //Add 3 comboboxes to combobox panel
        comboBoxPanel.add(genderBox);
        comboBoxPanel.add(ageBox);
        comboBoxPanel.add(emotionBox);

        //Add arrayNum JLabel to panel
        arrayIndexPanel.add(arrayNum);

        //Add buttons to controlPanel
        controlPanel.add(prevButton);
        controlPanel.add(nextButton);

        //Add resultsPanel and picturePanel to frame
        add(comboBoxPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);
        add(arrayIndexPanel, BorderLayout.SOUTH);

        genderBox.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e)
           {
               filterGender = (String) genderBox.getSelectedItem();

               try {
                   runSQL();
                   updatePictures();
                   arrayNum.setText("Picture Number: " + (picturePanel.getPicNum()+1) + "     " + " Out Of: " + numberOfPictures);
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,
                                                 ex.getMessage(), "Database error",
                                                 JOptionPane.ERROR_MESSAGE);
               }


           }
        });

        ageBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                filterAge = (String) ageBox.getSelectedItem();

                try {
                    runSQL();
                    updatePictures();
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum()+1) + "     " + " Out Of: " + numberOfPictures);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                                                  ex.getMessage(), "Database error",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        emotionBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                filterEmotion = (String) emotionBox.getSelectedItem();

                try {
                    runSQL();
                    updatePictures();
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum()+1) + "     " + " Out Of: " + numberOfPictures);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                                                  ex.getMessage(), "Database error",
                                                  JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        //Handles actionlistener for nextButton
        nextButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                //If another picture is in slide show before the end
                if (picturePanel.getPicNum() <= numberOfPictures) {

                    //Set array number to currNum + 1
                    picturePanel.setPicNum(picturePanel.getPicNum() + 1);
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum() + 1) + "     " + " Out Of: " + numberOfPictures);
                    picturePanel.getPicNum();    //For debugging purposes
                    System.out.println(picturePanel.getPicNum());    //For debugging purposes
                    //If reached last image in array
                }
                if (picturePanel.getPicNum() == numberOfPictures) {
                    //set back to first image
                    picturePanel.setPicNum(MIN_NUM);
                    arrayNum.setText("Picture Number: 1" + "     " + " Out Of: " + numberOfPictures);
                }

                picturePanel.repaint();  //Refresh images
                repaint();  //Refresh JLabel

            }
        }); // end call to addActionListener

        //prevButton action listener
        prevButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                //If not the first image in array
                if (picturePanel.getPicNum() > MIN_NUM) {

                    picturePanel.setPicNum(picturePanel.getPicNum() - 1);
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum() + 1) + "     " + " Out Of: " + numberOfPictures);
                    picturePanel.getPicNum();

                    //if first image in array
                } else if (picturePanel.getPicNum() == MIN_NUM) {

                    picturePanel.setPicNum(numberOfPictures - 1);
                    arrayNum.setText("Picture Number: " + numberOfPictures + "     " + " Out Of: " + numberOfPictures);


                }

                picturePanel.repaint(); //Refresh images
                repaint(); //Refresh JLabel

            }
        } ); // end call to addActionListener

    }

    private void runSQL() throws SQLException {
        System.out.println(filterAge + " " + filterGender + " " + filterEmotion);

        preparedStatement = connection.prepareStatement(
                "select image_file from people\n" +
                "    inner join age on people.person_id = age.person_id\n" +
                "    inner join emotion on people.person_id = emotion.person_id\n" +
                "    where age.age_range = ?\n" +
                "       and people.gender = ?\n" +
                "       and emotion.short_desc = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        preparedStatement.setString(1, filterAge);
        preparedStatement.setString(2, filterGender);
        preparedStatement.setString(3, filterEmotion);
        resultSet = preparedStatement.executeQuery();
        metaData = resultSet.getMetaData();
    }

    private void updatePictures() throws SQLException
    {
        ArrayList<String> imageStrings = new ArrayList<String>();

        if (resultSet.next()) {
            resultSet.first();

            do {
                System.out.println("images/" + resultSet.getString("image_file"));
                imageStrings.add("images/" + resultSet.getString("image_file"));
            } while (resultSet.next());
        }

        picturePanel.clearPictures();
        picturePanel.addPictures(imageStrings);

        resultSet.last();
        numberOfPictures = resultSet.getRow() + 1;

        picturePanel.repaint();

    }

    private void disconnect()
    {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connected = false;
        }
    }


}
