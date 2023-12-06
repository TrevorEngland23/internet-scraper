import javax.swing.*;
import java.awt.*; // imports BorderLayout

public class Scraper extends JFrame{
    // variables
    JTextField urlToGet;
    JTable table;

    // methods

    //ctor(s)
    public Scraper() {
        super("App Scraper");

        // Layouts

        setLayout(new BorderLayout());

        urlToGet = new JTextField("Enter URL"); // initalizes 
        add(urlToGet, BorderLayout.NORTH); // adds to the JFrame

        String columns[] = {"ID", "NAME", "SALARY"};
        String data[][] = {{"1", "Trevor Engand", "Unemployed"}, {"2", "Amber England", "85000"}, {"3", "Bob Marley", "100000"}};

        table = new JTable(data, columns); // intializes table
        add(table); // adds to JFrame

        // set JFrame visibility / viewing configs...
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
