/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurant_customerservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.DriverManager;
/**
 *
 * @author MS
 */
public class Restaurant_CustomerServices extends Application{
    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/restaurant_database?user=root&password=";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName(className);
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Restaurant_welcomePageDesign.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
}

//Eslam Hossam Zyada 1301214516
//Khaled AbdAlQader