package com.akka.demo.helloworld.lifecycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Subset {

    private static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> getSubset(int[] a, int m, int i) {
        List<List<Integer>> resList = new ArrayList<>();
        while (i < a.length) {
            list.add(a[i]);
            if (getsum(list) == m) {
                resList.add(list);
                return resList;
            }
            i++;
            getSubset(a, m, i);
            list.remove(list.size() - 1);
        }
        return resList;
    }

    private static int getsum(List<Integer> list) {
        int sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,9};
        System.out.println(Arrays.toString(arr));
        System.out.println(Subset.getSubset(arr, 10, 1));
    }

}
