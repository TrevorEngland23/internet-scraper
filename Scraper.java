import javax.swing.*;
import java.awt.*; // imports BorderLayout

public class Scraper extends JFrame{
    // variables
    JTextField urlToGet;

    // methods

    //ctor(s)
    public Scraper() {
        super("App Scraper");

        // Layouts

        setLayout(new BorderLayout());

        urlToGet = new JTextField(); // initalizes 
        add(urlToGet, BorderLayout.NORTH); // adds to the JFrame

        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
