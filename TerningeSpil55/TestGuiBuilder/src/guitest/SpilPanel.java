package guitest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;



public class SpilPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1935783544573383497L;
	private JButton buttonRoll;
	private JTextArea textArea0;
	private JTextArea textArea1;
	private SpringLayout currentLayout;
	private int turn;
	private JTextArea scoreBoard1, scoreBoard2;
	private JTextArea infoDie1, infoDie2;
	
	private Image bgImage;
	
			
	private Player player[] = {new Player("Player 1"), new Player("Player 2")};
	
	public SpilPanel() {
		
		
		buttonRoll = new JButton("Throw Dice");
		textArea0 = new JTextArea();
		textArea1 = new JTextArea();
		currentLayout = new SpringLayout();
		scoreBoard1 = new JTextArea();
		infoDie1 = new JTextArea();
		scoreBoard2 = new JTextArea();
		infoDie2 = new JTextArea();
		
		bgImage = Toolkit.getDefaultToolkit().createImage("C:/Users/admin/Pictures/Background.jpg");
		
				
		
		setupPanel();		
		setupListeners();
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
	}
	
	private void setupPanel(){
		setBackground(new Color(0, 0, 0));
		
		this.setOpaque(false);
		this.setLayout(currentLayout);
		
		this.add(buttonRoll);
		this.add(textArea0);
		this.add(textArea1);
		this.add(scoreBoard1);
		this.add(scoreBoard2);
		this.add(infoDie1);
		this.add(infoDie2);
		
		
		
		textArea0.setEditable(false);
		textArea1.setEditable(false);
		textArea0.setText(player[0].getName());
		textArea1.setText(player[1].getName());
		
		scoreBoard1.setEditable(false);
		scoreBoard2.setEditable(false);
		
		infoDie1.setEditable(false);
		infoDie2.setEditable(false);
		
		currentLayout.putConstraint(SpringLayout.WEST, buttonRoll, 168, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, buttonRoll, 11, SpringLayout.NORTH, this);
		
		currentLayout.putConstraint(SpringLayout.NORTH, textArea0, -1, SpringLayout.NORTH, buttonRoll);
		currentLayout.putConstraint(SpringLayout.WEST, textArea0, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.NORTH, textArea1, -1, SpringLayout.NORTH, buttonRoll);
		currentLayout.putConstraint(SpringLayout.EAST, textArea1, -10, SpringLayout.EAST, this);
		
		currentLayout.putConstraint(SpringLayout.WEST, scoreBoard1, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, scoreBoard1, -169, SpringLayout.SOUTH, this);
		
		currentLayout.putConstraint(SpringLayout.EAST, scoreBoard1, -186, SpringLayout.WEST, scoreBoard2);
		currentLayout.putConstraint(SpringLayout.NORTH, scoreBoard2, 0, SpringLayout.NORTH, scoreBoard1);
		currentLayout.putConstraint(SpringLayout.WEST, scoreBoard2, 318, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, scoreBoard2, 0, SpringLayout.EAST, textArea1);
		
		currentLayout.putConstraint(SpringLayout.NORTH, infoDie1, 6, SpringLayout.SOUTH, textArea0);
		currentLayout.putConstraint(SpringLayout.WEST, infoDie1, 10, SpringLayout.WEST, this);
		
		currentLayout.putConstraint(SpringLayout.EAST, infoDie1, -186, SpringLayout.WEST, infoDie2);
		currentLayout.putConstraint(SpringLayout.NORTH, infoDie2, 0, SpringLayout.NORTH, infoDie1);
		currentLayout.putConstraint(SpringLayout.WEST, infoDie2, 318, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, infoDie2, 0, SpringLayout.EAST, textArea1);
	}
	
	Handler handler = new Handler();
	private void setupListeners(){
		buttonRoll.addActionListener(handler);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(!player[0].getVundet() && !player[1].getVundet()){
				
				if(turn%2==0){
					
						player[0].rafl();
						player[0].endturn();
						
						if(player[0].getXtraTurn())
							turn++;
				}
				else{
					
						player[1].rafl();
						player[1].endturn();
						
						if(player[1].getXtraTurn())
							turn++;
					
					}
				turn++;
				scoreBoard1.setText(Integer.toString(player[0].getPoint()>=40 ? 40 : player[0].getPoint()));
				scoreBoard2.setText(Integer.toString(player[1].getPoint()>=40 ? 40 : player[1].getPoint()));
				
				infoDie1.setText(player[0].getDice()[0]+" & "+player[0].getDice()[1]);
				infoDie2.setText(player[1].getDice()[0]+" & "+player[1].getDice()[1]);
				
				
				
			}
			else{
				if(player[0].getVundet())
					JOptionPane.showMessageDialog(null, "Game Over..." + player[0].getName() + " won!");
				else if(player[1].getVundet())
					JOptionPane.showMessageDialog(null, "Game Over..." + player[1].getName() + " won!");
			}
			
			
		}
		
	}
			
		
	}
	
	
	


