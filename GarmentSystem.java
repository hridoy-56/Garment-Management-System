package garmentsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        System.out.println("Discount :" + discount);
        return discount;
    }

    void displayDetails() {
        System.out.println("---------------");
        System.out.println("Garment:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);

    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    double calculateCost(double meters) {
        double newPrice = pricePerMeter * meters;
        System.out.println("Cost:" + newPrice);
        return newPrice;
    }

    void displayDetails() {
        System.out.println("--------------------------");
        System.out.println("Fabric: ");
        System.out.println("Fabric ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Price per Meter: " + pricePerMeter);
        System.out.println("--------------------------");
    }

}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    List<Fabric> suppliedFabric = new ArrayList<>();

    Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
        System.out.println("Added fabric " + fabric.type + " to supplier " + name);
    }

    List<Fabric> getSuppliedFabrics() {
        System.out.println("fabric supplied");
        return suppliedFabric;
    }

    void displayDetails() {
        System.out.println("--------------------------");
        System.out.println("Supplier: ");
        System.out.println("Supplier ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Supplied Fabrics:");

        System.out.println("--------------------------");
    }
}

class Order {

   public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    Order(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Added garment " + garment.name + " to order " + orderId);
    }

    double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        System.out.println("Total amount for order " + orderId + " is " + totalAmount);
        return totalAmount;
    }

    void orderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order: ");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Items:");
        System.out.println("Total Amount: " + calculateTotalAmount());
        System.out.println("--------------------------");
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    void placeOrder(Order order) {
        System.out.println("Placing order " + order.orderId + " by customer " + name);
        order.orderDetails();
        System.out.println("Order Placed by: " + name);
        System.out.println("--------------------------");
    }

    void displayDetails() {
        System.out.println("--------------------------");
        System.out.println("Customer: ");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("--------------------------");
    }
}


class Inventory {

    List<Garment> garments = new ArrayList<>();

    void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Added garment " + garment.name + " to inventory");
    }

    void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
        System.out.println("Removed garment with ID " + id + " from inventory");
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                System.out.println("Found garment with ID " + id);
                return g;
            }
        }
        System.out.println("Garment with ID " + id + " not found in inventory");
        return null;
    }

    void displayAllGarments() {
        System.out.println("Inventory: ");
        System.out.println("Displaying all garments in inventory:");
        for (Garment garment : garments) {
            garment.displayDetails();
        }
    }
}

public class GarmentSystem {

    public static void main(String[] args) {
        Garment g1 = new Garment("M001", "Silk", "Good Product", "M", "Red", 1000.0, 20);
        Garment g2 = new Garment("N001", "Silk", "Good Product", "L", "Blue", 1050.0, 30);
        Garment g3 = new Garment("C001", "Silk", "Good Product", "XL", "Green", 1080.0, 40);
        g1.displayDetails();
        g2.displayDetails();
        g3.displayDetails();

        Fabric f1 = new Fabric("F001", "Cotton", "Blue", 50.0);
        f1.displayDetails();
        f1.calculateCost(5);
    
        Fabric f2 = new Fabric("F002", "Cotton", "White", 80.0);
        f2.displayDetails();
        f2.calculateCost(10);

       Supplier supplier = new Supplier("S001", "Best Fabrics", "123-456-7890");
        supplier.addFabric(f1);
        supplier.displayDetails();
        supplier.getSuppliedFabrics();
   
        Order order = new Order("O001", new Date());
        order.addGarment(g1);
        order.calculateTotalAmount();
        order.orderDetails();
        
        Customer customer = new Customer("C001", "Mehedi", "mehedihasanm567@gmail.com", "1234567890");
        customer.displayDetails();
        customer.placeOrder(order);

        Inventory inventory = new Inventory();
        inventory.addGarment(g1);

        inventory.displayAllGarments();
    }

}
