package visualizer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import visualizer.search.FindMax;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

import visualizer.dataset.RandomArray;



public class ControllerFindMax implements Initializable {

    // array cfg
    @FXML
    private TextField array_start_sizeTField;

    @FXML
    private TextField array_end_sizeTField;

    @FXML
    private TextArea search_infoTArea;

    // search
    @FXML
    private TextField stepTField;

    @FXML
    private CheckBox binary_findmaxCBox;

    @FXML
    private CheckBox linear_findmaxCBox;

    @FXML
    private LineChart<String, Number> findMaxChart;

    XYChart.Series<String, Number> linear_findmaxSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> binary_findmaxSeries = new XYChart.Series<String, Number>();

    @FXML
    private void handleButton_initChart (ActionEvent event) {

        linear_findmaxSeries.getData().clear();
        binary_findmaxSeries.getData().clear();
        findMaxChart.getData().removeAll(linear_findmaxSeries, binary_findmaxSeries);

        try {
            for (int i = Integer.parseInt(array_start_sizeTField.getText()); i <= Integer.parseInt(array_end_sizeTField.getText()); i += Integer.parseInt(stepTField.getText())) {

                FindMax findmax = new FindMax(new RandomArray(i, true, false, false).getArray());
                String total_array_size = String.valueOf(i);

                // binary search
                if (binary_findmaxCBox.isSelected()) {
                    binary_findmaxSeries.getData().add(new XYChart.Data<String, Number>(total_array_size, findmax.binaryMax_getTotalRuntime()));
                }

                // linear search
                if (linear_findmaxCBox.isSelected()) {
                    linear_findmaxSeries.getData().add(new XYChart.Data<String, Number>(total_array_size, findmax.linearMax_getTotalRuntime()));

                }
            }

            // binary search
            if (binary_findmaxCBox.isSelected()) {
                findMaxChart.getData().add(binary_findmaxSeries);
            }

            // linear search
            if (linear_findmaxCBox.isSelected()) {
                findMaxChart.getData().add(linear_findmaxSeries);
            }

            findMaxChart.setCreateSymbols(false);
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
        linear_findmaxSeries.setName("Linear FindMax");
        binary_findmaxSeries.setName("Binary FindMax");

        // starting point
        linear_findmaxSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        binary_findmaxSeries.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        findMaxChart.getData().add(linear_findmaxSeries);
        findMaxChart.getData().add(binary_findmaxSeries);
    }

}
