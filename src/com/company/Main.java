package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Teile eingeben: ");
        int teile = Integer.parseInt(sc.nextLine());
        System.out.println("Teiler eingeben");
        int teiler = Integer.parseInt(sc.nextLine());

        Main m = new Main();
        m.readfile();
        m.print(teile,teiler);

    }

    public void readfile() {

        File file = new File("numbers.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(":");
                for (int i = 0; i < arr.length; i++) {

                    if(isint(arr[i])){
                        list.add(Integer.parseInt(arr[i]));
                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isint(String value) {
        try {
            Integer.parseInt(value);
            return true;

        } catch (NumberFormatException n) {
            return false;
        }
    }

    public void print(int teile,int teiler){
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(teile);
        List<Integer> list1 = null;
        int numberofpartstodivide = list.size()/teile;
        for (int i = 0; i < teile; i++) {
            list1 = list.subList(i * numberofpartstodivide,i *numberofpartstodivide + numberofpartstodivide);
            MyThread thread = new MyThread(list1,teiler);
            tpe.execute(thread);


        }
        tpe.shutdown();
        }
    }
