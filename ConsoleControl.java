import java.util.Scanner;

// ConsoleControl
// David, 7/4/2013

public class ConsoleControl
{
	public static void controlFor( Hangman hangman)
	{
		Scanner scan = new Scanner( System.in);

		// variables

		Scanner scanner = new Scanner( System.in );
        int triesLeft; //the number of tries left fot the user guess the word
        int gameState; //the state of the letter in the word 
        
        boolean tryAgain; //whether the user wants to play again
        
        char letter; //the letter that the user enters

		// program code
		do {

            //prints welcome message
            System.out.println( "Welcome to Hangman game! ");
            
            //instantiating the HangmanModel class
			hangman = new HangmanModel( new BasicSetup() );

            //adds a view to the hangmanmodel
            //hangman.addView(new ConsoleHangmanView());
            System.out.println();
            //hangman.addView(new ConsoleHangmanView());

            //System.out.println("The secret word is: " + hangman.getSecretWord());
                   
            
            //while the game is not over
            while (!hangman.isGameOver()) {
                
                //prints how many tries the user has left
                //triesLeft = hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries();
                //System.out.println("You have " + triesLeft + " tries left");

                //asks the user to enter a letter
                System.out.print("Please enter a letter: ");
                letter = scanner.next().toLowerCase().charAt(0);

                //checks the relevancy of the entered char with tryThis
                gameState = hangman.tryThis(letter);

                //if the game is over
                if(gameState == -3){
                    tryAgain = false;   
                } 
                
                //if the letter has been tried before
                else if(gameState == -2){
                    System.out.println("You already tried this letter");   
                }
                
                //if the entered character is invalid
                else if (gameState == -1) {
                    System.out.println("The character is invalid");
                }
                
                //if the letter is not in the word
                else if (gameState == 0) {
                    System.out.println("Letter isn't in the word");
                } 
                
                //if the letter is in the word, shows how many times it occurs
                else {
                    System.out.println("Letter is in the word " + gameState + " times");
                }
                 
                //prints the current state of the word
                System.out.println("The word so far: " + hangman.getKnownSoFar());
            }
            
            //if the game has been lost
            if (hangman.hasLost()) {
                
                //lets the user know that they lost and prints the word
                System.out.println("You lost");
                //System.out.println("The word was: " + hangman.secretWord());
            } 
            
            //if the user has won the game, prints congratulations message
            else {
                System.out.println("Congratulations! You won!");
            }
            
            //asks whether the user wants to play again 
            System.out.print( "Press \"y\" to play again: " );
            String answer = scanner.next();
            tryAgain = false;
            
            //if the user presses 'y' or 'Y'
            if ( answer.equalsIgnoreCase( "y" ) ) {
                tryAgain = true;
            }
        }
        while ( tryAgain );
        
        //prints goodbye message
		System.out.println( "\nEnd of ConsoleHangman\n" );

        scan.close();
	}
  
}
