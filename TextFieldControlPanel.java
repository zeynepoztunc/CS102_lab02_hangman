import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Panel with a text field for the user to enter letters!
 * @author Zeynep Öztunç
 * @version 1 19.07.2021
 */
public class TextFieldControlPanel extends JPanel{

    //properties
    Hangman h;
    JTextField textField;

    //constructor
    public TextFieldControlPanel(Hangman h) {
        super();
        this.h = h;

        //inits the text field
        textField = new JTextField();

        //sets the size of the text field
        textField.setPreferredSize(new Dimension(200,20));

        //inits the actionlistener and adds it to the textfield
        Listener listen = new Listener();
        textField.addKeyListener(listen);

        //adds the textfield to the panel
        add(textField);

        //sets the background color
        this.setBackground(Color.pink);
    }
    /**
     * Inner class that implemenents KeyListener!
     */
    class Listener implements KeyListener{
        /**
         * Depends on what happens when a key is pressed
         * @param e, KeyEvent object
         */
        public void keyPressed(KeyEvent e){ 

            //inits letter
            char letter = ' ';
            
            //if the user pressed enter
            if(e.getKeyCode() == KeyEvent.VK_ENTER){

                //gets the letter in the text field
                String input = textField.getText();
                letter = input.charAt(0);

                //plays the letter
                h.tryThis(letter);

                //empties the textfield
                textField.setText("");

                //if the game is over, sets the textfield disabled
                if(h.isGameOver()){
                    //textField.setEnabled(false);
                }
            }
           
        }  
        public void keyTyped(KeyEvent e){ 
            
        }  
        public void keyReleased(KeyEvent e){ 
            
        }  
    }
}
