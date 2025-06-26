//Dean Mason
//Unit 3

/**
 * Aardvarks extends Animalia kingdom and implements consumes ants
 * @author Dean Mason
 * @version 1.0
 */
public class Aardvarks  extends AnimaliaKingdom implements ConsumesAnts{

    private String habitat;

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
     * @param habitat name of habitat
     */
    public Aardvarks(String className, String order, String family, String genus,
                     String species, String name, boolean isExtinct, String phylum, String habitat) {
        super(className, order, family, genus, species, name, isExtinct, phylum);
        this.habitat = habitat;
    }

    @Override
    public String toString(){
        return super.toString() + "\nHabitat -> " + habitat + "\nEats ants?: " + eatsAnts;
    }
    /** @return habitat */
    public String getHabitat(){
        return habitat;
    }
    /** Sets habitat */
    public void setHabitat(String habitat){
        this.habitat = habitat;
    }
}
