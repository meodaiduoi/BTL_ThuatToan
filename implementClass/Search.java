
import java.util.ArrayList;
import java.util.Random;
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

        if ( key == null ) {
            binarySearch_TotalRuntime = 0;
            return -1;
        }

        if( low > high  ) {
            return -1;
        }


        int mid = low+(high-low)/2;

        if( key.doubleValue() - list.get(mid).doubleValue()  > 0 )
            return binarySearch(key, mid+1, high);
        else if( key.doubleValue()   -  list.get(mid).doubleValue()  < 0 )
            return binarySearch( key, low, mid-1 );
        else {
            return mid;
        }
    } // binarySearch

    public Number linearSearch(Number key, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>(this.array);
        for (int i = low; i <= high; i++) {
            if (list.get(i).doubleValue() == key.doubleValue()) {
                return i;
            }

        } // for
        
        return -1;
    } // linearSearch

    public double binarySearch_getTotalRuntime() {
        long startTime = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>(this.array);
        binarySearch(list.get(50), 0, list.size() -1);
        long stopTime = System.nanoTime();
        binarySearch_TotalRuntime = nanoToMili(startTime, stopTime);
        return binarySearch_TotalRuntime;
    }

    public double linearSearch_getTotalRuntime() {
        long startTime = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>(this.array);
        linearSearch(list.get(50), 0, list.size() -1);
        long stopTime = System.nanoTime();
        linearSearch_TotalRuntime = nanoToMili(startTime, stopTime);
        return linearSearch_TotalRuntime;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Random rd = new Random();
		for (int i = 0; i < 55; i++) {
            a.add(100 * rd.nextInt());
        }

        Search s = new Search(a);

        System.out.println(s.binarySearch_getTotalRuntime());
        System.out.println(s.linearSearch_getTotalRuntime());
    }
}
