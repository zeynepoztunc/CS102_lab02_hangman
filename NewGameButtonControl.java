import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
/**
 * Button to start a new hangman game!
 * @author Zeynep Öztunç
 * @version 1 19.07.2021
 */
public class NewGameButtonControl extends JButton implements IHangmanView {

    //properties
    Hangman man;

    //constructor
    public NewGameButtonControl(Hangman man) {
        super();
        this.man = man;

        //sets the text of the buttons
        setText("New Game");

        //sets the background color
        setBackground(Color.PINK);
        setEnabled(false);

        //adds an actionlistener to it
        Click click = new Click();
        addActionListener(click);
    }  
    /**
     * Updates the button depending on the situation of the game
     * @param h, Hangman instance
     */
    public void updateView(Hangman i){
        
        //sets the button enabled if the game is over
        if(man.isGameOver()){
            setEnabled(true);
        }
       
    }

    /**
     * Inner class that implemenents ActionListener!
     */
    class Click implements ActionListener{
        /**
        * Updates the button when the button is clicked
        * @param e, ActionEvent object
        */
        public void actionPerformed(ActionEvent e){  

            //initializes the new game
            man.initNewGame();

            //sets the button disabled
            setEnabled(false);
        }
    }
}
