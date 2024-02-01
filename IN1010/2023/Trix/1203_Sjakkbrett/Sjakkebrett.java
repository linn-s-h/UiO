
import java.awt.*;
import javax.swing.*;

class Sjakkbrett{

    public static void main(String[] args){

        JFrame vindu = new JFrame();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel brett = new JPanel();
        brett.setLayout(new GridLayout(8,8,0,0));
        vindu.add(brett);

        JButton[][] ruter = new JButton[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ruter[i][j] = new JButton();
                ruter[i][j].setPreferredSize(new Dimension(50,50));
                ruter[i][j].setBorder(BorderFactory.createEmptyBorder());
                brett.add(ruter[i][j]);

                int rute = i + j;
                if (rute % 2 == 0){   //annenhver rute skal være sort
                    ruter[i][j].setBackground(Color.BLACK);
                    ruter[i][j].setOpaque(true);
                } else {
                    ruter[i][j].setBackground(Color.WHITE);
                    ruter[i][j].setOpaque(true);
                }
            }
        }

        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
        vindu.pack();
        vindu.setSize(800,800);
    }
}