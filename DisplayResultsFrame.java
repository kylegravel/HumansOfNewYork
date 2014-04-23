import java.awt.BorderLayout;
import java.awt.Component;
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
	
	//static final String DATABASE_URL = "jdbc:derby:"; 
	 
	  public DisplayResultsFrame()  {  
	    	
		  //Set size of frame due to landscape vs horizontal images
          setSize(600, 610);
          setResizable(true);
          //setLayout(new BorderLayout());
		  
          //Picture panel inside results panel to handle images
          PicturePanel picturePanel = new PicturePanel();
		  ResultsPanel resultsPanel = new ResultsPanel(picturePanel);
		  	
		  //Add two panels to frame
		  add(resultsPanel, BorderLayout.NORTH);
		  add(picturePanel, BorderLayout.CENTER);
		  	
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	      
	 }
	 
	 //Main
	 public static void main( String args[] )  {
		 
		 new DisplayResultsFrame();
		
	 }
	
}
