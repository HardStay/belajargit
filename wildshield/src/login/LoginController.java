package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import modeldata.DataKomunitas;
import modeldata.DataUser;

public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button login;

    @FXML
    private ToggleGroup jenisUser;

    @FXML
    private RadioButton rButtonKomunitas;

    @FXML
    private RadioButton rButtonUser;

    @FXML
    private RadioButton rButtonOperator;

    @FXML
    private Button signUp;

    String pilihanJenisUser = "";

    @FXML
    void handleButtonRadio(ActionEvent event) {
        if (rButtonUser.isSelected()) {
            pilihanJenisUser = "User";
        } else if (rButtonKomunitas.isSelected()) {
            pilihanJenisUser = "Komunitas";
        } else if (rButtonOperator.isSelected()) {
            pilihanJenisUser = "Operator";
        }
    }

    @FXML
    void handleButtonLogin(ActionEvent event) {
        if (!usernameField.getText().equals("") && !passwordField.getText().equals("")) {
            String username = usernameField.getText();
            String pass = passwordField.getText();
            if (pilihanJenisUser.equals("User")) {
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
                    ArrayList<DataUser> listUser = (ArrayList<DataUser>) xstream.fromXML(stringnya);
                    boolean flag = true;
                    for (int i = 0; i < listUser.size(); i++) {
                        if (username.equals(listUser.get(i).getUsername())
                                && pass.equals(listUser.get(i).getPassword())) {
                            flag = false;
                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(1));
                            pt.setOnFinished(ev -> {
                                System.out.println("Login Succesfully");
                                login.getScene().getWindow().hide();
                                Stage login = new Stage();
                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("/multiplescene/HalamanUtama.fxml"));
                                    Scene scene = new Scene(root);
                                    login.setScene(scene);
                                    login.show();
                                    login.setResizable(false);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            pt.play();
                            break;
                        }
                    }
                    if (!username.equals(listUser.get(0).getUsername()) && flag == true
                            || !pass.equals(listUser.get(0).getPassword()) && flag == true) {
                        System.out.println("Ada yang salah");
                    }
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
            } else if (pilihanJenisUser.equals("Komunitas")) {
                XStream xstream = new XStream(new StaxDriver());
                xstream.addPermission(AnyTypePermission.ANY);
                FileInputStream data = null;
                try {
                    data = new FileInputStream("DataKomunitas.xml");
                    int isi;
                    char c;
                    String stringnya = "";

                    while ((isi = data.read()) != -1) {
                        c = (char) isi;
                        stringnya += c;
                    }

                    ArrayList<DataKomunitas> listKomunitas = (ArrayList<DataKomunitas>) xstream.fromXML(stringnya);
                    boolean flag = true;
                    for (int i = 0; i < listKomunitas.size(); i++) {
                        if (username.equals(listKomunitas.get(i).getUsername())
                                && pass.equals(listKomunitas.get(i).getPassword())) {
                            flag = false;
                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(1));
                            pt.setOnFinished(ev -> {
                                System.out.println("Login Succesfully");
                                login.getScene().getWindow().hide();
                                Stage login = new Stage();
                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("/multiplescene/HalamanUtama.fxml"));
                                    Scene scene = new Scene(root);
                                    login.setScene(scene);
                                    login.show();
                                    login.setResizable(false);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            pt.play();
                            break;
                        }
                    }
                    if (!username.equals(listKomunitas.get(0).getUsername()) && flag == true
                            || !pass.equals(listKomunitas.get(0).getPassword()) && flag == true) {
                        System.out.println("Ada yang salah");
                    }

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
            } else if (pilihanJenisUser.equals("Operator")) {
                if (username.equals("Operator")
                        && pass.equals("operators")) {
                    PauseTransition pt = new PauseTransition();
                    pt.setDuration(Duration.seconds(1));
                    pt.setOnFinished(ev -> {
                        System.out.println("Login Succesfully");
                        login.getScene().getWindow().hide();
                        Stage login = new Stage();
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/operator/operator.fxml"));
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
        }
    }

    @FXML
    void handleButtonSignUp(ActionEvent event) throws IOException {
        signUp.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/signup/JenisPendaftar.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    @FXML
    void handleButtonSecret(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            rButtonOperator.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rButtonOperator.setVisible(false);
    }

}
