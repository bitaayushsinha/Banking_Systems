package ankush;


    import java.util.ArrayList;
import java.util.Scanner;

    public class StockManagementSystem {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // create an empty arraylist to hold the products
            ArrayList<Product> products = new ArrayList<>();

            // display the menu and ask for user input
            int choice;
            do {
                System.out.println("1. Add product");
                System.out.println("2. Remove product");
                System.out.println("3. View products");
                System.out.println("4. Sell product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        // ask for product details
                        System.out.print("Enter the product name: ");
                        String name = input.next();
                        System.out.print("Enter the product quantity: ");
                        int quantity = input.nextInt();
                        System.out.print("Enter the product price: ");
                        double price = input.nextDouble();

                        // create a new Product object and add it to the arraylist
                        Product newProduct = new Stock(name, quantity, price);
                        products.add(newProduct);

                        System.out.println("Product added successfully");
                        break;

                    case 2:
                        // ask for the product name and quantity to remove
                        System.out.print("Enter the product name: ");
                        String productNameToRemove = input.next();
                        System.out.print("Enter the quantity to remove: ");
                        int removeQuantity = input.nextInt();

                        // find the product to remove
                        Product productToRemove = findProductByName(products, productNameToRemove);

                        // if the product is found, remove the specified quantity
                        if (productToRemove != null) {
                            productToRemove.removeQuantity(removeQuantity);
                            if (productToRemove.getQuantity() == 0) {
                                // If the quantity becomes zero, remove the product from the list
                                products.remove(productToRemove);
                                System.out.println("Product removed successfully");
                            } else {
                                System.out.println("Quantity removed from the product");
                            }
                        } else {
                            System.out.println("Product not found");
                        }
                        break;

                    case 3:
                        // display the list of products
                        System.out.println("Current products:");
                        for (Product product : products) {
                            System.out.println(product.toString());
                        }
                        break;

                    case 4:
                        // ask for the product name and quantity to sell
                        System.out.print("Enter the product name: ");
                        String productNameToSell = input.next();
                        System.out.print("Enter the quantity to sell: ");
                        int sellQuantity = input.nextInt();

                        // find the product to sell
                        Product productToSell = findProductByName(products, productNameToSell);

                        // if the product is found, sell the specified quantity
                        if (productToSell != null) {
                            if (productToSell.getQuantity() >= sellQuantity) {
                                double totalPrice = productToSell.getPrice() * sellQuantity;
                                System.out.println("Total Price: ₹" + totalPrice);
                                productToSell.removeQuantity(sellQuantity);
                                System.out.println("Sale successful");
                                if (productToSell.getQuantity() == 0) {
                                    // If the quantity becomes zero, remove the product from the list
                                    products.remove(productToSell);
                                }
                            } else {
                                System.out.println("Not enough quantity available for sale");
                            }
                        } else {
                            System.out.println("Product not found");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting the program...");
                        break;

                    default:
                        System.out.println("Invalid choice, try again.");
                        break;
                }

            } while (choice != 5);

            input.close();
        }

        // Helper method to find a product by name
        private static Product findProductByName(ArrayList<Product> products, String name) {
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    return product;
                }
            }
            return null;
        }
    }

    // Base class for products
    class Product {
        protected String name;
        protected int quantity;
        protected double price;

        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void removeQuantity(int quantityToRemove) {
            if (quantityToRemove <= quantity) {
                quantity -= quantityToRemove;
            } else {
                System.out.println("Not enough quantity to remove");
            }
        }

        public String toString() {
            return name + ", quantity: " + quantity + ", price: ₹" + price;
        }
    }

    // Subclass representing Stock, inheriting from Product
    class Stock extends Product {
        public Stock(String name, int quantity, double price) {
            super(name, quantity, price);
        }
    }

