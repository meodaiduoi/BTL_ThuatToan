package Java.BTL_ThuatToan;

import java.util.ArrayList;
import 
public class sort {

    protected double[] array;
    protected double interval;
    protected double runtime = 0;
    protected int[] loop = {};

    public sort (double[] array, double interval) {
        this.array = array;
        this.interval = interval;
    }


    public double getRuntime() {
        return runtime;
    }

    public int[] getLoopTimes() {
        return loop;
    }

}
