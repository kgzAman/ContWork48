package edu.company.Aman;

import edu.company.Aman.Server.Server;

import java.io.IOException;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
//        DataModel dataModel = new DataModel();
//        System.out.println(dataModel.getDay().toString());
        try {
            new Server("localhost", 9889).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
