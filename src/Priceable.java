public interface Priceable {

    double getPrice();
    double getVAT();
    
    default double getPriceWithVAT(){
        return getPrice() + (getVAT() * getPrice());
    }
}