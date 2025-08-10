import java.time.Year;

public abstract class Recording extends Item implements PriceableWithVAT25 {
    private final String artist;
    private final int year;
    private int condition;
    private final double price;

    protected Recording(String name, String artist, int year, int condition, double price){
        super(name);
        this.artist = artist;
        this.year = year;
        this.condition = condition;
        this.price = price;
    }

    public abstract String getType();

    public String getArtist(){
        return artist;
    }

    public int getCondition(){
        return condition;
    }

    public double getPrice(){
        double newPrice = price * (condition/10.0);
        if(newPrice < 10){
            return 10;
        }else{
            if(this instanceof LongPlay){
                return newPrice + (Year.now().getValue() - year) * 5.0;
            }
            return newPrice;
        }

    }

    public String toString(){
        return getType() + " { namn='" + getName() + "', artist='"+ artist + "', year=" + year + ", condition=" + condition + ", original price=" + getOriginalPrice() + ", price=" + getPrice() + ", price+VAT=" + getPriceWithVAT() + " }";
    }

    public int getYear(){
        return year;
    }

    protected double getOriginalPrice(){
        return price;
    }

}
