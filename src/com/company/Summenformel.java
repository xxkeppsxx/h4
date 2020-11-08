package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Summenformel {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Obergrenze : ");
        int obergrenze = Integer.parseInt(sc.nextLine());

        System.out.print("summe :" );
        sumcalc(obergrenze);
    }

    public static void sumcalc(int obergrenze){

        int teile = obergrenze/100 +1;
        int untergrenze = 1;
        int teilobergrenze = 100;
        ExecutorService es = Executors.newFixedThreadPool(teile);

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = null;
        List<Future> listfuture = new ArrayList<>();
        for(int i = untergrenze;i<= obergrenze;i++){
            list.add(i);
        }
        for(int i = 0;i<teile;i++){
            if(teilobergrenze > obergrenze){
                teilobergrenze = obergrenze;
            }
            list2 = list.subList(untergrenze -1,teilobergrenze);
            MyThreadsum ts = new MyThreadsum(list2);
            listfuture.add(es.submit(ts));
            untergrenze += 100;
            teilobergrenze += 100;
        }
        int sum = 0;

        for (Future f:listfuture) {
            try {
                sum += (int)  f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
        System.out.println(sum);

    }
}
