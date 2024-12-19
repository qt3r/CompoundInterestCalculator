import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CompoundInterestCalculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        Label title =  new Label("Compound Interest Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle(":-)");
        stage.show();
    }

    public static void main(String[] args) {launch();}


}
