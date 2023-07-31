/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package restaurant_customerservices;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author MS
 */
public class Restaurant_welcomePageDesignController {

    @FXML
    private Button locationBrn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button menuButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button signUpBtn;
    
    private Stage menuStage;
    
    private Stage locationStage;

    @FXML
    void locationAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Location_DesignPage.fxml"));
        Parent root = loader.load();
        Locatio_DesignPageController locatio = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


    @FXML
    void loginAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant_LoginPage.fxml"));
        Parent root = loader.load();
        Restaurant_LoginPageController loginPage = loader.getController();
        
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
   void menuAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OurMenu_DesignPage.fxml"));
        Parent root = loader.load();
        OurMenu_DesignPageController ourMenu = loader.getController();

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) throws IOException{
       
    }

    @FXML
    void signUpAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rstaurant_SignupPage.fxml"));
        Parent root = loader.load();
        Rstaurant_SignupPageController signUp = loader.getController();
        // Do something with the mainPage controller if needed

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

}
