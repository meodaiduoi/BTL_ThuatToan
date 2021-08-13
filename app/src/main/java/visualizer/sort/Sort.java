package visualizer.sort;

import java.util.ArrayList;
import java.util.Random;

public class Sort implements RuntimeClock{

    private ArrayList<Integer> array = new ArrayList<>();

    public Sort(ArrayList<Integer> array) {
        this.array = array;
    }


    private double bubblesort_TotalRuntime, interchangesort_TotalRuntime, selectionsort_TotalRuntime, insertionsort_TotalRuntime, mergeSort_TotalRuntime;

    // return milisecond
    public double nanoToMili(long startTimes, long endTimes) {
        return (double) (endTimes - startTimes) / 1000000;
    }

    /**
     * Insertion Sort
     */
    public ArrayList<Integer> insertionSort() {
        ArrayList<Integer> list = new ArrayList<>(this.array);
        int size = list.size();

        if (size == 0) {
            return list;
        }
        for (int i = 0; i < list.size(); i++) {
            // start
            int j = i;
            Integer current_item = list.get(i);

            while (j > 0 && (current_item.doubleValue() - list.get(j - 1).doubleValue()) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, current_item);

        }
        return list;
    }

    /**
     * Insertion Sort
     */
    public ArrayList<Integer> bubbleSort() {
        ArrayList<Integer> list = new ArrayList<>(array);
        int size = list.size();

        if (size == 0) {
            return list;
        }

        for (int i = 1; i < size; i++) {
            for (int j = (size - 1); j >= i; j--) {

                if (list.get(j - 1).doubleValue() - list.get(j).doubleValue() > 0) {
                    Integer tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }

            }

        }
        return list;
    }

    /**
     * Insertion Sort
     * @param list
     */
    public ArrayList<Integer> selectionSort() {
        ArrayList<Integer> list = new ArrayList<>(array);

        int size = list.size();

        if (size == 0) {
            return list;
        }
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if ((list.get(minIndex).doubleValue() - list.get(j).doubleValue()) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Integer tmp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, tmp);
            }

        }
        return list;
    }

    /**
     * Insertion Sort
     * @param list
     */
    public ArrayList<Integer> interChangeSort() {
        ArrayList<Integer> list = new ArrayList<>(array);

        int size = list.size();

        if (size == 0) {
            return list;
        }

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if ((list.get(i).doubleValue() - list.get(j).doubleValue()) > 0) {
                    Integer tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        return list;
    }

    /**
     * Merge Sort
     * @param list
     */
    public ArrayList<Integer> mergeSort(ArrayList<Integer> ilist) {

		if(ilist.size() <= 1) {
			return ilist;
		} else {
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();

			int middle = ilist.size() / 2;
			for(int i=0;i<middle;i++) {
				left.add(ilist.get(i));
			}
			for(int i=middle;i<ilist.size();i++) {
				right.add(ilist.get(i));
			}
			return merge(mergeSort(left), mergeSort(right));
		}
    }

	//Merging
	private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int a_idx = 0, b_idx = 0;

		while(a_idx+1 <= a.size() || b_idx+1 <= b.size()) {
			if(a_idx+1 <= a.size() && b_idx+1 <= b.size()) {
				if(a.get(a_idx).compareTo(b.get(b_idx)) <= 0.0) {
					ret.add(a.get(a_idx));
					a_idx++;
				} else {
					ret.add(b.get(b_idx));
					b_idx++;
				}
			} else if(a_idx+1 <= a.size()) {
				ret.add(a.get(a_idx));
				a_idx++;
			} else if(b_idx+1 <= b.size()) {
				ret.add(b.get(b_idx));
				b_idx++;
			}
		}

		return ret;
	}



    // return runtime and looptimes here

    public double bubblesort_getTotalRuntime() {
        long startTime = System.nanoTime();
        bubbleSort();
        long stopTime = System.nanoTime();
        bubblesort_TotalRuntime = nanoToMili(startTime , stopTime);
        return bubblesort_TotalRuntime;
    }

    public double interchangesort_getTotalRuntime() {
        long startTime = System.nanoTime();
        interChangeSort();
        long stopTime = System.nanoTime();
        interchangesort_TotalRuntime = nanoToMili(startTime , stopTime);
        return interchangesort_TotalRuntime;
    }

    public double insertionsort_getTotalRuntime() {
        long startTime = System.nanoTime();
        insertionSort();
        long stopTime = System.nanoTime();
        insertionsort_TotalRuntime = nanoToMili(startTime , stopTime);
        return insertionsort_TotalRuntime;
    }

    public double selectionsort_getTotalRuntime() {
        long startTime = System.nanoTime();
        selectionSort();
        long stopTime = System.nanoTime();
        selectionsort_TotalRuntime = nanoToMili(startTime , stopTime);
        return selectionsort_TotalRuntime;
    }

    public double mergesort_getTotalRuntime() {
        long startTime = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>(this.array);
        mergeSort(list);
        long stopTime = System.nanoTime();
        mergeSort_TotalRuntime = nanoToMili(startTime , stopTime);
        return mergeSort_TotalRuntime;

	}


    public static void main(String[] args) {

		ArrayList<Integer> l1 = new ArrayList<Integer>();
        Random rd = new Random();
		for (int i = 0; i < 5; i++) {
            l1.add(100 * rd.nextInt());
        }
        Sort ml2 = new Sort(l1);
		System.out.println("mergesort_getTotalRuntime : " +  ml2.mergesort_getTotalRuntime());
        // System.out.println(ml2.mergeSort(l1));
        System.out.println("bubblesort_getTotalRuntime : " +  ml2.bubblesort_getTotalRuntime());
        // System.out.println(ml2.bubbleSort());
        System.out.println("insertionsort_getTotalRuntime : " +  ml2.insertionsort_getTotalRuntime());
        // System.out.println(ml2.insertionSort());
        System.out.println("interchangesort_getTotalRuntime : " +  ml2.interchangesort_getTotalRuntime());
        // System.out.println(ml2.interChangeSort());
        System.out.println("selectionsort_getTotalRuntime : " +  ml2.selectionsort_getTotalRuntime());
        // System.out.println(ml2.selectionSort());
	}

}
