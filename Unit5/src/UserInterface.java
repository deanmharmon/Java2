//Dean Mason
//Unit 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * User interface is everything that the user can see and select. Calls correct methods from EnhancedBST
 */
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    int choice;
    EnhancedBST tree = new EnhancedBST();

    /**
     * Runs the user interface using a do-while loop. Gives user ability to
     * choose what to do from menu and when to quit. Calls correct methods from EnhancedBST
     */
    public void go() {
        //TODO finish
        System.out.println("Welcome to Enhanced BST Tester.\n\n");

        do {
            int choice = 10;
            while ((choice > 9) || (choice < 0)){
                printMenu();
                choice = intInputValidation(scanner);
                if ((choice > 9) || (choice < 0)){
                    System.out.println("Invalid number entered. Please enter a number between 0 and 9");
                }
            }
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using Enhanced BST Tester.");
                    break;
                case 1:
                    System.out.println("Please enter the filename that you would like to use");
                    String name = scanner.nextLine();
                    try {
                        File file = fileValidation(name, scanner);
                        tree.buildFromFile(file);
                    } catch (FileNotFoundException e) {
                        System.out.println("The filename entered could not be found.");
                    }
                    break;
                case 2:
                    tree.printTree();
                    break;
                case 3:
                    System.out.println("Please enter an integer to add to the tree: ");
                    int addInt = intInputValidation(scanner);
                    tree.addData(addInt);
                    break;
                case 4:
                    System.out.println("Please enter an integer to remove from the tree: ");
                    int removeInt = intInputValidation(scanner);
                    tree.removeData(removeInt);
                    break;
                case 5:
                    tree.showHeight();
                    break;
                case 6:
                    tree.showLength();
                    break;
                case 7:
                    tree.countAbsChildren();
                    break;
                case 8:
                    tree.findPathSum();
                    break;
                case 9:
                    System.out.println("Please enter the name you would like to use for the file, do NOT include .txt");
                    String newFile = scanner.nextLine();
                    String workingName = fileValidation(newFile);
                    if (workingName != null){
                        tree.exportToFile(workingName + ".txt");
                    }
                    break;
            }
        }while (choice != 0);
    }

    /**
     * Validates that integers have been input
     * @param scanner scanner object used to extract what was input
     * @return the parsed integer
     */
    public int intInputValidation(Scanner scanner){
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid integer");
            }
        }
    }

    /**
     * Verifies that a file exists and can be read from before performing operations on it
     * @param filename the name of the file being checked
     * @param scanner scanner object to parse
     * @return the valid file object
     * @throws FileNotFoundException if the file cannot be found
     */
    public File fileValidation(String filename, Scanner scanner) throws FileNotFoundException {
        File inputFile = new File(filename);
        if (inputFile.exists() && inputFile.canRead()){
            return inputFile;
        } else {
            throw new FileNotFoundException("Please double check that the file exists");
        }
    }

    /**
     * Simple validation to check that user doesn't enter illegal characters for file name
     * @param newName the name being checked
     * @return working name String or null if unusable
     */
    public String fileValidation(String newName){
        String lowerName = newName.trim().toLowerCase();
        String properName = "";
        for (char letter : lowerName.toCharArray()){
            if ((letter >= 'a' && letter <= 'z') || (letter >= '0' && letter <= '9') ||
                    (letter == '_') || (letter == '-')){
                properName = properName + letter;
            } else {
                System.out.println("Improper character entered, please try again");
                return null;
            }
        }
        return properName;
    }

    /**
     * Prints the menu for the user to see
     */
    public void printMenu(){
        System.out.println("Here's the menu of choices -\n" +
                "\t0) Quit\n" +
                "\t1) Build a BST from a text file\n" +
                "\t2) Print the tree\n" +
                "\t3) Add data\n" +
                "\t4) Remove data\n" +
                "\t5) Show tree height\n" +
                "\t6) Show internal path length\n" +
                "\t7) Count absent children\n" +
                "\t8) Find a path sum\n" +
                "\t9) Export a BST to a text file\n" +
                "Enter your choice: ");
    }

}
