import java.util.List;

public class CustInfo {
    private String custId;
    private String custIC;
    private int counterPaid;
    private List<ItemInfo> itemsPurchased;
    private double totalAmount;

    public CustInfo(String custId, String custIC, int counterPaid, List<ItemInfo> itemsPurchased) {
        this.custId = custId;
        this.custIC = custIC;
        this.counterPaid = counterPaid;
        this.itemsPurchased = itemsPurchased;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustIC() {
        return custIC;
    }

    public int getCounterPaid() {
        return counterPaid;
    }

    public List<ItemInfo> getItemsPurchased() {
        return itemsPurchased;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(custId).append("\n");
        sb.append("IC: ").append(custIC).append("\n");
        sb.append("Counter Paid: ").append(counterPaid).append("\n");
        sb.append("Items Purchased:\n");
        for (ItemInfo item : itemsPurchased) {
            sb.append("- Item ID: ").append(item.getitemId()).append("\n");
            sb.append("  Name: ").append(item.getitemName()).append("\n");
            sb.append("  Price: ").append(item.getitemPrice()).append("\n");
            sb.append("  Date of Purchase: ").append(item.getdatePurchase()).append("\n");
        }
        return sb.toString();

        
    }

}