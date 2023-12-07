package com.example.task3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloApplication extends Application {
    public static ArrayList<Account> accounts = new ArrayList<>(); //Arraylist of Account class onjects

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//                FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                // new Scene(fxmlLoader);
        stage.setTitle("ATM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FileReader inputFile = null;  //Initially inputFile is set to null
        try {
            inputFile = new FileReader("AccountDataIn.txt"); //File is initialized which contains accounts woth their ids and opening balances
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Input file is wrapped around try catch to detect exceptions
        Scanner parser = new Scanner(inputFile);
        while (parser.hasNextLine())   //Input file is parsed line by line
        {
            String line = parser.nextLine();  //A single line is obtained as a string
            String[] acc = line.split(" "); //First 2 accounts are separated by a space in between
            for (String elm: acc) //We look through each individual account
            {
                String[] att = elm.split(",");
                System.out.println(att[0]); //It should contain 'C'
                System.out.println(att[1]); //It contains account number
                System.out.println(att[2]); //It contains account balance
                Account account = new Account(Integer.parseInt(att[1]),Double.parseDouble(att[2])); //We initialize a single account object
                accounts.add(account); //We add this account instance to the arrayList of accounts
            }
        }
        launch();
    }

}