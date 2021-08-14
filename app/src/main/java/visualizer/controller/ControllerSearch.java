package visualizer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import visualizer.search.Search;
import javafx.event.ActionEvent;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import visualizer.dataset.RandomArray;

public class ControllerSearch implements Initializable{
    public ControllerSearch() {}

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
    private CheckBox binary_searchCBox;

    @FXML
    private CheckBox linear_searchCBox;

    // chart
    XYChart.Series<String, Number> linear_searchSeries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> binary_searchSeries = new XYChart.Series<String, Number>();

    @FXML
    private LineChart<String, Number> searchChart;

    @FXML
    private void handleButton_initgraph (ActionEvent event) {

        try {
            binary_searchSeries.getData().clear();
            linear_searchSeries.getData().clear();
            searchChart.getData().removeAll(binary_searchSeries, linear_searchSeries);

            for (int i = Integer.parseInt(array_start_sizeTField.getText()); i <= Integer.parseInt(array_end_sizeTField.getText()); i += Integer.parseInt(stepTField.getText())) {

                Search search = new Search(new RandomArray(i, true, false, false).getArray());
                String total_array_size = String.valueOf(i);

                // binary search
                if (binary_searchCBox.isSelected()) {
                    binary_searchSeries.getData().add(new XYChart.Data<String, Number>(total_array_size, search.binarySearch_getTotalRuntime()));
                }

                // linear search
                if (linear_searchCBox.isSelected()) {
                    linear_searchSeries.getData().add(new XYChart.Data<String, Number>(total_array_size, search.linearSearch_getTotalRuntime()));

                }
            }

            // binary search
            if (binary_searchCBox.isSelected()) {
                searchChart.getData().add(binary_searchSeries);
            }

            // linear search
            if (linear_searchCBox.isSelected()) {
                searchChart.getData().add(linear_searchSeries);
            }

            searchChart.setCreateSymbols(false);
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
        linear_searchSeries.setName("Linear search");
        binary_searchSeries.setName("Binary search");

        // starting point
        linear_searchSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
        binary_searchSeries.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        searchChart.getData().add(linear_searchSeries);
        searchChart.getData().add(binary_searchSeries);
    }

}
