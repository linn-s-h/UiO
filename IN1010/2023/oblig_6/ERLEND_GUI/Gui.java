import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Gui {

    public ArrayList<JButton> celleButtonList;
    public JButton startButton;
    public JButton avsluttButton;

    public Gui() {
        celleButtonList = new ArrayList<>();
    }

    public void startGui(String antallCeller) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }
        
        int indexCeller = (int) Math.sqrt(Double.parseDouble(antallCeller));

        // Lag rutenett JPanel
        JPanel rutenettPanel = new JPanel();
        GridLayout rutenettGrid = new GridLayout(indexCeller, indexCeller);
        rutenettPanel.setLayout(rutenettGrid);
        rutenettPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        // Lag the andre JPanel
        JPanel otherPanel = new JPanel();

        // Fyll inn rutenettGrid
        for (int i = 0; i < indexCeller; i++) {
            for (int j = 0; j < indexCeller; j++) {
                JButton celleButton = new JButton();
                celleButton.setBackground(Color.BLACK);
                celleButton.setForeground(Color.BLACK);
                celleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                celleButton.setPreferredSize(new Dimension(15, 15));

                rutenettPanel.add(celleButton, i, j);  
                celleButtonList.add(celleButton);
            }
        }

        // Fyll inn i det andre panelet
        JLabel gameOfLifeLabel = new JLabel("GAME OF LIFE");
        otherPanel.setBackground(Color.BLACK);
        otherPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        gameOfLifeLabel.setFont(new Font("" , Font.BOLD, 24));
        gameOfLifeLabel.setIconTextGap(15);
        gameOfLifeLabel.setForeground(Color.WHITE);
        //otherPanel.setPreferredSize(new Dimension(0, 100));

        startButton = new JButton("START");
        avsluttButton = new JButton("AVSLUTT");
        otherPanel.add(startButton);
        otherPanel.add(gameOfLifeLabel);
        otherPanel.add(avsluttButton);
        
        // Lag og add elements til JFrame
        JFrame vindu = new JFrame();
        vindu.setLayout(new BorderLayout());
        vindu.add(rutenettPanel, BorderLayout.NORTH);
        vindu.add(otherPanel, BorderLayout.SOUTH);

        vindu.pack();
        vindu.setTitle("Game of Life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        vindu.setLocationRelativeTo(null);
        vindu.setResizable(true);
        vindu.getContentPane().setBackground(new Color(50,50,50));
        vindu.setVisible(true);
    }

    public void assignActionListeners(Verden verden) {
        ArrayList<Celle> alleCeller = new ArrayList<>();

        for (int i = 0; i < verden.rutenett.antRader; i++) {
            for (int j = 0; j < verden.rutenett.antKolonner; j++) {
                alleCeller.add(verden.rutenett.rutene[i][j]);
            }
        }

        for (int i = 0; i < celleButtonList.size(); i++) {
            JButton currentButton = celleButtonList.get(i);
            Celle currentCelle = alleCeller.get(i);
            currentButton.addActionListener(new EndreStatus(currentCelle, currentButton));
        }

        startButton.addActionListener(new StartSimulasjon(verden, this));
        avsluttButton.addActionListener((new Avslutt(this)));
        startButton.setBackground(Color.BLACK);
        avsluttButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        avsluttButton.setForeground(Color.WHITE);
    }
}
