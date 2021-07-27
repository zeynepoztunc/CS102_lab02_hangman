import java.awt.*;
import javax.swing.*;
/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		//properties
		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;
		TextFieldControlPanel panel;
		SimpleJFrame frame;
		NewGameButtonControl button;
		LabelsHangmanView label;
		GallowsHangmanView gallow;
		//LetterButtonControls buttons;
		HangmanLetterButtonControls buttonControls;
	
		//inits basicsetup and hangman
		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		//inits the new game button control
		button = new NewGameButtonControl(hangman);

		//inits the labelshangmanview
		label = new LabelsHangmanView(hangman);
		
		//inits the gallowshangmanview
		gallow = new GallowsHangmanView(hangman);

		//inits the hangmanletterbuttoncontrols
		buttonControls = new HangmanLetterButtonControls(hangman, 13, 2);

		//adds an action listener to the hangmanletterbuttons
		HangmanLetterButtonsController listen = new HangmanLetterButtonsController(hangman);
		buttonControls.addActionListener(listen);

		//inits the consoleview
		consoleView = new ConsoleHangmanView();

		//adds the views to the hangman
		hangman.addView( consoleView);
		hangman.addView(label);
		hangman.addView(buttonControls);
		hangman.addView(button);
		hangman.addView(gallow);
;
		//inits the textfieldcontrolpanel and simplejframe
		panel = new TextFieldControlPanel(hangman);
		frame = new SimpleJFrame( "GUIHangman", 	// title
							gallow,			// center
							panel, button,		// north, south
							buttonControls, label );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);

	}

	public static void main( String[] args)
	{
		//inits GUIHangman
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
