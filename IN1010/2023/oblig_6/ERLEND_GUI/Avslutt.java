import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Avslutt implements ActionListener {
    
    Gui gui;

    public Avslutt(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
