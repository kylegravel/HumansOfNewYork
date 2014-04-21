import javax.swing.JComboBox;
import javax.swing.JPanel;


public class ResultsPanel extends JPanel {

	public JComboBox<String> genderBox;
	public JComboBox<String> ageBox;
	public JComboBox<String> emotionBox;
	
	
	public ResultsPanel() {
		
		JPanel resultsPanel = new JPanel();
		
		genderBox = new JComboBox<String>(new String[] { "Male", "Female", "Self-Identified" });	
		ageBox = new JComboBox<String>(new String[] { "0-10", "11-20", "21-30" , "31-40", "41-50" , "51-60" , "61-70" , "70+" });
		emotionBox = new JComboBox<String>(new String[] { "Happy", "Proud" , "Angry" , "Sad", "Lonely" , "Beautiful" , "Dissapointed" });
		
		resultsPanel.add(genderBox);
		resultsPanel.add(ageBox);
		resultsPanel.add(emotionBox);
		
		add(resultsPanel);
		
	}
	
	
}
