package Classes;

import java.util.ArrayList;

public class Control {
    public static void main(String args[]) {
        ArrayList totalFile;
        FileReader F1 = new FileReader("temp.txt");
        F1.openFile();
        totalFile = F1.readExamine();
        //
        System.out.println(totalFile);
    }
}
