
import java.awt.*;
import javax.swing.*;

class KalkulatorView{

    //instansvariabler som holder av verdiene
    private JFrame vindu;
    private JPanel hovedPanel;
    private JLabel tekstTall1;
    private JTextField tekstOmraade1;
    private JLabel tekstTall2;
    private JTextField tekstOmraade2;
    private JLabel tekstResultat;
    private JTextField resultatOmraade;

    private JButton leggTilKnapp;
    private JButton trekkFraKnapp;
    private JButton gangeKnapp;
    private JButton delPaaKnapp;


    public KalkulatorView(){

        vindu = new JFrame("Kalkulator");
        vindu.setSize(600,400); //antall pixels
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hovedPanel = new JPanel();
        hovedPanel.setLayout(new GridLayout(5,2)); //5 rader, 2 kolonner
        vindu.add(hovedPanel); //legger til hovedpanelet i vinduet

        Font tekstFont = new Font("Arial", Font.PLAIN, 30); //font
        tekstTall1 = new JLabel("Tall 1: ");
        hovedPanel.add(tekstTall1);
        tekstOmraade1 = new JTextField();
        tekstOmraade1.setFont(tekstFont);
        hovedPanel.add(tekstOmraade1);

        tekstTall2 = new JLabel("Tall 2: ");
        hovedPanel.add(tekstTall2);
        tekstOmraade2 = new JTextField();
        tekstOmraade2.setFont(tekstFont);
        hovedPanel.add(tekstOmraade2);

        //Resultat område 
        tekstResultat = new JLabel("Resultat: ");
        hovedPanel.add(tekstResultat);
        resultatOmraade = new JTextField();
        resultatOmraade.setFont(tekstFont);
        hovedPanel.add(resultatOmraade);

        //Legger til knappene
        leggTilKnapp = new JButton("+");
        leggTilKnapp.setFont(tekstFont);
        hovedPanel.add(leggTilKnapp);

        trekkFraKnapp = new JButton("-");
        trekkFraKnapp.setFont(tekstFont);
        hovedPanel.add(trekkFraKnapp);

        gangeKnapp = new JButton("*");
        gangeKnapp.setFont(tekstFont);
        hovedPanel.add(gangeKnapp);

        delPaaKnapp = new JButton("/");
        delPaaKnapp.setFont(tekstFont);
        hovedPanel.add(delPaaKnapp);


        vindu.setLocationRelativeTo(null); //midtstiller
        vindu.setVisible(true);
  
    }
}