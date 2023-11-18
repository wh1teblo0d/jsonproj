package org.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        String filePath = "D:\\proshka\\jsonClient\\jsonData\\data.json";
        List<Human> people = new ArrayList<>();

        Scanner askAction = new Scanner(System.in);
        int doAction;

        do {
            System.out.println("1 - New Acc\n2 - See All Acc\n3 - See Age\n4 - See Name\n" +
                    "5 - Choose Acc And Change\n6 - Exit" );
            doAction = askAction.nextInt();

            switch (doAction) {
                case 1 -> {
                    int newAge;
                    String newName;
                    Scanner askData = new Scanner(System.in);

                    System.out.print ("Enter Age:  ");
                    newAge = askData.nextInt();

                    System.out.print ("Enter Name:  ");
                    newName = askData.next();

                    people = readDataFromFile(filePath);

                    Human newHuman = new Human(newAge, newName);
                    people.add(newHuman);
                    addDataToFile(filePath, people);

                }
                case 2 -> {
                    people = readDataFromFile(filePath);
                    for ()


                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
            }


        }while (doAction != 6);

    }


    public static void addDataToFile (String filePath, List<Human> data){
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
            System.out.println("Data added to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Human> readDataFromFile(String filePath) {
        List<Human> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Human>>(){}.getType();
            people = gson.fromJson(reader,listType);


        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return people;
    }

}
