import java.util.ArrayList;
interface RuntimeClock {
    double bubblesort_getRuntime ();
    double interchangesort_getRuntime ();
    double selectionsort_getRuntime ();
    double insertionsort_getRuntime ();

    ArrayList<Number> bubblesort_getLoopsTimes ();
    ArrayList<Number> interchangesort_getLoopTimes ();
    ArrayList<Number> selectionsort_getLoopTimes ();
    ArrayList<Number> insertionsort_getLoopTimes ();
    
}
