/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package restaurant_customerservices;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Restaurant_LoginPageController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button backButton;
    @FXML
    private Hyperlink signUpHyperLink;

    private Connection connection;
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String url1 = "jdbc:mysql://127.0.0.1:3306/restaurant_database?user=root&password=";
    @FXML
    private Label message;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url1);
        } catch (Exception e) {
            System.out.println("Error occurred while establishing the database connection: " + e.getMessage());
        }
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if(username.isEmpty() || !username.matches("^[a-zA-Z]{3,}$")){
            if(username.isEmpty()){
                message.setText("Username is required!");
                message.setTextFill(Color.RED);
            } else {
                message.setText("Username doesn't match the right format!");
                message.setTextFill(Color.RED);
            }
        } else if(password.isEmpty() || !password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
            if(password.isEmpty()){
                message.setText("Password is required!");
                message.setTextFill(Color.RED);
            } else if(!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
                message.setText("Password should at least contains 8 digits and have 1 uppercase, lowerCase, Sympol, and numeric Value!");
                message.setTextFill(Color.RED);
            }
        } else {
            passwordField.clear();
            usernameField.clear();
            message.setTextFill(Color.GREEN);
            try {
                String selectQuery = "SELECT customer_id FROM customer WHERE customer_Name = ? AND customer_Password = ?";
                ResultSet result;
                try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    result = statement.executeQuery();
                    if (result.next()) {
                        String customerId = result.getString("customer_id");
                        message.setText("Logged in Successfully!");
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Restaurant_MainPage.fxml"));
                        Parent root = loader.load();
                        Restaurant_MainPageController mainPage = loader.getController();
                        mainPage.nameLabel.setText(username);
                        mainPage.idLabel.setText(customerId);

                        stage.setScene(new Scene(root));
                        stage.setResizable(false);
                        stage.show();
                    } else {
                        message.setText("Invalid username or password. Please try again.");
                        message.setTextFill(Color.RED);
                    }
                }
                result.close();
            } catch (SQLException e) {
                System.out.println("Error occurred while performing the login: " + e.getMessage());
            }
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
    private void signUpAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rstaurant_SignupPage.fxml"));
        Parent root = loader.load();
        Rstaurant_SignupPageController signUpPage = loader.getController();

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
}
