import java.awt.BorderLayout;
import javax.swing.JFrame;

public class DisplayResultsFrame extends JFrame
{
    public DisplayResultsFrame()
    {

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
    public static void main(String args[])
    {

        new DisplayResultsFrame();

    }

}
