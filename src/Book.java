public class Book extends Item implements PriceableWithVAT6 {
    
    private static final double BOUND_BOOK_PRICE_FACTOR = 1.3; 
    private final double price;
    private final boolean bound;
    private final String author;

    public Book(String name, String author, double price, boolean bound){
        super(name);
        this.author = author;
        this.price = price;
        this.bound = bound;
    }

    public double getPrice(){
        return bound ? BOUND_BOOK_PRICE_FACTOR * price : price;
    }

    public String toString(){
        return "Book { " + getName() + ", " + author + ", " + bound + ", " + String.format("%.1f", getPrice()) + ", " +  this.getPriceWithVAT() + " }";
        //return "Name='" + getName() + "', author:'" + author + "', bound=" + bound + " price=" + getPrice() + ", price+vat=" + getPriceWithVAT();
    }
}
