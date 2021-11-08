package Controllers;

import Animations.Shake;
import connection.Connection;
import connection.ConnectionEnum;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Action;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller extends Action {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() throws IOException {
        Connection connection = ConnectionEnum.CONNECTION_ENUM.getConnection();
        connection.connect();
        LogInButton.setOnAction(event -> {
            String logintext = LoginField.getText().trim();
            String loginpassword = PasswordField.getText().trim();
            if (!logintext.equals("") && !loginpassword.equals(""))
                loginUser(logintext, loginpassword);
            else
          loginUser(logintext,loginpassword);
        });

        SignUpButton.setOnAction(event -> moveTo(SignUpButton, "/Banksy-Client/FXMLs/SignUp.fxml"));
    }

    private void loginUser(String logintext, String loginpassword)
    {
        Connection connection = ConnectionEnum.CONNECTION_ENUM.getConnection();
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataBaseHandler dbhandler= new DataBaseHandler();
        User user = new User();
        user.setUsername(logintext);
        user.setPassword(loginpassword);
        ResultSet result=dbhandler.getUser(user);
        int counter=0;
        try {

            //считаем пользователи
            while (result.next()) {
                counter++;
            }
        }
        catch (SQLException e){ e.printStackTrace();}
        if (counter>=1)
        {
         moveTo(LogInButton, "/Banksy-Client/FXMLs/LoggedIn.fxml");
            if (logintext.equals("saramsvi") & loginpassword.equals("123"))
                moveTo(LogInButton, "/.idea/BanksyServer/Admin_FXMLs/AdminsLoggedIn.fxml");
        }

            else {
                Shake userLoginAnim = new Shake(LoginField);
                Shake userPassAnim = new Shake(PasswordField);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
        }
    }
}



