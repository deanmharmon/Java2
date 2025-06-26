//Dean Mason
//Unit 3

/**
 * Abstract class for Eukarya Domain
 * @author Dean Mason
 * @version 1.0
 */
public abstract class EukaryaDomain {
    private String className;
    private String order;
    private String family;
    private String genus;
    private String species;
    private String name;
    private boolean isExtinct;
    private String extinction;

    /**
     * Constructor
     *
     * @param className name of class
     * @param order     name of order
     * @param family    name of family
     * @param genus     name of genus
     * @param species   name of species
     * @param name      name
     * @param isExtinct is extinct boolean
     */
    public EukaryaDomain(String className, String order, String family,
                         String genus, String species, String name, boolean isExtinct) {
        this.className = className;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.name = name;
        this.isExtinct = isExtinct;

    }

    /**
     * @return String of valuable information
     */
    @Override
    public String toString() {
        //TODO finish
        if (isExtinct) {
            extinction = "Is extinct.";
        } else {
            extinction = "Is not extinct.";
        }
        return ("Class -> " + className + "\nOrder -> "
                + order + "\nFamily -> " + family + "\nGenus -> "
                + genus + "\nSpecies -> " + species + "\nName -> "
                + name + "\n" + extinction);
    }

    /// All setters and getters
    /// Naming conventions are obvious enough that javadocing each one feels excessive

    public void setClassName(String className) {
        this.className = className;
    }

    public void setExtinct(boolean extinct) {
        isExtinct = extinct;
    }

    public void setExtinction(String extinction) {
        this.extinction = extinction;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getExtinction() {
        return extinction;
    }

    public String getClassName() {
        return className;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isExtinct() {
        return isExtinct;
    }


}
