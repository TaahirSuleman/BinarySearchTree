import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
/** Class used to extract data from vaccinations.csv and add it to a Binary Search Tree (BST)
    containing Vaccine objects accordingly.
    This class also uses the BST find method to determine whether an inputted
    country and date combination appears in the BST.
    02/03/2022
    @author Taahir Suleman
*/ 
public class VaccineBST{

    BinarySearchTree<Vaccine> bst = new BinarySearchTree<Vaccine>();
    
    /** Reads the data from the vaccinations.csv file and appends the consequently created
        Vaccine objects to the BST created above.
    */
    public void extractData(){
        try{
            Scanner sc = new Scanner(new FileReader("data/vaccinations.csv"));
            while(sc.hasNext()){
                String line = sc.nextLine();
                bst.insert(new Vaccine(line));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found. ");
        }
    }
    
    /** Method used to determine whether a provided Vaccine object, created with a country and
        date combination provided by the user, is present in the BST of Vaccine objects.
        @param v Vaccine object provided that is compared against Vaccine objects in the BST.
        @return Vaccine object if one that matches the argument provided is found; null if it is
                not found.
    */        
    public Vaccine findVax(Vaccine v){
        BinaryTreeNode btn = bst.find(v);
        if (btn != null)
            return (Vaccine) btn.data;
                
        
        return null;                        
    }
    
    /** Method used to return the insert operation counter retrieved from the BST program that counts
        the number of comparisons done by the BST operations when inserting all the Vaccination
        items. This method make it readily available to VaccineBSTApp.
        @return Integer value of the insert operation counter from the BST program.
    */
    
    public int getIOpCount(){
        return bst.iOpCount;
    }
    
    /** Method used to return the find operation counter retrieved from the BST program that counts
        the number of comparisons done by the BST operations when performing the find operations. 
        This method make it readily available to VaccineBSTApp.
        @return Integer value of the find operation counter from the BST program.
    */
    public int getFOpCount(){
        return bst.fOpCount;
    }
}