package multiplescene.edukasi;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modeldata.DataEduWild;

public class EdukasiController implements Initializable {
    @FXML
    private VBox edukasiLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<DataEduWild> dataedu = new ArrayList<>();
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream data = null;
        try {
            data = new FileInputStream("DataEduWild.xml");

            int isi;
            char c;
            String stringnya = "";

            while ((isi = data.read()) != -1) {
                c = (char) isi;
                stringnya += c;
            }
            ArrayList<DataEduWild> list = (ArrayList<DataEduWild>) xstream.fromXML(stringnya);
            dataedu = list;

        } catch (Exception e) {
            System.err.println("test: " + e.getMessage());
        } finally {
            if (data != null) {
                try {
                    data.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            for (int i = 0; i < dataedu.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("samplelabel.fxml"));
                HBox cardBox = fxmlLoader.load();
                samplelabelController labelController = fxmlLoader.getController();
                labelController.setData(dataedu.get(i));
                edukasiLayout.getChildren().add(cardBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
