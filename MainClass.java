import java.io.FileReader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Queue<CustInfo> customersQueue = new Queue<>();
        String inputFile = "customerdata.txt"; // Replace with the actual input file path

        try (Scanner scanner = new Scanner(new FileReader(inputFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                String custId = parts[3];
                System.out.println("Customer ID: " + custId);

                String custIC = parts[1].trim();
                int counterPaid = Integer.parseInt(parts[2].trim());

                List<ItemInfo> itemsPurchased = new ArrayList<>();
                for (int i = 4; i < parts.length; i += 4) {
                    if (i + 3 >= parts.length) {
                        System.out.println("Invalid number of item fields for customer ID: " + custId);
                        break; // Exit the loop if there are insufficient fields for an item
                    }

                    int itemId;
                    try {
                        itemId = Integer.parseInt(parts[i]);
                        System.out.println("Item ID: " + itemId);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid item ID for customer ID: " + custId);
                        break; // Exit the loop if there's an error parsing the item ID
                    }

                    System.out.println("Item ID: " + itemId);

                    String itemName = parts[i + 1].trim();
                    System.out.println("Item Name: " + itemName);

                    double itemPrice;
                    try {
                        itemPrice = Double.parseDouble(parts[i + 2].trim());
                        System.out.println("Item Price: " + itemPrice);
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid item price for customer ID: " + custId);
                        break; // Exit the loop if there's an error parsing the item price
                    }

                    Date datePurchase = parseDate(parts[i + 3].trim());
                    System.out.println("Date Purchase: " + datePurchase);

                    ItemInfo item = new ItemInfo(itemId, itemName, itemPrice, datePurchase);
                    itemsPurchased.add(item);
                }

                CustInfo customer = new CustInfo(custId, custIC, counterPaid, itemsPurchased);
                customersQueue.enqueue(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Process the queues and display the receipts
        processQueues(customersQueue);
    }

    // Process the queues and display the receipts
    private static void processQueues(Queue<CustInfo> customersQueue) {
        int counter1Count = 0;
        int counter2Count = 0;
        int counter3Count = 0;

        while (!customersQueue.isEmpty()) {
            if (counter1Count < 5) {
                CustInfo customer = customersQueue.dequeue();
                processCustomerPayment(customer);
                counter1Count++;
            } else if (counter2Count < 5) {
                CustInfo customer = customersQueue.dequeue();
                processCustomerPayment(customer);
                counter2Count++;
            } else if (counter3Count < 10) {
                CustInfo customer = customersQueue.dequeue();
                processCustomerPayment(customer);
                counter3Count++;
            } else {
                counter1Count = 0;
                counter2Count = 0;
                counter3Count = 0;
            }
        }
    }

    // Process the payment for a customer
    private static void processCustomerPayment(CustInfo customer) {
        // Perform payment processing here
        double totalAmount = calculateTotalAmount(customer.getItemsPurchased());
        customer.setTotalAmount(totalAmount);

        // Display the receipt
        displayReceipt(customer);
    }

    // Calculate the total amount for the items purchased by a customer
    private static double calculateTotalAmount(List<ItemInfo> itemsPurchased) {
        double totalAmount = 0.0;
        for (ItemInfo item : itemsPurchased) {
            totalAmount += item.getitemPrice();
        }
        return totalAmount;
    }

    // Display the receipt for a customer
    private static void displayReceipt(CustInfo customer) {
        // Implement the receipt display logic here
        System.out.println("Customer ID: " + customer.getCustId());
        System.out.println("IC: " + customer.getCustIC());
        System.out.println("Counter Paid: " + customer.getCounterPaid());
        System.out.println("Total Amount: " + customer.getTotalAmount());
        System.out.println("Items Purchased:");
        for (ItemInfo item : customer.getItemsPurchased()) {
            System.out.println("- Item ID: " + item.getitemId());
            System.out.println("  Name: " + item.getitemName());
            System.out.println("  Price: " + item.getitemPrice());
            System.out.println("  Date of Purchase: " + item.getdatePurchase());
        }
        System.out.println();
    }

    // Parse the date string in the format "dd-MM-yyyy" to a Date object
    private static Date parseDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}