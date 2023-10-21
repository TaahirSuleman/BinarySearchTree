import java.util.Scanner;

/** Class used to facilitate user input and produce output accordingly after searching for the
    inputted countries and the respective date.
    02/03/2022
    @author Taahir Suleman
*/
public class VaccineBSTApp{

    VaccineBST vb = new VaccineBST();
    
    /** Method that first allows for the user to input a date and list of countries to search
        for with that date, then continuously concatenates an output string before printing 
        this string out.
        @return a complete output string to be displayed on the console.
    */
    public String output(){
        String output = "Results:\n";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the date:");
        String date = input.next();
        System.out.println("Enter the list of countries (end with an empty line):");
        String empty = input.nextLine();
        String line = input.nextLine();
        
        while(!line.equals("")){
            String country = line;
            Vaccine v = vb.findVax(new Vaccine(country, date));
            output += country + " = "; 
            if (v == null){
                output += "<Not Found>\n";
                line = input.nextLine();                
            }
            else{
                output += v.vaccinations + "\n";
                line = input.nextLine();
            }
        }
        output += "Insert operations:\t" + vb.getIOpCount() + "\n";
        output += "Find operations:\t" + vb.getFOpCount() + "\n";
        int totalOp = vb.getIOpCount() + vb.getFOpCount(); 
        output += "Total operations:\t" + totalOp + "\n";
        return output;      
    }
    
    public String testOutput(){
        
        String output = "";
        output += vb.getIOpCount() + "," + vb.getFOpCount() + "\n";
        return output;
    }
    
    /** Method that calls the extractData method from VaccineBST for ease of use in the static
        main method that follows.
    */
    public void readFile(){
      vb.extractData();
    }
    
    /** Main method that is invoked to facilitate running this program.
        @param args Used for Arguments provided when running.
    */    
    public static void main(String[] args){
        VaccineBSTApp vst = new VaccineBSTApp();
        vst.readFile();
        System.out.print(vst.output());
    }

}