package mynewproject;

import java.awt.Label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class QuizApp extends Application {

    private int score = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple JavaFX Quiz");

        Label q1Label = new Label("1. What is the capital of India?");
        RadioButton q1Option1 = new RadioButton("Mumbai");
        RadioButton q1Option2 = new RadioButton("New Delhi");
        RadioButton q1Option3 = new RadioButton("Kolkata");
        RadioButton q1Option4 = new RadioButton("Chennai");

        ToggleGroup q1Group = new ToggleGroup();
        q1Option1.setToggleGroup(q1Group);
        q1Option2.setToggleGroup(q1Group);
        q1Option3.setToggleGroup(q1Group);
        q1Option4.setToggleGroup(q1Group);

        VBox q1Box = new VBox(5, q1Label, q1Option1, q1Option2, q1Option3, q1Option4);
        q1Box.setPadding(new Insets(10));

        // Question 2 - Multiple correct answers
        Label q2Label = new Label("2. Which crops are available in all seasons in India?");
        CheckBox q2Option1 = new CheckBox("Rice");
        CheckBox q2Option2 = new CheckBox("Jute");
        CheckBox q2Option3 = new CheckBox("Maize");
        CheckBox q2Option4 = new CheckBox("Raagi");

        VBox q2Box = new VBox(5, q2Label, q2Option1, q2Option2, q2Option3, q2Option4);
        q2Box.setPadding(new Insets(10));

        // Submit button and result display
        Button submitButton = new Button("Submit");
        Label resultLabel = new Label();

        submitButton.setOnAction(e -> {
            score = 0;

            // ✅ Question 1 logic
            if (q1Group.getSelectedToggle() != null) {
                RadioButton selected = (RadioButton) q1Group.getSelectedToggle();
                if (selected.getText().equals("New Delhi")) {
                    score++;
                }
            }

            
            boolean correctRice = q2Option1.isSelected();
            boolean correctMaize = q2Option3.isSelected();
            boolean correctRaagi = q2Option4.isSelected();
            boolean wrongJute = q2Option2.isSelected();

            if (correctRice && correctMaize && correctRaagi && !wrongJute) {
                score++;
            }

            resultLabel.setText("Your score: " + score + "/2");
        });

        VBox root = new VBox(15, q1Box, q2Box, submitButton, resultLabel);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}