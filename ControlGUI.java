package Classes;

//import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ControlGUI extends JFrame implements ActionListener {

    //declare GUI components
    private JTextField fileName;
    private JTextField newWord;
    private JButton enterFile;
    private JButton addWord;

    //constructor
    public ControlGUI (String title){
        super(title);
        setLayout(new FlowLayout());
        setSize(500,500);

        //initialise textfields
        fileName = new JTextField("Enter Filename");
        newWord = new JTextField("Add Word");

        //initialise buttons
        enterFile = new JButton("Enter");
        addWord = new JButton("Add");

        //add components
        add(fileName);
        add(newWord);

        add(enterFile);
        add(addWord);

        //add action listener
        enterFile.addActionListener(this);
        addWord.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent Event) {
        if(Event.getSource() == enterFile) {
            ArrayList totalFile;
            FileReader F1 = new FileReader(fileName.getText());
            F1.openFile();
            totalFile = F1.readExamine();
            System.out.println(totalFile);

            //JOptionPane.showMessageDialog(this,);
        }
        if(Event.getSource() == addWord) {
            //write word to slang file
            FileReader F2 = new FileReader(newWord.getText());
            F2.getFileWriter();
            F2.writeLineToFile(newWord.getText());
        }

    }
}
