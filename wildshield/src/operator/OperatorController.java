package operator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class OperatorController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    void keVerifikasi(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("verifikasi/halamanverifikasi");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keEduWild(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("eduwild/UploadEduWild");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keKonservasi(ActionEvent event) {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("konservasi/UploadKegiatan");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
