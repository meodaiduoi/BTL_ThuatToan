package search;
import java.util.ArrayList;

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

    public Number binaryMax(int low, int high) {
        Number  max1, max2 ,localMax;
        int mid;
        ArrayList<Number> list = new ArrayList<>(array);
        long startTime = System.nanoTime();
        if (low == high) {
            long stopTime = System.nanoTime();
            binaryMax_TotalRuntime = nanoToMili(startTime, stopTime);
            localMax = list.get(low);
        }
        else {
            mid = (low + high) / 2;
            max1 = binaryMax(low, mid);
            max2 = binaryMax(mid+1, high);
            if ((max1.doubleValue() - max2.doubleValue()) < 0) {
                localMax = max2;
            } else {
                localMax = max1;
            }
        }
        long stopTime = System.nanoTime();
        binaryMax_TotalRuntime = nanoToMili(startTime, stopTime);
        return localMax;
    }

    public Number linearMax(int low, int high) {
        long startTime = System.nanoTime();
        ArrayList<Number> list = new ArrayList<>(array);
        Number localMax = list.get(low);
        for (int i = 1; i <= high; i++) {
            if((localMax.doubleValue() - list.get(i).doubleValue()) < 0)
                localMax = list.get(i);
        }
        long stopTime = System.nanoTime();
        linearMax_TotalRuntime = nanoToMili(startTime, stopTime);
        return localMax;
    }



    @Override
    public double binaryMax_getTotalRuntime() {
        return binaryMax_TotalRuntime;
    }

    @Override
    public double linearMax_getTotalRuntime() {
        return linearMax_TotalRuntime;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(4);

        FindMax s = new FindMax(a);
        System.out.println(s.binaryMax(0, a.size() - 1));
        System.out.println(s.binaryMax_getTotalRuntime());
        System.out.println(s.linearMax(0, a.size() - 1));
        System.out.println(s.linearMax_getTotalRuntime());

    }
}
