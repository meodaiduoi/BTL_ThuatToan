// package visualizer.controller;

// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.chart.LineChart;
// import javafx.scene.chart.XYChart;

// import javafx.scene.control.Button;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.TextArea;
// import javafx.scene.control.TextField;
// import javafx.event.ActionEvent;

// import java.io.IOException;
// import java.net.URL;
// import java.util.ResourceBundle;

// public class ControllerSearch implements Initializable{
//     public ControllerSearch() {}

//     // array cfg
//     @FXML
//     private TextField array_start_sizeTField;

//     @FXML
//     private TextField array_end_sizeTField;

//     @FXML
//     private TextArea search_infoTArea;

//     // search
//     @FXML
//     private TextField intervalTField;

//     @FXML
//     private CheckBox binary_searchCBox;

//     @FXML
//     private CheckBox linear_search_CBox;

//     @FXML
//     private Button init_sreach_chartButton;

//     // chart
//     XYChart.Series<String, Number> linear_searchSeries = new XYChart.Series<String, Number>();
//     XYChart.Series<String, Number> binary_searchSeries = new XYChart.Series<String, Number>();

//     @FXML
//     private LineChart<String, Number> searchChart;

//     @FXML
//     private void handleButton_initChart (ActionEvent event) {
//         linear_searchSeries.getData().clear();
//         binary_searchSeries.getData().clear();

//         searchChart.getData().removeAll(linear_searchSeries, binary_searchSeries);

//         try {

//         }

//         catch (NumberFormatException E) {

//         }
//         catch (Exception E) {}

//     }


//     @Override
//     public void initialize(URL location, ResourceBundle resources) {

//         // init linechart
//         linear_searchSeries.setName("Bubblesort");
//         binary_searchSeries.setName("Interchange sort");

//         // starting point
//         linear_searchSeries.getData().add(new XYChart.Data<String, Number>("0", 0));
//         binary_searchSeries.getData().add(new XYChart.Data<String, Number>("0", 0));

//         // add figure
//         searchChart.getData().add(linear_searchSeries);
//         searchChart.getData().add(binary_searchSeries);
//     }

// }
