public class LongPlay extends Recording {

    public LongPlay(String name, String artist, int year, int condition, double price){
        super(name, artist, year, condition, price);
    }

    @Override
    public String getType(){
        return "LP";
    }
}