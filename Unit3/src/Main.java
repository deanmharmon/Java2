//Dean Mason
//Unit 3

/**
 * Main prints relevant info
 * @author Dean Mason
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        VenusFlyTraps vft = new VenusFlyTraps("Magnoliopsida", "Caryophyllales",
                "Droseraceae", "Dionaea", "Muscipula",
                "Venus Fly Trap", false, "Anthophyta", 40);
        Aardvarks aard = new Aardvarks("Mammalia", "Tubulidentata", "Orycteropodidae",
                "Orycteropus", "Orycteropus afer", "Aardvark", false, "Chordata",
                "Woodland");
        Ants ant = new Ants("Insecta", "Hymenoptera", "Formicidae",
                "Solenopsis", "Invicta", "Fire Ant", false, "Anthropoda",
              "Queen");
        System.out.println(ant.toString() + "\n");
        System.out.println(aard.toString() + "\n");
        System.out.println(vft.toString());

    }
}
