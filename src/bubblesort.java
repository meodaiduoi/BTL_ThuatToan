package Java.BTL_ThuatToan.src;

import java.util.ArrayList;

public class bubblesort extends sort implements RuntimeClock {

    int loop_count = 0;
    long nano_startTime;
    long nano_endTime;

    ArrayList<Integer> array = new ArrayList<>();

    bubblesort (double[] array, double interval) {
        super(array, interval);
    }

    public double[] sort() {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
        return array;
    }

    @Override
    public long getRuntime() {
        
        return en;
    }
}
