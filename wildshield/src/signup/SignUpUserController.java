package signup;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.Duration;
import modeldata.DataUser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;

public class SignUpUserController implements Initializable {
    @FXML
    private ToggleGroup jenis;

    @FXML
    private RadioButton rButtonLaki;

    @FXML
    private TextField namaPendaftar;

    @FXML
    private TextField passPendaftar;

    @FXML
    private RadioButton rButtonPerempuan;

    @FXML
    private Button registerUser;

    @FXML
    private TextField ttl;

    @FXML
    private TextField usernamePendaftar;

    String jenisKelamin;

    @FXML
    void handleButtonRadio(ActionEvent event) {
        if (rButtonLaki.isSelected()) {
            jenisKelamin = "Laki - Laki";
        } else if (rButtonPerempuan.isSelected()) {
            jenisKelamin = "Perempuan";
        }
    }

    @FXML
    void handleButtonRegisterUser(ActionEvent event) {
        if (!usernamePendaftar.getText().equals("") && !passPendaftar.getText().equals("")) {
            ArrayList<DataUser> listUser = new ArrayList<>();
            XStream xstream = new XStream(new StaxDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            FileInputStream data = null;
            try {
                data = new FileInputStream("DataUser.xml");

                int isi;
                char c;
                String stringnya = "";

                while ((isi = data.read()) != -1) {
                    c = (char) isi;
                    stringnya += c;
                }
                ArrayList<DataUser> list = (ArrayList<DataUser>) xstream.fromXML(stringnya);
                listUser = list;

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
            FileOutputStream dataUser = null;
            String username = usernamePendaftar.getText();
            String pass = passPendaftar.getText();
            String nama = namaPendaftar.getText();
            String tetl = ttl.getText();
            listUser.add(new DataUser(username, pass, nama, tetl, jenisKelamin));
            String xml = xstream.toXML(listUser);
            try {
                dataUser = new FileOutputStream("DataUser.xml");
                byte[] bytes = xml.getBytes("UTF-8");
                dataUser.write(bytes);
            } catch (Exception e) {
                System.out.println("Perhatian: " + e.getMessage());
            } finally {
                if (dataUser != null) {
                    try {
                        dataUser.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Data berhasil disimpan");
            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(1));
            pt.setOnFinished(ev -> {
                System.out.println("SignUp User Succesfully");
                registerUser.getScene().getWindow().hide();
                Stage login = new Stage();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("/login/login.fxml"));
                    Scene scene = new Scene(root);
                    login.setScene(scene);
                    login.show();
                    login.setResizable(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            pt.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
