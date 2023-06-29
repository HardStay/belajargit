package operator.verifikasi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VerifikasiController implements Initializable {
    @FXML
    private BorderPane mainPane;

    @FXML
    void keVerifikasiUser(ActionEvent event) {
        OpenScene1 object = new OpenScene1();
        Pane halaman = object.getPane("verifuser/verifikasiuser");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keVerifikasiPenggalangan(ActionEvent event) {
        OpenScene1 object = new OpenScene1();
        Pane halaman = object.getPane("verifpenggalangan/verifpenggalangandana");
        mainPane.setCenter(halaman);
    }

    @FXML
    void keVerifikasiLaporan(ActionEvent event) {
        OpenScene1 object = new OpenScene1();
        Pane halaman = object.getPane("veriflaporan/verifikasilaporan");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
