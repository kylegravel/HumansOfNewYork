import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class DisplayResultsFrame extends JFrame {
	
	// database URL
	//static final String DATABASE_URL = "jdbc:derby:"; 
	 ResultsPanel resultsPanel;
	 
	 
	  public DisplayResultsFrame()  {  
	    	 
		  setLayout(new BorderLayout());
	      resultsPanel = new ResultsPanel();
	      
	            
	        
	      
	 } 
	 
	 public static void main( String args[] )  {
		 
		 SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            JFrame fr = new JFrame("Humans of New York");
	            // fr.setSize(1200, 1000);
	            fr.setResizable(false);
	            ResultsPanel resultsPanel = new ResultsPanel();
	            // fr.setVisible(true);
	            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            fr.add(resultsPanel);
	            fr.pack(); //!! added 
	            fr.setVisible(true); // !! moved
	         }
	      });
	   }
	
}
