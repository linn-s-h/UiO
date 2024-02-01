

import java.awt.*;
import javax.swing.*;

class EksempelGrid{

    public static void main(String[] args){

        JFrame vindu = new JFrame("Navn på vinduet");
        vindu.setLayout(new GridLayout(2, 1));
        vindu.setSize(600,400); //antall pixels
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel toppPanel = new JPanel();
        toppPanel.setLayout(new GridLayout(1,2)); //en slags rutenett (rad, kol)
        vindu.add(toppPanel);

        JLabel tekst = new JLabel("Dette er tekst");
        toppPanel.add(tekst);

        JButton knappV = new JButton();
        toppPanel.add(knappV);

        JButton knappH = new JButton();
        toppPanel.add(knappH);

        JPanel hovedPanel = new JPanel();
        hovedPanel.setLayout(new GridLayout(2,3)); //en slags rutenett (rad, kol)
        //hovedPanel.setPreferedSize(new Dimension(600, 400)) 
        //Dette er en annen måte å endre størrelse på komponenter ved å sende inn et Dimension objekt
        vindu.add(hovedPanel); //tom panel helt til du legger til elementer

        for (int i = 0; i < 6; i++){ //fyller inn rutenettet med kanpper
            JButton knapp = new JButton("Tekst knapp"); //oppretter en knapp som gjør ingenting til å starte med
            hovedPanel.add(knapp);
        }
    
        vindu.pack(); //komprimerer vinduet //hindrer at størrelse blir satt
        vindu.setLocationRelativeTo(null); //midtstiller
        vindu.setVisible(true);
    }


}