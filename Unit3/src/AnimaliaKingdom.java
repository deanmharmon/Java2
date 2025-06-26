//Dean Mason
//Unit 3

public class AnimaliaKingdom extends EukaryaDomain{
    private String phylum;


    public AnimaliaKingdom(String className, String order, String family, String genus,
                           String species, String name, boolean isExtinct, String phylum){
        super(className, order, family, genus, species, name, isExtinct);
        this.phylum = phylum;

    }

    @Override
    public String toString(){
        //TODO finish
        return "Phylum -> " + phylum + "\n" + super.toString();
    }
}
