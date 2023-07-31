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
import java.sql.Statement;

import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MS
 */

public class Restaurant_MainPageController implements Initializable {
    
    @FXML
    private BorderPane border;
    @FXML
    public Label nameLabel;
    @FXML
    private Button exitButton;
    @FXML
    private Button desertsButton;
    @FXML
    private Button soupsButton;
    @FXML
    private Button appetizersButton;
    @FXML
    private Button saladsButton;
    @FXML
    private Button mainDishesButton;
    @FXML
    private Button drinksButton;
    @FXML
    private TableView<MenuOrders> listTable;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ImageView IV;
    @FXML
    private AnchorPane salads;
    @FXML
    private Button scallopsButton;
    @FXML
    private Button veganSaladButton;
    @FXML
    private Button friedChickenButton;
    @FXML
    private Button ketoPieBtn;
    @FXML
    private Button potatoCakeButton;
    @FXML
    private Button greenSaladButton;
    @FXML
    private AnchorPane appetizers;
    @FXML
    private AnchorPane mainDishes;
    @FXML
    private Button kebabButton;
    @FXML
    private Button wrappedKebabButton;
    @FXML
    private Button shrimpButton;
    @FXML
    private Button steakButton;
    @FXML
    private Button sushiButton;
    @FXML
    private Button burgerButton;
    @FXML
    private Button vegiSaladButton;
    @FXML
    private Button seaSaladButton;
    @FXML
    private Button cheeseSaladButton;
    @FXML
    private Button avocadoSaladButton;
    @FXML
    private Button greekSaladButton;
    @FXML
    private Button greenOnionsSalad;
    @FXML
    private AnchorPane soups;
    @FXML
    private Button indomieButton;
    @FXML
    private Button lentilButton;
    @FXML
    private Button specialMushroomBtn;
    @FXML
    private Button chickenButton;
    @FXML
    private Button mushroomButton;
    @FXML
    private Button tomatoButton;
    @FXML
    private AnchorPane drinks;
    @FXML
    private Button limeButton;
    @FXML
    private Button mohitoButton;
    @FXML
    private Button teaButton;
    @FXML
    private Button coffeButton;
    @FXML
    private Button passionButton;
    @FXML
    private Button lemonButton;
    @FXML
    private AnchorPane deserts;
    @FXML
    private Button croassonButton;
    @FXML
    private Button creamCakeButton;
    @FXML
    private Button panCakeButton;
    @FXML
    private Button chocolateCakeButton;
    @FXML
    private Button bakedCakeButton;
    @FXML
    private Button waffelButton;
    @FXML
    private TableColumn<MenuOrders, String> ordersColumn;
    @FXML
    private TableColumn<MenuOrders, Double> priceColumn;
    
    private static Statement statement;
    private static ResultSet resultSet;
    private Connection connection;
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String url1 = "jdbc:mysql://127.0.0.1:3306/restaurant_database?user=root&password=";
    @FXML
    private TextField totalField;
    private double total = 0.0;
    @FXML
    private Button editButton1;
    @FXML
    private Label customer_IDLabel;
    @FXML
    public Label idLabel;
    @FXML
    private Button mainPageButton;
    @FXML
    private TableColumn<MenuOrders, Integer> idColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            Class.forName(className);
            connection = DriverManager.getConnection(url1);
        } catch (Exception e) {
            System.out.println("Error occurred while establishing the database connection: " + e.getMessage());
        }
        
        ordersColumn.setCellValueFactory(new PropertyValueFactory<>("orders"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void desertsAction(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(false);
        salads.setVisible(false);
        mainDishes.setVisible(false);
        soups.setVisible(false);
        drinks.setVisible(false);
        deserts.setVisible(true);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void soupsAction(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(false);
        salads.setVisible(false);
        mainDishes.setVisible(false);
        soups.setVisible(true);
        drinks.setVisible(false);
        deserts.setVisible(false);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void appetizerButton(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(true);
        salads.setVisible(false);
        mainDishes.setVisible(false);
        soups.setVisible(false);
        drinks.setVisible(false);
        deserts.setVisible(false);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void saladsAction(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(false);
        salads.setVisible(true);
        mainDishes.setVisible(false);
        soups.setVisible(false);
        drinks.setVisible(false);
        deserts.setVisible(false);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void mainDishesAction(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(false);
        salads.setVisible(false);
        mainDishes.setVisible(true);
        soups.setVisible(false);
        drinks.setVisible(false);
        deserts.setVisible(false);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void drinksAction(ActionEvent event) {
        IV.setVisible(false);
        appetizers.setVisible(false);
        salads.setVisible(false);
        mainDishes.setVisible(false);
        soups.setVisible(false);
        drinks.setVisible(true);
        deserts.setVisible(false);
        idLabel.setVisible(false);
        customer_IDLabel.setVisible(false);
    }

    @FXML
    private void exitAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Do you want to go back?");
        alert.setTitle("Confirmation");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Restaurant_welcomePageDesign.fxml"));
            Parent root = loader.load();
            Restaurant_welcomePageDesignController mainPage = loader.getController();
            // Do something with the mainPage controller if needed

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }
    
    @FXML
    private void addAction(ActionEvent event) {
        ObservableList<MenuOrders> ordersList = listTable.getItems();
        deleteButton.setVisible(false);
        for (MenuOrders order : ordersList) {
            String orderName = order.getOrders();
            double price = order.getPrice();

            insertOrderIntoDatabase(orderName, price, total);
        }

        ordersList.clear();
        totalField.clear();
    }

    @FXML
    private void editAction(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Edit Order");
        dialog.setHeaderText("Enter Order ID");
        dialog.setContentText("Order ID:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(orderId -> {
            try {
                String selectQuery = "SELECT * FROM orders o JOIN customer_orders co ON o.order_id = co.order_id WHERE o.order_id = ? AND co.customer_id = ?";
                ResultSet resultSet;
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setInt(1, Integer.parseInt(orderId));
                    preparedStatement.setInt(2, Integer.parseInt(idLabel.getText())); 
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        TextInputDialog dialogUpdateName = new TextInputDialog();
                        dialogUpdateName.setTitle("Edit Order");
                        dialogUpdateName.setHeaderText("Enter Order Name");
                        dialogUpdateName.setContentText("Order Name:");

                        Optional<String> updateName = dialogUpdateName.showAndWait();
                        updateName.ifPresent(orderName -> {
                            TextInputDialog dialogUpdatePrice = new TextInputDialog();
                            dialogUpdatePrice.setTitle("Edit Order");
                            dialogUpdatePrice.setHeaderText("Enter Order Price");
                            dialogUpdatePrice.setContentText("Order Price:");

                            Optional<String> updatePrice = dialogUpdatePrice.showAndWait();
                            updatePrice.ifPresent(orderPrice -> {
                                try {
                                    String updateQuery = "UPDATE orders SET order_name = ?, orderPrice = ? WHERE order_id = ?";
                                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                        updateStatement.setString(1, orderName);
                                        updateStatement.setDouble(2, Double.parseDouble(orderPrice));
                                        updateStatement.setInt(3, Integer.parseInt(orderId));

                                        int rowsAffected = updateStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setTitle("Order Update");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Order updated successfully.");
                                            alert.showAndWait();
                                        } else {
                                            Alert alert = new Alert(AlertType.ERROR);
                                            alert.setTitle("Order Update");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Failed to update the order.");
                                            alert.showAndWait();
                                        }
                                    }
                                } catch (SQLException ex) {
                                    System.out.println("Error occurred while updating the order: " + ex.getMessage());
                                }
                            });
                        });
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Order Update");
                        alert.setHeaderText(null);
                        alert.setContentText("Order with ID " + orderId + " does not exist or is not associated with the current customer.");
                        alert.showAndWait();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error occurred while performing the order update: " + e.getMessage());
            }
        });
    }




    @FXML
    private void deleteAction(ActionEvent event){
        MenuOrders selectedOrder = listTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            listTable.getItems().remove(selectedOrder);
            total -= selectedOrder.getPrice();
            totalField.setText(String.valueOf(total));
        } else {
            System.out.println("No item selected for deletion.");
        }
    }

    private void insertOrderIntoDatabase(String orderName, double price, double total) {
        try {
            String insertQuery = "INSERT INTO orders (Order_Name, OrderPrice, order_Total) VALUES (?, ?, ?)";

            int orderId = -1;

            try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, orderName);
                statement.setDouble(2, price);
                statement.setDouble(3, total);
                statement.executeUpdate();
                
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }
            }

            if (orderId != -1) {
                String customerOrdersQuery = "INSERT INTO customer_orders (customer_id, order_id) VALUES (?, ?)";
                try (PreparedStatement customerOrdersStatement = connection.prepareStatement(customerOrdersQuery)) {
                    customerOrdersStatement.setInt(1, Integer.parseInt(idLabel.getText()));
                    customerOrdersStatement.setInt(2, orderId);
                    customerOrdersStatement.executeUpdate();
                }

                String selectOrdersQuery = "SELECT o.* FROM orders o " +
                        "JOIN customer_orders co ON o.order_id = co.order_id " +
                        "WHERE co.customer_id = ?";
                try (PreparedStatement selectOrdersStatement = connection.prepareStatement(selectOrdersQuery)) {
                    selectOrdersStatement.setInt(1, Integer.parseInt(idLabel.getText()));
                    ResultSet resultSet = selectOrdersStatement.executeQuery();

                    ObservableList<MenuOrders> ordersList = FXCollections.observableArrayList();
                    while (resultSet.next()) {
                        int orderID = resultSet.getInt("order_id");
                        String orderNameDB = resultSet.getString("Order_Name");
                        double orderPrice = resultSet.getDouble("OrderPrice");
                        double orderTotal = resultSet.getDouble("order_Total");
                        idColumn.setVisible(true);
                        
                        totalField.setText(String.valueOf(orderTotal));
                        MenuOrders menuOrder = new MenuOrders(orderNameDB, orderPrice, orderID);
                        ordersList.add(menuOrder);
                    }
                    listTable.setItems(ordersList);
                }
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Order Update");
                alert.setHeaderText(null);
                alert.setContentText("Order inserted into the database successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Order Update");
                alert.setHeaderText(null);
                alert.setContentText("Failed to retrieve the generated order ID.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting order into the database: " + e.getMessage());
        }
    }

    @FXML
    private void scallopsAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Baked Scallops", 10.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void veganSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Vegan Salad", 5.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void friedChickenAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Fried Chicken", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void ketoPieAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Keto Pumpkin Pie", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void potatoCakeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Potato Chese Cake", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void greenSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Green Bean Salad", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void kebabAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Kebab", 35.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void wrappedKebabAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Wrapped Kebab", 20.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void shrimpAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Shrimp Soup", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void steakAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Well done Steak", 32.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void sushiAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Sushi Fingers", 18.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void burgerAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Beef Burger", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void vegiSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Vegitable Salad", 5.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void seaSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Sea Salad", 20.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void cheeseSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Cheese & Meat Salad", 15.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void avocadoSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Avocado Salad", 7.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void greekSaladAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Greek Salad", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void greenOnionsAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Green Onion Salad", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void indomieAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Indomie Soup", 6.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void lentilAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Lentil Salad", 16.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void specialMushroomAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Special Mushroom Soup", 15.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void chickenSoupAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Chicken Soup", 23.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void mushroomAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Mushroom Soup", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void tomatoAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Tomato Soup", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void limeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Kiwi & Lime Juice", 8.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void mohitoAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Mohito & Lemon Juice", 10.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void teaAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Iced Tea", 15.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void coffeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Heavy Coffe", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void passionAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Passion Juice", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void lemonAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Iced Lemon", 10.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void croassonAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Coroasson", 7.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void creamCakeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Cream Cake", 5.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void panCakeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Pan Cake", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void chocoCakeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Chocolate Cake", 5.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void bakedCakeAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Creamed Baked Cake", 10.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void waffelAction(ActionEvent event) {
        MenuOrders order = new MenuOrders("Waffel Pie", 12.0);
        listTable.getItems().add(order);
        total += order.getPrice();
        totalField.setText(String.valueOf(total));
    }

    @FXML
    private void mainPageAction(ActionEvent event) {
        IV.setVisible(true);
        idLabel.setVisible(true);
        customer_IDLabel.setVisible(true);
        appetizers.setVisible(false);
        salads.setVisible(false);
        mainDishes.setVisible(false);
        soups.setVisible(false);
        drinks.setVisible(false);
        deserts.setVisible(false);
    }

    
}
