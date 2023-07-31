/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package restaurant_customerservices;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author MS
 */
public class Rstaurant_SignupPageController implements Initializable {

    @FXML
    private TextField UsernameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Button backButton;
    @FXML
    private Hyperlink signInHyperLink;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmField;
    @FXML
    private Button submitButton;

    private Connection connection;
    private Statement statement;
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String url1 = "jdbc:mysql://127.0.0.1:3306/restaurant_database?user=root&password=";
    @FXML
    private Label message;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url1);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while establishing the database connection: " + e.getMessage());
        }
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Restaurant_welcomePageDesign.fxml"));
        Parent root = loader.load();
        Restaurant_welcomePageDesignController mainPage = loader.getController();
        // Do something with the mainPage controller if needed

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void signInAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant_LoginPage.fxml"));
        Parent root = loader.load();
        Restaurant_LoginPageController loginPage = loader.getController();

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void submitAction(ActionEvent event) {
        String username = UsernameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String password = passwordField.getText();
        String passwordConfirm = confirmField.getText();
        if(username.isEmpty() || !username.matches("^[a-zA-Z]{3,}$")){
            if(username.isEmpty()){
                message.setText("Username is required!");
                message.setTextFill(Color.RED);
            } else {
                if(!username.matches("^[a-zA-Z]{1,}$")){
                    message.setText("Username can't Accept Sympols or numeric Values!");
                    message.setTextFill(Color.RED);
                }else
                {
                    message.setText("Username should be at least 3 charachters!");
                    message.setTextFill(Color.RED);
                }
            }
                
        }else if(email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")){
            if(email.isEmpty()){
                message.setText("Email is required!");
                message.setTextFill(Color.RED);
            }else{
                message.setText("Email doesn't match the right format!");
                message.setTextFill(Color.RED);
            }
         
        }else if (phoneNumber.isEmpty() || (!phoneNumber.matches("^[059]+[0-9]{7}$") && !phoneNumber.matches("^[056]+[0-9]{7}$")) || phoneNumber.matches(".*[^0-9].*")) {
            if (phoneNumber.isEmpty()) {
                message.setText("Phone number is required!");
                message.setTextFill(Color.RED);
            } else if (phoneNumber.matches(".*[^0-9].*")) {
                message.setText("Phone number can't contain characters or symbols!");
                message.setTextFill(Color.RED);
            } else {
                message.setText("Phone number doesn't match the right format!");
                message.setTextFill(Color.RED);
            }
        }else if (password.isEmpty() || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*") || !password.matches(".*[@$!%*?&].*") || password.length() < 8) {
            if (password.isEmpty()) {
                message.setText("Password is required!");
                message.setTextFill(Color.RED);
            } else if (!password.matches(".*[A-Z].*")){
                message.setText("Password should contains at least one Uppercase charachter!");
                message.setTextFill(Color.RED);
            } else if (!password.matches(".*[a-z].*")){
                message.setText("Password should contains at least one lowercase charachter!");
                message.setTextFill(Color.RED);
            } else if (!password.matches(".*[@$!%*?&].*")){
                message.setText("Password should contains at least one Sympol!");
                message.setTextFill(Color.RED);
            } else if (password.length() < 8){
                message.setText("Password should contains at least 8 degits!");
                message.setTextFill(Color.RED);
            } else {
                message.setText("Password should have at least one numeric value!.");
                message.setTextFill(Color.RED);
            }
        } else if(passwordConfirm.isEmpty() || !passwordConfirm.equals(password)){
            if(passwordConfirm.isEmpty()){
                message.setText("You should Confirm your password!");
                message.setTextFill(Color.RED);
            } else {
                message.setText("Passwords don't match!");
                message.setTextFill(Color.RED);
            }
        }else{
            UsernameField.clear();
            emailField.clear();
            phoneNumberField.clear();
            passwordField.clear();
            confirmField.clear();
            
            String insertQuery = "INSERT INTO customer (customer_Name, customer_Email, customer_Phone, customer_Password) VALUES ('" + username
                    + "', '" + email + "', '" + phoneNumber + "', '" + password + "')";

            try {
                statement.executeUpdate(insertQuery);
                message.setText("Signed Up Successfully!");
                message.setTextFill(Color.GREEN);
            } catch (SQLException e) {
                message.setText("Failed to sign Up");
                message.setTextFill(Color.RED);
                System.out.println("Error occurred while registering the user: " + e.getMessage());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error occurred while closing database resources: " + e.getMessage());
                }
            }
        }
    }
}