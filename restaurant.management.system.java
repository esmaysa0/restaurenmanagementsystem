import java.util.*;

// Food Category enum
enum FoodCategory {

    STARTERS, APPETIZERS, ENTREES, BEVERAGES, DESSERTS, SALADS, MAIN_DISHES // Categories

}

// Menu Item Class
class MenuItem {

    private String name; // Name of the food

    private double price; // Price of the food

    private FoodCategory category; // Category of the food
    
    
 // Constructor to initialize MenuItem, for creating a new MenuItem item.
    public MenuItem(String name, double price, FoodCategory category) {

        this.name = name;	// Name of the food

        this.price = price;	// Price of the food

        this.category = category;	// Category of the food
        
    }
    // Getter method of the name
    public String getName() {

        return name;

    }
 // Getter method of the price
    public double getPrice() {

        return price;

    }
 // Getter method of the category
    public FoodCategory getCategory() {

        return category;

    }

}

// Order Item Class
class OrderItem {

    private MenuItem item;

    private int quantity;
    
    
    // Constructor to initialize OrderItem
    public OrderItem(MenuItem item, int quantity) {

        this.item = item;

        this.quantity = quantity;

    }
    // Getter method to return the menu item
    public MenuItem getItem() {

        return item;

    }
    
    // Getter method to return the quantity
    public int getQuantity() {

        return quantity;

    }

}

	// Interface for retrieving user input

interface InputRetriever<T> {

    T getInput();	// Method used to get input

}

// Class representing a restaurant

class Restaurant {

    private List<MenuItem> menu; // List of menu items

    private List<OrderItem> orders; // List of order items

    
    // Constructor method, used when creating a new Restaurant object.
    public Restaurant() {

        menu = new ArrayList<>(); // Initializes the menu list

        orders = new ArrayList<>(); // Initializes the order list

    }
 // Method to add a new item to the menu
    public void addMenuItem(MenuItem item) {

        menu.add(item);

    }
    // Getter method to return the menu
    public List<MenuItem> getMenu() {
    	return menu;
    }
    // Method to display the menu on the screen
    public void displayMenu() {

        System.out.println("Menu:");
        
        int index = 1;

        for (MenuItem item : menu) {

           // System.out.println(item.getName() + " - $" + item.getPrice() + " (" + item.getCategory() + ")");

        	System.out.println(index++ + ". " + item.getName() + " - $" + item.getPrice() + " (" + item.getCategory() + ")");
        	
        }

    }
    // Method to place an order
    public void placeOrder(MenuItem item, int quantity) {

        orders.add(new OrderItem(item, quantity));

    }

    // Method to calculate the total bill
    public double calculateTotalBill() {
        double total = 0;
        System.out.println("Items ordered:");
        for (OrderItem order : orders) {
            double itemTotal = order.getItem().getPrice() * order.getQuantity();
            total += itemTotal;
            System.out.println(order.getItem().getName() + " x " + order.getQuantity() + " = $" + String.format("%.2f", itemTotal));
        }
        System.out.println("Total Bill: $" + String.format("%.2f", total));
        return total;

    }

}

//Main class representing the restaurant management system
public class RestaurantManagementSystem implements InputRetriever<Integer> {

    private Restaurant restaurant; // The restaurant object

    
    // Constructor method, used when creating a new RestaurantManagementSystem object.
    public RestaurantManagementSystem() {

        restaurant = new Restaurant(); // Initializes the restaurant object

    }

    // Method to run the system
    public void run() {

        Scanner scanner = new Scanner(System.in); // Scanner object for user input

        while (true) { // Infinite loop, continues until the user exits
        	
            // Displays menu options
        	
        	for (int i =1; i<15;i++) { // Displaying a line of asterisks for visual separation
        		System.out.print("*-");
        	}
        	System.out.print("*");
        	System.out.println(""); 
        	
        /---------------------------/ // <- Like this

            System.out.println("1. Add Menu Item (Management Systems)");

            System.out.println("2. Display Menu");

            System.out.println("3. Place Order");

            System.out.println("4. Calculate Total Bill");

            System.out.println("5. Exit");
            
        	for (int i =1; i<15;i++) { // Displaying a line of asterisks for visual separation
        		System.out.print("*-");
        	}
        	System.out.print("*");
        	System.out.println();
        	
            /---------------------------/ // <- Like this
        	
            System.out.print("Enter your choice: "); // Asks the user to make a choice

            int choice = scanner.nextInt(); // Gets the user's choice

            switch (choice) { // Performs an action based on the user's choice

                case 1:

                    // Add Menu Item
                    scanner.nextLine(); // Consume the leftover newline from nextInt()
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine(); // Use nextLine() to read the full name

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.print("Enter category (STARTERS, APPETIZERS, ENTREES, BEVERAGES, DESSERTS, SALADS, MAIN_DISHES): ");

                    FoodCategory category = FoodCategory.valueOf(scanner.next().toUpperCase());

                    restaurant.addMenuItem(new MenuItem(name, price, category));

                    break;

                case 2:

                    // Display Menu

                    restaurant.displayMenu();

                    break;

                case 3:

                    // Place Order
                	
                	restaurant.displayMenu();

                    System.out.print("Enter the number of the item: ");
                    
                    int itemNumber = scanner.nextInt();

                    if (itemNumber < 1 || itemNumber > restaurant.getMenu().size()) {
                        System.out.println("Invalid item number. Please try again.");
                        break;
                    }

                    MenuItem selectedItem = restaurant.getMenu().get(itemNumber - 1);

                    System.out.print("Enter quantity: ");

                    
                    int quantity = scanner.nextInt();
                    
                    restaurant.placeOrder(selectedItem, quantity);

                            break;
                            

                        case 4:

                            // Calculate Total Bill

                            double totalBill = restaurant.calculateTotalBill();


                            break;

                        case 5:

                            // Exit
                        	for (int a=1; a < 45; a++) { // adds 45 blank lines to make it vanish
                        		System.out.println("");
                        	}

                            return;

                        default:

                            System.out.println("Invalid choice. Please try again.");

                    }

                }

            }


    

    @Override

    public Integer getInput() {

        Scanner scanner = new Scanner(System.in); // New Scanner object

        return scanner.nextInt();	// Returns the user's input

    }
    
    
    // Main method, the starting point of the program
    public static void main(String[] args) {
    	
    	for (int i =1; i<15;i++) { // Displaying a line of asterisks for visual separation
    		System.out.print("*-");
    	}
    	System.out.print("*");
    	System.out.println();
    	
        /---------------------------/ // <- Like this
    	System.out.println("   Welcome to the sushico!"); // Welcome message
    	
        RestaurantManagementSystem system = new RestaurantManagementSystem();

        // MAIN_DISHES
        system.restaurant.addMenuItem(new MenuItem("Tuna Nigiri", 5.99, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Salmon Nigiri", 6.49, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Eel Nigiri", 7.99, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Shrimp Nigiri", 5.49, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Octopus Nigiri", 6.99, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Yellowtail Nigiri", 6.99, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Scallop Nigiri", 7.49, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Surf Clam Nigiri", 6.49, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Mackerel Nigiri", 5.49, FoodCategory.MAIN_DISHES));
        system.restaurant.addMenuItem(new MenuItem("Fatty Tuna Nigiri", 9.99, FoodCategory.MAIN_DISHES));

        // APPETIZERS 
        system.restaurant.addMenuItem(new MenuItem("California Roll", 8.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Spicy Tuna Roll", 9.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Salmon Avocado Roll", 10.49, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Dragon Roll", 12.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Rainbow Roll", 13.49, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Caterpillar Roll", 11.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Volcano Roll", 12.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Spider Roll", 11.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Sushi Burrito", 10.99, FoodCategory.APPETIZERS));
        system.restaurant.addMenuItem(new MenuItem("Tuna Tataki", 11.49, FoodCategory.APPETIZERS));

        // STARTERS
        system.restaurant.addMenuItem(new MenuItem("Miso Soup", 3.99, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Edamame", 4.49, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Seaweed Salad", 5.49, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Agedashi Tofu", 5.99, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Gyoza", 6.99, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Takoyaki", 7.49, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Tempura", 8.49, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Sashimi Sampler", 13.99, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Sunomono", 9.99, FoodCategory.STARTERS));
        system.restaurant.addMenuItem(new MenuItem("Yakitori", 10.49, FoodCategory.STARTERS));

        // Run the restaurant management system
        system.run();

    }

}