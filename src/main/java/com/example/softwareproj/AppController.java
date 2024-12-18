package com.example.softwareproj;

import com.example.softwareproj.GettersAndSetters.CustomerOrder;
import com.example.softwareproj.GettersAndSetters.FoodItem;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    private TextField titleOfConcerntf;

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
    private TableColumn<CustomerOrder, Integer> mainOrderID;

    @FXML
    private TableView<CustomerOrder> mainOrderTable;

    @FXML
    private TableColumn<CustomerOrder, String> mainCustomerName;

    @FXML
    private TableColumn<CustomerOrder, String> mainContactNumber;

    @FXML
    private TableColumn<CustomerOrder, String> mainOrderType;

    @FXML
    private TableColumn<CustomerOrder, String> mainAddress;


    @FXML
    private TableColumn<CustomerOrder, String> mainDate;

    @FXML
    private TableColumn<CustomerOrder, String> mainPaymentType;

    @FXML
    private TableColumn<CustomerOrder, String> mainStatus;

    @FXML
    private TableColumn<CustomerOrder, Integer> mainTotal;

    @FXML
    private TableColumn<CustomerOrder, Integer> mainTotalProducts;

    @FXML
    private TableColumn<CustomerOrder, String> transactionAddress;

    @FXML
    private TableColumn<CustomerOrder, String> transactionContactNumber;

    @FXML
    private TableColumn<CustomerOrder, String> transactionCustomerName;

    @FXML
    private TableColumn<CustomerOrder, String> transactionDate;

    @FXML
    private TableView<CustomerOrder> transactionHistoryTable;

    @FXML
    private TableColumn<CustomerOrder, Integer> transactionOrderID;

    @FXML
    private TableColumn<CustomerOrder, String> transactionOrderType;

    @FXML
    private TableColumn<CustomerOrder, String> transactionPaymentType;

    @FXML
    private TableColumn<CustomerOrder, String> transactionFoodItems;

    @FXML
    private TableColumn<CustomerOrder, String> transactionStatus;

    @FXML
    private TableColumn<CustomerOrder, Integer> transactionTotal;

    @FXML
    private TableColumn<CustomerOrder, Integer> transactionTotalProducts;

    @FXML
    private TextArea transactionContent;

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
    private GridPane dessertsGridpane,maindishGridpane,sidedishGridpane,drinksGridpane;

    @FXML
    private Spinner<Integer> food_spinner, food_spinner2, food_spinner3, food_spinner4,
            food_spinner5, food_spinner6, food_spinner7, food_spinner8,
            food_spinner9, food_spinner10, food_spinner11, food_spinner12,
            food_spinner13, food_spinner14, food_spinner15, food_spinner16,
            food_spinner17, food_spinner18, food_spinner19, food_spinner20,
            food_spinner21, food_spinner22, food_spinner23, food_spinner24;

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
                    populateMainOrderOverview();
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
        updateFoodPage(maindishGridpane, sidedishGridpane, drinksGridpane, dessertsGridpane);

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

        mainOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        mainCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        mainContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        mainOrderType.setCellValueFactory(new PropertyValueFactory<>("customerOrderType"));
        mainPaymentType.setCellValueFactory(new PropertyValueFactory<>("customerPaymentType"));
        mainDate.setCellValueFactory(new PropertyValueFactory<>("customerOrderDate"));
        mainAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        mainTotalProducts.setCellValueFactory(new PropertyValueFactory<>("amountOfProducts"));
        mainTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        mainStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));

        transactionOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        transactionCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        transactionContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        transactionOrderType.setCellValueFactory(new PropertyValueFactory<>("customerOrderType"));
        transactionPaymentType.setCellValueFactory(new PropertyValueFactory<>("customerPaymentType"));
        transactionDate.setCellValueFactory(new PropertyValueFactory<>("customerOrderDate"));
        transactionAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        transactionTotalProducts.setCellValueFactory(new PropertyValueFactory<>("amountOfProducts"));
        transactionFoodItems.setCellValueFactory(new PropertyValueFactory<>("foodItem"));
        transactionTotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        transactionStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
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

//navigator
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
    public void toHome(ActionEvent event) {
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
        deleteButton.setTextFill(Color.web("#f8dc93"));
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
        OrderTable.refresh();
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
    void cancelOrder(ActionEvent event) {
        // Get the selected order
        CustomerOrder selectedOrder = transactionHistoryTable.getSelectionModel().getSelectedItem();

        if (selectedOrder != null) {
            String orderStatus = selectedOrder.getOrderStatus();
            if ("Pending".equals(orderStatus)) {
                DBconnectionFood.cancelCustomerOrder(selectedOrder);
                showAlert("Success", "Order has been cancelled successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Cancel Order", "Order cannot be cancelled because it is not pending.", Alert.AlertType.WARNING);
            }
            // Refresh the data in the tables
            populateMainOrderOverview();
        } else {
            showAlert("Cancel Order", "No order selected. Please select an order to cancel.", Alert.AlertType.WARNING);
        }
    }


    @FXML
    private void handleSubmitFeedback() {
        // Retrieve the selected feedback type
        String feedbackType = "";
        if (questionradionBtn.isSelected()) {
            feedbackType = "Question";
        } else if (suggestionradioBtn.isSelected()) {
            feedbackType = "Suggestion";
        }

        // Validate that feedback type is selected
        if (feedbackType.isEmpty()) {
            showAlert("Validation Error", "Please select a feedback type.", Alert.AlertType.WARNING);
            return;
        }

        // Retrieve the feedback description from the TextArea
        String feedbackDescription = feedbacktxtArea.getText();

        // Validate that feedback description is not empty
        if (feedbackDescription.isEmpty()) {
            showAlert("Validation Error", "Please provide a feedback description.", Alert.AlertType.WARNING);
            return;
        }

        // Retrieve the username and account ID from the labels (make sure they are not null)
        String username = AccUsername1.getText();
        String userId = AccID.getText();
        String title = titleOfConcerntf.getText();

        if (username == null || username.isEmpty() || userId == null || userId.isEmpty()|| title.isEmpty()) {
            showAlert("Validation Error", "Username or Account ID is missing.", Alert.AlertType.WARNING);
            return;
        }

        // Call the submitFeedback method
        DBconnectionFood.submitFeedback(userId, username, feedbackType, title,feedbackDescription);

        feedbacktxtArea.clear();
        titleOfConcerntf.clear();
        questionradionBtn.setSelected(false);
        suggestionradioBtn.setSelected(false);
    }


    @FXML
    private void handleEditInformationButton() {
        int id = Integer.parseInt(AccID.getText());
        String username = AccUsername.getText();  // Get the current username
        String fullName = AccFullName.getText();
        String email = AccEmail.getText();
        String password = AccPassword.getText();
        String retypePassword = AccRetypePassword.getText();
        String mobileNumber = AccMobileNumber.getText();
        String gender = getSelectedGender();  // Get the selected gender
        String address = AccAddress.getText();
        Image img = avatar.getImage();

        // If no image selected, use the default "No Image" value
        String imageFilePath = (selectedImageFile != null)
                ? getRelativePath(selectedImageFile) // Convert to relative path
                : "No Image";

        if (!password.equals(retypePassword)) {
            showAlert("Validation Error", "Passwords do not match.", Alert.AlertType.WARNING);
            return;
        }

        // Call the method to save or update user info
        DBconnectionFood.saveOrUpdateUserInfo(id,username, fullName, email, password, mobileNumber, gender, address, imageFilePath);

        // Update UI components
        OrderDetailsUserContactNumber.setText(mobileNumber);
        OrderDetailsUserAddress.setText(address);
        AvatarMore.setImage(avatar.getImage());
    }



    private String getRelativePath(File file) {
        // Assuming the images are stored in "src/main/resources/images/"
        // This method returns the path relative to the resources folder
        String baseDir = new File("src/main/resources").getAbsolutePath();
        String filePath = file.getAbsolutePath();

        if (filePath.startsWith(baseDir)) {
            String relativePath = filePath.substring(baseDir.length() + 1); // +1 to remove the slash after "resources"
            relativePath = relativePath.replace("\\", "/"); // Ensure forward slashes
            return relativePath;
        } else {
            return "No Image";
        }
    }

    private File selectedImageFile; // Store the selected image file path

    @FXML
    void ImportAvatar(MouseEvent event) {
        // Open a file chooser to select an image
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        selectedImageFile = fileChooser.showOpenDialog(null); // Assign to the class-level variable

        // If an image is selected, display it in the ImageView
        if (selectedImageFile != null && selectedImageFile.exists()) {
            try {
                // Use the absolute file path to create an Image object
                Image image = new Image(selectedImageFile.toURI().toString());

                // Set the image to the avatar ImageView
                avatar.setImage(image);

                // Optional: Set the ImageView size and apply a circular clip (if needed)
                double size = 230;  // Example size for the avatar
                avatar.setFitWidth(size);
                avatar.setFitHeight(size);

                // Apply a circular clip with adjusted center and radius
                double centerX = size / 2;  // Center X
                double centerY = size / 2;  // Center Y
                double radius = size / 2;   // Radius
                Circle clip = new Circle(centerX, centerY, radius);
                avatar.setClip(clip);

                // Optional: Add a border to the circular image
                avatar.setStyle("-fx-border-color: black; -fx-border-width: 2;");
            } catch (Exception e) {
                showAlert("Error", "Unable to load the image.", Alert.AlertType.ERROR);
            }
        } else {
            // If no image is selected or the file doesn't exist, show an alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Image Selected");
            alert.setHeaderText(null);
            alert.setContentText("No image was selected. Please choose an image to upload.");
            alert.showAndWait();
        }
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


    @FXML
    void HandleUserCardInformationButton(ActionEvent event) {
        String cardName = UserCardName.getText();
        String cardNumber = UserCardNumber.getText();
        LocalDate cardDate = UserCardExpiryDate.getValue(); // Get the selected date from the date picker
        String cardCVC = UserCVC.getText();

        // Validate inputs
        if (cardName.isEmpty() || cardNumber.isEmpty() || cardDate == null || cardCVC.isEmpty()) {
            showAlert("Validation Error", "Please fill in all the required fields.", Alert.AlertType.WARNING);
            return; // Stop execution if fields are empty
        }

        // Call the method to save or update the card information
        int accountId = Integer.parseInt(AccID.getText()); // Assuming AccID is a TextField or similar
        DBconnectionFood.saveOrUpdateCardInfo(accountId, cardName, cardNumber, cardDate, cardCVC);
    }

    @FXML
    void ClearUserCardInformation(ActionEvent event) { //sa credit page
        UserCardName.clear();
        UserCardNumber.clear();
        UserCVC.clear();
        UserCardExpiryDate.setValue(null);
    }

    @FXML
    void toDeleteAccount(ActionEvent event) {
        // Retrieve username from label
        String username = AccUsername1.getText();

        // Ask for confirmation before deleting the account
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account");
        alert.setHeaderText("Are you sure you want to delete your account?");
        alert.setContentText("This action is irreversible.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Call the method to delete the account from database
            boolean accountDeleted = DBconnectionFood.deleteAccountFromDatabase(username);
            if (accountDeleted) {
                logout();
            } else {
                showAlert("Error", "Failed to delete account.", Alert.AlertType.ERROR);
            }
        }
    }

    void logout() {
        try {
            // Load the login page
            Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));
            Stage currentStage = (Stage) logoutbutton.getScene().getWindow();

            // Set the scene in the current stage
            Scene scene = new Scene(root);
            currentStage.setScene(scene);

            // Set the application icon
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            currentStage.getIcons().add(icon);

            // Set the title for the login window
            currentStage.setTitle("El Pedidos Mexicanos");

            // Show the login window in the same stage
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load login page: " + e.getMessage(), Alert.AlertType.ERROR);
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

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Stage currentStage = (Stage) logoutbutton.getScene().getWindow();

            try {
                // Load the login page
                Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));

                // Set the scene in the current stage
                Scene scene = new Scene(root);
                currentStage.setScene(scene);

                // Set the application icon
                Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
                currentStage.getIcons().add(icon);

                // Set the title for the login window
                currentStage.setTitle("El Pedidos Mexicanos");

                // Show the login window in the same stage
                currentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to load login page: " + e.getMessage(), Alert.AlertType.ERROR);
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
        transactionContent.clear();
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
        ObservableList<FoodItem> quantity = OrderTable.getItems();
        try {
            // Validate User Details
            String userFullName = OrderDetailsUserFullname.getText().trim();
            String userContactNumber = OrderDetailsUserContactNumber.getText().trim();
            String userAddress = OrderDetailsUserAddress.getText().trim();
            int amountOfProducts = 0;
            // Loop through each row in the table to get the quantity
            for (FoodItem item : quantity) {
                // Assuming YourItemType has a getQuantity() method to get the quantity of each item
                amountOfProducts += item.getQuantity();
            }
            int typeOfItems = Integer.parseInt(itemCounter.getText());
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
            };

            // Calculate Total Price
            double foodItemsSubtotal = checkoutItems.stream()
                    .mapToDouble(FoodItem::getTotal)
                    .sum();
            double shippingCost = deliveryType.equals("Delivery") ? getShippingCost() : 0; // No shipping cost for pickup
            double handlingFee = getHandlingFee();
            double totalPrice = foodItemsSubtotal + shippingCost + handlingFee;

            String OrderItems = checkoutItems.stream()
                    .map(item -> String.format("%s x%d - ₱%.2f",
                            item.getName(), item.getQuantity(), item.getTotal()))
                    .collect(Collectors.joining("\n")); // Join each food item with a line break
            // Determine Payment Method
            String paymentType;
            FXMLLoader loader;
            Scene scene;
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            stage.getIcons().add(icon);

            if (CODPayment.isSelected()) {
                paymentType = "Cash on Delivery";
                loader = new FXMLLoader(getClass().getResource("JustReceipt.fxml"));
                scene = new Scene(loader.load());
                stage.setTitle("El Pedidos - COD Receipt");
            } else if (PayOnlinePayment.isSelected()) {
                paymentType = "Online Payment";
                loader = new FXMLLoader(getClass().getResource("OnlinePaymentReceipt.fxml"));
                scene = new Scene(loader.load());
                stage.setTitle("El Pedidos - Online Payment Receipt");
            } else {
                throw new IllegalArgumentException("Please select a payment method.");
            }

            // Insert order into database
            DBconnectionFood.insertOrderIntoDatabase(
                    userFullName, userContactNumber, userAddress, deliveryType, paymentType,
                    amountOfProducts ,totalPrice, OrderItems
            );

            // Pass data to the receipt controller
            ReceiptController receiptController = loader.getController();
            receiptController.setReceiptDetails(
                    userFullName, userContactNumber, userAddress, amountOfProducts,typeOfItems,deliveryType, paymentType,
                    checkoutItems, foodItemsSubtotal, shippingCost, handlingFee, totalPrice
            );
            if (PayOnlinePayment.isSelected()) {
                receiptController.PayAmountbtn.setText("Pay ₱" + totalPrice);
            }
            stage.setScene(scene);
            stage.show();

            // Position the window
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(bounds.getMaxX() - scene.getWidth() - 10);
            stage.setY(bounds.getMinY() + 10);

            // Clear cart and update UI
            cartItems.clear();
            updateCartDisplay();
            updateCounters();
            updateTotalPrice();
            OrderTable.getItems().clear();
            OrderTable.refresh();
            showAlert("Success", "Your order has been placed successfully! Please print your receipt as proof for order validation and claiming.", Alert.AlertType.INFORMATION);
            refreshTable();
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

    //tables
    void refreshTable(){
        populateMainOrderOverview(); // Re-fetch and update the tables with new data from the database
        mainOrderTable.refresh();
        transactionHistoryTable.refresh();
    }

    @FXML
    void populateOrderDetails(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check for double-click
            CustomerOrder orders = transactionHistoryTable.getSelectionModel().getSelectedItem();

            if (orders != null) {
                // Create a border around the receipt
                String border = "************************************\n";
                StringBuilder receiptText = new StringBuilder();

                // Add the border and customer details section
                receiptText.append(border)
                        .append("       TRANSACTION RECEIPT\n")
                        .append(border)
                        .append("Customer Name: ").append(orders.getCustomerName()).append("\n")
                        .append("Contact Number: ").append(orders.getCustomerNumber()).append("\n")
                        .append("Address: ").append(orders.getCustomerAddress()).append("\n")
                        .append("Order Type: ").append(orders.getCustomerOrderType()).append("\n")
                        .append("Payment Type: ").append(orders.getCustomerPaymentType()).append("\n")
                        .append("Order Date: ").append(orders.getCustomerOrderDate()).append("\n")
                        .append(border);

                // Items section
                String[] foodItems = orders.getFoodItems().split("\n");  // Split food items by newline
                int itemCount = foodItems.length;  // Count number of items
                receiptText.append("Items (").append(itemCount).append("):\n");
                receiptText.append(orders.getFoodItems()).append("\n");
                receiptText.append(border);

                // Total section
                receiptText.append(String.format("TOTAL AMOUNT: ₱%.2f (Including Shipping Cost & Handling Fee)\n",
                                (double) orders.getTotalAmount()))
                        .append(border);

                // Display receipt in transactionContent
                transactionContent.setText(receiptText.toString());
            }
        }
    }


    //sql queries
    public void updateFoodPage(GridPane maindishGridpane, GridPane sidedishGridpane, GridPane drinksGridpane, GridPane dessertsGridpane) {
         // Clear previous items
         maindishGridpane.getChildren().clear();
         sidedishGridpane.getChildren().clear();
         drinksGridpane.getChildren().clear();
         dessertsGridpane.getChildren().clear();

         // Styling and spacing for GridPane
         setupGridPane(maindishGridpane);
         setupGridPane(sidedishGridpane);
         setupGridPane(drinksGridpane);
         setupGridPane(dessertsGridpane);

         String query = "SELECT ProductName, Category, Price, ProductImg FROM products WHERE Status != 'Unavailable'"; // Adjust to match your database
         int spinnerIdCounter = 0; // Starting ID for spinners
         final int COLUMNS = 2; // Number of columns in the grid

         try (Connection connection = DBconnectionFood.ConnectionDB();
              PreparedStatement statement = connection.prepareStatement(query);
              ResultSet rs = statement.executeQuery()) {

             int mainIndex = 0, sideIndex = 0, drinkIndex = 0, dessertIndex = 0; // Track positions in each category

             while (rs.next()) {
                 String foodName = rs.getString("ProductName");
                 String category = rs.getString("Category");
                 int price = rs.getInt("Price");
                 String imagePath = rs.getString("ProductImg");

                 // Create a food pane and bind it with the cart
                 Pane foodPane = createFoodPane(foodName, price, spinnerIdCounter, imagePath);

                 // Add to the appropriate GridPane
                 switch (category) {
                     case "Main Dish" -> addToGridPane(maindishGridpane, foodPane, mainIndex++, COLUMNS);
                     case "Side Dish" -> addToGridPane(sidedishGridpane, foodPane, sideIndex++, COLUMNS);
                     case "Drinks" -> addToGridPane(drinksGridpane, foodPane, drinkIndex++, COLUMNS);
                     case "Desserts" -> addToGridPane(dessertsGridpane, foodPane, dessertIndex++, COLUMNS);
                     default -> System.out.println("Unknown category: " + category);
                 }

                 spinnerIdCounter++; // Increment spinner ID counter
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

        private void setupGridPane(GridPane gridPane) {
            gridPane.setHgap(10); // Horizontal gap between items
            gridPane.setVgap(10); // Vertical gap between items
            gridPane.setPadding(new Insets(10)); // Padding around the grid

            // Column constraints
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(50); // Set first column width to 50%
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setPercentWidth(50); // Set second column width to 50%
            gridPane.getColumnConstraints().addAll(column1, column2);
        }

        private static void addToGridPane(GridPane gridPane, Pane pane, int index, int columns) {
            int row = index / columns; // Calculate row based on index
            int col = index % columns; // Calculate column based on index
            gridPane.add(pane, col, row); // Add the pane at the specified position
        }

        private Pane createFoodPane(String foodName, int price, int spinnerIdCounter, String imagePath) {
            Pane foodPane = new Pane();
            foodPane.setPrefSize(355, 385);
            foodPane.setStyle("-fx-background-color: white; -fx-background-radius: 30;");

            // Declare image variable for food image
            Image foodImageObject = null;

            // Load the image from the resources folder based on the relative path stored in the database
            try {
                if (imagePath != null && !imagePath.isEmpty()) {
                    URL imageUrl = getClass().getResource("/" + imagePath); // Load from resources folder
                    if (imageUrl != null) {
                        foodImageObject = new Image(imageUrl.toExternalForm()); // Assign the image to the variable
                    } else {
                        System.err.println("Image not found: " + imagePath);
                    }
                } else {
                    System.err.println("Invalid image path: " + imagePath);
                }
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }

            // Set the image to ImageView if it's not null
            if (foodImageObject != null) {
                ImageView foodImage = new ImageView(foodImageObject);
                foodImage.setFitHeight(226);
                foodImage.setFitWidth(346);
                foodImage.setLayoutX(8);
                foodImage.setLayoutY(11);
                foodImage.setPreserveRatio(true);
                foodPane.getChildren().add(foodImage);
            }

            Label nameLabel = new Label(foodName);
            nameLabel.setLayoutX(68);
            nameLabel.setLayoutY(227);
            nameLabel.setPrefSize(300, 53);
            nameLabel.setStyle("-fx-text-fill: black;");
            nameLabel.setFont(new Font(36));
            nameLabel.setAlignment(Pos.CENTER_LEFT);
            nameLabel.setTextAlignment(TextAlignment.RIGHT);

            Label priceLabel = new Label("₱" + price);
            priceLabel.setLayoutX(26);
            priceLabel.setLayoutY(319);
            priceLabel.setPrefSize(140, 58);
            priceLabel.setStyle("-fx-text-fill: #EF3A31;");
            priceLabel.setFont(new Font(36));

            Spinner<Integer> quantitySpinner = new Spinner<>();
            quantitySpinner.setId("food_spinner" + spinnerIdCounter);
            quantitySpinner.setLayoutX(125);
            quantitySpinner.setLayoutY(334);
            quantitySpinner.setPrefSize(115, 43);
            quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

            // Add to the spinner map
            spinnerMap.put(foodName, quantitySpinner);

            Button addToCartButton = new Button();
            addToCartButton.setLayoutX(239);
            addToCartButton.setLayoutY(326);
            addToCartButton.setPrefSize(81, 48);
            addToCartButton.setStyle("-fx-background-color: transparent;");

            ImageView buttonImageView = null;
            try {
                URL buttonImageUrl = DBconnectionFood.class.getResource("/com/example/softwareproj/images/AddToCartbtnImg.png");
                if (buttonImageUrl != null) {
                    buttonImageView = new ImageView(new Image(buttonImageUrl.toExternalForm()));
                    buttonImageView.setFitHeight(54);
                    buttonImageView.setFitWidth(87);
                    addToCartButton.setGraphic(buttonImageView);
                } else {
                    System.err.println("Button image not found.");
                }
            } catch (Exception e) {
                System.err.println("Error loading button image: " + e.getMessage());
            }

            // Add item to cart when button is clicked
            addToCartButton.setOnAction(e -> {
                FoodItem selectedItem = new FoodItem(foodName, price, quantitySpinner.getValue(), imagePath);
                addItemToCart(selectedItem);
            });

            foodPane.getChildren().addAll(nameLabel, priceLabel, quantitySpinner, addToCartButton);
            return foodPane;
        }

    @FXML
    public void checkAndPopulateAccountDetails(String username) {
        Connection con = DBconnectionFood.ConnectionDB();
        String sql = "SELECT * FROM accountdetails WHERE Username = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username); // Set the username of the logged-in user
            rs = pst.executeQuery();

            if (rs.next()) {
                // If the account exists and has data, populate the text fields
                populateAccountDetails(rs);
                System.out.println("Account Details Populated");
            }
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void populateAccountDetails(ResultSet rs) throws SQLException {
        // Order details
        OrderDetailsUserContactNumber.setText(rs.getString("Mobile_Number"));
        OrderDetailsUserAddress.setText(rs.getString("Account_Address"));

        // More page
        String avatarPath = rs.getString("Account_Avatar");
        if (avatarPath != null && !avatarPath.isEmpty()) {
            System.out.println("Image Path: " + avatarPath);  // Debug the avatar path
            URL imageUrl = getClass().getResource("/com/example/softwareproj/images/" + avatarPath);
            System.out.println("Resolved URL: " + imageUrl);  // Debug the resolved URL

            if (imageUrl != null) {
                Image avatarImage = new Image(imageUrl.toExternalForm());
                avatarimg.setImage(avatarImage);
                avatar.setImage(avatarImage);
            } else {
                showAlert("Error", "Avatar image not found.", Alert.AlertType.ERROR);
                setDefaultAvatarImage();  // Set default avatar image if not found
            }

        } else {
            // If no avatar path is available, set a default image
            setDefaultAvatarImage(); // Set a default avatar image
        }

        AccPassword.setText(rs.getString("Password"));
        AccMobileNumber.setText(rs.getString("Mobile_Number"));

        // Gender selection (assuming "Gender" is stored as an integer or boolean)
        String gender = rs.getString("Gender"); // Replace with appropriate data type if necessary
        if ("Male".equalsIgnoreCase(gender)) {
            AccGenderM.setSelected(true);
        } else if ("Female".equalsIgnoreCase(gender)) {
            AccGenderF.setSelected(true);
        } else {
            AccGenderO.setSelected(true);
        }
        AccAddress.setText(rs.getString("Account_Address"));
        UserCardName.setText(rs.getString("Account_Cardname"));
        UserCardNumber.setText(rs.getString("Account_Cardnumber"));
        UserCardExpiryDate.setValue(rs.getDate("Account_CardExpiryDate").toLocalDate());
        UserCVC.setText(rs.getString("Account_CardCVC"));
    }

    // Method to set a default avatar image
    private void setDefaultAvatarImage() {
        // Correctly specify the path to the resource relative to the root of the classpath
        Image defaultAvatarImage = new Image(getClass().getResource("/com/example/softwareproj/images/defaultavatar.png").toExternalForm());
        AvatarMore.setImage(defaultAvatarImage);
        avatar.setImage(defaultAvatarImage);

    }
    public void populateMainOrderOverview() {
        String customerName = AccFullName.getText();
        if (customerName == null || customerName.isEmpty()) {
            showAlert("Error", "Customer name cannot be empty.", Alert.AlertType.WARNING);
            return;
        }

        try {
            // Fetch customer orders from the database
            ObservableList<CustomerOrder> cusOrders = DBconnectionFood.getCustomerOrders(customerName);
            // Set the list in the TableView
            transactionHistoryTable.setItems(cusOrders);
            mainOrderTable.setItems(cusOrders);

        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

}
