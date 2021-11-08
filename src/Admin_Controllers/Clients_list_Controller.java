package Admin_Controllers;

import Controllers.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class Clients_list_Controller extends Action {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> Clients_Table;

    @FXML
    private TableColumn<User, String> fxid;

    @FXML
    private TableColumn<User, String> fxusername;

    @FXML
    private TableColumn<User, String> fxname;

    @FXML
    private TableColumn<User, String> fxsurname;

    @FXML
    private TableColumn<User, String> fxgender;

    @FXML
    private TableColumn<User, String> fxpassport;

    @FXML
    private TableColumn<User, String> fxbirthday;

    @FXML
    private TableColumn<User, String> fxbirthplace;

    @FXML
    private TableColumn<User, String> fxphonenumb;

    @FXML
    private TableColumn<User, String> fxaddress;

    @FXML
    private TableColumn<User, String> fxpassword;
    @FXML
    private TableColumn<User, String> fxbalance;
    @FXML
    private TextField searchbox;

    @FXML
    private Button BackButton;

    //observable list to store  data
    private final ObservableList<User> dataList= FXCollections.observableArrayList();
    @FXML
    void initialize() {
       BackButton.setOnAction(event -> moveTo(BackButton, "/BanksyServer/Admin_FXMLs/AdminsLoggedIn.fxml"));

       fxid.setCellValueFactory(new PropertyValueFactory<>("idUser"));
    fxname.setCellValueFactory(new PropertyValueFactory<>("Name"));
    fxsurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
    fxgender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
    fxpassport.setCellValueFactory(new PropertyValueFactory<>("PassportNumber"));
    fxbirthday.setCellValueFactory(new PropertyValueFactory<>("BirthDay"));
    fxbirthplace.setCellValueFactory(new PropertyValueFactory<>("PlaceofBirth"));
    fxphonenumb.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
    fxaddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
    fxpassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
    fxbalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
    Clients_Table.setItems(dataList);
    dataList.addAll();

// Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchbox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (user.getSurname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Clients_Table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        Clients_Table.setItems(sortedData);
    }
}

