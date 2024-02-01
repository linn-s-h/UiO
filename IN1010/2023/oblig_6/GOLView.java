
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GOLView implements ActionListener{

    JFrame vindu;
    JPanel toppPanel, hovedPanel;
    JLabel tekstAntLevendeCeller;
    JTextField tekstOmraade;
    JButton startKnapp, avsluttKnapp;

    JButton cKnapp;
    JButton[][] celle;

    int rad, kol;
    GOLKontroll kontroller;
    
    boolean aktiver = true; //aktiver boolean for start knappen

    public GOLView(int rad, int kol, GOLKontroll kontroller){

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }  

        this.rad = rad;
        this.kol = kol;
        this.kontroller = kontroller;
        celle = new JButton[rad][kol];  

        vindu = new JFrame("Game of Life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font tekstFont = new Font("Arial", Font.PLAIN, 14); //font
    
        //Topp-panel for tekstlig beskrivelse av antall levende celler, Start-knapp og Avslutt-knapp
        toppPanel = new JPanel();
        toppPanel.setLayout(new FlowLayout());
        vindu.add(toppPanel, BorderLayout.NORTH);

        //Hoved-panel for cellene
        hovedPanel = new JPanel();
        hovedPanel.setLayout(new GridLayout(rad, kol, 0, 0)); //30 rad, 30 kol //endre dette sendere til input verdi av int
        //hovedPanel.setBorder(BorderFactory.createLineBorder(new Color(170, 51, 106), 20));
        hovedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        vindu.add(hovedPanel, BorderLayout.CENTER);

        //Fyller inn Topp-panel
        tekstAntLevendeCeller = new JLabel("Antall levende celler: ");
        tekstAntLevendeCeller.setFont(tekstFont);
        toppPanel.add(tekstAntLevendeCeller);

        tekstOmraade = new JTextField("0"); //kommer til å sende inn ant levende celler fra kontroller //0 er startverdi
        tekstOmraade.setPreferredSize(new Dimension(50,30));
        tekstOmraade.setFont(tekstFont);
        tekstOmraade.setEditable(false); //fjerner muligheten til å skrive inn i tekst-boksen
        tekstOmraade.setFocusable(false);
        tekstOmraade.setHorizontalAlignment(JTextField.CENTER); //midtstiller innholdet
        toppPanel.add(tekstOmraade);

        //Start-knapp
        startKnapp = new JButton("Start");
        startKnapp.setFont(tekstFont);
        startKnapp.addActionListener(this);
        toppPanel.add(startKnapp);

        //Avslutt-knapp
        avsluttKnapp = new JButton("Avslutt");
        avsluttKnapp.setFont(tekstFont);
        avsluttKnapp.addActionListener(this);
        toppPanel.add(avsluttKnapp);        

        //Nøstet klasse for å finne kordinatene til knappen
        class Celle implements ActionListener{

            int r, k;
            public Celle(int raden, int kolonnen){
                this.r = raden;
                this.k = kolonnen;
            }
            public void actionPerformed(ActionEvent e){

                boolean status = kontroller.oppdaterCelle(r, k);
                kontroller.endreAntLevendeCeller(); 
                oppdaterView(r,k,status);
            }
        }

        //Fyller inn Hoved-Panel
        for (int i = 0; i < rad; i++){ //rad
            for (int j = 0; j < kol; j++){ //kol
                cKnapp = new JButton();
                cKnapp.setPreferredSize(new Dimension(5,5));
                cKnapp.setBackground(new Color(0,0,0,0));
                cKnapp.setOpaque(false);
                cKnapp.addActionListener(new Celle(i,j));

                if (celle[i][j] == null){
                    celle[i][j] = cKnapp;
                }
                hovedPanel.add(cKnapp);
            }
        }

        vindu.setLocationRelativeTo(null); //midtstiller innhold
        vindu.setVisible(true);
        vindu.pack();
        vindu.setSize(800,800); //antall pixels

    }
    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() == avsluttKnapp){
            kontroller.avslutt();
        }
        if(e.getSource() == startKnapp && aktiver){
            aktiver = false; //setter til false sånn at knappen kun kan trykkes en gang
            kontroller.start();
        }
    }
    //Metode for å oppdatere tekstlig beskrivelse av ant levende celler i utsynet
    public void oppdaterAntLevendeCeller(int ant){
        tekstOmraade.setText(String.valueOf(ant));
    }

    
    public void oppdaterView(int r, int k, boolean status){

        /*int R = (int)(Math.random()*195) % 255;
        int G = (int)(Math.random()*195) % 255;
        int B = (int)(Math.random()*195) % 255;
        Color randomFarge = new Color(R,G,B);*/

        if (status == true){
            celle[r][k].setBackground(Color.BLACK);
            celle[r][k].setOpaque(true);

        } else {
            celle[r][k].setBackground(new Color(0,0,0,0));
            celle[r][k].setOpaque(false);
        }
        celle[r][k].repaint();    
    }
    
}