package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class MyThread implements Runnable{
    List <Integer> list ;
    int teiler;

    public MyThread(List<Integer> list, int teiler){
        this.list = list;
        this.teiler = teiler;
    }
public void run(){
    list = list.stream().filter(i -> i%teiler == 0).collect(Collectors.toList());
    for (Integer i:list) {
        System.out.println(i);
    }
}
}
