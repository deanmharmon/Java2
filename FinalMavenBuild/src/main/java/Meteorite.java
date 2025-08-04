//Dean Mason
//Final

import java.io.Serializable;

/**
 * Used to create useful objects from JSON file
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

    public String display(){
        return "name= " + name + ", id= "
                + id + ", recclass= " + recclass +
                ", mass= " + mass + ", year= " +
                year;
    }

    @Override
    public String toString(){
        return "name= " + name + ", id= "
                + id + ", nametype= " + nametype + ", recclass= " + recclass +
                ", mass= " + mass + ", fall= " + fall + ", year= " +
                year + ", reclat= " + reclat + ", reclong= " + reclong;
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

    public String getYear() {
        return year;
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