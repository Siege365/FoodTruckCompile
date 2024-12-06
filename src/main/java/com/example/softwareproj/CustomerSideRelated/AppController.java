package com.example.softwareproj.CustomerSideRelated;

import com.example.softwareproj.AnimationHelper;
import com.example.softwareproj.DatabaseRelated.DBconnectionFood;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.StageStyle;


import java.util.*;

public class AppController {

    @FXML
    private AnchorPane AboutUs;

    @FXML
    private TextArea AccAddress;

    @FXML
    private TextField AccEmail;

    @FXML
    private Label AccID;

    @FXML
    private TextField AccFullName;

    @FXML
    private RadioButton AccGenderF;

    @FXML
    private RadioButton AccGenderM;

    @FXML
    private RadioButton AccGenderO;

    @FXML
    private TextField AccMobileNumber;

    @FXML
    private PasswordField AccPassword;

    @FXML
    private PasswordField AccRetypePassword;

    @FXML
    private Label AccUsername;

    @FXML
    private Label AccUsername1;

    @FXML
    private Button ArrozConLeche;

    @FXML
    private ImageView AvatarMore;

    @FXML
    private Button Burrito;

    @FXML
    private Button Buñuelos;

    @FXML
    private RadioButton CODPayment;

    @FXML
    private Button Capirotada;

    @FXML
    private AnchorPane Cart;

    @FXML
    private AnchorPane creditcard;

    @FXML
    private Pane CartHeader;

    @FXML
    private Button CreditCard;

    @FXML
    private Button ClearUserCardInfo;

    @FXML
    private AnchorPane CheckouFooter;

    @FXML
    private Button ChiaLime;

    @FXML
    private Button Chicharrones;

    @FXML
    private Button Chilaquiles;

    @FXML
    private Button Churros;

    @FXML
    private Button CucumberLime;

    @FXML
    private RadioButton DeliveryShippingOption;

    @FXML
    private Pane Dessertspane;

    @FXML
    private Pane Drinkspane;

    @FXML
    private Button EditInfobtn;

    @FXML
    private Button Elote;

    @FXML
    private Button Enchiladas;

    @FXML
    private Button Feedback;

    @FXML
    private Label FoodItemsSubtotalPaymentDetails;

    @FXML
    private Label HandlingFeePaymentDetails;

    @FXML
    private Button HotChocoBrownies;

    @FXML
    private Label ItemCounter1;

    @FXML
    private Button MangoMargarita;

    @FXML
    private Button Mechilada;

    @FXML
    private Button MyAccount;

    @FXML
    private Button Nachos;

    @FXML
    private AnchorPane Navigator;

    @FXML
    private Label OrderDetailsUserContactNumber;

    @FXML
    private Label OrderDetailsUserFullname;

    @FXML
    private AnchorPane OrderFooter;

    @FXML
    private TableView<FoodItem> OrderTable;

    @FXML
    private TableColumn<FoodItem, String> Order_Product;

    @FXML
    private TableColumn<FoodItem, Integer> Order_Quantity;

    @FXML
    private TableColumn<FoodItem, Double> Order_Price;

    @FXML
    private TableColumn<FoodItem, Double> Order_Total;

    @FXML
    private RadioButton PayOnlinePayment;

    @FXML
    private RadioButton PickUpShippingOption;

    @FXML
    private Button PinaColada;

    @FXML
    private Button PlaceOrder;

    @FXML
    private Button Quesadillas;

    @FXML
    private Button QuesoFresco;

    @FXML
    private Button RefriedBeans;

    @FXML
    private Label ShippingSubtotalPaymentDetails;

    @FXML
    private Button StrawberryLime;

    @FXML
    private Button TacoAlPastor;

    @FXML
    private Button TacoSalad;

    @FXML
    private Button TortillaChips;

    @FXML
    private Button TortillaSoup;

    @FXML
    private Label TotalPaymentDetails;

    @FXML
    private Button TransactionHistory;

    @FXML
    private Label Userlabel;

    @FXML
    private TextField UserCVC;

    @FXML
    private DatePicker UserCardExpiryDate;

    @FXML
    private TextField UserCardName;

    @FXML
    private TextField UserCardNumber;

    @FXML
    private TextArea OrderDetailsUserAddress;

    @FXML
    private Label Userlabel1;

    @FXML
    private Label Userlabel2;

    @FXML
    private ImageView avatar;

    @FXML
    private ImageView avatarimg;

    @FXML
    private Button back;

    @FXML
    private AnchorPane backButton;

    @FXML
    private Button backButton1;

    @FXML
    private Button cart;

    @FXML
    private AnchorPane desserts;

    @FXML
    private AnchorPane drinks;

    @FXML
    private AnchorPane feedback;

    @FXML
    private TextArea feedbacktxtArea;

    @FXML
    private ImageView foodCategoryLogo;

    @FXML
    private Label foodCategorytxt;

    @FXML
    private AnchorPane foodPage;

    @FXML
    private Pane footer;

    @FXML
    private Pane fpHeader;

    @FXML
    private Label itemCounter;

    @FXML
    private Button logoutbutton;

    @FXML
    private Pane mainAds;

    @FXML
    private Pane mainBestSeller;

    @FXML
    private Pane mainDishpane;

    @FXML
    private Pane mainHeader,orderheader;

    @FXML
    private TableView<?> mainOrderStatus;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Pane mainfirstPane;

    @FXML
    private AnchorPane md;

    @FXML
    private AnchorPane morePage;

    @FXML
    private Group morepageMain;

    @FXML
    private AnchorPane myaccount;

    @FXML
    private AnchorPane orderPage;

    @FXML
    private VBox paneContainer;

    @FXML
    private RadioButton questionradionBtn;

    @FXML
    private AnchorPane sd;

    @FXML
    private Pane sideDishpane;

    @FXML
    private Button submitFBbtn;

    @FXML
    private RadioButton suggestionradioBtn;

    @FXML
    private Label TotalPriceLabel , CartTitle,totalPriceLabel;

    @FXML
    private AnchorPane transactionhistory;
    @FXML
    private Spinner<Integer> food_spinner, food_spinner2, food_spinner3, food_spinner4,
            food_spinner5, food_spinner6, food_spinner7, food_spinner8,
            food_spinner9, food_spinner10, food_spinner11, food_spinner12,
            food_spinner13, food_spinner14, food_spinner15, food_spinner16,
            food_spinner17, food_spinner18, food_spinner19, food_spinner20,
            food_spinner21, food_spinner22, food_spinner23, food_spinner24;


    public void initialize() {
        // Initialize all spinners with consistent behavior
        List<Spinner<Integer>> spinners = Arrays.asList(
                food_spinner, food_spinner2, food_spinner3, food_spinner4, food_spinner5,
                food_spinner6, food_spinner7, food_spinner8, food_spinner9, food_spinner10,
                food_spinner11, food_spinner12, food_spinner13, food_spinner14, food_spinner15,
                food_spinner16, food_spinner17, food_spinner18, food_spinner19, food_spinner20,
                food_spinner21, food_spinner22, food_spinner23, food_spinner24
        );

        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
        }

        // Add available items to the spinner map
        availableItems.add(new FoodItem("Taco Al Pastor", 75.0, 1, "com/example/softwareproj/images/TacoPastor.jpg"));
        availableItems.add(new FoodItem("Burrito", 180.0, 1, "com/example/softwareproj/images/Burrito.jpg"));
        availableItems.add(new FoodItem("Quesadillas", 100.0, 1, "com/example/softwareproj/images/Quesa.jpg"));
        availableItems.add(new FoodItem("Enchiladas", 150.0, 1, "com/example/softwareproj/images/Enchiladas.jpg"));
        availableItems.add(new FoodItem("Nachos", 150.0, 1, "com/example/softwareproj/images/Nachos.png"));
        availableItems.add(new FoodItem("Chilaquiles", 140.0, 1, "com/example/softwareproj/images/Chila.png"));

        availableItems.add(new FoodItem("Tortilla Chips", 80.0, 1, "com/example/softwareproj/images/TortillaChips.png"));
        availableItems.add(new FoodItem("Elote", 75.0, 1, "com/example/softwareproj/images/Elote.png"));
        availableItems.add(new FoodItem("Refried Beans", 50.0, 1, "com/example/softwareproj/images/Refried.png"));
        availableItems.add(new FoodItem("Chicharrones", 50.0, 1, "com/example/softwareproj/images/Chicharrones.png"));
        availableItems.add(new FoodItem("Taco Salad", 95.0, 1, "com/example/softwareproj/images/TacoSalad.png"));
        availableItems.add(new FoodItem("Tortilla Soup", 100.0, 1, "com/example/softwareproj/images/TortillaSoup.png"));

        availableItems.add(new FoodItem("Chia Lime", 50.0, 1, "com/example/softwareproj/images/Chia.png"));
        availableItems.add(new FoodItem("Mechilada", 100.0, 1, "com/example/softwareproj/images/Mechilada.png"));
        availableItems.add(new FoodItem("Mango Margarita", 65.0, 1, "com/example/softwareproj/images/MangoMargarita.png"));
        availableItems.add(new FoodItem("Cucumber Lime", 50.0, 1, "com/example/softwareproj/images/CucumberLime.png"));
        availableItems.add(new FoodItem("Pina Colada", 65.0, 1, "com/example/softwareproj/images/Colada.png"));
        availableItems.add(new FoodItem("Strawberry Lime", 50.0, 1, "com/example/softwareproj/images/StrawberryLime.png"));

        availableItems.add(new FoodItem("Churros", 45.0, 1, "com/example/softwareproj/images/churro.png"));
        availableItems.add(new FoodItem("Buñuelos", 50.0, 1, "com/example/softwareproj/images/Bunuelos.png"));
        availableItems.add(new FoodItem("Hot Choco Brownies", 70.0, 1, "com/example/softwareproj/images/Brownies.png"));
        availableItems.add(new FoodItem("Arroz con Leche", 65.0, 1, "com/example/softwareproj/images/Arroz.png"));
        availableItems.add(new FoodItem("Queso Fresco", 70.0, 1, "com/example/softwareproj/images/Queso.png"));
        availableItems.add(new FoodItem("Capirotada", 70.0, 1, "com/example/softwareproj/images/Capirotada.png"));


        spinnerMap.put("Taco Al Pastor", food_spinner);
        spinnerMap.put("Burrito", food_spinner2);
        spinnerMap.put("Quesadillas", food_spinner3);
        spinnerMap.put("Enchiladas", food_spinner4);
        spinnerMap.put("Nachos", food_spinner5);
        spinnerMap.put("Chilaquiles", food_spinner6);
        spinnerMap.put("Tortilla Chips", food_spinner7);
        spinnerMap.put("Elote", food_spinner8);
        spinnerMap.put("Refried Beans", food_spinner9);
        spinnerMap.put("Chicharrones", food_spinner10);
        spinnerMap.put("Taco Salad", food_spinner11);
        spinnerMap.put("Tortilla Soup", food_spinner12);
        spinnerMap.put("Chia Lime", food_spinner13);
        spinnerMap.put("Mechilada", food_spinner14);
        spinnerMap.put("Mango Margarita", food_spinner15);
        spinnerMap.put("Cucumber Lime", food_spinner16);
        spinnerMap.put("Pina Colada", food_spinner17);
        spinnerMap.put("Strawberry Lime", food_spinner18);
        spinnerMap.put("Churros", food_spinner19);
        spinnerMap.put("Buñuelos", food_spinner20);
        spinnerMap.put("Hot Choco Brownies", food_spinner21);
        spinnerMap.put("Arroz con Leche", food_spinner22);
        spinnerMap.put("Queso Fresco", food_spinner23);
        spinnerMap.put("Capirotada", food_spinner24);

        // Bind the table columns to the properties of FoodItem
        Order_Product.setCellValueFactory(new PropertyValueFactory<>("name"));
        Order_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Order_Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Order_Total.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getTotal()).asObject()
        );

        // Create ToggleGroups
        ToggleGroup ShippingOption = new ToggleGroup();
        ToggleGroup PaymentMethods = new ToggleGroup();

        // Assign groups to RadioButtons
        PickUpShippingOption.setToggleGroup(ShippingOption);
        DeliveryShippingOption.setToggleGroup(ShippingOption);

        CODPayment.setToggleGroup(PaymentMethods);
        PayOnlinePayment.setToggleGroup(PaymentMethods);

        // Add listener for the ShippingOption group
        ShippingOption.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Disable all radio buttons in the ShippingOption group after selection
                PickUpShippingOption.setDisable(true);
                DeliveryShippingOption.setDisable(true);
            }
        });

        // Add listener for the PaymentMethods group
        PaymentMethods.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Disable all radio buttons in the PaymentMethods group after selection
                CODPayment.setDisable(true);
                PayOnlinePayment.setDisable(true);
            }
        });
    }
//start sa mga table shits
        private void updateOrderTable() { // Method to update the OrderTable when cart data changes

            OrderTable.refresh();  // Refresh the table to reflect changes in the cart
        }
//end sa mga table shits
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void getUserData(String username) {
        Userlabel.setText("Hello, " + username + "!");
        AccUsername.setText(username);
        AccUsername1.setText(username);
        Connection con = DBconnectionFood.ConnectionDB();
        String sql = "SELECT Email, FullName, UserID FROM register WHERE username = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    AccID.setText(rs.getString("UserID"));
                    AccFullName.setText(rs.getString("FullName"));
                    AccEmail.setText(rs.getString("Email"));
                    OrderDetailsUserFullname.setText(rs.getString("FullName"));
                } else {
                    showAlert("No Data", "No record found for the given username.", Alert.AlertType.INFORMATION);
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();  // Close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void toFood(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(false);
        foodPage.setVisible(true);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);
        OrderFooter.setVisible(false);
        orderheader.setVisible(false);
    }

    @FXML
    void toHome(ActionEvent event) {
        mainPage.setVisible(true);
        orderPage.setVisible(false);
        foodPage.setVisible(false);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);
        OrderFooter.setVisible(false);
        orderheader.setVisible(false);
        Navigator.setVisible(true);
        totalPriceLabel.setText("Total: ");
    }

    @FXML
    void toMore(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(false);
        foodPage.setVisible(false);
        morePage.setVisible(true);
        itemCounter.setVisible(false);
        cart.setVisible(false);
        OrderFooter.setVisible(false);
        orderheader.setVisible(false);

    }

    @FXML
    void toOrder(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(true);
        foodPage.setVisible(false);
        morePage.setVisible(false);
        itemCounter.setVisible(false);
        cart.setVisible(false);
        OrderFooter.setVisible(true);
        orderheader.setVisible(true);

    }
    @FXML
    void toCart(ActionEvent event) {
        // Hide all other pages or elements
        mainPage.setVisible(false);
        mainHeader.setVisible(true);
        orderPage.setVisible(false);
        foodPage.setVisible(true);
        morePage.setVisible(false);
        itemCounter.setVisible(false);
        cart.setVisible(true); // Make cart visible before starting the animation

        // Make the Navigator, Cart, and CheckouFooter visible
        Navigator.setVisible(false);
        Cart.setVisible(true);
        CheckouFooter.setVisible(true);
        OrderFooter.setVisible(false);
        orderheader.setVisible(false);

        AnimationHelper.animateNodesFromRightToLeft(Cart,CheckouFooter);

    }


    //end of navigation


    //start sa cart
    private ObservableList<FoodItem> cartItems = FXCollections.observableArrayList(); // List to store items in the cart
    private List<FoodItem> availableItems = new ArrayList<>(); // Your list of food items
    private Map<String, Spinner<Integer>> spinnerMap = new HashMap<>();
    private ObservableList<FoodItem> checkoutItems = FXCollections.observableArrayList();

    public void addItemToCart(FoodItem item) {
        // Check if the item is already in the cart
        for (FoodItem cartItem : cartItems) {
            if (cartItem.getName().equals(item.getName())) {
                // Update the quantity directly from the spinner
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                updateCartDisplay(); // Update the cart UI
                updateCounters();
                updateTotalPrice();  // Recalculate total price when quantity is updated
                return; // Exit the method since the item was already in the cart
            }
        }

        // If not found, add the new item to the cart
        cartItems.add(new FoodItem(item.getName(), item.getPrice(), item.getQuantity(), item.getImagePath()));
        updateCounters();
        updateTotalPrice(); // Recalculate total price
        updateCartDisplay();
    }

    private void updateCounters() {
        // Count the distinct food items in the cart
        int distinctItems = (int) cartItems.stream()
                .map(FoodItem::getName) // Get the name of each food item
                .distinct() // Ensure each food item is counted once, regardless of quantity
                .count(); // Count the number of unique items

        // Update both counters with the number of distinct food items
        itemCounter.setText(String.valueOf(distinctItems));
        ItemCounter1.setText(String.valueOf(distinctItems));
        int countreachmorethan10 = Integer.parseInt(itemCounter.getText());
        if (countreachmorethan10 >= 10){
            CartTitle.setText("Food Cart(    )");
        } else {
            CartTitle.setText("Food Cart(  )");
        }
    }

    // Method to update the display of the cart in the VBox
    private void updateCartDisplay() {
        // Clear the current cart display
        paneContainer.getChildren().clear();

        // Recreate the UI elements for each item in the cart
        for (FoodItem cartItem : cartItems) {
            Pane itemPane = createItemPane(cartItem);
            paneContainer.getChildren().add(itemPane);
        }

        // Optionally, update the total price of the cart
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double totalPrice = cartItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity()) // Ensure correct calculation
                .sum();

        TotalPriceLabel.setText("Total: ₱" + String.format("%.2f", totalPrice)); // Format total price to 2 decimal places
    }

    // Method to create a pane for a food item in the cart
    private Pane createItemPane(FoodItem item) {
        // Create the AnchorPane as the root of the item pane
        AnchorPane itemPane = new AnchorPane();
        itemPane.setPrefSize(1800, 200);  // Set width to 1800 and height to 200
        itemPane.setMaxHeight(200);       // Prevent shrinking the height
        itemPane.setMinHeight(200);       // Ensure the height remains constant
        itemPane.setStyle("-fx-background-color: white; -fx-background-radius: 15;");

        // Delete Button
        Button deleteButton = new Button("Delete");
        deleteButton.setLayoutX(600); // Position at the top right
        deleteButton.setLayoutY(20);
        deleteButton.setPrefSize(94, 47);
        deleteButton.setStyle("-fx-background-color: #EF3A31; -fx-background-radius: 15;");
        deleteButton.setTextFill(javafx.scene.paint.Color.web("#f8dc93"));
        deleteButton.setFont(new Font("System Bold", 13));
        deleteButton.setOnAction(e -> {
            cartItems.remove(item);
            updateCartDisplay();
            updateCounters();   //itemcounter and itemcounter1
            updateTotalPrice(); // Recalculate total price
        });

        // ImageView (directly added to the AnchorPane)
        ImageView itemImage = new ImageView();
        try {
            URL imageUrl = getClass().getResource("/" + item.getImagePath());
            if (imageUrl != null) {
                itemImage.setImage(new Image(imageUrl.toExternalForm())); // Load the image
            } else {
                System.err.println("Image not found: " + item.getImagePath()); // Log missing image
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage()); // Handle errors
        }

        // Stretch the image to fit within the desired size
        itemImage.setLayoutX(45); // Position the image
        itemImage.setLayoutY(50); // Position below the checkbox
        itemImage.setFitWidth(120); // Set the width of the image
        itemImage.setFitHeight(120); // Set the height of the image
        itemImage.setPreserveRatio(false); // Disable aspect ratio preservation
        itemImage.setSmooth(true); // Enable smooth scaling

        // Item Name Label
        Label itemNameLabel = new Label(item.getName());
        itemNameLabel.setLayoutX(180); // Next to the image
        itemNameLabel.setLayoutY(50); // Align with the image top
        itemNameLabel.setFont(new Font("System Bold", 18));
        itemNameLabel.setPrefWidth(300); // Provide enough space for names

        // Item Price Label
        Label itemPriceLabel = new Label("₱" + item.getPrice());
        itemPriceLabel.setLayoutX(180); // Align with name
        itemPriceLabel.setLayoutY(90); // Slightly below the name
        itemPriceLabel.setFont(new Font("System Bold", 16));


        // Quantity Spinner
        Spinner<Integer> quantitySpinner = new Spinner<>();
        quantitySpinner.setLayoutX(550); // Align right
        quantitySpinner.setLayoutY(140); // Bottom-right corner
        quantitySpinner.setPrefSize(120, 30);
        quantitySpinner.setStyle("-fx-scale-x: 1.5; -fx-scale-y: 1.5;");
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, item.getQuantity());
        quantitySpinner.setValueFactory(valueFactory);

        quantitySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Update the item quantity when spinner value changes
            item.setQuantity(newValue);
            updateTotalPrice(); // Recalculate total price when quantity changes
        });

        // Add all components to the AnchorPane
        itemPane.getChildren().addAll(
                deleteButton, itemImage,
                itemNameLabel, itemPriceLabel, quantitySpinner
        );

        return itemPane;
    }

    @FXML
    void toBackMain(ActionEvent event) {
        // Show Cart and then animate it off-screen
        Cart.setVisible(true); // Make sure Cart is visible before animation starts
        mainPage.setVisible(false);
        orderPage.setVisible(false);
        foodPage.setVisible(true);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);
        Navigator.setVisible(true);
        CheckouFooter.setVisible(true);
        OrderFooter.setVisible(false);
        orderheader.setVisible(false);

        AnimationHelper.animateNodesFromLeftToRight(Cart,CheckouFooter);

    }


    @FXML
    private void DeleteAllPane(ActionEvent event){
        cartItems.clear();
        paneContainer.getChildren().clear();
        updateOrderTable();
        updateCounters();
        updateTotalPrice();
    }
    // Method to handle the button click to add to cart
    @FXML
    private void Add2Cart(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String itemId = clickedButton.getId(); // ID of the clicked button

        // Find the corresponding FoodItem
        FoodItem selectedItem = availableItems.stream()
                .filter(item -> item.getName().replace(" ", "").equalsIgnoreCase(itemId.replace(" ", "")))
                .findFirst()
                .orElse(null);

        if (selectedItem != null) {
            // Get the corresponding spinner for this food item
            Spinner<Integer> spinner = spinnerMap.get(selectedItem.getName());
            if (spinner != null) {
                int quantity = spinner.getValue(); // Get the spinner value
                selectedItem.setQuantity(quantity); // Update the item's quantity
                addItemToCart(selectedItem); // Add the item to the cart
            } else {
                System.err.println("Spinner not found for item: " + selectedItem.getName());
            }
        } else {
            System.out.println("Item not found for ID: " + itemId);
        }
    }

    @FXML
    private void handleCheckout(ActionEvent event) {
        // Check if cart is empty
        if (cartItems.isEmpty()) {
            // Call your existing method to show the error message
            showAlert("Your cart is empty"," Please add items to the cart before proceeding.", Alert.AlertType.WARNING);
            return; // Exit the method if cart is empty
        }

        double totalPrice = 0.0;

        for (FoodItem cartItem : cartItems) {
            Optional<FoodItem> existingItem = checkoutItems.stream()
                    .filter(item -> item.getName().equals(cartItem.getName()))
                    .findFirst();

            if (existingItem.isPresent()) {
                FoodItem existing = existingItem.get();
                existing.setQuantity(existing.getQuantity() + cartItem.getQuantity());
            } else {
                checkoutItems.add(new FoodItem(
                        cartItem.getName(),
                        cartItem.getPrice(),
                        cartItem.getQuantity(),
                        cartItem.getImagePath()
                ));
            }
        }

        // Update the OrderTable
        OrderTable.setItems(checkoutItems);
        OrderTable.refresh();

        // Calculate total price
        totalPrice = checkoutItems.stream()
                .mapToDouble(item -> item.getTotal())
                .sum();

        // Update the total price label
        totalPriceLabel.setText(String.format("Total: ₱%.2f", totalPrice));

        // Proceed to the order page
        FoodItemsSubtotalPaymentDetails.setText("₱"+totalPrice);

        // Hide the cart and footer
        Cart.setVisible(false);
        CheckouFooter.setVisible(false);
        toOrder(event);

        // Call the helper method to animate the nodes
        AnimationHelper.animateStartFromRight(Cart,CheckouFooter);
       AnimationHelper.animateNodesFromRightToLeft(orderPage, orderheader, OrderFooter);
    }


//end of cart


    //start sa food category
    @FXML
    void toBack(ActionEvent event) {
        desserts.setVisible(false);
        md.setVisible(false);
        sd.setVisible(false);
        drinks.setVisible(false);
        backButton.setVisible(false);
        foodCategoryLogo.setVisible(true);
        foodCategorytxt.setVisible(true);
        mainDishpane.setVisible(true);
        sideDishpane.setVisible(true);
        Dessertspane.setVisible(true);
        Drinkspane.setVisible(true);

    }

    @FXML
    void toDesserts(MouseEvent event) {
        desserts.setVisible(true);
        mainDishpane.setVisible(false);
        sideDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        backButton.setVisible(true);

    }

    @FXML
    void toDrinks(MouseEvent event) {
        drinks.setVisible(true);
        mainDishpane.setVisible(false);
        sideDishpane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);

    }

    @FXML
    void toMD(MouseEvent event) {
        md.setVisible(true);
        sideDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);
    }

    @FXML
    void toSD(MouseEvent event) {
        sd.setVisible(true);
        mainDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);

    }
//end sa food category

//start sa more page

    @FXML
    private void handleSubmitFeedback() {
        // Retrieve the selected feedback type
        String feedbackType = "";
        if (questionradionBtn.isSelected()) {
            feedbackType = "Question";
        } else if (suggestionradioBtn.isSelected()) {
            feedbackType = "Suggestion";
        }

        // Retrieve the feedback description from the TextArea
        String feedbackDescription = feedbacktxtArea.getText();

        // Validate that feedback description is not empty
        if (feedbackDescription.isEmpty() || feedbackType.isEmpty()) {
            showAlert("Validation Error", "Please select a feedback type and provide a description.", Alert.AlertType.WARNING);
            return;
        }

        // SQL query to insert feedback into the database
        String query = "INSERT INTO feedback (feedback_type, feedback_description) VALUES (?, ?)";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the parameters for the query
            statement.setString(1, feedbackType);
            statement.setString(2, feedbackDescription);

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Feedback submitted successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to submit feedback.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while submitting feedback.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEditInformationButton() {
        String username = AccUsername.getText();  // Get the current username
        String fullName = AccFullName.getText();
        String email = AccEmail.getText();
        String password = AccPassword.getText();
        String mobileNumber = AccMobileNumber.getText();
        String gender = getSelectedGender();  // Get the selected gender
        String address = AccAddress.getText();
        Image img = avatarimg.getImage();

        // Store the image file path if an image was selected
        String imageFilePath = (img != null && img.getUrl() != null) ? new File(img.getUrl()).getAbsolutePath() : "No Image";

        saveOrUpdateUserInfo(username, fullName, email, password, mobileNumber, gender, address, imageFilePath);
    }

    // Get the selected gender from the RadioButtons
    private String getSelectedGender() {
        if (AccGenderM.isSelected()) {
            return "Male";
        } else if (AccGenderF.isSelected()) {
            return "Female";
        } else if (AccGenderO.isSelected()) {
            return "Other";
        }
        return null;
    }

    // Updated saveOrUpdateUserInfo to accept imageFilePath as String
    private void saveOrUpdateUserInfo(String username, String fullName, String email, String password, String mobileNumber, String gender, String address, String imageFilePath) {
        // Validate that required fields are not empty
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || mobileNumber.isEmpty() || gender == null || address.isEmpty()) {
            showAlert("Validation Error", "Please fill in all the required fields.", Alert.AlertType.WARNING);
            return; // Stop execution if fields are empty
        }

        String query = "INSERT INTO accountdetails (Username, Full_Name, Email, Password, Mobile_Number, Gender, Account_Address, Account_Avatar) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "Full_Name = VALUES(Full_Name), " +
                "Email = VALUES(Email), " +
                "Password = VALUES(Password), " +
                "Mobile_Number = VALUES(Mobile_Number), " +
                "Gender = VALUES(Gender), " +
                "Account_Address = VALUES(Account_Address), " +
                "Account_Avatar = VALUES(Account_Avatar);";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the query
            statement.setString(1, username);
            statement.setString(2, fullName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, mobileNumber);
            statement.setString(6, gender);
            statement.setString(7, address);
            statement.setString(8, imageFilePath); // Save the image file path as String

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                // Show success alert if the information is saved/updated successfully
                showAlert("Success", "Information saved/updated successfully.", Alert.AlertType.INFORMATION);
            } else {
                // Show error alert if the information wasn't saved
                showAlert("Error", "Error: Information not saved.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Show error alert if there's an exception
            showAlert("Error", "An error occurred while saving/updating information.", Alert.AlertType.ERROR);
        }
        OrderDetailsUserContactNumber.setText(mobileNumber);
        OrderDetailsUserAddress.setText(address);
        //AvatarMore.
    }

    @FXML
    void HandleUserCardInformationButton(ActionEvent event) { //sa credit page

    }
    @FXML
    void ClearUserCardInformation(ActionEvent event) { //sa credit page

    }

    @FXML
    void toDeleteAccount(ActionEvent event) {
        // Show confirmation alert to the user
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account");
        alert.setHeaderText("Are you sure you want to delete your account?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed account deletion

            // Retrieve username from label (ensure it's correctly initialized)
            String username = Userlabel.getText();

            // Establish the database connection using try-with-resources
            try (Connection con = DBconnectionFood.ConnectionDB()) {
                if (con != null) {
                    // Prepare and execute the delete queries using separate PreparedStatements
                    String sql1 = "DELETE FROM accountdetails WHERE Username = ?";
                    String sql2 = "DELETE FROM register WHERE Username = ?";

                    // Delete from accountdetails
                    try (PreparedStatement pst1 = con.prepareStatement(sql1)) {
                        pst1.setString(1, username);
                        int rowsAffected1 = pst1.executeUpdate();

                        // Delete from register
                        try (PreparedStatement pst2 = con.prepareStatement(sql2)) {
                            pst2.setString(1, username);
                            int rowsAffected2 = pst2.executeUpdate();

                            // Check if both deletions were successful
                            if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                                // Deletion was successful
                                showAlert("Success", "Your account has been successfully deleted.", Alert.AlertType.INFORMATION);
                                // Perform logout or any other necessary actions
                                toLogout();
                            } else {
                                // If no rows were affected, the account wasn't found in one of the tables
                                showAlert("Error", "Account not found or could not be deleted.", Alert.AlertType.ERROR);
                            }
                        }
                    }
                } else {
                    // Handle case where database connection failed
                    showAlert("Error", "Failed to connect to the database.", Alert.AlertType.ERROR);
                }
            } catch (SQLException e) {
                // Handle SQL exceptions
                showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
                e.printStackTrace(); // Print stack trace for debugging
            }
        }
    }

    @FXML
    void toLogout() {
        // Create and display the confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("You are about to log out.");
        alert.setContentText("Are you sure you want to log out?");

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // If the user confirms, proceed with logout
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Close the current stage using the event source
            Stage currentStage = (Stage) logoutbutton.getScene().getWindow();
            currentStage.close();

            try {
                // Load the login page
                Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);

                // Set the application icon
                Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
                stage.getIcons().add(icon);

                // Set the title and display the login page
                stage.setTitle("El Pedidos Mexicanos");
                stage.show();
            } catch (IOException e) {
                // Handle potential IOExceptions
                e.printStackTrace();
            }
        }
    }
    @FXML
    void toAboutUs(ActionEvent event) {
        AboutUs.setVisible(true);
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(false);
        back.setVisible(true);
        morepageMain.setVisible(false);
    }
    @FXML
    void toCreditCard(ActionEvent event) {
        creditcard.setVisible(true);
        myaccount.setVisible(true);
        feedback.setVisible(false);
        back.setVisible(true);
        AboutUs.setVisible(false);
        morepageMain.setVisible(false);
    }

    @FXML
    void MyAccount(ActionEvent  event) {
        myaccount.setVisible(true);
        feedback.setVisible(false);
        back.setVisible(true);
        AboutUs.setVisible(false);
        morepageMain.setVisible(false);

    }
    @FXML
    void toBack1(ActionEvent event) {
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(false);
        back.setVisible(false);
        AboutUs.setVisible(false);
        morepageMain.setVisible(true);
        creditcard.setVisible(false);
    }


    @FXML
    void Feedback(ActionEvent  event) {
        myaccount.setVisible(false);
        feedback.setVisible(true);
        transactionhistory.setVisible(false);
        back.setVisible(true);
        AboutUs.setVisible(false);
        morepageMain.setVisible(false);

    }
    @FXML
    void TransactionHistory(ActionEvent  event) {
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(true);
        back.setVisible(true);
        AboutUs.setVisible(false);
        morepageMain.setVisible(false);

    }
    @FXML
    void ImportAvatar(MouseEvent event) {
        // Open a file chooser to select an image
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File selectedImageFile = fileChooser.showOpenDialog(null);

        // If an image is selected, display it in the ImageView
        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            avatar.setImage(image);

            // Set the ImageView size to be a square for proper circular effect
            double size = 230;  // Use a square size for the avatar
            avatar.setFitWidth(size);
            avatar.setFitHeight(size);

            // Apply a circular clip with adjusted center and radius
            double centerX = size / 2;  // Center X (115 for 230 size)
            double centerY = size / 2;  // Center Y (115 for 230 size)
            double radius = size / 2;   // Radius (115 for 230 size)
            Circle clip = new Circle(centerX, centerY, radius);
            avatar.setClip(clip);

            // Optional: Add a border to the circular image
            avatar.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 2;" +
                            "-fx-padding: 0 0 0 5;"
            );
        } else {
            // Create and display an alert if no image is selected
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Image Selected");
            alert.setHeaderText(null);
            alert.setContentText("No image was selected. Please choose an image to upload.");
            alert.showAndWait();
        }
    }
    @FXML
    void RadioButtons(ActionEvent event) {
        // Create a ToggleGroup
        ToggleGroup genderGroup = new ToggleGroup();

        // Assign the ToggleGroup to all RadioButtons
        AccGenderM.setToggleGroup(genderGroup);
        AccGenderF.setToggleGroup(genderGroup);
        AccGenderO.setToggleGroup(genderGroup);

        // Add listeners to detect when a RadioButton is selected or deselected
        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // When a RadioButton is selected, disable the others
                disableAccGenderOButtons(newValue);
            } else {
                // If no selection, enable all RadioButtons
                enableAllRadioButtons();
            }
        });
    }

    // Disable RadioButtons based on the selected one
    private void disableAccGenderOButtons(Toggle selectedToggle) {
        if (selectedToggle == AccGenderM) {
            AccGenderF.setDisable(true);
            AccGenderO.setDisable(true);
        } else if (selectedToggle == AccGenderF) {
            AccGenderM.setDisable(true);
            AccGenderO.setDisable(true);
        } else if (selectedToggle == AccGenderO) {
            AccGenderM.setDisable(true);
            AccGenderF.setDisable(true);
        }
    }

    // Enable all RadioButtons
    private void enableAllRadioButtons() {
        AccGenderM.setDisable(false);
        AccGenderF.setDisable(false);
        AccGenderO.setDisable(false);
    }
    //end sa more page

    //start sa orderpage

    @FXML
    private void GotoHomeOrGotoCart(ActionEvent event) {
        // Check if OrderTable has data
        if (OrderTable.getItems().isEmpty()) {
            toHome(event); // Navigate to Home if table is empty
        } else {
            // Ensure all required nodes are visible
            mainPage.setVisible(false);
            mainHeader.setVisible(true);
            foodPage.setVisible(false);
            morePage.setVisible(false);
            itemCounter.setVisible(false);
            Navigator.setVisible(false);
            Cart.setVisible(true);
            CheckouFooter.setVisible(true);
            orderPage.setVisible(true);
            orderheader.setVisible(true);
            OrderFooter.setVisible(true);
            OrderTable.getItems().clear();
            OrderTable.refresh();
            AnimationHelper.animateNodesFromLeftToRightThatWontPermanentlyHideTheNode(orderPage, orderheader, OrderFooter);
            AnimationHelper.animateStartFromLeft(CheckouFooter, Cart);

        }
    }




    @FXML
    void RadioButtonsOrderDetails(ActionEvent event) {
        // Enable all radio buttons
        enableRadioButtons(true);
        // Recalculate payment details based on current selection
        calculateOrderDetails();
    }

    private void calculateOrderDetails() {
        // Get the food items subtotal text, remove the currency symbol and parse the value
        String foodItemsSubtotalText = FoodItemsSubtotalPaymentDetails.getText();
        double foodItemsSubtotal = 0.0;

        // Check if the text contains the ₱ symbol and remove it before parsing
        if (foodItemsSubtotalText.contains("₱")) {
            foodItemsSubtotalText = foodItemsSubtotalText.replace("₱", "").trim();
        }
        // Parse the numeric value into a double
        try {
            foodItemsSubtotal = Double.parseDouble(foodItemsSubtotalText);
        } catch (NumberFormatException e) {
            // Handle invalid input gracefully (e.g., show an error message)
            System.out.println("Invalid number format: " + e.getMessage());
            return;
        }

        // Calculate the shipping cost
        double shippingCost = getShippingCost();
        ShippingSubtotalPaymentDetails.setText("₱" + String.format("%.2f", shippingCost));

        // Calculate the handling fee based on the selected payment method
        double handlingFee = getHandlingFee();
        HandlingFeePaymentDetails.setText("₱" + String.format("%.2f", handlingFee));

        // Recalculate the total payment
        double totalPayment = foodItemsSubtotal + shippingCost + handlingFee;
        TotalPaymentDetails.setText("₱" + String.format("%.2f", totalPayment));
        totalPriceLabel.setText("Total: ₱" + totalPayment);
    }


    private double getShippingCost() {
        // Calculate shipping cost based on the selected shipping option
        if (DeliveryShippingOption.isSelected()) {
            return 80.0;
        } else if (PickUpShippingOption.isSelected()) {
            return 20.0;
        } else {
            return 0.0;
        }
    }

    private double getHandlingFee() {
        // Calculate handling fee based on the selected payment method
        if (CODPayment.isSelected()) {
            return 0.0;
        } else if (PayOnlinePayment.isSelected()) {
            return 40.0;
        } else {
            return 0.0;
        }
    }

    private void enableRadioButtons(boolean isEnabled) {
        // Enable or disable radio buttons based on the passed flag
        PickUpShippingOption.setDisable(!isEnabled);
        DeliveryShippingOption.setDisable(!isEnabled);
        CODPayment.setDisable(!isEnabled);
        PayOnlinePayment.setDisable(!isEnabled);
    }

    @FXML
    private void handleOrderPage(ActionEvent event) {
        try {
            // Validate User Details
            String userFullName = OrderDetailsUserFullname.getText().trim();
            String userContactNumber = OrderDetailsUserContactNumber.getText().trim();
            if (userFullName.isEmpty() || userContactNumber.isEmpty()) {
                throw new IllegalArgumentException("Please complete all user details.");
            }

            // Validate Delivery Method
            String deliveryType;
            if (DeliveryShippingOption.isSelected()) {
                deliveryType = "Delivery";
            } else if (PickUpShippingOption.isSelected()) {
                deliveryType = "Pickup";
            } else {
                throw new IllegalArgumentException("Please select a delivery method.");
            }

            // Calculate Total Price
            double foodItemsSubtotal = checkoutItems.stream()
                    .mapToDouble(FoodItem::getTotal)
                    .sum();
            double shippingCost = deliveryType.equals("Delivery") ? getShippingCost() : 0; // No shipping cost for pickup
            double handlingFee = getHandlingFee();
            double totalPrice = foodItemsSubtotal + shippingCost + handlingFee;

            // Determine Payment Method
            FXMLLoader loader;
            Scene scene;
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED); // No window decorations
            stage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            stage.getIcons().add(icon);

            if (CODPayment.isSelected()) {
                // Cash on Delivery
                loader = new FXMLLoader(getClass().getResource("JustReceipt.fxml"));
                scene = new Scene(loader.load());
                stage.setTitle("El Pedidos - COD Receipt");

                // Pass data to the receipt controller
                ReceiptController receiptController = loader.getController();
                receiptController.setReceiptDetails(
                        userFullName, userContactNumber, deliveryType, "Cash on Delivery",
                        checkoutItems, foodItemsSubtotal, shippingCost, handlingFee, totalPrice
                );

                stage.setScene(scene);
                stage.show();

                // Show success alert for COD
                showAlert("Success", "Your order has been placed successfully! Please print your receipt as proof for order validation and claiming.", Alert.AlertType.INFORMATION);
            } else if (PayOnlinePayment.isSelected()) {
                // Online Payment
                loader = new FXMLLoader(getClass().getResource("OnlinePaymentReceipt.fxml"));
                scene = new Scene(loader.load());
                stage.setTitle("El Pedidos - Online Payment Receipt");

                // Pass data to the receipt controller
                ReceiptController receiptController = loader.getController();
                receiptController.setReceiptDetails(
                        userFullName, userContactNumber, deliveryType, "Online Payment",
                        checkoutItems, foodItemsSubtotal, shippingCost, handlingFee, totalPrice
                );
                receiptController.PayAmountbtn.setText("Pay ₱"+totalPrice);
                stage.setScene(scene);
                stage.show();
                // No success alert for Online Payment
            } else {
                throw new IllegalArgumentException("Please select a payment method.");
            }

            // Clear cart and update UI
            cartItems.clear();
            updateCartDisplay();
            updateCounters();
            updateTotalPrice();
            OrderTable.getItems().clear(); // Clear the table
            OrderTable.refresh();

            // Navigate to Home after placing the order
            toHome(event);

        } catch (IllegalArgumentException e) {
            showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        } catch (IOException e) {
            showAlert("Error", "Failed to load the receipt page: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }








    private void saveTransaction(String userFullName, String userContactNumber, List<FoodItem> orderedItems, double totalPrice, double shippingCost, double handlingFee) {
        // Save the order to the transaction history table in the database
        String query = "INSERT INTO transaction_history (userFullName, userContactNumber, orderedItems, totalPrice, shippingCost, handlingFee) VALUES (?,?,?,?,?,?)";
        // Execute the query with appropriate parameters
    }

 //sql queries

}
