import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PicturePanel extends JPanel
{

    final ArrayList<Image> slideshowPics = new ArrayList<Image>();

    //Used to keep track of index
    private int currNum = 0;

    public PicturePanel()
    {

        //Add images to array<image>
        slideshowPics.add(new ImageIcon("images/openingImage.jpg").getImage()); //Example image
        slideshowPics.add(new ImageIcon("images/image2.jpg").getImage()); //Marriage Guy
        slideshowPics.add(new ImageIcon("images/image3.jpg").getImage()); //Social Worker Female
        slideshowPics.add(new ImageIcon("images/image4.jpg").getImage()); //Proud Father
        slideshowPics.add(new ImageIcon("images/image5.jpg").getImage()); //Pressured Female
        slideshowPics.add(new ImageIcon("images/image6.jpg").getImage()); //Daughter who won't let go


    }

    //Return current index number
    public int getPicNum()
    {
        return currNum;
    }

    //Set pic number
    //Used for next and previous buttons in ResultsPanel class
    public void setPicNum(int currNum)
    {
        this.currNum = currNum;

    }

    // display image
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);

        // the following values are used to center the image
        double spareWidth = getWidth() - slideshowPics.get(currNum).getWidth(null);
        double spareHeight = getHeight() - slideshowPics.get(currNum).getHeight(null);

        // draw image with scaled width and height
        g.drawImage(slideshowPics.get(currNum),
                    (int) (spareWidth) / 2, (int) (spareHeight) / 2,
                    (int) (slideshowPics.get(currNum).getWidth(null)),
                    (int) (slideshowPics.get(currNum).getHeight(null)), this);
    }
}
