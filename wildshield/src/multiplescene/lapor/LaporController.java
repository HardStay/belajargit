package multiplescene.lapor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LaporController implements Initializable {
    @FXML
    private TextArea deskripsi;

    @FXML
    private Button kirim;

    @FXML
    private Button pilihFile;

    @FXML
    private ChoiceBox<String> pilihJenis;

    @FXML
    private DatePicker tanggal;

    private String[] jenisLaporan = { "Perburuan Liar", "Kemunculan Satwa Liar" };
    private String laporan;

    public void getLaporan(ActionEvent event) {
        laporan = pilihJenis.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pilihJenis.getItems().addAll(jenisLaporan);
        pilihJenis.setOnAction(this::getLaporan);
    }
}
