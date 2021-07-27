import javax.swing.*;
import java.awt.*;
/**
 * Panel that has labels to show the status of the game!
 * @author Zeynep Öztunç
 * @version 1 19.07.2021
 */
public class LabelsHangmanView extends JPanel implements IHangmanView{

    //properties
    Hangman h;
    JLabel incorrect;
    JLabel knownSoFar;
    JLabel usedLetters;
    JLabel hasLost;
    JLabel gameOver;
    JLabel triesLeft;
    int triesleft;
   
    //constructor
    public LabelsHangmanView(Hangman h) {
        super();
        this.h = h;

        //sets the size of the panel
        this.setPreferredSize(new Dimension(350,400));

        //inits the labels
        knownSoFar = new JLabel();
        incorrect = new JLabel();
        usedLetters = new JLabel();
        hasLost = new JLabel();
        gameOver = new JLabel();
        triesLeft = new JLabel();
        
        //sets their background color
        knownSoFar.setForeground(Color.darkGray);
        incorrect.setForeground(Color.darkGray);
        hasLost.setForeground(Color.darkGray);
        usedLetters.setForeground(Color.darkGray);
        gameOver.setForeground(Color.darkGray);
        triesLeft.setForeground(Color.darkGray);

        //sets their font
        knownSoFar.setFont(new Font("Verdana", Font.PLAIN, 18));
        incorrect.setFont(new Font("Verdana", Font.PLAIN, 18));
        hasLost.setFont(new Font("Verdana", Font.PLAIN, 18));
        usedLetters.setFont(new Font("Verdana", Font.PLAIN, 18));
        gameOver.setFont(new Font("Verdana", Font.PLAIN, 18));
        triesLeft.setFont(new Font("Verdana", Font.PLAIN, 18));

        //adds them to the panel
        add(knownSoFar);
        add(incorrect);
        add(usedLetters);
        add(hasLost);
        add(gameOver);
        add(triesLeft);

        //sets the background of the panel
        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Updates the labels depending on the situation of the game
     * @param h, Hangman instance
     */
    public void updateView(Hangman h){
        
        //if the game is over
        if(!h.isGameOver()){

            //the label prints the known so far
            knownSoFar.setText("Known so far is: " + h.getKnownSoFar());

            //the label prints the tries left
            triesleft = h.getMaxAllowedIncorrectTries() - h.getNumOfIncorrectTries();
            triesLeft.setText("You have " + triesleft+ " tries left" );

            //incorrect.setText("Number of incorrect tries is: " + h.getNumOfIncorrectTries());

            //the label prints the used letters
            usedLetters.setText("Used letters are: " + h.getUsedLetters());

            //the label prints whether the game is lost or not
            hasLost.setText("Is the game is lost? : " + h.hasLost());
        }
        else{

            //if the user has lost the game
            if(h.hasLost()){

                //the label prints "lost" message
                gameOver.setText("Sorry! You have lost the game");
                knownSoFar.setText("");
                incorrect.setText("");
                usedLetters.setText("");
                hasLost.setText("");
                triesLeft.setText("");
            }

            //if the user has won the game
            else{

                //the label prints congrats message
                gameOver.setText("Congratulations! You have won");
                knownSoFar.setText("");
                incorrect.setText("");
                usedLetters.setText("");
                hasLost.setText("");
                triesLeft.setText("");
            }
        } 
    }
}
