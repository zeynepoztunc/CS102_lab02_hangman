// import java.util.Scanner;
// /**
//  * ConsoleHangman
//  *
//  * @author
//  * @version 1.00 2013/4/7
//  */

// public class ConsoleHangman
// {
//     public static void main( String[] args)
// 	{
//     	Scanner scan = new Scanner( System.in);

//     	System.out.println( "Start of ConsoleHangman\n");

// 		// VARIABLES
// 		Hangman		hangman;
// 		Scanner scanner = new Scanner( System.in );
//         int triesLeft; //the number of tries left fot the user guess the word
//         int gameState; //the state of the letter in the word 
        
//         boolean tryAgain; //whether the user wants to play again
        
//         char letter; //the letter that the user enters

// 		// PROGRAM CODE
		

// 		// ToDo - allow user to repeatedly enter a letter and tryThis letter
// 		//		  then show game status, until gameover. Finally report win/lose.
// 		do {
            
//             //instantiating the Hangman class
// 			hangman = new Hangman( new BasicSetup() );

// 			System.out.println( hangman.getKnownSoFar() );
           
//             System.out.println("The secret word is: " + hangman.getSecretWord());
            
//             //prints welcome message and the word so far
//             System.out.println( "Welcome to Hangman game! ");
//             System.out.println( hangman.getKnownSoFar() );
            
//             //while the game is not over
//             while (!hangman.isGameOver()) {
                
//                 //prints how many tries the user has left
//                 triesLeft = hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries();
//                 System.out.println("You have " + triesLeft + " tries left");

//                 //asks the user to enter a letter
//                 System.out.print("Please enter a letter: ");
//                 letter = scanner.next().toLowerCase().charAt(0);

//                 //checks the relevancy of the entered char with tryThis
//                 gameState = hangman.tryThis(letter);

//                 //if the game is over
//                 if(gameState == -3){
//                     tryAgain = false;   
//                 } 
                
//                 //if the letter has been tried before
//                 else if(gameState == -2){
//                     System.out.println("You already tried this letter");   
//                 }
                
//                 //if the entered character is invalid
//                 else if (gameState == -1) {
//                     System.out.println("The character is invalid");
//                 }
                
//                 //if the letter is not in the worf
//                 else if (gameState == 0) {
//                     System.out.println("Letter isn't in the word");
//                 } 
                
//                 //if the letter is in the word, shows how many times it occurs
//                 else {
//                     System.out.println("Letter is in the word " + gameState + " times");
//                 }
                
//                 //prints the current state of the word
//                 System.out.println("The word so far: " + hangman.getKnownSoFar());
//             }
            
//             //if the game has been lost
//             if (hangman.hasLost()) {
                
//                 //lets the user know that they lost and prints the word
//                 System.out.println("You lost");
//                 System.out.println("The word was: " + hangman.getSecretWord());
//             } 
            
//             //if the user has won the game, prints congratulations message
//             else {
//                 System.out.println("Congratulations! You won!");
//             }
            
//             //asks whether the user wants to play again 
//             System.out.print( "Press \"y\" to play again: " );
//             String answer = scanner.next();
//             tryAgain = false;
            
//             //if the user presses 'y' or 'Y'
//             if ( answer.equalsIgnoreCase( "y" ) ) {
//                 tryAgain = true;
//             }
//         }
//         while ( tryAgain );
        
//         //prints goodbye message

// 		System.out.println( "\nEnd of ConsoleHangman\n" );
// 	}

// } // end of class ConsoleHangman
