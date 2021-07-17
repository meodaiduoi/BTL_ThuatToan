import java.util.ArrayList;
import java.util.Random;

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

    RandomArray(int size, boolean isInt, boolean isSorted, boolean isReversed, boolean isApproximatelyArray){
        this.size = size;
        arrayGenerator(isInt, isSorted, isReversed, isApproximatelyArray);
    }

    private void arrayGenerator (boolean isInt, boolean isSorted, boolean isReversed, boolean isApproximatelyArray) {
        Random rd = new Random();
        if (isInt) {
            for (int i = 0; i < size; i++) {
                array.add(rd.nextInt((100 + 100) + 1) - 100);
                // array.add(rd.nextInt());
            }
        }
        if (isSorted) {
            for (int i = 0; i < size; i++) {
                array.add(i);
            }
        }
        if (isReversed) {
            for (int i = size; i > 0; i--) {
                array.add(i);
            }
        }
        if (isApproximatelyArray) {
            for (int i = 0; i < size; i++) {
                if(i == (size-1)) {
                    Number tmp = array.get(i-1);
                    array.set(i-1, array.get(i - 2));
                    array.set(i - 2, tmp);
                }
                array.add(i);
            }
        }
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
