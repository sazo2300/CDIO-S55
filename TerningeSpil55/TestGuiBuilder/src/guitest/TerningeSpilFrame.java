package guitest;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class TerningeSpilFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpilPanel currentPanel;
	
	public TerningeSpilFrame(){
		super("DiceGame55");
		currentPanel = new SpilPanel();
		
		setupPanel();
		
	}
	
	private void setupPanel(){
		this.setContentPane(currentPanel);
		
		
	}
	
	public void start(){
		this.setSize(1100,800);
		this.setVisible(true);
		
		
		//this.setResizable(false);
	}
	
	
	

}
