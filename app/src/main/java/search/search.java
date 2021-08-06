package search;

import java.util.ArrayList;

public class Search implements SearchImpl {
    private ArrayList<Integer> array = new ArrayList<>();

    public Search(ArrayList<Integer> array) {
        this.array = array;
    }

    private double binarySearch_TotalRuntime, linearSearch_TotalRuntime;

    // return milisecond
    public double nanoToMili(long startTimes, long endTimes) {
        return (double) (endTimes - startTimes) / 1000000;
    }


    public Number binarySearch(Number key, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>(this.array);

        long startTime = System.nanoTime();
        if ( key == null ) {
            binarySearch_TotalRuntime = 0;
            return -1;
        }

        if( low > high  ) {
            long stopTime = System.nanoTime();
            binarySearch_TotalRuntime = nanoToMili(startTime, stopTime);
            return -1;
        }


        int mid = low+(high-low)/2;

        if( key.doubleValue() - list.get(mid).doubleValue()  > 0 )
            return binarySearch(key, mid+1, high);
        else if( key.doubleValue()   -  list.get(mid).doubleValue()  < 0 )
            return binarySearch( key, low, mid-1 );
        else {
            long stopTime = System.nanoTime();
            binarySearch_TotalRuntime = nanoToMili(startTime, stopTime);
            return mid;
        }
    } // binarySearch

    public Number linearSearch(Number key, int low, int high) {
        long startTime = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>(this.array);
        for (int i = low; i <= high; i++) {
            if (list.get(i).doubleValue() == key.doubleValue()) {
                long stopTime = System.nanoTime();
                linearSearch_TotalRuntime = nanoToMili(startTime, stopTime);
                return i;
            }

        } // for
        long stopTime = System.nanoTime();
        linearSearch_TotalRuntime = nanoToMili(startTime, stopTime);
        return -1;
    } // linearSearch

    public double binarySearch_getTotalRuntime() {
        return binarySearch_TotalRuntime;
    }

    public double linearSearch_getTotalRuntime() {
        return linearSearch_TotalRuntime;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(4);

        Search s = new Search(a);

        // s.le
        System.out.println(s.binarySearch(1, 0, a.size() -1));
        System.out.println(s.binarySearch_getTotalRuntime());
        System.out.println(s.linearSearch(1, 0, a.size() -1));
        System.out.println(s.linearSearch_getTotalRuntime());
    }
}
