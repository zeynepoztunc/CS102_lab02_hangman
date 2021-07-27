/**
 * This class contains all the necessary methods to make a hangman game! 
 * The method getSecretWord() is additional
 * @author zeynepoztunc and section 1 students.
 * @version 1.0 13.06.2021 
 */
public class Hangman{

    //properties
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    char blankChar;
    String charsToPreserve;
    IHangmanSetup setup;
    
    private int numberOfIncorrectTries;
    private int maxAllowedIncorrectTries;

    //constructor
    public Hangman(IHangmanSetup setup) {
        this.setup = setup;
        this.initNewGame();	
    }
    
    /**
     * Gets all letters, which is all the letters in
     * the english alphabet
     * @return allLetters in alphabet
     */
    public String getAllLetters(){
        return allLetters.toString();   
    }
    
    /**
     * Gets the letters that has been used by the user
     * @return letters which are used by user 
     */
    public String getUsedLetters(){
        return usedLetters.toString();   
    }
    
    /**
     * Gets the number of incorrect tries
     * @return the value of incorrect tries
     */
    public int getNumOfIncorrectTries(){
        return numberOfIncorrectTries;
    }
    
    /**
     * Gets the maximum allowed incorrect tries
     * @return the value of maximum incorrect tries
     */
    public int getMaxAllowedIncorrectTries(){
        return maxAllowedIncorrectTries;   
    }
    
    /**
     * Gets the word that has been guessed by the user so far
     * @return the word that has been guessed so far 
     */
    public String getKnownSoFar(){
        return knownSoFar.toString();   
    }
    /**
     * Gets the secretWord
     * @return the secretWord
     */
    public String getSecretWord (){
        return secretWord.toString();
    }
    
    /**
     * Determines whether the game is over or not
     * @return whether the game is over or not
     */
    public boolean isGameOver() {
        return (hasLost() || (knownSoFar.toString().equals(secretWord.toString().toLowerCase())));
    }
    
    /** Determines whether user has lost game or not
     * @return true if number of incorrect tries is bigger or equal to the max allowed tries
     */
    public boolean hasLost() {
        return (numberOfIncorrectTries >= maxAllowedIncorrectTries);
    }
    
    /** Randomly chooses a secret word from an array 
     * @return the secret word
     */
    private String chooseSecretWord() {
        String[] words = { "apple", "pencil", "computer", "people", "students", "book", "laptop", "violin", "tiger", "lion" };
        int indexOfWord = ( int ) (Math.random() * (words.length));
        return words[ indexOfWord ];
    }
    
    /** Determines the current state of the letter in the word
     * @param letter, the letter that the user enters
     * @return -3 if the letter has been used before, -2 if the 
     * game is over, -1 if the letter is invalid, otherwise the 
     * occurence of the letter in the word
     */
    public int tryThis( char letter) {
        int occurences;//occurences of the letter in the word
        
        //if the game is over
        if( isGameOver() ) {
            return -3;
        }
        
        // if the char is invalid
        else if( allLetters.indexOf(letter + "") == -1 ) {
            return -1;
        }
        
        else {
            
            // if it is a letter that has not been tried
            if( usedLetters.indexOf(letter + "") == -1) {
                occurences = 0;
                
                //searches the secret word   
                for( int i = 0; i < this.secretWord.length(); i++ ) {
                   
                    //if the letter is in the word
                    if( letter == Character.toLowerCase(this.secretWord.charAt(i)) ) {
                        
                        //updates the occurences and the knownSoFar
                        occurences++;
                        knownSoFar.replace(i, i + 1, letter + ""); //updates knownSoFar
                    }
                }
                
                //adds the letter to usedLetter
                usedLetters.append(letter);
                
                // updates numberOfIncorrectTries if char is not includedd in secretWord
                if( occurences == 0 ) {
                    numberOfIncorrectTries++;
                }
                return occurences;
            }
            return -2; // if letter is used before
        }
    }
    public void initNewGame() {
                this.maxAllowedIncorrectTries = this.setup.getMaxAllowedIncorrectTries();
                this.blankChar = this.setup.getBlankChar();
                this.charsToPreserve = this.setup.getCharsToPreserve();
                this.allLetters = new StringBuffer(this.setup.getAllLetters());
                this.secretWord = new StringBuffer(this.setup.chooseSecretWord());
                this.knownSoFar = new StringBuffer();
                for (int i = 0; i < this.secretWord.length(); ++i) {
                    if (this.charsToPreserve.indexOf(this.secretWord.charAt(i)) >= 0) {
                        this.knownSoFar.append(this.secretWord.charAt(i));
                    }
                    else {
                        this.knownSoFar.append(this.blankChar);
                    }
                }
                this.usedLetters = new StringBuffer();
                this.numberOfIncorrectTries = 0;
    }  
    private boolean isComplete() {
        return !this.existsIn(this.knownSoFar, this.blankChar);
    }
            
    private boolean existsIn(final StringBuffer s, final char c) {
        for (int i = 0; i < s.length(); ++i) {
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(c)) {
                    return true;
            }
        }
        return false;
    } 
} 

