
/**Class used to create and populate a Vaccine array of objects using the data from 
   vaccinations.csv and use this array to find certain Vaccine objects given a specific 
   country and date combination.
   01/03/2022
   @author Taahir Suleman
*/
public class VaccineArray{

    Vaccine[] vaccines = new Vaccine[10000];
    int counter = 0;
    int opCount = 0;    
    /** Method used by VaccineArrayApp to populate the vaccines array of objects after the data
        in vaccinations.csv is extracted and separated accordingly.
        @param v Vaccine object to add to the vaccines array.
    */    
    public void addVax(Vaccine v){
        vaccines[counter] = v;
        counter++;
    }
    
    /** Method used to find a Vaccine object in the vaccines array with the country and date 
        combination in v and to then return this object in the array.
        @param v Vaccine object whose country and date combination is compared to elements
        in the vaccines array to determine whether it is in the array.
        @return the Vaccine object from the vaccines array if it is found; null if it not found.
    */
    public Vaccine findVax(Vaccine v){
        for(int i = 0; i < counter - 1; i++){
            opCount++;
            if(v.compareTo(vaccines[i]) == 0){
                return vaccines[i];
            } 
        }
        return null;
    }
    
    /** Method used to formulate output to be produced after the user provides input and the
        vaccines array is searched accordingly.
        @param countries Array containing the list of countries entered by the user.
        @param date String containing the date inputted by the user.
        @param count Gives the number of countries contained in the countries array.
        @return String array containing the vaccination quantities for the given country and
                date combinations, appending "Not found" where it wasn't located in the vaccines
                array.
    */
    public String[] outputVax(String[] countries, String date, int count){
        Vaccine[] vax = new Vaccine[count+1];
        for(int i =0; i < count; i++){
            vax[i] = new Vaccine(countries[i], date);
            
        }
       String[] vaccinations = new String[count+1];
        for(int j = 0; j < count; j++){
            Vaccine v = findVax(vax[j]);
            if(v == null){
                vaccinations[j] = "<Not found>";
            }
            else{
                vaccinations[j] = v.vaccinations;                
            }
        }
        return vaccinations;
    }

}