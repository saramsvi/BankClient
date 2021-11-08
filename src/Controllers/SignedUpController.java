package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Action;

public class SignedUpController extends Action {


    @FXML
    private Button BackButton;

    @FXML
    void initialize() { BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/sample.fxml")); }}
