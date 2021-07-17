import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.event.ActionEvent;



public class Controller implements Initializable {

    public Controller() {}

    // Binding
    @FXML
    private TextField array_size;

    @FXML
    private TextField interval;

    @FXML
    private TextArea debug_output;

    @FXML
    private CheckBox is_interger_array;

    @FXML
    private CheckBox bubblesort;

    @FXML
    private CheckBox interchangesort;

    @FXML
    private CheckBox selectionsort;

    @FXML
    private CheckBox insertionsort;

    @FXML
    private CheckBox debug;

    @FXML
    private Button initchart;

    @FXML
    private LineChart<String, Number> linechart;

    XYChart.Series<String, Number> series_bubblesort = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series_interchangesort = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series_selectionsort = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series_insertionsort = new XYChart.Series<String, Number>();

    // Eventhandle - Controller
    private void debugInfo (String text) {
        System.out.println(text);
        debug_output.appendText(text + "\n");
    }

    @FXML
    private void handleButton_initgraph (ActionEvent event) {

        // remove old data
        series_bubblesort.getData().clear();
        series_interchangesort.getData().clear();
        series_selectionsort.getData().clear();
        series_insertionsort.getData().clear();
        linechart.getData().removeAll(series_bubblesort, series_insertionsort, series_interchangesort, series_selectionsort);

        try {
            debugInfo("--------------");

            int loop_interval = Integer.parseInt(interval.getText());

            RandomArray array = new RandomArray(Integer.parseInt(array_size.getText()), is_interger_array.isSelected());
            Sort sort = new Sort(array.getArray(), loop_interval);

            debugInfo("Init array size: ");
            //sorting option

            //bubble sort
            if (bubblesort.isSelected()) {
                debugInfo("bbsort on");

                sort.bubbleSort();
                sort.bubblesort_getTotalRuntime();

                int total_loop = 0;
                series_bubblesort.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.bubblesort_getLoopTime()) {
                    total_loop += loop_interval;
                    series_bubblesort.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                linechart.setCreateSymbols(false);
                linechart.getData().add(series_bubblesort);
            }

            //interchange sort
            if (interchangesort.isSelected()) {
                debugInfo("icsort on");

                sort.interChangeSort();
                sort.interchangesort_getTotalRuntime();

                int total_loop = 0;
                series_interchangesort.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.interchangesort_getLoopTime()) {
                    total_loop += loop_interval;
                    series_interchangesort.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                linechart.setCreateSymbols(false);
                linechart.getData().add(series_interchangesort);
            }

            //selection sort
            if (selectionsort.isSelected()) {
                debugInfo("sltsort on");

                sort.selectionSort();
                sort.selectionsort_getTotalRuntime();

                int total_loop = 0;
                series_selectionsort.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.selectionsort_getLoopTime()) {
                    total_loop += loop_interval;
                    series_selectionsort.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                linechart.setCreateSymbols(false);
                linechart.getData().add(series_selectionsort);
            }

            // insertion sort
            if (insertionsort.isSelected()) {
                debugInfo("isertsort on");

                sort.insertionSort();
                sort.insertionsort_getTotalRuntime();

                int total_loop = 0;
                series_insertionsort.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.insertionsort_getLoopTime()) {
                    total_loop += loop_interval;
                    series_insertionsort.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                linechart.setCreateSymbols(false);
                linechart.getData().add(series_insertionsort);
            }
        }

        catch (NumberFormatException E) {
            debugInfo("Not A Number");
        }

        // catch (Exception E) {
        //     System.out.println("Error ?");
        // }
    }



    //init
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // This section of code is retared
        debug.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (debug.isSelected()) {
                debug_output.setVisible(true);
            }
            if (!debug.isSelected()) {
                debug_output.setVisible(false);
            }
        });

        // init linechart
        series_bubblesort.setName("Bubblesort");
        series_interchangesort.setName("Interchange sort");
        series_selectionsort.setName("Selection sort");
        series_insertionsort.setName("Insertion sort");

        // starting point
        series_bubblesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        series_interchangesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        series_selectionsort.getData().add(new XYChart.Data<String, Number>("0", 0));
        series_insertionsort.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        linechart.getData().add(series_bubblesort);
        linechart.getData().add(series_interchangesort);
        linechart.getData().add(series_selectionsort);
        linechart.getData().add(series_insertionsort);
    }
}

    // public static void main(String[] args) {
    //     RandomArray rd = new RandomArray(5);

    //     Sort sort = new Sort(rd.getArray(), 1);

    //     System.out.println("------------insertionsort---------------");

    //     System.out.println(sort.array);
    //     sort.insertionSort();
    //     System.out.println(sort.insertionSort());
    //     System.out.println("Rum time: " + sort.insertionsort_TotalRuntime);
    //     System.out.println("List time: " + sort.insertionsort_getLoopTime);

    //     System.out.println("------------bubblesort---------------");
    //     System.out.println(sort.array);
    //     sort.bubbleSort();
    //     System.out.println(sort.bubbleSort());
    //     System.out.println("Rum time: " + sort.bubblesort_TotalRuntime);
    //     System.out.println("List time: " + sort.bubblesort_getLoopTime);

    //     System.out.println("-----------SELECTION---------------");
    //     // System.out.println(rd.getArray());
    //     System.out.println(sort.array);
    //     sort.selectionSort();
    //     System.out.println(sort.selectionSort());
    //     System.out.println("Rum time: " + sort.selectionsort_TotalRuntime);
    //     System.out.println("List time: " + sort.selectionsort_getLoopTime);

    //     System.out.println("-----------InterChange---------------");
    //     // System.out.println(rd.getArray());
    //     System.out.println(sort.array);
    //     sort.selectionSort();
    //     System.out.println(sort.interChangeSort());
    //     System.out.println("Rum time: " + sort.interchangesort_TotalRuntime);
    //     System.out.println("List time: " + sort.interchangesort_getLoopTime);

    // }