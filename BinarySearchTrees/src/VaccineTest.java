import java.io.*;
import java.util.*;
/**Script used to automate the process of performing find operations on each item in the 
   subsets of vaccineBig.csv to find the min max and average opCount accordingly for each 
   subset.
   06/03/2022
   @author Taahir Suleman
*/
public class VaccineTest{
   VaccineArray va = new VaccineArray();
   int sumOpCount = 0;
   int min = 100000;
   int max = 0;
   /**Class that reads each line of the subset file vaccinations.csv then writes the country 
      and date on separate lines with a third blank line to act as redirected input for 
      VaccineBSTApp/VaccineArrayApp for experimentation. Also runs each main app on each 
      iteration and runs it with this newly created file using the script run.sh.
      */ 
   public void readWriteFile(){
      
      String[] temp = new String[3];
      try{
         Scanner sc = new Scanner(new FileReader("data/vaccinations.csv"));
         while(sc.hasNext()){
            String line = sc.nextLine();
            temp = line.split(",");
            writeInput(temp);
            //command to run program with testinput from this program.
            try{
               String[] command = {"/home/tai/CSC2001/Assignment1/src/run.sh"};
               ProcessBuilder pb = new ProcessBuilder(command);
               Process process = pb.start();
               Scanner scFile = new Scanner(new FileReader("data/testoutput.txt"));
               String l = scFile.next();
               int findOp = Integer.parseInt(l);
               sumOpCount += findOp;
               if (findOp < min){
                  min = findOp;
               } 
               if (findOp > max){
                  max = findOp;
               }
            }
            catch(IOException e){
               System.out.println(e);
            }
      }
      }
      catch(FileNotFoundException e){
         System.out.println("File was not found.");
      }
      int average = sumOpCount/991;
      System.out.println("Min: " + min + "\nMax: " + max +"\nAverage: " + average + "\n"); 
   }
   
   /** Method used to write each single input query to a file to be used when running the apps
       with input redirection.
   */
   public void writeInput(String[] items){
      try{
         FileWriter myWriter = new FileWriter("data/testinput.txt");
         myWriter.write(items[1] + "\n" + items[0] + "\n" + "\n");
         myWriter.close();
      }

      catch(IOException e){
         System.out.println("Error occurred while writing.");
      }

   }
   
   /** Main method that is invoked when VaccineTest is run to use the methods of this class to
       perform experimentation accordingly.
   */
   public static void main(String[] args){
      VaccineTest vt = new VaccineTest();
      vt.readWriteFile();
      
   }    

}