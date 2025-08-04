//Dean Mason
//Final

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Handles the UI, as well as using Gson to parse
 *
 * @author Dean Mason
 * @version 1.0
 */
public class UserInterface {
    final Gson gson = new Gson();
    Scanner scanner = new Scanner(System.in);
    Meteorite[] fullData;
    final Path DEFAULT = Path.of("NASA_Meteorite.json");

    public void go() {
        try {
            //System.out.println(Files.exists(Path.of("NASA_Meteorite.json")));
            List<String> line = Files.readAllLines(Path.of("NASA_Meteorite.json"));
            String data = String.join("", line);
            fullData = gson.fromJson(data, Meteorite[].class);
        } catch (Exception e) {
            System.out.println("Failure.");
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
                    listClasses();
                    break;
                default:
                    System.out.println("Invalid.");
            }

        } while (choice != 0);
    }

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

            List<String> allJson = Files.readAllLines(path);
            String allString = String.join("", allJson);
            fullData = gson.fromJson(allString, Meteorite[].class);
            System.out.println(fullData.length + " records processed.");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

    private void displayData() {
        if (fullData == null){
            System.out.println("Data has not yet been loaded.");
            return;
        }
        System.out.println("Meteorite data: \n");
        for (int count = 0; count < fullData.length; count++){
            System.out.println("Meteorite " + fullData[count]);
        }

    }

    private void exportBin() {
        if (fullData == null){
            System.out.println("Data has not yet been loaded.");
            return;
        }
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(("meteorites.data")))) {
            outStream.writeObject(fullData);
            System.out.println(".\n..\n...\n" + "Data has been saved successfully!");
        } catch (Exception e){
            System.out.println("Error saving.");
        }
    }

    private void findName() {
        if (fullData == null){
            System.out.println("Data has not yet been loaded.");
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


    private void listClasses() {
    }

    private void recent() {
    }

    private void largest() {
    }

    private void findID() {
    }


    public int intValidation(String num) {
        int valaNum;
        try {
            int valNum = Integer.parseInt(num);
            return valNum;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return -1;
        }
    }

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


}