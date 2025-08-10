import java.util.ArrayList;
import java.util.List;

public class Order {

    private static long counter;    
    private final long orderNumber;
    private final List<Item> items;

    public Order(Item... items){
        this.items = new ArrayList<>();
        for(Item item : items){
            this.items.add(item);
        }
        this.orderNumber = ++counter;
    }

    public String getReceipt(){
        StringBuilder str =  new StringBuilder();

        for(Item item : items){
            str.append(item.toString() + "\n");
        }

        return "Receipt for order #" + orderNumber + "\n" 
        + "-".repeat(10) + "\n" + 
        str.toString();
    }

    public double getTotalValuePlusVAT(){
        double totalValuePlusVAT = 0;
        for(Item item: items){
            totalValuePlusVAT += item.getPriceWithVAT();
        }

        return totalValuePlusVAT;
    }

    public double getTotalValue(){
        double totalValue = 0;
        for(Item item: items){
            totalValue += item.getPrice();
        }

        return totalValue;
    }
}
