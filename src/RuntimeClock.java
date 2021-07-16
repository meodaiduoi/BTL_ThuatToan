import java.util.ArrayList;
interface RuntimeClock {
    long bubblesort_getRuntime ();
    long interchangesort_getRuntime ();
    long selectionsort_getRuntime ();

    ArrayList<Number> bubblesort_getLoopsTimes ();
    ArrayList<Number> interchangesort_getLoopTimes ();
    ArrayList<Number> selectionsort_getLoopTimes ();
}
