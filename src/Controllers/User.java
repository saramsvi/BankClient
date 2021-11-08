package Controllers;

public class User {
    private String Username;
    private String Name;
    private String Surname;
    private String Gender;
    private String PassportNumber;
    private String Birthday;
    private String PlaceofBirth;
    private String PhoneNumber;
    private String Address;
    private String Password;
    private String Balance;

    public User(String username, String name, String surname, String gender,
                String passportNumber, String birthday, String placeofBirth,
                String phoneNumber, String address, String password, String balance) {
        Username = username;
        Name = name;
        Surname = surname;
        Gender = gender;
        PassportNumber = passportNumber;
        Birthday = birthday;
        PlaceofBirth = placeofBirth;
        PhoneNumber = phoneNumber;
        Address = address;
        Password = password;
        Balance = balance;
    }

    public User() { }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getPlaceofBirth() {
        return PlaceofBirth;
    }

    public void setPlaceofBirth(String placeofBirth) {
        PlaceofBirth = placeofBirth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }
};



