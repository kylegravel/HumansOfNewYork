import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ResultsPanel extends JPanel {

	public JComboBox<String> genderBox;
	public JComboBox<String> ageBox;
	public JComboBox<String> emotionBox;
	
	private static Image image1;
	
	
	public ResultsPanel() {
		
		
		
		super.setLayout(new BorderLayout());
		
		//Example for infrastructure appearance 
		image1 = new ImageIcon("images/exampleImage.jpg").getImage(); // get the image
		
		//Handles JComboBoxes and Submit Button
		JPanel resultsPanel = new JPanel();		
		resultsPanel.setLayout(new GridLayout(3,2));
		
		JPanel picturePanel = new JPanel();
		
		genderBox = new JComboBox<String>(new String[] { "Male", "Female", "Self-Identified" });	
		ageBox = new JComboBox<String>(new String[] { "0-10", "11-20", "21-30" , "31-40", "41-50" , "51-60" , "61-70" , "70+" });
		emotionBox = new JComboBox<String>(new String[] { "Happy", "Proud" , "Angry" , "Sad", "Lonely" , "Beautiful" , "Dissapointed" });
		
		JButton submitButton = new JButton("Submit");
		
		JButton nextButton = new JButton("Next");
		JButton prevButton = new JButton("Previous");
		
		//Image JButton -- no action listener
		JButton imageIcon = new JButton();
		imageIcon.setIcon(new ImageIcon(image1));
		
		resultsPanel.add(genderBox);
		resultsPanel.add(ageBox);
		resultsPanel.add(emotionBox);		
		resultsPanel.add(submitButton);
		
		picturePanel.add(prevButton);
		picturePanel.add(imageIcon);
		picturePanel.add(nextButton);
		
		//Add resultsPanel and picturePanel to frame
		add(resultsPanel, BorderLayout.NORTH);
		add(picturePanel, BorderLayout.SOUTH);
		
	}
	
	
}
