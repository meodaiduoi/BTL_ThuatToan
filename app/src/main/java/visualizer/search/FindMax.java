package visualizer.search;

import java.util.ArrayList;
import java.util.Random;

import visualizer.dataset.RandomArray;
public class FindMax implements FindMaxImpl {
    private ArrayList<Integer> array = new ArrayList<>();

    public FindMax(ArrayList<Integer> array) {
        this.array = array;
    }

    private double binaryMax_TotalRuntime, linearMax_TotalRuntime;

    // return milisecond
    public double nanoToMili(long startTimes, long endTimes) {
        return (double) (endTimes - startTimes) / 1000000;
    }

    public Integer linearMax(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>(array);
        int localMax = list.get(low);
        for (int i = 1; i <= high; i++) {
            if((localMax - list.get(i)) < 0)
                localMax = list.get(i);
        }
        return localMax;
    }

    public Integer binaryMax(int low, int high) {
        int  max1, max2 ,localMax;
        int mid;
        ArrayList<Integer> list = new ArrayList<>(array);
        if (low == high) {
            localMax = list.get(low);
        }
        else {
            mid = (low + high) / 2;
            max1 = binaryMax(low, mid);
            max2 = binaryMax(mid+1, high);
            if ((max1 - max2) < 0) {
                localMax = max2;
            } else {
                localMax = max1;
            }
        }
        return localMax;
    }


    @Override
    public double binaryMax_getTotalRuntime() {
        ArrayList<Integer> list = new ArrayList<>(this.array);
        long startTime = System.nanoTime();
        binaryMax(0, list.size() - 1);
        long stopTime = System.nanoTime();
        binaryMax_TotalRuntime = nanoToMili(startTime , stopTime);
        return binaryMax_TotalRuntime;
    }

    @Override
    public double linearMax_getTotalRuntime() {
        ArrayList<Integer> list = new ArrayList<>(this.array);
        long startTime = System.nanoTime();
        linearMax(0, list.size() - 1);
        long stopTime = System.nanoTime();
        linearMax_TotalRuntime = nanoToMili(startTime , stopTime);
        return linearMax_TotalRuntime;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Random rd = new Random();
		for (int i = 0; i < 5000; i++) {
            a.add(10 * rd.nextInt());
        }
        // System.out.println(a.toString());

        FindMax s = new FindMax(new RandomArray(555, true, true, false).getArray());
        System.out.println(s.linearMax_getTotalRuntime());
        System.out.println(s.binaryMax_getTotalRuntime());
    }
}
