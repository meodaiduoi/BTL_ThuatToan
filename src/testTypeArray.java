import java.util.ArrayList;
import java.util.Random;
public class testTypeArray {
    public static void main(String[] args) {
        ArrayList<Number> array = new ArrayList<Number>();
        ArrayList<Number> array1 = new ArrayList<Number>();
        ArrayList<Number> array2 = new ArrayList<Number>();
        ArrayList<Number> array3 = new ArrayList<Number>();
        Random rd = new Random();
        int size = 10;
                        // random array
        for (int i = 0; i < size; i++) {
            array1.add(rd.nextInt((100 + 100) + 1) - 100);
             array1.add(rd.nextInt());
        }
        
                      // sorted array
        for (int i = 0; i < size; i++) {
            array2.add(i);
         }
        
        // inverse array
        for (int i = size; i > 0; i--) {
            array3.add(i);
         }

        for (int i = 0; i < size; i++) {
            if(i == (size-1)) {
                Number tmp = array.get(i-1);
                array.set(i-1, array.get(i - 2));
                array.set(i - 2, tmp);
            }
            array.add(i);
        }

        System.out.println(array1);
        System.out.println(array2);
        System.out.println(array3);
        System.out.println(array);
    }
}
