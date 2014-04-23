import java.awt.BorderLayout;
//import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Array;
import java.util.ArrayList;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultsPanel extends JPanel {

	public JComboBox<String> genderBox;
	public JComboBox<String> ageBox;
	public JComboBox<String> emotionBox;
	
	private int MAX_NUM = 6;	//Represents max images for slideshow
	private int MIN_NUM = 0;
	//public int currNum = 0;
	
	//Array of images
	final ArrayList<Image> slideshowPics = new ArrayList<Image>();
	
	public ResultsPanel(final PicturePanel picturePanel) {
			
		super.setLayout(new BorderLayout());
		
		//Handles JComboBoxes and Submit Button
		JPanel comboBoxPanel = new JPanel();		
		comboBoxPanel.setLayout(new GridLayout(1,3));
		
		//For next and previous buttons
		JPanel controlPanel = new JPanel();

		//3 comboboxes for datatables
		genderBox = new JComboBox<String>(new String[] { "No Gender Filter" , "Male", "Female", "Self-Identified"  });	
		ageBox = new JComboBox<String>(new String[] {"No Age Filter" , "0-10", "11-20", "21-30" , "31-40", "41-50" , "51-60" , "61-70" , "70+" });
		emotionBox = new JComboBox<String>(new String[] {"No Emotion Filter" , "Happy", "Proud" , "Angry" , "Sad", "Lonely" , "Beautiful" , "Dissapointed" });
		
		//JButton submitButton = new JButton("Submit");
		
		JButton nextButton = new JButton("Next");
		JButton prevButton = new JButton("Previous");
				
		comboBoxPanel.add(genderBox);
		comboBoxPanel.add(ageBox);
		comboBoxPanel.add(emotionBox);		
		//resultsPanel.add(submitButton);
		
		controlPanel.add(prevButton);
		controlPanel.add(nextButton);
		
		//Add resultsPanel and picturePanel to frame
		add(comboBoxPanel, BorderLayout.NORTH);
		add(controlPanel, BorderLayout.SOUTH);
		
		//Handles actionlistener for nextButton
		 nextButton.addActionListener(
	    		  new ActionListener() {	    			  
	    			  	    			     	                    
	    			  public void actionPerformed( ActionEvent e ) {    	                                			 
	    				 
	    				  //If another picture is in slideshow before the end
	    				 if (picturePanel.getPicNum() <= MAX_NUM) {
	    		                
	    		                picturePanel.setPicNum(picturePanel.getPicNum() + 1);
	    	                    picturePanel.getPicNum();
	    	                    System.out.println(picturePanel.getPicNum());
	    				 //If reached last image in array
	    				 } if (picturePanel.getPicNum() == MAX_NUM) {
	    					 	//set back to first image
	    					 	picturePanel.setPicNum(0);
	    				 }
	    				 
	    				 picturePanel.repaint();
	    	               
	    			  }
	    		  }// end anonymous inner class
	    ); // end call to addActionListener
		
		 //prevButton action listener
		 prevButton.addActionListener(
	    		  new ActionListener() {	    			  
	    			  	    			     	                    
	    			  public void actionPerformed( ActionEvent e ) {	    	                                	    				 
	    				//If not the first image in array
	    				 if (picturePanel.getPicNum() > MIN_NUM) {
	    		                
	    		                picturePanel.setPicNum(picturePanel.getPicNum() - 1);
	    	                    picturePanel.getPicNum();
	    	                    System.out.println(picturePanel.getPicNum());
	    				 //if first image in array
	    				 } else if (picturePanel.getPicNum() == MIN_NUM) {
	    					 
	    					 	picturePanel.setPicNum(5);
	    					 	
	    					 	
	    				 }
	    				 
	    				 picturePanel.repaint();
	    	               
	    			  }
	    		  }// end anonymous inner class
	    ); // end call to addActionListener
		 
	}
	
	
}
