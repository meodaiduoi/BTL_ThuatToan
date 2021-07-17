import java.util.ArrayList;
import java.util.Random;

public class RandomArray {
    private int size = 10;
    private ArrayList<Number> array = new ArrayList<>();
    RandomArray () {
        arrayGenerator(0);
    }

    RandomArray (int size) {
        this.size = size;
        arrayGenerator(0);
    }

    RandomArray (int size, int type_array) {
        this.size = size;
        arrayGenerator(type_array);
    }

    private void arrayGenerator (int type_array) {
        Random rd = new Random();
        switch(type_array) {
            case 0:
                // random array
                for (int i = 0; i < this.size; i++) {
                    this.array.add(rd.nextInt((100 + 100) + 1) - 100);
                    // this.array.add(rd.nextInt());
                }
                break;
            case 1:
                // sorted array
                for (int i = 0; i < this.size; i++) {
                    this.array.add(i);
                }
                break;
            case 2:
                // inverse array
                for (int i = this.size; i > 0; i--) {
                    this.array.add(i);
                }
                break;
            case 3:
                // Mảng sai 1 vài phần tử
                for (int i = 0; i < size; i++) {
                    if(i == (size-1)) {
                        Number tmp = array.get(i-1);
                        array.set(i-1, array.get(i - 2));
                        array.set(i - 2, tmp);
                    }
                    array.add(i);
                }
                break;
            default:
              // code block
              // random array
                for (int i = 0; i < this.size; i++) {
                    // this.array.add(rd.nextInt((100 + 100) + 1) - 100);
                    this.array.add(rd.nextInt());
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
