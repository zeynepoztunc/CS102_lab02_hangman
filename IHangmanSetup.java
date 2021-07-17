public interface IHangmanSetup
{
    public static final String version = "v1.0";
    
    int getMaxAllowedIncorrectTries();
    
    char getBlankChar();
    
    String getCharsToPreserve();
    
    String getAllLetters();
    
    String chooseSecretWord();
}
