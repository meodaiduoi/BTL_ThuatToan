package Java.BTL_ThuatToan.src;

import java.util.ArrayList;
public class sort {

    /**
     *Insertion Sort
     * @param <T>
     * @param list
     */

    public static <T extends Comparable> void insertionSort(ArrayList<T> list) {
        if (list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int j = i;
            T current_item = list.get(i);

            while (j > 0 && current_item.compareTo(list.get(j - 1)) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, current_item);
        }
    }

    /**
     *Insertion Sort
     * @param <T>
     * @param list
     */
    public static <T extends Comparable> void bubbleSort(ArrayList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            for (int j = (size - 1); j >= i; j--) {

                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    T tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }

            }
        }
    }

    /**
     *Insertion Sort
     * @param <T>
     * @param list
     */
    public static <T extends Comparable> void selectionSort(ArrayList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(minIndex).compareTo(list.get(j)) > 0) {
                    minIndex = j;
                }
            }
            if ( minIndex != i ) {
                T tmp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, tmp);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(6);
        System.out.println(arrayList);

        sort.insertionSort(arrayList);
        sort.bubbleSort(arrayList);
        sort.selectionSort(arrayList);
        System.out.println(arrayList);
    }
}