package visualizer.dataset;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultiRandomArray extends RandomArray {

    private int start_size = 10;
    private int end_size = 50;
    private int step = 2;
    private ArrayList<Integer>[][] array;

    public MultiRandomArray () {}

    public MultiRandomArray (int end_size, int step) {
        this.end_size = end_size;
        arrayGen();
    }

    public MultiRandomArray (int start_size, int end_size, int step) {
        this.start_size = start_size;
        this.end_size = end_size;
        this.step = step;
        arrayGen();
    }

    private void arrayGen() {
        for (int i = this.start_size; i <= this.end_size; i+= this.step) {
            array[][].add(temp_array);
        }
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public static void main(String[] args) {
        
    }

}
