import java.util.ArrayList;
//update i anlamadım hiç ama hiç
/**
 * Subclass of the Hangman class!
 * @author zeynepoztunc 
 * @version 1.0 16.07.2021 
 */
public class HangmanModel extends Hangman {

    //properties
    IHangmanView view;
    ArrayList  <IHangmanView> views;

    //constructor
    public HangmanModel(IHangmanSetup s){
        super(s);
        views = new ArrayList<IHangmanView>();
    }

    //methods
    /**
    * Adds a view to the IHangmanView arraylist!
    * @param view, IHangmanView object
    */
    public void addView( IHangmanView view) {
        views.add(view);
        view.updateView(this);
    }

    /**
    * Updates every value on the IHangmanView arraylist!
    * @param view, IHangmanView object
    */ 
    public void update(){
        for (int i = 0; i < views.size(); i++) {
            views.get(i).updateView(this);   
        }
    }

    /**
    * Checks whether an char is in the word!
    * @param c, char to be tried
    */
    @Override
    public int tryThis(char c){
        int tryChar = super.tryThis(c);
        update();
        return tryChar;
    }

    /**
    * Resets the game!
    */
    @Override
    public void initNewGame(){
        super.initNewGame();
        //update();
    }
   
}
