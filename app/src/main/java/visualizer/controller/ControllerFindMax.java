package visualizer.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFindMax implements Initializable{ {

    XYChart.Series<String, Number> min_max_Series = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> min_max_Series = new XYChart.Series<String, Number>();

    @FXML
    private void handleButton_initChart (ActionEvent event) {
        linear_findmaxSeries.getData().clear();
        binary_Series.getData().clear();

        findMaxChart.getData().removeAll();

        try {

        }

        catch (NumberFormatException E) {

        }
        catch (Exception E) {}

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // init linechart
        Series.setName("Bubblesort");
        Series.setName("Interchange sort");

        // starting point
        Series.getData().add(new XYChart.Data<String, Number>("0", 0));
        Series.getData().add(new XYChart.Data<String, Number>("0", 0));

        // add figure
        Chart.getData().add(linearhSeries);
        Chart.getData().add(binaryhSeries);
    }

}
