package game_control;

import game_board.Game_board;
import game_view.GameView;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestOptionPane03 {
	 public TestOptionPane03() {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	           

	                JPanel panel = new JPanel();
	                panel.add(new JLabel("Please make a selection:"));
	                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	                model.addElement("4");
	                model.addElement("5");
	                model.addElement("6");
	                model.addElement("7");
	                model.addElement("8");
	                JComboBox<String> comboBox = new JComboBox<String>(model);
	                panel.add(comboBox);

	                int result = JOptionPane.showConfirmDialog(null, panel, "Number of Player", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	                switch (result) {
	                    case JOptionPane.OK_OPTION:
	                        int num = Integer.parseInt((String) comboBox.getSelectedItem());
	                        Game_board game = new Game_board(num);
	                    	new GameView(game, game.Players[0]);
	                        break;
	                }

	            }
	        });
	 }
	 
}
