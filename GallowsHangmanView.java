import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * Panel that has graphics components that show the hangman and gallow!
 * @author Zeynep Öztunç
 * @version 1 19.07.2021
 */
public class GallowsHangmanView extends JPanel implements IHangmanView{


  //properties
  private Shape[] gallow;
  private Shape[] man;
  private Hangman hangman;

  //constructor
  public GallowsHangmanView(Hangman hangman){
    super();
    this.hangman = hangman;

    //init arrays
    gallow = new Rectangle2D.Double[4];
    man = new Shape[6];
    
    //array to make gallow
    gallow[0] = (new Rectangle2D.Double(50, 10, 150, 15));//bottom rectangle
    gallow[1] = (new Rectangle2D.Double(50, 10, 15, 300));//from bottom vertical
    gallow[2] = (new Rectangle2D.Double(20, 300, 76, 15));//top horizontal
    gallow[3] = (new Rectangle2D.Double(190, 10, 10, 50));//top vertical
  
    //draws the hangman
    //head
    man[0] = new Ellipse2D.Double(172,60,50,50);
    
    //body
    man[1] = new Line2D.Double(195, 110, 195, 200);
    
    //arms
    man[2] = new Line2D.Double(195,135,215,180);
    man[3] = new Line2D.Double(195, 135, 175,180);

    //legs
    man[4] = new Line2D.Double(195,200,175,275);
    man[5] = new Line2D.Double(195,200,215,275);  

    //sets the background color
    this.setBackground(Color.white);
  }
  
  /**
    * Prints the game status!!!
    * @param h, Hangman instance
    */
  public void updateView(Hangman hangman){
    repaint();
  }
  
  /**
  * Prints the gallow and the hangman!!!
  * @param h, Hangman instance
  */
  public void paintComponent(Graphics g){

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    //draws the gallow using rectangles
    for(int i = 0; i < gallow.length; i++){
      g2.fill(gallow[i]);
    }
    
    //draws the body parts based on the number of incorrect tries
    for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++){
    
      g2.draw(man[i]);
    }
  }
}