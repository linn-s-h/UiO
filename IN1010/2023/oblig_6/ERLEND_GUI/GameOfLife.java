import java.util.*;

public class GameOfLife {

    public Verden verden;

    public GameOfLife(String antallCeller) {

        this.verden = new Verden((int) Math.sqrt(Double.parseDouble(antallCeller)));
        //verden.tegn();

        /*
        while (true) {
            verden.oppdatering();
            verden.tegn();
        }
        */
    }
}
