//Dean Mason
//Final

import java.io.Serializable;
import java.util.Arrays;

/**
 * Used to get the geolocation data for meteorites
 *
 * @author Dean Mason
 * @version 1.0
 */
public class Geolocation implements Serializable {

    private final String type;
    private final double[] coordinates;

    /**
     * Constructoe
     * @param type type, ie: point
     * @param coordinates spatial place of being
     */
    public Geolocation(String type, double[] coordinates){
        this.type = type;
        this.coordinates = coordinates;
    }

    /**
     * toString
     * @return useful info
     */
    @Override
    public String toString(){
        return "type= " + type + ", coordinates= " + Arrays.toString(coordinates);
    }
}
