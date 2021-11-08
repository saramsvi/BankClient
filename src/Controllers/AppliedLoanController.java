package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class AppliedLoanController extends Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ContinueButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/LoggedIn.fxml"));

    }
}
