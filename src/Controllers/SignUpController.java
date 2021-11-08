package Controllers;

import Animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class SignUpController extends sample.Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUp_Name;
    @FXML
    private TextField Balance_Signup;

    @FXML
    private TextField SignUp_Surname;

    @FXML
    private TextField SignUp_Address;

    @FXML
    private TextField SignUp_Passport;

    @FXML
    private TextField Birthdd;

    @FXML
    private TextField SignUp_Placeofbirth;

    @FXML
    private PasswordField SignUp_Password;

    @FXML
    private TextField SignUp_Username;

    @FXML
    private Button SignUp_button;

    @FXML
    private TextField Phonenumber;


    @FXML
    private CheckBox CheckBoxMale;

    @FXML
    private CheckBox CheckBoxFemale;


    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(event -> moveTo(BackButton, "/Banksy-Client/FXMLs/sample.fxml"));
        SignUp_button.setOnAction(event -> SignUpNewUser());

    }

    private void SignUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
         String Username =SignUp_Username.getText().trim();
         String Name=   SignUp_Name.getText();
         String Surname=  SignUp_Surname.getText();
         String Gender="";
         if (CheckBoxFemale.isSelected())
             Gender= "Женский";
         else
             Gender="Мужской";
         String PassportNumber= SignUp_Passport.getText().trim();
         String Birthday=Birthdd.getText();
         String PlaceofBirth=SignUp_Placeofbirth.getText();
         String PhoneNumber=Phonenumber.getText().trim();
         String Address=SignUp_Address.getText();
         String Password=  SignUp_Password.getText().trim();
         String Balance=  Balance_Signup.getText().trim();
         User user = new User(Username,Name,Surname,Gender,
         PassportNumber,Birthday,PlaceofBirth,PhoneNumber,Address,Password,Balance);
        dbHandler.signUpUser(user);
        if (!Username.equals("") && !Password.equals("") && !Name.equals("") && !Surname.equals("")
        && !PlaceofBirth.equals("") && !PassportNumber.equals("") && !Address.equals("") && !PhoneNumber.equals("")
                && !Balance_Signup.equals("") && !Gender.equals("")) {

            moveTo(SignUp_button, "/Banksy-Client/FXMLs/SignedUp.fxml");
        }
else
        {
            Shake userSignupAnim = new Shake(SignUp_button);
              userSignupAnim.playAnim(); }
    }
}
