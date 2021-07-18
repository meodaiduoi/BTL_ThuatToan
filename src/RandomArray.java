import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;
public class RandomArray {
    private int size = 10;
    private ArrayList<Number> array = new ArrayList<>();
    RandomArray () {
        arrayGenerator(true, false, false, false);
    }

    RandomArray (int size) {
        this.size = size;
        arrayGenerator(true, false, false, false);
    }

    RandomArray(int size, boolean isInt, boolean isSorted, boolean isReversed, boolean isHaftSorted){
        this.size = size;
        arrayGenerator(isInt, isSorted, isReversed, isHaftSorted);
    }

    private void arrayGenerator (boolean isInt, boolean isSorted, boolean isReversed, boolean isHaftSorted) {



        Random rd = new Random();
        if (isInt) {
            for (int i = 0; i < size; i++) {
                // array.add(rd.nextInt((100 + 100) + 1) - 100);
                array.add(rd.nextInt());
            }
        }

        if (!isInt) {
            array.add(rd.nextDouble());
        }


        if (isSorted) {
            //? This Part is retarded but i have no ideal to deal with.
            ArrayList<Double> array = new ArrayList<>();
            for (Number i : this.array) {
                array.add(i.doubleValue());
            }

            Collections.sort(array);

            this.array.clear();
            for (Double i : array) {
                this.array.add(i);
            }

            // gc - save memory
            array = null;
            //? end of retarded part

            if (isReversed) {
                Collections.reverse(this.array);
            }

            if (isHaftSorted) {
                for (int i = 0; i < this.array.size(); i++) {
                    this.array.set(i, rd.nextInt());
                }
            }
        }
    }

    public long getRuntime() {
        return 0;
    }

    public int getLength() {
        return array.size();
    }

    public ArrayList<Number> getArray() {
        return array;
    }

    public Number getElement(int position) {
        return array.get(position);
    }

}
