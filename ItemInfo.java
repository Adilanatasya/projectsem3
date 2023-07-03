import java.util.Date;

public class ItemInfo {
    private int itemId;
    private String itemName;
    private double itemPrice;
    private Date datePurchase;

    public ItemInfo(int itemId, String itemName, double itemPrice, Date datePurchase) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.datePurchase = datePurchase;
    }

    // Add getters and setters
    public void setitemId(int itemId) {
        this.itemId = itemId;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public void setitemPrice(double itemPrice) {
        this.itemId = itemId;
    }

    public void setdatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public int getitemId() {
        return itemId;
    }

    public String getitemName() {
        return itemName;
    }

    public double getitemPrice() {
        return itemPrice;
    }

    public Date getdatePurchase() {
        return datePurchase;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item ID: ").append(itemId).append("\n");
        sb.append("Name: ").append(itemName).append("\n");
        sb.append("Price: ").append(itemPrice).append("\n");
        sb.append("Date of Purchase: ").append(datePurchase).append("\n");
        return sb.toString();
        // ...
    }
}