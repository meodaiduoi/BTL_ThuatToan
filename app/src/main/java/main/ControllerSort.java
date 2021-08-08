package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sort.Sort;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dataset.RandomArray;

public class ControllerSort implements Initializable{
    public ControllerSort() {}

    // Binding

    // Tab 1


    // array cfg
    @FXML
    private TextField array_sizeTField;

    @FXML
    private CheckBox is_interger_arrayCBox;

    @FXML
    private CheckBox is_reversedCBox;

    @FXML
    private CheckBox is_sortedCBox;

    @FXML
    private CheckBox is_haft_sortedCBox;

    // sort cfg
    @FXML
    private TextField intervalTField;

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
    private LineChart<String, Number> sortChart;

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
    private void handleButton_about (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sort/fxml/About.fxml"));
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.getIcons().add(new Image("/sort/icon/icon.png"));
        stage.setTitle("About");

        stage.setScene(new Scene(root));
        stage.show();
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
            int loop_interval = Integer.parseInt(intervalTField.getText());

            RandomArray array = new RandomArray(Integer.parseInt(array_sizeTField.getText()), is_interger_arrayCBox.isSelected(), is_sortedCBox.isSelected(), is_reversedCBox.isSelected(), is_haft_sortedCBox.isSelected());
            Sort sort = new Sort(array.getArray(), loop_interval);

            debugInfo("-- Initialize new chart: --");
            debugInfo("Array size: " + array_sizeTField.getText());
            debugInfo("Option: " + " Interger array = " + (String.valueOf(is_interger_arrayCBox.isSelected())));

            // bubble sort
            if (bubble_sortCBox.isSelected()) {

                sort.bubbleSort();
                sort.bubblesort_getTotalRuntime();

                int total_loop = 0;
                bubble_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.bubblesort_getLoopTime()) {
                    total_loop += loop_interval;
                    bubble_sortSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                sortChart.setCreateSymbols(false);
                sortChart.getData().add(bubble_sortSeries);

                debugInfo("- Bubble sort:");
                debugInfo("Finished time: " + sort.bubblesort_getTotalRuntime() + "ms");
            }

            // interchange sort
            if (interchange_sortCBox.isSelected()) {

                sort.interChangeSort();
                sort.interchangesort_getTotalRuntime();

                int total_loop = 0;
                interchange_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.interchangesort_getLoopTime()) {
                    total_loop += loop_interval;
                    interchange_sortSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                sortChart.setCreateSymbols(false);
                sortChart.getData().add(interchange_sortSeries);

                debugInfo("- Interchange sort:");
                debugInfo("Finished time: " + sort.interchangesort_getTotalRuntime() + "ms");
            }

            //selection sort
            if (selection_sortCBox.isSelected()) {

                sort.selectionSort();
                sort.selectionsort_getTotalRuntime();

                int total_loop = 0;
                selection_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.selectionsort_getLoopTime()) {
                    total_loop += loop_interval;
                    selection_sortSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                sortChart.setCreateSymbols(false);
                sortChart.getData().add(selection_sortSeries);

                debugInfo("- Selection sort:");
                debugInfo("Finished time: " + sort.selectionsort_getTotalRuntime() + "ms");
            }

            // insertion sort
            if (insertion_sortCBox.isSelected()) {

                sort.insertionSort();
                sort.insertionsort_getTotalRuntime();

                int total_loop = 0;
                insertion_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
                for (Number i : sort.insertionsort_getLoopTime()) {
                    total_loop += loop_interval;
                    insertion_sortSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
                }

                sortChart.setCreateSymbols(false);
                sortChart.getData().add(insertion_sortSeries);

                debugInfo("- Insertion sort:");
                debugInfo("Finished time: " + sort.insertionsort_getTotalRuntime() + "ms");
            }

            // merge sort
            // if (merge_sortCBox.isSelected()) {

            //     sort.mergeSort();
            //     sort.insertionsort_getTotalRuntime();

            //     int total_loop = 0;
            //     insertion_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
            //     for (Number i : sort.insertionsort_getLoopTime()) {
            //         total_loop += loop_interval;
            //         insertion_sortSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(total_loop), i));
            //     }

            //     sortChart.setCreateSymbols(false);
            //     sortChart.getData().add(insertion_sortSeries);

            //     debugInfo("- Insertion sort:");
            //     debugInfo("Finished time: " + sort.insertionsort_getTotalRuntime() + "ms");
            // }
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

        is_sortedCBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (is_sortedCBox.isSelected()) {
                is_haft_sortedCBox.setDisable(false);
                is_reversedCBox.setDisable(false);
            }
            if (!is_sortedCBox.isSelected()) {
                is_haft_sortedCBox.setDisable(true);
                is_reversedCBox.setDisable(true);
            }
        });

        // init linechart
        bubble_sortSeries.setName("Bubblesort");
        interchange_sortSeries.setName("Interchange sort");
        selection_sortSeries.setName("Selection sort");
        insertion_sortSeries.setName("Insertion sort");
        merge_sortSeries.setName("Insertion sort");

        // starting point
        bubble_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        interchange_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        selection_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        insertion_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        merge_sortSeries.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        sortChart.getData().removeAll(bubble_sortSeries, interchange_sortSeries, selection_sortSeries, insertion_sortSeries, merge_sortSeries);

    }

}
