
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class CompoundInterestCalculator extends Application {

    private final TextField investedField = new TextField();
    private final TextField rateField = new TextField();
    private final TextField yearsField = new TextField();
    private final RadioButton yearly = new RadioButton("Yearly ");
    private final RadioButton halfYearly = new RadioButton("Half-Yearly ");
    private final RadioButton quarterly = new RadioButton("Quarterly ");
    private final TextArea output = new TextArea();
    private final ToggleGroup group = new ToggleGroup();

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        Label title = new Label("Compound Interest Calculator");
        Font titlefont = Font.font("Arial", FontWeight.BOLD, 20);
        title.setFont(titlefont);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        FlowPane top = new FlowPane(Orientation.HORIZONTAL, 20, 20);
        top.setAlignment(Pos.CENTER);
        top.getChildren().add(title);
        root.setTop(top);


        Label invested = new Label("Invested Amount:");
        Label rate = new Label("Rate of Interest (%):");
        Label years = new Label("Investment Years:");


        grid.add(invested, 0, 0);
        grid.add(rate, 0, 1);
        grid.add(years, 0, 2);
        grid.add(investedField, 1, 0);
        grid.add(rateField, 1, 1);
        grid.add(yearsField, 1, 2);

        Label frequency = new Label("Frequency of Interest:");
        grid.add(frequency, 0, 4);
        RadioButton yearly = new RadioButton("Yearly ");
        RadioButton halfYearly = new RadioButton("Half-Yearly ");
        RadioButton quarterly = new RadioButton("Quarterly ");
        yearly.setToggleGroup(group);
        halfYearly.setToggleGroup(group);
        quarterly.setToggleGroup(group);
        yearly.setUserData(1);
        halfYearly.setUserData(2);
        quarterly.setUserData(4);
        HBox box = new HBox(yearly, halfYearly, quarterly);
        box.setAlignment(Pos.CENTER);
        grid.add(box, 1, 4);

        root.setCenter(grid);

        Button calculate = new Button("Calculate");
        calculate.setOnAction(new calculateAction());
        grid.add(calculate, 0, 6);

        root.setBottom(output);


        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Compound Interest Calculator");
        stage.show();
    }

    class calculateAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            double p = Double.parseDouble(investedField.getText());
            double r = Double.parseDouble(rateField.getText()) / 100;
            int t = Integer.parseInt(yearsField.getText());
            int n = (int) group.getSelectedToggle().getUserData();
            Interest account = new Interest(p, r, n, t);
            output.setText(account.display());
        }
    }


    public static void main(String[] args) {
        launch();
    }


}
