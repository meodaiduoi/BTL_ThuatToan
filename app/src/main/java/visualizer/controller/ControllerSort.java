package visualizer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

import visualizer.dataset.RandomArray;
import visualizer.sort.Sort;

public class ControllerSort implements Initializable{
    public ControllerSort() {}

    // array cfg
    // array cfg
    @FXML
    private TextField array_sizeTField;

    // sort cfg
    @FXML
    private CheckBox bubble_sortCBox;

    @FXML
    private CheckBox interchange_sortCBox;

    @FXML
    private CheckBox selection_sortCBox;

    @FXML
    private CheckBox insertion_sortCBox;

    @FXML
    private CheckBox merge_sortCBox;

    @FXML
    private Button init_sort_chartButton;

    // info out
    @FXML
    private TextArea sort_infoTArea;

    // chart
    @FXML
    private BarChart<String, Number> sortChart;

    XYChart.Series<String, Number> bubble_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> interchange_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> selection_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> insertion_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> merge_sortSeries = new XYChart.Series<String, Number>();


    // Event
    void debugInfo(String text) {
        sort_infoTArea.appendText(text + "\n");
        System.out.println(text);
    }

    @FXML
    private void handleButton_initgraph (ActionEvent event) {

        // remove old data
        bubble_sortSeries.getData().clear();
        interchange_sortSeries.getData().clear();
        selection_sortSeries.getData().clear();
        insertion_sortSeries.getData().clear();
        merge_sortSeries.getData().clear();

        sortChart.getData().removeAll(bubble_sortSeries, interchange_sortSeries, selection_sortSeries, insertion_sortSeries, merge_sortSeries);

        try {
            String[] array_type = {"Random", "Sorted", "Revesed", "Nearly sorted"};
            for (String type : array_type) {

                Sort sort;
                if (type == "Random") { sort = new Sort(new RandomArray(Integer.parseInt(array_sizeTField.getText()), false, false, false).getArray()); }
                if (type == "Sorted") { sort = new Sort(new RandomArray(Integer.parseInt(array_sizeTField.getText()), true, false, false).getArray()); }
                if (type == "Revesed") { sort = new Sort(new RandomArray(Integer.parseInt(array_sizeTField.getText()), true, true, false).getArray()); }
                else { sort = new Sort(new RandomArray(Integer.parseInt(array_sizeTField.getText()), true, false, true).getArray()); }

                // bubble sort
                if (bubble_sortCBox.isSelected()) {
                    bubble_sortSeries.getData().add(new XYChart.Data<String, Number>(type, sort.bubblesort_getTotalRuntime()));
                }

                // interchange sort
                if (interchange_sortCBox.isSelected()) {
                    interchange_sortSeries.getData().add(new XYChart.Data<String, Number>(type, sort.interchangesort_getTotalRuntime()));
                }

                //selection sort
                if (selection_sortCBox.isSelected()) {
                    selection_sortSeries.getData().add(new XYChart.Data<String, Number>(type, sort.selectionsort_getTotalRuntime()));
                }

                // insertion sort
                if (insertion_sortCBox.isSelected()) {
                    insertion_sortSeries.getData().add(new XYChart.Data<String, Number>(type, sort.insertionsort_getTotalRuntime()));
                }

                // merge sort
                if (merge_sortCBox.isSelected()) {
                    merge_sortSeries.getData().add(new XYChart.Data<String, Number>(type, sort.mergesort_getTotalRuntime()));
                }
            }

            // bubble sort
            if (bubble_sortCBox.isSelected()) {
                sortChart.getData().add(bubble_sortSeries);
            }

            // interchange sort
            if (interchange_sortCBox.isSelected()) {
                sortChart.getData().add(interchange_sortSeries);
            }

            //selection sort
            if (selection_sortCBox.isSelected()) {
                sortChart.getData().add(selection_sortSeries);
            }

            // insertion sort
            if (insertion_sortCBox.isSelected()) {
                sortChart.getData().add(insertion_sortSeries);
            }

            // merge sort
            if (merge_sortCBox.isSelected()) {
                sortChart.getData().add(merge_sortSeries);
            }

        }

        catch (NumberFormatException E) {
            System.out.println("Not A Number");
        }

        catch (Exception E) {
            System.out.println("Error ?");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // init linechart
        bubble_sortSeries.setName("Bubblesort");
        interchange_sortSeries.setName("Interchange sort");
        selection_sortSeries.setName("Selection sort");
        insertion_sortSeries.setName("Insertion sort");
        merge_sortSeries.setName("Merge sort");

        // starting point
        bubble_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        interchange_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        selection_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        insertion_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        merge_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        sortChart.getData().addAll(bubble_sortSeries, interchange_sortSeries, selection_sortSeries, insertion_sortSeries, merge_sortSeries);

    }

}
