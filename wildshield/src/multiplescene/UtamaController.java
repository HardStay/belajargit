package multiplescene;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class UtamaController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    void keEdukasi(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("edukasi/edukasi");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keLapor(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("lapor/lapor");
        mainPane.setCenter(halaman);
    }

    @FXML
    void kePantau(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("pantau/pantau");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
