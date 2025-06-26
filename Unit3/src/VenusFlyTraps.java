//Dean Mason
//Unit 3

public class VenusFlyTraps extends PlantaeKingdom implements ConsumesAnts{
    private int trapSize;

    public VenusFlyTraps(String className, String order, String family, String genus,
                         String species, String name, boolean isExtinct, String division, int trapSize) {
        super(className, order, family, genus, species, name, isExtinct, division);
        this.trapSize = trapSize;
    }

    @Override
    public String toString(){
        return super.toString() + "\nTrap size: " + Integer.toString(trapSize);
    }
}
