import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ResultsPanel extends JPanel
{

    //Instance Variables
    public JComboBox<String> genderBox;
    public JComboBox<String> ageBox;
    public JComboBox<String> emotionBox;

    private int MAX_NUM = 6;    //Represents max images for slide show
    private int MIN_NUM = 0;

    //Array of images
    final ArrayList<Image> slideshowPics = new ArrayList<Image>();

    public ResultsPanel(final PicturePanel picturePanel)
    {

        super.setLayout(new BorderLayout());

        //Handles JComboBoxes and Submit Button
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(1, 3));

        //Submit button
        JPanel arrayIndexPanel = new JPanel();

        //For next and previous buttons
        JPanel controlPanel = new JPanel();

        //3 comboboxes for data tables
        genderBox = new JComboBox<String>(new String[]{"No Gender Filter", "Male", "Female", "Self-Identified"});
        ageBox = new JComboBox<String>(new String[]{"No Age Filter", "0-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "70+"});
        emotionBox = new JComboBox<String>(new String[]{"No Emotion Filter", "Happy", "Proud", "Angry", "Sad", "Lonely", "Beautiful", "Dissapointed"});

        //JButton submitButton = new JButton("Submit");

        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Previous");

        final JLabel arrayNum = new JLabel("Picture Number: 1" + "     " + " Out Of: " + MAX_NUM);

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

        //Handles actionlistener for nextButton
        nextButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                //If another picture is in slide show before the end
                if (picturePanel.getPicNum() <= MAX_NUM) {

                    //Set array number to currNum + 1
                    picturePanel.setPicNum(picturePanel.getPicNum() + 1);
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum() + 1) + "     " + " Out Of: " + MAX_NUM);
                    picturePanel.getPicNum();    //For debugging purposes
                    System.out.println(picturePanel.getPicNum());    //For debugging purposes
                    //If reached last image in array
                }
                if (picturePanel.getPicNum() == MAX_NUM) {
                    //set back to first image
                    picturePanel.setPicNum(MIN_NUM);
                    arrayNum.setText("Picture Number: 1" + "     " + " Out Of: " + MAX_NUM);
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
                    arrayNum.setText("Picture Number: " + (picturePanel.getPicNum() + 1) + "     " + " Out Of: " + MAX_NUM);
                    picturePanel.getPicNum();
                    System.out.println(picturePanel.getPicNum());
                    //if first image in array
                } else if (picturePanel.getPicNum() == MIN_NUM) {

                    picturePanel.setPicNum(MAX_NUM - 1);
                    arrayNum.setText("Picture Number: " + MAX_NUM + "     " + " Out Of: " + MAX_NUM);


                }

                picturePanel.repaint(); //Refresh images
                repaint(); //Refresh JLabel

            }
        } ); // end call to addActionListener

    }


}
