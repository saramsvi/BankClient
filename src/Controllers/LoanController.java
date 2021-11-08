package Controllers;

import Animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class LoanController extends Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Loan_time;

    @FXML
    private TextField Loan_username;

    @FXML
    private TextField Loan_reason;

    @FXML
    private Button Loan_ApplyButton;

    @FXML
    private TextField Loan_occupatioon;

    @FXML
    private TextField Loan_salary;

    @FXML
    private CheckBox loan_unmarried;

    @FXML
    private CheckBox loan_married;

    @FXML
    private TextField Loan_kids;

    @FXML
    private TextField Loan_amount;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/LoggedIn.fxml"));
        Loan_ApplyButton.setOnAction(event -> NewLoanApplication());

    }

    private void NewLoanApplication() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String Username =Loan_username.getText();
        String Reason=   Loan_reason.getText();
        String Amount= Loan_amount.getText();
        String Time = Loan_time.getText();
        String Occupation =Loan_occupatioon.getText();
        String Salary =  Loan_salary.getText();
        String Mstatus="";
        if (loan_married.isSelected())
            Mstatus= "Замужем/Женат";
        else
            Mstatus="Не Замужем/Женат";
        String Kids= Loan_kids.getText();

        Loaner user = new Loaner(Username,Reason, Amount,Time,Occupation,Salary,Mstatus,Kids);
        dbHandler.NewLoanUser(user);
        if (!Username.equals("") && !Reason.equals("") && !Amount.equals("") && !Time.equals("")
                && !Occupation.equals("") && !Salary.equals("") && !Mstatus.equals("") && !Kids.equals(""))
        {

            moveTo(Loan_ApplyButton, "/Banksy-Client/FXMLs/AppliedLoan.fxml");
        }
        else
        {
            Shake Anim = new Shake(Loan_ApplyButton);
            Anim.playAnim();
        }
    }
}


