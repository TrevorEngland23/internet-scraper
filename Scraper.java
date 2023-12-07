import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.awt.*; // imports BorderLayout
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;


public class Scraper extends JFrame{
    // variables
    JTextField urlToGet;
    DefaultTableModel tableModel;
    JTable table;
    JComboBox<String> regexComboBox;
    JButton button;
    HashSet<String> matches = new HashSet<String>();
    JButton resetButton;


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

        // regexTextField = new JTextField("Enter REGEX", 20); // instanciate a new text field... 20 is to make the bar on the bottom larger
        regexComboBox = new JComboBox<String>();
        regexComboBox.addItem("\\d{3}\\-\\d{3}\\-\\d{4}");
        regexComboBox.addItem("[0-9]");
        regexComboBox.addItem("[A-Za-z0-9\\.]+\\@[A-Za-z0-9]+\\.[A-Za-z0-9]+"); // reference regex slides
        regexComboBox.addItem("<[^>]*>"); // regex for HTML elements
        regexComboBox.addItem("(\\d{1,3}\\.){3}\\d{1,3}"); // regex for ipv4
      

        southJPanel.add(regexComboBox); // add it to the new section we just created.

        button = new JButton("Submit");
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> reset(e));
        button.addActionListener(e -> searchPage(e)); // lambda for action event
        southJPanel.add(button);
        southJPanel.add(resetButton);

        add(southJPanel, BorderLayout.SOUTH); // append that to the bottom of the screen

        // set JFrame visibility / viewing configs...
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

       // methods

    public void reset(ActionEvent e){
        tableModel.setRowCount(0);
    }

    public void searchPage(ActionEvent e){
        tableModel.setRowCount(0); // resets the data upon each click
        try{
        URL url = new URL(urlToGet.getText()); // url passed in

        URLConnection urlConnection = url.openConnection(); // some built in method
        InputStream inputStream = urlConnection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
       
        String line = null;

        while((line = bufferedReader.readLine()) != null){ // while we have lines to read...
            // regex pattern matching
            Pattern pattern = Pattern.compile(regexComboBox.getSelectedItem().toString()); // get the pattern from the regex combo box from above
            Matcher matcher = pattern.matcher(line); // pass in line we are presently evaluating

            // add to our table 

            if(matcher.find()){ // if there is a line to read
                
                if(matches.contains(matcher.group())){
                    // do nothing
                }
                var grouping = matcher.group();
                matches.add(grouping);
                tableModel.addRow(new Object[]{String.valueOf(tableModel.getRowCount() + 1), matcher.group()}); // add a row to our table model, holding a key value pair of row count and a potential match based on the regex the user types in.
            }
        }

        } catch(Exception exception){

        }
    }
}
