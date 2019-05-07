package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.interfaces.GameEngine;
import view.NewPlayerForm;
import view.PlayerGUI;

public class PlayerActionListener implements ActionListener, ConstantVariable {

    private GameEngine gameEngine;
    private JFrame jframe;
    private StoreValue st;
    
    public PlayerActionListener(GameEngine gameEngine, StoreValue st) {
        this.gameEngine = gameEngine;
        this.st = st;
    }

    public PlayerActionListener(JFrame jframe) {
        this.jframe = jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
        case VIEW_PLAYER:
            new PlayerGUI(gameEngine, st);
            break;
        case NEW_PLAYER:
            new NewPlayerForm(gameEngine);
            break;
        case PLACE_BET:
            PlacePlayerBet placeBet = new PlacePlayerBet();
            placeBet.init(gameEngine, st.getBetType(), st.getBetAmt());
            break;
        case CLOSE_FRAME:
            this.jframe.setVisible(false);
            break;
        default:
            break;
        }
    }
}
