import javax.swing.*;
import javax.swing.table.*;

import java.awt.*; // imports BorderLayout
import java.awt.event.*;

public class Scraper extends JFrame{
    // variables
    JTextField urlToGet;
    DefaultTableModel tableModel;
    JTable table;
    JTextField regexTextField;
    JButton button;


    //ctor(s)
    public Scraper() {
        super("App Scraper");

        // Layouts

        setLayout(new BorderLayout());

        urlToGet = new JTextField("Enter URL"); // initalizes 
        add(urlToGet, BorderLayout.NORTH); // adds to the JFrame

        // String columns[] = {"ID", "NAME", "SALARY"};
        // String data[][] = {{"1", "Trevor Engand", "0"}, {"2", "Amber England", "85000"}, {"3", "Bob Marley", "100000"}};



        tableModel = new DefaultTableModel(); // intializes table model
        table = new JTable(tableModel); // initalizes JTable 

        tableModel.addColumn("Line #"); // add line number column
        tableModel.addColumn("Result"); // add result column

        JScrollPane scrollPane = new JScrollPane(table); // adds a scrollpane to allow scrolling when data is too large for the JFrame
        add(scrollPane); // adds the scrollPane to the JFrame

        JPanel southJPanel = new JPanel(); // basically a "div", creates a section basically

        regexTextField = new JTextField("Enter REGEX", 20); // instanciate a new text field... 20 is to make the bar on the bottom larger
        southJPanel.add(regexTextField); // add it to the new section we just created.

        button = new JButton("Submit");
        button.addActionListener(e -> searchPage(e)); // lambda for action event
        southJPanel.add(button);

        add(southJPanel, BorderLayout.SOUTH); // append that to the bottom of the screen

        // set JFrame visibility / viewing configs...
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // methods

    public void searchPage(ActionEvent e){
        // todo
    }
}
