//Dean Mason
//Unit 3

/**
 * Animalia kingdom extends Eukarya domain
 * @author Dean Mason
 * @version 1.0
 */
public class AnimaliaKingdom extends EukaryaDomain {
    private String phylum;

    /**
     * Constructor
     * @param className name of class
     * @param order name of order
     * @param family name of family
     * @param genus name of genus
     * @param species name of species
     * @param name name
     * @param isExtinct is extinct boolean
     * @param phylum name of phylym
     */
    public AnimaliaKingdom(String className, String order, String family, String genus,
                           String species, String name, boolean isExtinct, String phylum) {
        super(className, order, family, genus, species, name, isExtinct);
        this.phylum = phylum;

    }

    /**
     * @return String of relevant info
     */
    @Override
    public String toString() {
        //TODO finish
        return "Phylum -> " + phylum + "\n" + super.toString();
    }
    /** @return phylum */
    public String getPhylum() {
        return phylum;
    }
    /** Sets phylum */
    public void setPhylum(String phylum){
        this.phylum = phylum;
    }
}
