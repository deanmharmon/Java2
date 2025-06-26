//Dean Mason
//Unit 3

/**
 * Class plantae kingdom extends eukarya kingdom
 * @author Dean Mason
 * @version 1.0
 */
public class PlantaeKingdom extends EukaryaDomain {

    private String division;

    /**
     * Constructor
     * @param className name of class
     * @param order name of order
     * @param family name of family
     * @param genus name of genus
     * @param species name of species
     * @param name name
     * @param isExtinct is extinct boolean
     * @param division division
     */
    public PlantaeKingdom(String className, String order, String family, String genus,
                          String species, String name, boolean isExtinct, String division){
        super(className, order, family, genus, species, name, isExtinct);
        this.division = division;
    }

    /**
     * @return String of useful info
     */
    @Override
    public String toString(){
        return "Division -> " + division + "\n" + super.toString();
    }
    /** @return division */
    public String getDivision(){
        return division;
    }
    /** Sets division */
    public void setDivision(String division){
        this.division = division;
    }

}
