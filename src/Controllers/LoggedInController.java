package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController extends Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExchangeRatesButton;

    @FXML
    private Button LocationsButton;

    @FXML
    private Button AccountsButton;

    @FXML
    private Button CardsButton;

    @FXML
    private Button TransferButton;

    @FXML
    private Button LoanButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/sample.fxml"));
        ExchangeRatesButton.setOnAction(event -> moveTo(ExchangeRatesButton, "/Banksy-Client/FXMLs/ExchangeRates.fxml"));
        CardsButton.setOnAction(event -> moveTo(CardsButton,"/FXMLS/Cards.fxml"));
        TransferButton.setOnAction(event -> moveTo(TransferButton,"/FXMLS/Transfer.fxml"));
        LoanButton.setOnAction(event -> moveTo(LoanButton,"/FXMLS/Loan.fxml"));

    }
}
