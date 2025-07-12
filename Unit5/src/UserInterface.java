//Dean Mason
//Unit 5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    int choice;
    EnhancedBST tree = new EnhancedBST();

    public void go() throws FileNotFoundException {
        //TODO finish

        choice = intInputValidation(scanner);
        do {
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Please enter the filename that you would like to use");
                    String name = scanner.nextLine();
                    File file = fileValidation(name, scanner);
                    tree.buildFromFile(file);
                    break;

                case 2:
                    tree.printTree();
                    break;
                case 3:
                    tree.addData();
                    break;
                case 4:
                    tree.removeData();
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
                    tree.exportToFile();
                    break;
                default:
                    break;
            }
        }while (choice != 0);
    }



    public int intInputValidation(Scanner scanner){
        //TODO finish
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println("Invalid input, please enter a valid integer");
        }
        return 0;
    }

    public File fileValidation(String filename, Scanner scanner) throws FileNotFoundException {
        File inputFile = new File(filename);
        if (inputFile.exists() && inputFile.canRead()){
            return inputFile;
        } else {
            throw new FileNotFoundException("Please double check that the file exists");
        }
    }



}
