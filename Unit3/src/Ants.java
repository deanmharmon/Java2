//Dean Mason
//Unit 3

public class Ants extends AnimaliaKingdom{
    private String casteLevel;

    public Ants(String className, String order, String family, String genus,
                String species, String name, boolean isExtinct, String phylum, String casteLevel) {
        super(className, order, family, genus, species, name, isExtinct, phylum);
        this.casteLevel = casteLevel;
    }

    @Override
    public String toString(){
        //TODO finish
        return super.toString() + "\nCaste level -> " + casteLevel;
    }
}
