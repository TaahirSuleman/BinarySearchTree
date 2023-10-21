import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

    /** Main class - used to extract data from vaccinations.csv and store in respective variables
     * as well as receive input from the user and produce output.
     * 28/02/2022
     * @author Taahir Suleman
     */
public class VaccineArrayApp{
    VaccineArray va = new VaccineArray();
    
    /**Method used to extract the data from the vaccinations.csv files and make Vaccine objects 
       with this data by using the addVax() method in the VaccineArray class and
       the Vaccine constructor with the String line parameter.
    */
    public void readData(){
        try{
            Scanner sc = new Scanner(new FileReader("data/vaccinations.csv"));        
            while(sc.hasNext()){
                String line = sc.nextLine();
                va.addVax(new Vaccine(line));       
        }
        
        }
        catch(FileNotFoundException e){
            System.out.println("File was not found.");
        }    
    }
    
    /**Method that facilitates input from the user, uses the outputVax method from the 
       VaccineArray class to find the inputted country and date combination and its respective
       vaccine quantity, then outputting this in a descriptive manner.
    */ 
    public void userInteraction(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date:");
        String date = input.next();
        System.out.println("Enter the list of countries (end with an empty line):");
        String countries[] = new String[10000];
        int count = 0;
        String empty = input.nextLine();
        String line = input.nextLine();
        while (!line.equals("")){
            countries[count] = line;
            count++;
            line = input.nextLine();
        }
        String[] vaccinations = va.outputVax(countries, date, count);
        System.out.println("Results:");
        for(int i = 0; i < count; i++){
            System.out.println(countries[i] + " = " + vaccinations[i]);
        }
        System.out.println("Total operations =\t" + va.opCount);    
    }
    
    /** main method that is invoked to facilitate running this program.
        @param args Used for Arguments provided when running.
    */
    public static void main(String[] args){
        VaccineArrayApp obj = new VaccineArrayApp();
        obj.readData();
        obj.userInteraction();
    }
}