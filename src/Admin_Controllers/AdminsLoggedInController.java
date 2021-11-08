package Admin_Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Action;

public class AdminsLoggedInController extends Action {


    @FXML
    private Button ExchangeRatesButton;

    @FXML
    private Button loanbutton;

    @FXML
    private Button Clientslistbutton;

    @FXML
    private Button BackButton;




    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/BanksyClient/FXMLs/sample.fxml"));
        //LocationsButton.setOnAction(event -> moveTo(LocationsButton,"/FXMLs/Locations.fxml"));
        //ExchangeRatesButton.setOnAction(event -> moveTo(ExchangeRatesButton,"/FXMLs/ExchangeRates.fxml"));
        Clientslistbutton.setOnAction(event -> moveTo(Clientslistbutton,"/BanksyClient/Admin_FXMLS/Clients_list.fxml"));
        //TransferButton.setOnAction(event -> moveTo(TransferButton,"/FXMLS/Transfer.fxml"));
        //LoanButton.setOnAction(event -> moveTo(LoanButton,"/FXMLS/Loan.fxml"));

    }
}
