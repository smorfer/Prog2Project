package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NewWindow {
    public NewWindow(String title, String text) {
        BorderPane root = new BorderPane();
        Label content = new Label(text);
        content.setAlignment(Pos.CENTER);
        root.setCenter(content);

        Stage window = new Stage();
        window.setTitle(title);
        window.setScene(new Scene(root, 500, 300));
        window.setAlwaysOnTop(true);
        window.show();

    }

}
