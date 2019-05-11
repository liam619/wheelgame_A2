package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.ConstantVariable;
import model.StoreValue;
import model.interfaces.GameEngine;
import view.NewPlayerForm;
import view.PlayerGUI;

public class PlayerActionListener implements ActionListener, ConstantVariable {

    private GameEngine gameEngine;
    private JFrame jframe;
    private StoreValue st;
    private PlayerGUI playerGUI;

    public PlayerActionListener(GameEngine gameEngine, StoreValue st, PlayerGUI playerGUI) {
        this.gameEngine = gameEngine;
        this.st = st;
        this.playerGUI = playerGUI;
    }

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
            new NewPlayerForm(gameEngine, playerGUI);
            break;
        case PLACE_BET:
            new PlacePlayerBet(gameEngine, st.getBetType(), st.getBetAmt());
            break;
        case SPIN_WHEEL:
            new Thread() {
                public void run() {
                    gameEngine.spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
                }
            }.start();
            break;
        case CLOSE_FRAME:
            this.jframe.setVisible(false);
            break;
        default:
            break;
        }
    }
}
