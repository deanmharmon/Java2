//Dean Mason
//Final

import java.io.Serializable;
import java.util.Arrays;

/**
 * Used to get the geolocation data from JSON file
 *
 * @author Dean Mason
 * @version 1.0
 */
public class Geolocation implements Serializable {

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
