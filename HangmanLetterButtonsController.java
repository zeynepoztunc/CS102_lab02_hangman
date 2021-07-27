import java.awt.event.*;
import javax.swing.*;
/**
 * This class decides what happens when clicked on a letter button
 * @author Zeynep Öztunç
 * @version 1.0 21.07.2021 
 */
public class HangmanLetterButtonsController implements ActionListener {

    //properties
    Hangman h;

    //constructor
    public HangmanLetterButtonsController(Hangman h) {
        super();
        this.h = h;
    }

    //methods
    /**
     * Decides what will happen to the buttons when clicked
     * @param e, ActionEvent instance
     */
    public void actionPerformed(ActionEvent e) {
        
        //gets the char on the button clicked
        JButton b = (JButton) e.getSource();
        char ch = b.getText().charAt(0);

        //plays that char using tryThis
        h.tryThis(ch);

        //sets the button disabled
        b.setEnabled(false);
    }
}
