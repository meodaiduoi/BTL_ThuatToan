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
    private CheckBox bubblesort;

    @FXML
    private CheckBox interchangesort;

    @FXML
    private CheckBox selectionsort;

    @FXML
    private CheckBox debug;

    @FXML
    private Button initchart;

    @FXML
    private LineChart<String, Number> linechart;

    XYChart.Series<String, Number> series_bubblesort = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series_interchangesort = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> series_selectionsort = new XYChart.Series<String, Number>();

    // Eventhandle - Controller

    @FXML
    private void handleCheckBox_bubblesort (ActionEvent event) {
        if (bubblesort.isSelected()) {
            System.out.println("bbsort on");
        }
        else {
            System.out.println("bbsort off");
        }
    }

    @FXML
    private void handleCheckBox_interchangesort (ActionEvent event) {
        if (interchangesort.isSelected()) {
            System.out.println("icsort on");
            //.setStyle();
        }
        else {
            System.out.println("bbsort off");
        }
    }

    @FXML
    private void handleCheckBox_selectionsort (ActionEvent event) {
        if (selectionsort.isSelected()) {
            System.out.println("sssort on");
        }
        else {
            System.out.println("bbsort off");
        }
    }

    @FXML
    private void handleButton_initgraph (ActionEvent event) {
        series_bubblesort.getData().clear();
        series_interchangesort.getData().clear();
        series_selectionsort.getData().clear();

        try {
            Double.parseDouble(interval.getText());
            RandomIntArray array = new RandomIntArray(Integer.parseInt(array_size.getText()));


            //sorting option
            if (bubblesort.isSelected()) {
                System.out.println("bbsort on");
                //for (int time = 0)
                // series_bubblesort.getData().add(new XYChart.Data<String, Number>(, 3));
                //linechart.getData().add(series_bubblesort);
            }

            if (interchangesort.isSelected()) {
                System.out.println("icsort on");
                //linechart.getData().add(series_interchangesort);
            }

            if (selectionsort.isSelected()) {
                System.out.println("stsort on");
                //linechart.getData().add(series_selectionsort);
            }
        }

        catch (NumberFormatException E) {
            System.out.println("Not A Number");
        }

        catch (Exception E) {
            System.out.println("Error ?");
        }
    }

    //init
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // init linechart
        series_bubblesort.setName("Bubblesort");
        series_interchangesort.setName("Interchange sort");
        series_selectionsort.setName("Selection sort");

        // test data
        // series_bubblesort.getData().add(new XYChart.Data<String, Number>("0.1", 3));
        // series_bubblesort.getData().add(new XYChart.Data<String, Number>("0.2", 33));
        // series_bubblesort.getData().add(new XYChart.Data<String, Number>("0.3", 69));

        // series_interchangesort.getData().add(new XYChart.Data<String, Number>("0.1", 60));
        // series_interchangesort.getData().add(new XYChart.Data<String, Number>("0.2", 80));
        // series_interchangesort.getData().add(new XYChart.Data<String, Number>("0.3", 50));

        // series_selectionsort.getData().add(new XYChart.Data<String, Number>("0.1", 12));
        // series_selectionsort.getData().add(new XYChart.Data<String, Number>("0.2", 50));
        // series_selectionsort.getData().add(new XYChart.Data<String, Number>("0.3", 4));

        // add figure
        linechart.getData().add(series_bubblesort);
        linechart.getData().add(series_interchangesort);
        linechart.getData().add(series_selectionsort);
    }
}
