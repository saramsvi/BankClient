package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferController extends Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Rusername;

    @FXML
    private TextField TAmount;

    @FXML
    private Button TransferButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/LoggedIn.fxml"));
        TransferButton.setOnAction(event -> moveTo(TransferButton, "/Banksy-Client/FXMLs/TransferComplete.fxml"));
    }
}
