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
    private void handleButton_initgraph (ActionEvent event) {
        series_bubblesort.getData().clear();
        series_interchangesort.getData().clear();
        series_selectionsort.getData().clear();

        try {
            Double.parseDouble(interval.getText());
            RandomArray array = new RandomArray(Integer.parseInt(array_size.getText()), is_interger_array.isSelected());

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

        // starting point
        series_bubblesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        series_interchangesort.getData().add(new XYChart.Data<String, Number>("0", 0));
        series_selectionsort.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        linechart.getData().add(series_bubblesort);
        linechart.getData().add(series_interchangesort);
        linechart.getData().add(series_selectionsort);
    }
}