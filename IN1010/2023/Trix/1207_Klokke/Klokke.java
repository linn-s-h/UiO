
import java.awt.*;
import javax.swing.*;
import java.time.LocalTime;

class Klokke{

    private static String naa(){
        LocalTime t = LocalTime.now();
        return String.format("%02d:%02d:%02d", t.getHour(), t.getMinute(), t.getSecond());
    }

}