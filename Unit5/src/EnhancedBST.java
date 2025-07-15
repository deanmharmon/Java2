//Dean Mason
//Unit 5

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * EnhancedBST extends the functionality of BinarySearchTree
 */
public class EnhancedBST extends BinarySearchTree{

    /**
     * Builds tree from a given filename
     * @param filename name of file
     */
    public void buildFromFile(File filename){
        try {
            Scanner lineReader = new Scanner(filename);
            while (lineReader.hasNextLine()){
                String currentLine = lineReader.nextLine().trim();
                if (currentLine.isEmpty() == false){
                    int currentNumber = Integer.parseInt((currentLine));
                    add(currentNumber);
                }
            }
            lineReader.close();
        } catch (Exception e){
            System.out.println("Reading from this file is currently not working.");
        }

    }

    /**
     * Overriden print func from BinarySearchTree
     */
    @Override
    public void print(){
        System.out.print("Inorder: " );
        inOrder(getRoot());
        System.out.println("");
        System.out.print("Preorder: ");
        preOrder(getRoot());
        System.out.println("");
        System.out.print("Postorder: ");
        postOrder(getRoot());
    }

    /**
     * Adds data to tree
     * @param newInt integer to add
     */
    public void addData(int newInt){
        add(newInt);
    }

    /**
     * Removes data from tree
     * @param removeInt integer to remove
     */
    public void removeData(int removeInt){
        remove(removeInt);
    }

    /**
     * Prints height of trree
     */
    public void showHeight(){
        Node root = getRoot();
        int height = height(root);
        System.out.println("The height of the tree currently is: " + height);
    }

    /**
     * Prints length of tree
     */
    public void showLength(){
        Node root = getRoot();
        int length = length(root, 0);
        System.out.println("The length of the tree currently is: " + length);
    }

    /**
     * Counts the absent children from tree
     */
    public void countAbsChildren(){
        int total = absChildren(getRoot());
        System.out.println("There are " + total + " absent children in this tree");
    }

    /**
     * Finds a path using the sum of all nodes through path (must end on leaf)
     * @param userNum sum to look for
     */
    public void findPathSum(int userNum){
        boolean isThere = sum(getRoot(), userNum);
        if (isThere){
            System.out.println("A path was found using that sum!");
        } else {
            System.out.println("A path with that sum was not found :(");
        }
    }

    /**
     * Exports tree to a text file
     * @param workingName name of new file (validated for safety)
     */
    public void exportToFile(String workingName){
        try {
            PrintWriter output = new PrintWriter(workingName);
            Iterator<Integer> myTreeIterator = printingIterator();
            while (myTreeIterator.hasNext()){
                output.println(myTreeIterator.next());
            }
            output.close();
            System.out.println("File has successfully been exported.");
        } catch (FileNotFoundException e){
            System.out.println("File could not be written.");
        }

    }

    /**
     * Private method to order
     * @param startingNode node to start from
     */
    private void inOrder(Node startingNode){
        if (startingNode == null){
            return;
        }
        inOrder(startingNode.left);
        System.out.print(startingNode.data + " ");
        inOrder(startingNode.right);
    }

    /**
     * Private method to order
     * @param startingNode node to start from
     */
    private void postOrder(Node startingNode){
        if (startingNode == null) {
            return;
        }

        postOrder(startingNode.left);
        postOrder(startingNode.right);
        System.out.print(startingNode.data + " ");
    }

    /**
     * Private method to order
     * @param startingNode node to start from
     */
    private void preOrder(Node startingNode){
        if (startingNode == null){
            return;
        }
        System.out.print(startingNode.data + " ");
        preOrder(startingNode.left);
        preOrder(startingNode.right);

    }

    /**
     * Private method that finds height
     * @param thisNode node you are finding height of
     * @return height
     */
    private int height(Node thisNode){
        if (thisNode == null){
            return 0;
        }

        int rightSide = height(thisNode.right);
        int leftSide = height(thisNode.left);

        if (leftSide > rightSide){
            return (leftSide + 1);
        } else {
            return (rightSide + 1);
        }
    }

    /**
     * Finds length of tree
     * @param thisNode node to look at
     * @param level what level to start from
     * @return length of tree
     */
    private int length(Node thisNode, int level){
        if (thisNode == null){
            return 0;
        }

        return length(thisNode.right, level + 1) + length(thisNode.left, level + 1) + level;
    }

    /**
     * Private method to find absent children
     * @param thisNode node to xtart from
     * @return the num of absent children
     */
    private int absChildren(Node thisNode){
        if (thisNode == null){
            return 0;
        }
        int children = 0;
        if (thisNode.left == null){
            children += 1;
        } else {
            children += absChildren(thisNode.left);
        }
        if (thisNode.right == null){
            children += 1;
        } else {
            children += absChildren(thisNode.right);
        }

        return children;
    }

    /**
     * Private method to verify if a path sum can be found
     * @param thisNode node to start from
     * @param userNum the sum to be looking for
     * @return true/false if that path sum is found
     */
    private boolean sum(Node thisNode, int userNum){
        if (thisNode == null){
            return false;
        }
        if (thisNode.left == null && thisNode.right == null){
            return (int) thisNode.data == userNum;
        }

        if (sum(thisNode.left, userNum - (int) thisNode.data)){
            return true;
        }
        if (sum(thisNode.right, userNum - (int) thisNode.data)){
            return true;
        }
        return false;

    }

    /**
     * Iterator for printing to document
     * @return iterator
     */
    public Iterator<Integer> printingIterator(){
        ArrayList<Integer> numbers = new ArrayList<>();
        makeList(getRoot(), numbers);
        return numbers.iterator();
    }

    /**
     * Adds node values to a list
     * @param thisNode the node being looked at
     * @param numbers ArrayList to add node values to
     */
    private void makeList(Node thisNode, ArrayList<Integer> numbers){
        if (thisNode == null){
            return;
        }
        numbers.add((Integer) thisNode.data);
        makeList(thisNode.left, numbers);
        makeList(thisNode.right, numbers);
    }

}

