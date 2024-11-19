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
    //List
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        for (Garment g : garments) {
            totalAmount = totalAmount + g.price;
        }
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }

}

class Inventory {

    List<Garment> garments;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        garments.remove(id);
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id == id) {
                return g;
            }
        }
        return null;
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

        double x = g1.calculateDiscountPrice(10);
        System.out.println(x);

    }

}
