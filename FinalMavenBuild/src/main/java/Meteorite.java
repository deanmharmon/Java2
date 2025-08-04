public class Meteorite {
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


    @Override
    public String toString(){
        return "name= " + name + ", id= "
                + id + ", nametype= " + nametype + ", recclass= " + recclass +
                ", mass= " + mass + ", fall= " + fall + ", year= " +
                year + ", reclat= " + reclat + ", reclong= " + reclong;
    }
}