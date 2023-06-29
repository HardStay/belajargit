package multiplescene.pantau;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PantauController implements Initializable {
    @FXML
    private BorderPane mapPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.openstreetmap.org");

        mapPane.setCenter(webView);
        mapPane.setOnMouseClicked(event -> {
        double mouseX = event.getX();
        double mouseY = event.getY();
        System.out.println("Koordinat klik: X = " + mouseX + ", Y = " + mouseY);
        });
    }

}
