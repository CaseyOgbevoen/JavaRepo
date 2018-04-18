package Classes;

/***************************************************************************
 * Author: Casey Ogbevoen
 * Date: March/April 2018
 * OS: Windows 10
 * Purpose: The function of this class is to initialise the GUI screen
 *          and all the functionality that occurs once a button is pushed.
 ***************************************************************************/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setSize(500,200);

        //initialise textfields
        fileName = new JTextField("Enter Filename",20);
        newWord = new JTextField("Add Word",21);

        //initialise buttons
        enterFile = new JButton("Enter");
        addWord = new JButton("Add");

        //add components
        add(fileName);
        add(enterFile);

        add(newWord);
        add(addWord);

        //add action listener
        enterFile.addActionListener(this);
        addWord.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent Event) {
        if(Event.getSource() == enterFile) {
            System.out.println("\nFilename: " + fileName.getText());
            FileReader F1 = new FileReader(fileName.getText());
            F1.openFile();
            F1.readExamine();

            JOptionPane.showMessageDialog(this,"File has been Examined! Please look to the System Output for Results.");
        }
        if(Event.getSource() == addWord) {

            //check if word is already in slang file
            int appears = 0;
            Slang textWord = new Slang(newWord.getText());
            appears = appears + textWord.countSlang(newWord.getText());

            if(appears == 1){
                JOptionPane.showMessageDialog(this, "Error. This word is already in the Slang File.");

            }
            else {
                //write word to slang file
                FileReader F2 = new FileReader(newWord.getText());
                F2.appendToFile(newWord.getText());

                System.out.println("Word has been Added!");
                JOptionPane.showMessageDialog(this, "Word has been Added!");
            }
        }

    }
}
