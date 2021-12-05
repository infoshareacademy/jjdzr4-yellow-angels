package pl.infoshare.model;

public class OrderItem {
    private ItemComponent item;
    private int quantity;

    public OrderItem(ItemComponent item,int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;

    }

    public ItemComponent getItemComponent() {
        return item;
    }
}
