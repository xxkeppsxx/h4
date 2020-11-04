package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<String[]> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {



        System.out.println("Teile eingeben: ");
        int teile = Integer.parseInt(sc.nextLine());
        System.out.println("Teiler eingeben");
        int teiler = Integer.parseInt(sc.nextLine());


        }
        public void readfile(){
            File file = new File("numbers.csv");
            try {
                list = Files.lines(file.toPath())
                        .skip(1)
                        .map(s -> s.split(":"))

                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(list);

        }
}
