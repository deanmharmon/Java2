//Dean Mason
//Unit 3

public class PlantaeKingdom extends EukaryaDomain {

    private String division;

    public PlantaeKingdom(String className, String order, String family, String genus,
                          String species, String name, boolean isExtinct, String division){
        super(className, order, family, genus, species, name, isExtinct);
        this.division = division;
    }
    @Override
    public String toString(){
        return "Division -> " + division + "\n" + super.toString();
    }
}
