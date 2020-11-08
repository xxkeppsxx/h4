package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyThreadsum implements Callable<Integer>{
    List<Integer> list = new ArrayList<>();
    public MyThreadsum(List<Integer> list){
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = 0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }
}
