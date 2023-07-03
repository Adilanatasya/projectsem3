import java.util.*;
import java.util.Stack;

public class Hypermarket {
    LinkedList<CustInfo> qCustomer = new LinkedList<>();
    LinkedList<CustInfo> qCounter1 = new LinkedList<>();
    LinkedList<CustInfo> qCounter2 = new LinkedList<>();
    LinkedList<CustInfo> qCounter3 = new LinkedList<>();
    LinkedList<CustInfo> qCompleted = new LinkedList<>();

    public Hypermarket() {
        // Initialize the queues and stack
        qCounter1 = new LinkedList<>();
        qCounter2 = new LinkedList<>();
        qCounter3 = new LinkedList<>();
        Stack qCompleted = new Stack<>();
    }

    public void addCustomerToQueue(CustInfo customer) {
        // Add the customer to the appropriate counter queue based on the number of items purchased
        if (customer.getItemsPurchased().size() <= 5) {
            if (qCounter1.size() > qCounter2.size()) {
                qCounter2.offer(customer);
            } else {
                qCounter1.offer(customer);
            }
        } else {
            qCounter3.offer(customer);
        }
    }

    public void removeCustomerFromQueue(CustInfo customer) {
        // Remove the customer from the counter queue if present
        if (qCounter1.contains(customer)) {
            qCounter1.remove(customer);
        } else if (qCounter2.contains(customer)) {
            qCounter2.remove(customer);
        } else if (qCounter3.contains(customer)) {
            qCounter3.remove(customer);
        }
    }

    public void displayReceipt(CustInfo customer) {
        // Display the receipt for a customer
        System.out.println("Customer ID: " + customer.getCustId());
        System.out.println("Customer IC: " + customer.getCustIC());

        List<ItemInfo> itemsPurchased = customer.getItemsPurchased();
        for (ItemInfo item : itemsPurchased) {
            System.out.println("Item ID: " + item.getitemId());
            System.out.println("Item Name: " + item.getitemName());
            System.out.println("Item Price: " + item.getitemPrice());
            System.out.println("Date of Purchase: " + item.getdatePurchase());
        }
    }
}