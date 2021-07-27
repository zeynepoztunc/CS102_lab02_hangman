import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
/**
 * LetterButtonControls - keyboard for MVC demo of Hangman, but general.
 *
 * @author David
 * @version 1.00 2012/4/8
 */
public class LetterButtonControls extends JPanel
{
	//properties
	public static TitledBorder border = new TitledBorder("Choose a letter: ");
	
	public LetterButtonControls( String letters)
	{
		this( letters, 13, 2);
		this.setPreferredSize(new Dimension(300,400));
		
	}

	public LetterButtonControls( String letters, int rows, int cols)
	{
		setFont(new Font("Verdana", Font.PLAIN, 18));
		setBorder(border );
		border.setTitleFont(new Font("Verdana", Font.PLAIN, 18));
		setLayout( new GridLayout( rows, cols) );

		for( int i = 0; i < letters.length(); i++) {
			JButton b = new JButton( "" + letters.charAt(i) );
			b.setMargin( new Insets( 1, 2, 1, 2) );
			b.setBackground(Color.lightGray);
			add( b);
		}
	}

	public void addActionListener( ActionListener l)
	{
		Component[] buttons = getComponents();
		for ( Component b : buttons )
		{
			( (JButton) b).addActionListener( l);
		}
	}

	public void setEnabledAll( boolean state)
	{
		for ( Component c : getComponents() ) {
			((JButton) c).setEnabled( state);
		}
	}

	public void setDisabled( String letters)
	{
		for ( Component c : getComponents() ) {
			char ch = ((JButton) c).getLabel().charAt(0);
			if ( letters.indexOf(ch) >= 0)
				((JButton) c).setEnabled( false);
		}
	}
}