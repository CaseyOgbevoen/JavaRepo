package Classes;

import java.util.ArrayList;

public class Control {
    public static void main(String args[]) {
        String totalFile;
        FileExaminer F1 = new FileExaminer("randomfile.txt");
        F1.openFile();
        totalFile = F1.readAll();
        System.out.println(totalFile);
    }
}
