// package visualizer.dataset;

// import java.util.ArrayList;

// public class MultiRandomArray {

//     private int start_size = 10;
//     private int end_size = 50;
//     private int step = 2;

//     private ArrayList<ArrayList<Integer>> array;

//     public MultiRandomArray () {}

//     public MultiRandomArray (int end_size, int step) {
//         this.end_size = end_size;
//         arrayGen(true, false, false);
//     }

//     public MultiRandomArray (int start_size, int end_size, int step) {
//         this.start_size = start_size;
//         this.end_size = end_size;
//         this.step = step;
//         arrayGen(true, false, false);
//     }

//     public MultiRandomArray (int start_size, int end_size, int step, boolean isSorted, boolean isReversed, boolean isNearlySorted) {
//         this.start_size = start_size;
//         this.end_size = end_size;
//         this.step = step;

//         arrayGen(isSorted, isReversed, isNearlySorted);
//     }


//     private void arrayGen(boolean isSorted, boolean isReversed, boolean isNearlySorted) {
//         for (int i = this.start_size; i <= this.end_size; i++) {
//             array.add(new RandomArray(i, isSorted, isReversed, isNearlySorted).getArray());
//         }
//     }

//     public ArrayList<ArrayList<Integer>> getArray() {
//         return array;
//     }

//     public Ar
// }
