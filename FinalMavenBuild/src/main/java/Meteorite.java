//Dean Mason
//Final

import java.io.Serializable;

/**
 * Stores all info on meteorites except for geolocation
 * @author Dean Mason
 * @version 1.0
 */
public class Meteorite implements Serializable {
    private String name;
    private String id;
    private String nametype;
    private String recclass;
    private String mass;
    private String fall;
    private String year;
    private String reclat;
    private String reclong;
    private Geolocation geolocation;


    /**
     * Constructor, sets instance vars
     * @param name
     * @param id
     * @param nametype
     * @param recclass
     * @param mass
     * @param fall
     * @param year
     * @param reclat
     * @param reclong
     */
    public Meteorite(String name, String id, String nametype, String recclass, String mass, String fall, String year, String reclat,
                     String reclong){
        this.name = name;
        this.id = id;
        this.nametype = nametype;
        this.recclass = recclass;
        this.mass = mass;
        this.fall = fall;
        this.year = year;
        this.reclat = reclat;
        this.reclong = reclong;
    }

    /**
     * Smaller toString basically, for when searching
     * @return useful info
     */
    public String display(){
        return "name= " + name + ", id= "
                + id + ", recclass= " + recclass +
                ", mass= " + mass + ", year= " +
                getYear();
    }

    @Override
    public String toString(){
        String geoLoc;
        try {
            geoLoc = geolocation.toString();
        }catch (Exception e){
            geoLoc = "none";
        }
        return "[name= " + name + ", id= "
                + id + ", nametype= " + nametype + ", recclass= " + recclass +
                ", mass= " + mass + ", fall= " + fall + ", year= " +
                getYear() + ", reclat= " + reclat + ", reclong= " + reclong + ", geolocation=Geolocation [" +
                geoLoc + "]]";
    }

    /// Below are all the auto geneated getters/settes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRecclass() {
        return recclass;
    }

    public String getNametype() {
        return nametype;
    }

    public String getMass() {
        return mass;
    }

    public String getFall() {
        return fall;
    }

    /**
     * gives a year that is easy to read
     * @return year
     */
    public String getYear() {
        if (year == null || year.length() < 2) {
            return "0";
        }
        return year.substring(0,4);
    }


    public String getReclat() {
        return reclat;
    }

    public String getReclong() {
        return reclong;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public void setRecclass(String recclass) {
        this.recclass = recclass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFall(String fall) {
        this.fall = fall;
    }

    public void setReclat(String reclat) {
        this.reclat = reclat;
    }

    public void setReclong(String reclong) {
        this.reclong = reclong;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

}