import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
//Rafae Adil

public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cricket Database");

        
        Image backgroundImage = new Image("file:C:\\Users\\rafae\\Documents\\CricketDB\\Images\\ezgif.com-webp-to-jpg.jpg");

        //creates the background image
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );

        // Create a layout container (StackPane) and set the background
        StackPane root = new StackPane();
        root.setBackground(new Background(background));

        // Create content (your existing code)
        Label title = new Label("Cricket DB");
        title.setTextFill(Color.web("#e066ff")); 
        title.setFont(new Font(50));
        title.setUnderline(true);

        Button btn = createStyledButton("Drop Tables", "-fx-background-color: linear-gradient(#e066ff, #80ffff); -fx-text-fill: white;");
        Button btn1 = createStyledButton("Create Tables", "-fx-background-color: linear-gradient(#e066ff, #80ffff); -fx-text-fill: white;");
        Button btn2 = createStyledButton("Populate Tables", "-fx-background-color: linear-gradient(#e066ff,#80ffff ); -fx-text-fill: white;");
        Button btn3 = createStyledButton("Query Tables", "-fx-background-color: linear-gradient(#e066ff, #80ffff); -fx-text-fill: white;");
        Button btn4 = createStyledButton("Exit", "-fx-background-color: linear-gradient(#e066ff, #80ffff); -fx-text-fill: white;");

        // Set actions for buttons
        btn.setOnAction(event -> System.out.println("Cricket DB"));

        // Create a GridPane for layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);

        // ColumnConstraints to ensure the title spans the entire width
        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(colConstraints, colConstraints);

        // Add components to the grid
        gridPane.add(title, 1, 0, 1, 1);

        // HBox for the first row of buttons (Drop Tables and Create Tables)
        HBox firstRowButtons = new HBox(10);
        firstRowButtons.setAlignment(Pos.CENTER);
        firstRowButtons.getChildren().addAll(btn, btn1);

        // HBox for the second row of buttons (Populate Tables and Query Tables)
        HBox secondRowButtons = new HBox(10);
        secondRowButtons.setAlignment(Pos.CENTER);
        secondRowButtons.getChildren().addAll(btn2, btn3);

        // VBox for buttons, centered and spaced out
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(firstRowButtons, secondRowButtons, btn4);

        // Add VBox to the grid
        gridPane.add(buttonBox, 0, 1, 2, 1);

        // Enable grid lines (for visualization during development) change this when viewing final
        gridPane.setGridLinesVisible(false);

        // Add grid to the StackPane
        root.getChildren().add(gridPane);

        // Create a scene with the StackPane
        Scene scene = new Scene(root, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createStyledButton(String text, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}