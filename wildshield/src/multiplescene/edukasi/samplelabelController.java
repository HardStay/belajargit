package multiplescene.edukasi;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modeldata.DataEduWild;

public class samplelabelController {
    @FXML
    private HBox box;

    @FXML
    private Label content;

    @FXML
    private ImageView imageEdukasi;

    @FXML
    private Label judul;

    public void setData(DataEduWild data) {
        File file = new File(data.getFile());
        Image image = new Image(file.toURI().toString());
        imageEdukasi.setImage(image);
        judul.setText(data.getJudul());
        content.setText(data.getDeskripsi());
    }
}
