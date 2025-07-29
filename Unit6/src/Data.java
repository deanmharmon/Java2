//Dean Mason
//Unit 6 Project 6

import java.io.*;
import java.util.LinkedList;

/**
 * Data handles saving and loading data to keep the code clean in the input handler
 * @author Dean Mason
 * @version 1.0
 */
public class Data {

    /**
     * Saves picture to a file so that it can be reopened later
     * In a sense, it doesn't do any additional checking to make sure that you enter something, but it does foce there to
     * be text before it lets you save. So in another sense it does.
     * @param saveFile file object we are writing to
     * @param shapes linked list of shapes to save
     */
    public static void save(File saveFile, LinkedList<Shape> shapes) {
        System.out.println("Trying to save");
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(saveFile));
            output.writeObject(shapes);
        } catch (IOException ex){
            System.out.println("Error saving");
        }
    }

    /**
     *  Loads a data file to display image saved on it.
     *  Same for loading, if it wants to use a file where the data isn't readable, it continues working fine, just throwing an error.
     *  But it still works and can load a proper file after trying to load something that shouldn't work.
     * @param loadFile data file to look at for save information
     * @return the LinkedList holding the shapes to be used for redrawing
     * @throws Exception If it can't load file for whatever reason
     */
    public static LinkedList<Shape> load(File loadFile) throws Exception {
        System.out.println("Trying to load");
        try {
            ObjectInputStream input = new ObjectInputStream((new FileInputStream(loadFile)));
            return (LinkedList<Shape>) input.readObject();
        } catch (IOException ex){
            System.out.println("Error loading.");
            return null;
        }
    }
}
