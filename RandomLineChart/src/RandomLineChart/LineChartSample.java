package RandomLineChart;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartSample extends Application {

    Random rand = new Random();
    public int i;
    public int price;
    public int r1;

    @Override
    public void start(Stage stage) throws InterruptedException {
        stage.setTitle("Display");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Seconds");
        yAxis.setLabel("Stock Value");

        final LineChart<Number, Number> lineChart  = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Accurate Bitcoin Value");

        XYChart.Series series = new XYChart.Series();

        Scene scene = new Scene(lineChart, 800, 600);
        i = 0;
        price = 0;
        r1 = 0;
        boolean loop = true;

        stage.setScene(scene);
        stage.show();
        series.getData().add(new XYChart.Data(0, 0));

        lineChart.getData().add(series);
  for (int j = 1; j < 11; j++) {
        Platform.runLater(() -> {
            i++;
            r1 = rand.nextInt(20) + 1;
            price = (price - 10) + r1;
            series.getData().add(new XYChart.Data(i, price));
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        });
  }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
