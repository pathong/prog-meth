package logic;

public class Item {

    private String name;
    private int pricePerPiece;

    public Item(String name, int pricePerPiece){
        setPricePerPiece(pricePerPiece);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public int getPricePerPiece() {
        return pricePerPiece;
    }
    public void setPricePerPiece(int pricePerPiece){
        this.pricePerPiece = Math.max(1,pricePerPiece);
    }

    public void setName(String name){
        this.name = name;
    }






}
