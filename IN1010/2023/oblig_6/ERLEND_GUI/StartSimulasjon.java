import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartSimulasjon implements ActionListener, Runnable {
    
    Verden verden;
    Gui gui;

    public StartSimulasjon(Verden verden, Gui gui) {
        this.verden = verden;
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread traad = new Thread(new StartSimulasjon(verden, gui));
        traad.start();
    }

    @Override
    public void run() {
        Kontroll.startSimulasjon(verden, gui);
    }
}