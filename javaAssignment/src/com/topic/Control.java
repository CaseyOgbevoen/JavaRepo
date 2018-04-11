package com.topic;

import java.util.ArrayList;

public class Control {
    public static void main(String args[]) {
        ArrayList List;
        FileReader F1 = new FileReader("temp.txt");

        F1.openFile();
        List = F1.readAll();
        //System.out.println(List);
    }
}