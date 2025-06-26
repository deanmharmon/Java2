//Dean Mason
//Unit 3

/**
 * Venus FLy Traps extends Plantae kingdom and implements consumes ants
 * @author Dean Mason
 * @version 1.0
 */
public class VenusFlyTraps extends PlantaeKingdom implements ConsumesAnts{
    private int trapSize;

    /**
     * Constructor
     * @param className name of class
     * @param order name of order
     * @param family name of family
     * @param genus name of genus
     * @param species name of species
     * @param name name
     * @param isExtinct is extinct boolean
     * @param division division name
     * @param trapSize size of trap
     */
    public VenusFlyTraps(String className, String order, String family, String genus,
                         String species, String name, boolean isExtinct, String division, int trapSize) {
        super(className, order, family, genus, species, name, isExtinct, division);
        this.trapSize = trapSize;
    }

    /**
     * @return String of info
     */
    @Override
    public String toString(){
        return super.toString() + "\nTrap size: " + Integer.toString(trapSize) + "\nEats ants?: " + eatsAnts;
    }
    /** @return trap size*/
    public int getTrapSize(){
        return trapSize;
    }
    /** Sets trap size */
    public void setTrapSize(int trapSize){
        this.trapSize = trapSize;
    }
}
