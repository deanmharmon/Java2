//Dean Mason
//Unit 3

public abstract class EukaryaDomain {
    String className;
    String order;
    String family;
    String genus;
    String species;
    String name;
    boolean isExtinct;
    String extinction;

    public EukaryaDomain(String className, String order, String family,
                         String genus, String species, String name, boolean isExtinct){
        this.className = className;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.name = name;
        this.isExtinct = isExtinct;

    }

    @Override
    public String toString(){
        //TODO finish
        if (isExtinct){
            extinction = "Is extinct.";
        }else {
            extinction = "Is not extinct.";
        }
        return("Class -> " + className + "\nOrder -> "
        + order + "\nFamily -> " + family + "\nGenus -> "
        + genus + "\nSpecies -> " + species + "\nName -> "
        + name + "\n" + extinction);
    }
}
