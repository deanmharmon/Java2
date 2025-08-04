import java.util.Arrays;

public class Geolocation {

    private String type;
    private double[] coordinates;

    public Geolocation(String type, double[] coordinates){
        this.type = type;
        this.coordinates = coordinates;
    }
    @Override
    public String toString(){
        return "type= " + type + ", coordinates= " + Arrays.toString(coordinates);
    }
}
