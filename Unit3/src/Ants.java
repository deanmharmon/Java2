//Dean Mason
//Unit 3

/**
 * Ants extends animalia kingdom
 * @author Dean Mason
 * @version 1.0
 */
public class Ants extends AnimaliaKingdom{
    private String casteLevel;

    /**
     * Constructor
     * @param className name of class
     * @param order name of order
     * @param family name of family
     * @param genus name of genus
     * @param species name of species
     * @param name name
     * @param isExtinct is extinct boolean
     * @param phylum name of phylum
     * @param casteLevel what level in caste
     */
    public Ants(String className, String order, String family, String genus,
                String species, String name, boolean isExtinct, String phylum, String casteLevel) {
        super(className, order, family, genus, species, name, isExtinct, phylum);
        this.casteLevel = casteLevel;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCaste level -> " + casteLevel;
    }

    public String getCasteLevel() {
        return casteLevel;
    }

    public void setCasteLevel(String casteLevel) {
        this.casteLevel = casteLevel;
    }
}
