package game_view;

import java.awt.BorderLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import player.Player;
import provision_cards.Cash;
import provision_cards.Water;
import game_board.Game_board;

public class GameView {
	public Player selected;
	public Vector<JButton> topbar;
	
	public GameView(final Game_board game) {
		this.selected = game.Players[0];
		this.topbar = new Vector<JButton>(10);
		// TODO Auto-generated constructor stub
		final JPanel pane = initPanel();
		JFrame window = new JFrame("Life Boat");	
		
		JMenuItem menuItem;
		JMenu menu;
		
		JMenuBar menuBar = new JMenuBar();
		menu = new JMenu("Mug Somebody");
		menu.setMnemonic(KeyEvent.VK_A);
		//menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		for(int i = 0; i < game.max_Player_num; i++)
		{
			String menu_name = game.Players[i].getCharacter().getName();
			menuItem = new JMenuItem(menu_name);
			//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
			//menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
			menu.add(menuItem);
		}
		menu = new JMenu("Swap place");
		menu.setMnemonic(KeyEvent.VK_A);
		//menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		for(int i = 0; i < game.max_Player_num; i++)
		{
			String menu_name = game.Players[i].getCharacter().getName();
			menuItem = new JMenuItem(menu_name);
			//menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
			//menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
			menu.add(menuItem);
		}
		menu = new JMenu("Row");
		menu.setMnemonic(KeyEvent.VK_A);
		//menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		menu = new JMenu("Skip");
		menu.setMnemonic(KeyEvent.VK_A);
		//menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		window.setJMenuBar(menuBar);
		

		
			JButton button;
		    pane.setLayout(new GridBagLayout());
		    GridBagConstraints c = new GridBagConstraints();
		    Player selected_player = this.selected;


		    button = new JButton(selected_player.getCharacter().getName());

		    change_selected_player(pane, button, c, selected_player, game);
		    
		    for(int i = 0; i < game.max_Player_num; i++)
		    {
		    	 final Player temp = game.Players[game.max_Player_num-i-1];
		    	 String buttonName = temp.getCharacter().getName();
		    	 button = new JButton(buttonName);
		    	 button.addActionListener(new ActionListener() {
					 
		             public void actionPerformed(ActionEvent e)
		             {
		                 //Execute when button is pressed
		                 selected = temp; 
		                 for(int j = 0; j < topbar.size(); j++)
		     		     {
		     		    	 pane.remove(topbar.get(j));
		     		     }
		                 topbar.clear();
		                 
		                 GridBagConstraints c = new GridBagConstraints(); 
		                 JButton button = new JButton(selected.getCharacter().getName());
		                 
		     		    change_selected_player(pane, c, button);
		                 
		                 pane.revalidate();
		                 pane.paint(pane.getGraphics());
		                 
		             }

					private void change_selected_player(final JPanel pane,
							GridBagConstraints c, JButton button) {
						c.weightx = 0.5;
						c.fill = GridBagConstraints.HORIZONTAL;
						c.ipady = 220; 
						c.gridx = 0;
						c.gridy = 0;
						pane.add(button, c);
						topbar.add(button);
				 
						String button_name = "HP: "+selected.getCurrent_hp()+"/"+selected.getCharacter().getSize();
						button = new JButton(button_name);
						c.fill = GridBagConstraints.HORIZONTAL;
						c.weightx = 0.5;
						c.gridx = 1;
						c.gridy = 0;
						pane.add(button, c);
						topbar.add(button);
						
						button_name = "<html>didRow: ";
					    if(selected.getDid_row()) button_name += "YES";
					    else button_name += "NO";
					    button_name += "<br>didFight: ";
					    if(selected.getDid_fight()) button_name += "YES";
					    else button_name += "NO";
					    button_name += "</html>";
					    button = new JButton(button_name);
					    c.fill = GridBagConstraints.HORIZONTAL;
					    c.ipady = 202;
					    c.weightx = 0.5;
					    c.gridx = 2;
					    c.gridy = 0;
					    pane.add(button, c);
					    topbar.add(button);
					    c.ipady = 220;
					    
					    button_name = "Card in Hand: "+selected.cards_in_hand.size();
					    button = new JButton(button_name);
					    c.fill = GridBagConstraints.HORIZONTAL;
					    c.ipady = 220;
					    c.weightx = 0.5;
					    c.gridx = 3;
					    c.gridy = 0;
					    pane.add(button, c);
					    topbar.add(button);
					    
					    for(int i = 0; i < selected.cards_shown.size(); i++)
					    {
					        button_name = ""+selected.cards_shown.get(i);
						    button = new JButton(button_name);
						    c.fill = GridBagConstraints.HORIZONTAL;
						    c.ipady = 180;
						    c.weightx = 0.5;
						    c.gridx = i+4;
						    c.gridy = 0;
						    pane.add(button, c);
						    topbar.add(button);
					    }
					    
					    button = new JButton("Game Log");
						c.fill = GridBagConstraints.HORIZONTAL;
						c.anchor = GridBagConstraints.NORTH;
						c.ipady = 468;      //make this component tall
						c.weightx = 0.5;
						c.gridheight = 3;
						if(game.max_Player_num > 4+selected.cards_shown.size()) c.gridx = game.max_Player_num;
						else c.gridx = 4+selected.cards_shown.size();
						c.gridy = 0;
						pane.add(button, c);
					}
		         });      
		    	 c.fill = GridBagConstraints.HORIZONTAL;
		    	 c.ipady = 220;      //make this component tall
		    	 c.weightx = 0.5;
		    	 c.gridwidth = 1;
		    	 c.gridheight = 1;
		    	 c.gridx = i;
		    	 c.gridy = 1;
		    	 pane.add(button, c);
		    }
		 
		    Player owner = game.curPlayer;
		    int i;
		    for(i = 0; i < owner.cards_in_hand.size(); i++)
		    {
		    	String button_name = "";
		    	if(owner.cards_in_hand.get(i) instanceof Cash) button_name += "Cash: ";
		    	else if(owner.cards_in_hand.get(i) instanceof Water) button_name += "Water: ";
		    	button_name += owner.cards_in_hand.get(i).getID();
		    	button = new JButton(button_name);
		    	c.fill = GridBagConstraints.HORIZONTAL;
		   // c.ipady = 200;       //reset to default
		    //c.weighty = 1.0;   //request any extra vertical space
		    //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		    //c.insets = new Insets(10,0,0,0);  //top padding
		    	c.gridx = i;       //aligned with button 2
		    	c.gridwidth = 1;   //2 columns wide
		    	c.gridy = 2;       //third row
		    	pane.add(button, c);
		    }
	    	String button_name = "You love: ";
	    	button_name += owner.getLove().getName();
	    	button = new JButton(button_name);
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    	c.gridx = i;       
	    	c.gridwidth = 1;   
	    	c.gridy = 2;      
	    	pane.add(button, c);
	    	
	    	button_name = "You hate: ";
	    	button_name += owner.getHate().getName();
	    	button = new JButton(button_name);
	    	c.fill = GridBagConstraints.HORIZONTAL;
	    	c.gridx = i+1;       
	    	c.gridwidth = 1;   
	    	c.gridy = 2;      
	    	pane.add(button, c);
		    
		
		
		/**
		 * TODO: change to grid layout system
		 * instead of absolute positioning
		 */
		//view.add(boardImage);//add chess board to the screen
		

		int xSize = 800;  
		int ySize = 760;  
		window.setSize(xSize,ySize); 
		window.setResizable(false);


		window.setContentPane(pane);
		//window.setResizable(false);
        window.setVisible(true);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void change_selected_player(final JPanel pane, JButton button,
			GridBagConstraints c, Player selected_player, Game_board game) {
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 220; 
		c.gridx = 0;
		c.gridy = 0;
		pane.add(button, c);
		topbar.add(button);
 
		String button_name = "HP: "+selected_player.getCurrent_hp()+"/"+selected_player.getCharacter().getSize();
		button = new JButton(button_name);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);
		topbar.add(button);
		
		button_name = "<html>didRow: ";
	    if(selected.getDid_row()) button_name += "YES";
	    else button_name += "NO";
	    button_name += "<br>didFight: ";
	    if(selected.getDid_fight()) button_name += "YES";
	    else button_name += "NO";
	    button_name += "</html>";
	    button = new JButton(button_name);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 202;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    pane.add(button, c);
	    topbar.add(button);
	    c.ipady = 220;
	    
	    button_name = "Card in Hand: "+selected.cards_in_hand.size();
	    button = new JButton(button_name);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 220;
	    c.weightx = 0.5;
	    c.gridx = 3;
	    c.gridy = 0;
	    pane.add(button, c);
	    topbar.add(button);
	    
	    for(int i = 0; i < selected.cards_shown.size(); i++)
	    {
	        button_name = ""+selected.cards_shown.get(i);
		    button = new JButton(button_name);
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.ipady = 220;
		    c.weightx = 0.5;
		    c.gridx = i+4;
		    c.gridy = 0;
		    pane.add(button, c);
		    topbar.add(button);
	    }
	    
	    button = new JButton("Game Log");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.ipady = 468;      //make this component tall
		c.weightx = 0.5;
		c.gridheight = 3;
		if(game.max_Player_num > 4+selected_player.cards_shown.size()) c.gridx = game.max_Player_num;
		else c.gridx = 4+selected_player.cards_shown.size();
		c.gridy = 0;
		pane.add(button, c);
		topbar.add(button);
	}

	private JPanel initPanel() {
		JPanel result = new JPanel();
        result.setLayout(new BorderLayout());

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	static public void repaint(GameView game) {
		// TODO Auto-generated method stub
	}
}
