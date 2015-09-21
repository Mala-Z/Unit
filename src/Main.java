import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // GridPane
        GridPane gridPane = new GridPane();
        //gridPane.setPadding(new Insets());
//        gridPane.setStyle(("-fx-background-image: url('untitled.png'); " +
//                           "-fx-background-position: center center; " +
//                           "-fx-background-repeat: stretch;"));
        gridPane.setHgap(10);
        gridPane.setVgap(50);
        gridPane.setGridLinesVisible(true);
        gridPane.setStyle("-fx-background-image: url('4.jpg')");
        // Labels, Buttons...
        Label title = new Label("CONVERTER");
        gridPane.add(title, 3, 0);
        title.setTranslateX(22);
        title.setStyle("-fx-font-size: 22px;" + "-fx-font-family: DejaVu Sans Mono, monospace");

        Label label1 = new Label("Choose measurement:");
        gridPane.add(label1, 3, 1, 1, 3);

        ComboBox comboBox1 = new ComboBox();
        comboBox1.setTranslateY(-4);
        comboBox1.getItems().addAll("Kg", "Km", "C°", "Pounds", "Miles", "F°");
        comboBox1.setValue("Kg");
        gridPane.add(comboBox1, 3, 2, 1, 2);

        TextField textField1 = new TextField();
        gridPane.add(textField1, 3, 3);

        Button button = new Button("Convert");
        gridPane.add(button, 3, 2, 1, 4);
        button.setTranslateY(17);

        Label label2 = new Label("To be determined*");
        gridPane.add(label2, 3, 4);

        TextField textField2 = new TextField();
        gridPane.add(textField2, 3, 4, 1, 2);

        Button button1 = new Button("DK");
        gridPane.add(button1,4,0);




        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                comboBox1.getSelectionModel().getSelectedItem();


                if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Kg")) {

                    double kgToPound = Double.parseDouble(textField1.getText()) / 0.45359237;

                    textField2.setText(Double.toString(kgToPound));
                    label2.setText("Pounds:");

                } else if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Km")) {


                    double kmToMiles = Double.parseDouble(textField1.getText()) * 0.621;

                    textField2.setText(Double.toString(kmToMiles));
                    label2.setText("Miles:");

                } else if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("C°")) {


                    double cToF = ((Double.parseDouble(textField1.getText()) * 2) + 30);

                    textField2.setText(Double.toString(cToF));
                    label2.setText("F°:");
                }
                // and now the opposite formulas
                else if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Pounds")) {


                    double poundToKg = Double.parseDouble(textField1.getText()) * 0.45359237;

                    textField2.setText(Double.toString(poundToKg));
                    label2.setText("Kg:");
                }
                else if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Miles")) {


                    double mileToKm = (Double.parseDouble(textField1.getText()) / 0.621);

                    textField2.setText(Double.toString(mileToKm));
                    label2.setText("Km:");
                }
                else if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("F°")) {


                    double fToC = ((Double.parseDouble(textField1.getText()) - 32) * 0.55555555555);

                    textField2.setText(Double.toString(fToC));
                    label2.setText("C°:");
                }



            }
        });

        Scene scene = new Scene(gridPane, 250, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}