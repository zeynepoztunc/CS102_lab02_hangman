/**
 * Updates the game status!
 * @author zeynepoztunc 
 * @version 1.0 16.07.2021 
 */
public class ConsoleHangmanView implements IHangmanView {
     /**
     * Prints the game status!!!
     * @param h, Hangman instance
     */
    public void updateView(Hangman h ) {
        System.out.println("");

        //prints the secret word
        System.out.println("The secret word is: " + h.getSecretWord());

        //prints the known so far
        System.out.println("Known so far " + h.getKnownSoFar() );

        //prints the tries left
        int triesLeft = h.getMaxAllowedIncorrectTries() - h.getNumOfIncorrectTries();
        System.out.println("You have " + triesLeft + " tries left");

        //prints whether the game is over or not
        System.out.println("Is the game over? " + h.isGameOver());

        //prints the letters that have been used
        System.out.println("Letters that you have used : " + h.getUsedLetters());

        //System.out.println("Is the game lost? " + h.hasLost());
        
    }
}
