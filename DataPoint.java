public class DataPoint {
    private PolioDataPointInfo dim;
    private int Value;
    
    @Override
    public String toString() {
        return dim.getCountry() + " in" + dim.getYear() + ": " + Value + "% Immunized";
    }
}
