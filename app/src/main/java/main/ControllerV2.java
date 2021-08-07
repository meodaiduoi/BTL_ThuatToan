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

public class ControllerV2 implements Initializable {
    public ControllerV2() {}

    // Binding

    // Tab 1
    @FXML
    private TextField array_sizeTField;

    @FXML
    private TextField intervalTField;

    @FXML
    private TextArea sort_infoTArea;

    // array cfg
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


    @FXML
    private LineChart<String, Number> sortChart;

    XYChart.Series<String, Number> bubble_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> interchange_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> selection_sortSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> insertion_sortSeries = new XYChart.Series<String, Number>();

    // Tab 2
    @FXML
    private CheckBox binary_searchCBox;
    
    @FXML
    private CheckBox min_max_search_CBox;

    // @FXML
    // private CheckBox

    
    @FXML
    private TextArea searchTArea;
    
    @FXML
    private Button init_search_chartButton;


    @FXML
    private LineChart<String, Number> searchChart;

    XYChart.Series<String, Number>  = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> = new XYChart.Series<String, Number>();
    //XYChart.Series<String, Number>  = new XYChart.Series<String, Number>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // // This section of code is retared
        // debug.selectedProperty().addListener((observable, oldValue, newValue) -> {
        //     if (debug.isSelected()) {
        //         debug_output.setVisible(true);
        //     }
        //     if (!debug.isSelected()) {
        //         debug_output.setVisible(false);
        //     }
        // });

        // is_sorted.selectedProperty().addListener((observable, oldValue, newValue) -> {
        //     if (is_sorted.isSelected()) {
        //         is_haft_sorted.setDisable(false);
        //         is_reversed.setDisable(false);
        //     }
        //     if (!is_sorted.isSelected()) {
        //         is_haft_sorted.setDisable(true);
        //         is_reversed.setDisable(true);
        //     }
        // });

        // // init linechart
        // series_bubblesort.setName("Bubblesort");
        // series_interchangesort.setName("Interchange sort");
        // series_selectionsort.setName("Selection sort");
        // series_insertionsort.setName("Insertion sort");

        // // starting point
        // series_bubblesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        // series_interchangesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        // series_selectionsort.getData().add(new XYChart.Data<String, Number>("0", 0));
        // series_insertionsort.getData().add(new XYChart.Data<String, Number>("0", 0));

        // // add figure
        // linechart.getData().add(series_bubblesort);
        // linechart.getData().add(series_interchangesort);
        // linechart.getData().add(series_selectionsort);
        // linechart.getData().add(series_insertionsort);
    }

}
