package logic;

public class OrderItem {

    private Item item;
    private int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        setItem(item);
        setItemAmount(itemAmount);
    }

    public void increaseItemAmount(int amount){
        setItemAmount(getItemAmount() + Math.max(0,amount));
    }
    public int calculateTotalPrice(){
        return (int)(getItem().getPricePerPiece() * getItemAmount());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        System.out.println(itemAmount);
        this.itemAmount = Math.max(0,itemAmount);
    }

}
