import java.awt.*;
/**
 * This class synchronizes the text field and the letter buttons
 * @author Zeynep Öztunç
 * @version 1.0 21.07.2021 
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView{

    //properties
    Hangman h;

    //constructor
    public HangmanLetterButtonControls(Hangman h, int row, int column) {
        super(h.getAllLetters(), 13, 2);
        this.h = h;

        //sets the size
        this.setPreferredSize(new Dimension(300, 400));
    }

    //methods
    /**
     * Synchronizes the text field and letter buttons
     * the english alphabet
     * @return allLetters in alphabet
     */
    public void updateView(Hangman man){
        
        //disables the buttons of the used letters
        for (int i = 0; i < h.getUsedLetters().length(); i++) {
            setDisabled(String.valueOf(h.getUsedLetters().charAt(i)));
        }

        //enables all the letter buttons when the game is over
        if(h.isGameOver()){
            setEnabledAll(true);
        }
    }
}
