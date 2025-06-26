//Dean Mason
//Unit 3

public class Aardvarks  extends AnimaliaKingdom implements ConsumesAnts{

    private String habitat;

    public Aardvarks(String className, String order, String family, String genus,
                     String species, String name, boolean isExtinct, String phylum, String habitat) {
        super(className, order, family, genus, species, name, isExtinct, phylum);
        this.habitat = habitat;
    }

    @Override
    public String toString(){
        return super.toString() + "\nHabitat -> " + habitat;
    }
}
