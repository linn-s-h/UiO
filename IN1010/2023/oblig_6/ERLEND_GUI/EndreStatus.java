import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndreStatus implements ActionListener {

    Celle celle;
    JButton self;

    public EndreStatus(Celle celle, JButton self) {
        this.celle = celle;
        this.self = self;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (celle.erLevende()) {
            celle.settDoed();
            self.setBackground(Color.BLACK);
            self.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        } else {
            celle.settLevende();
            self.setBackground(Color.WHITE);
            self.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }
    }
}
