import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Kontroll {
    
    public static void start() {
        Gui gui = new Gui();
        GameOfLife gameOfLife = new GameOfLife("500");  
        Kontroll kontroll = new Kontroll(gui, gameOfLife, "500");
    }

    public Kontroll(Gui gui, GameOfLife gameOfLife, String antallCeller) {
        gui.startGui(antallCeller);
        gui.assignActionListeners(gameOfLife.verden); 
    }

    public static void startSimulasjon(Verden verden, Gui gui) {
        while (true) {
            verden.oppdatering();
            ArrayList<Character> celleStatusTegn = verden.hentStatusPaaCeller();

            for (int i = 0; i < gui.celleButtonList.size(); i++) {
                JButton currentButton = gui.celleButtonList.get(i);
                char currentChar = celleStatusTegn.get(i);

                if (currentChar == 'O') {
                    currentButton.setBackground(Color.WHITE);
                    currentButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                } else {
                    currentButton.setBackground(Color.BLACK);
                    currentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
