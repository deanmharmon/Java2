//Dean Mason
//Final

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the UI, as well as handling all logic. Method go is the main program loop
 *
 * @author Dean Mason
 * @version 1.0
 */
public class UserInterface {
    private final Gson gson = new Gson();
    private final Scanner scanner = new Scanner(System.in);
    private Meteorite[] fullData;
    final Path DEFAULT = Path.of("NASA_Meteorite.json");

    /**
     * Main loop
     */
    public void go() {

        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(("meteorites.data")))) {
            fullData = (Meteorite[]) inStream.readObject();
            System.out.println("Data loaded successfully from last runtime.");
        } catch (Exception e){
            //Meant to fail first time, so it will always just try
        }

        int choice;

        do {
            menu();
            choice = intValidation(scanner.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using the program! Now exiting...\n..\n.");
                    break;
                case 1:
                    importJson();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    exportBin();
                    break;
                case 4:
                    findName();
                    break;
                case 5:
                    findID();
                    break;
                case 6:
                    largest();
                    break;
                case 7:
                    recent();
                    break;
                case 8:
                    allClasses();
                    break;
                default:
                    System.out.println("Invalid input, please select an option.");
            }

        } while (choice != 0);
    }

    /**
     * Imports data from JSON file
     */
    private void importJson() {
        try {
            System.out.print("Enter the JSON file name or press <Enter>" +
                    " to accept the default (FinalMavenBuild/NASA_Meteorite.json): ");

            String jsonTry = scanner.nextLine().trim();
            Path path;

            if (jsonTry.isEmpty()) {
                path = DEFAULT;
            } else {
                path = Path.of(jsonTry);
            }
            //System.out.println(Files.exists(Path.of("NASA_Meteorite.json")));
            List<String> allJson = Files.readAllLines(path);
            String allString = String.join("", allJson);
            fullData = gson.fromJson(allString, Meteorite[].class);
            System.out.println(fullData.length + " records processed.");

        } catch (Exception e) {
            System.out.println("Failure, file not found/could not be loaded.");
        }
    }

    /**
     * Shows the toString from the meteorite/geolocation data
     */
    private void displayData() {
        if (dataNull()){
            return;
        }
        System.out.println("Meteorite data: \n");
        for (int count = 0; count < fullData.length; count++){
            System.out.println("Meteorite " + fullData[count]);
        }

    }

    /**
     * Saves all info to .data file for easy recovery
     */
    private void exportBin() {
        if (dataNull()){
            return;
        }
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(("meteorites.data")))) {
            outStream.writeObject(fullData);
            System.out.println(".\n..\n...\n" + "Data has been saved successfully!");
        } catch (Exception e){
            System.out.println("Error saving.");
        }
    }

    /**
     * Searches for a meteorite by name
     */
    private void findName() {
        if (dataNull()){
            return;
        }
        System.out.print("Enter the name of the meteorite: ");
        String meteorite = scanner.nextLine().trim();

        Meteorite same = Arrays.stream(fullData)
                .filter(w -> w.getName() != null && w.getName().equalsIgnoreCase(meteorite))
                .findFirst()
                .orElse(null);

        if (same == null){
            System.out.println("Meteor not found in data.");
        } else {
            System.out.println(same.display());
        }
    }

    /**
     * Searches for meteorite by ID
     */
    private void findID() {
        if (dataNull()){
            return;
        }
        System.out.print("Enter the ID of the meteorite: ");
        String meteorite = scanner.nextLine().trim();

        Meteorite same = Arrays.stream(fullData)
                .filter(w -> w.getId() != null && w.getId().equalsIgnoreCase(meteorite))
                .findFirst()
                .orElse(null);

        if (same == null){
            System.out.println("Meteor not found in data.");
        } else {
            System.out.println(same.display());
        }
    }

    /**
     * Searches for the largest X number of meteorites
     */
    private void largest() {
        if (dataNull()){
            return;
        }

        System.out.print("How many of the largest meteorites do you want to see? ");
        int displayNum = intValidation(scanner.nextLine().trim());
        if (displayNum == -1){
            System.out.println("You must enter a valid number");
            return;
        }

        Meteorite[] largest = Arrays.stream(fullData)
                .filter(w -> doubleValidation(w.getMass()) > 0)
                .sorted((first, second) ->
                        Double.compare(doubleValidation(second.getMass()), doubleValidation(first.getMass())))
                .limit(displayNum)
                .toArray(Meteorite[]::new);

        for(Meteorite l : largest){
            System.out.println(l.display());
        }

    }

    /**
     * Searches for the most recent X number of meteorites
     */
    private void recent() {
        if (dataNull()){
            return;
        }

        System.out.print("How many of the most recent meteorites do you want to see? ");
        int displayNum = intValidation(scanner.nextLine().trim());
        if (displayNum == -1){
            System.out.println("You must enter a valid number");
            return;
        }

        Meteorite[] recent = Arrays.stream(fullData)
                .filter(w -> intValidation(w.getYear()) > 0)
                .sorted((first, second) ->
                        Integer.compare(intValidation(second.getYear()),
                                intValidation(first.getYear())))
                .limit(displayNum)
                .toArray(Meteorite[]::new);

        for(Meteorite r : recent){
            System.out.println(r.display());
        }


    }

    /**
     * Lists all the different meteorite classes and number of each in the data
     */
    private void allClasses() {
        if (dataNull()){
            return;
        }
        List<String> classList = Arrays.stream(fullData)
                .map(Meteorite::getRecclass)
                .filter(w -> w != null && !w.isBlank())
                .distinct()
                .sorted((first, second) -> Integer.compare(countClass(second), countClass(first)))
                .toList();

        //Not pretty, functional however
        System.out.println("Meteorite classes:" +
                "\nCount\tClassification\n" +
                "=====\t===========");
        for (String c : classList) {
            System.out.printf("%5d\t", countClass(c));
            System.out.printf("%s\n", c );
        }
    }


    /**
     * helper to validate integers
     * @param num input
     * @return valid int or -1 for invalid int
     */
    public int intValidation(String num) {
        try {
            int valNum = Integer.parseInt(num);
            return valNum;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return -1;
        }
    }

    /**
     * validates doubles
     * @param num input
     * @return valid double or -1
     */
    public double doubleValidation(String num){
        try {
            double valNum = Double.parseDouble(num);
            return valNum;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * helper class for menu display
     */
    public void menu() {
        String menu = "Welcome to the NASA Meteorite tracking database." +
                "\n\nHere's the menu of choices -" +
                "\n\t0) Quit" +
                "\n\t1) Import meteorite data from a JSON file" +
                "\n\t2) Display the meteorite data" +
                "\n\t3) Export the meteorite data to a file" +
                "\n\t4) Find a meteorite by name" +
                "\n\t5) Find a meteorite by ID" +
                "\n\t6) List the largest meteorites" +
                "\n\t7) List the most recent meteorites by year" +
                "\n\t8) List the meteorite classes" +
                "\nEnter your choice: ";
        System.out.println(menu);
    }

    /**
     * helper since it gets used so frequently
     * @return true if data is currently null
     */
    private boolean dataNull(){
        if (fullData == null){
            System.out.println("Data has not yet been loaded.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * helper for counting the classes using a stream
     * @param recClass name of class you're counting
     * @return total number of a specific class
     */
    private int countClass(String recClass) {
        int total = (int) Arrays.stream(fullData)
                .filter(w -> w.getRecclass() != null && w.getRecclass().equals(recClass))
                .count();
        return total;
    }

}