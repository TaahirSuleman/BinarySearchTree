class Vaccine implements Comparable<Vaccine>{
    
    /* Class used to store the data of each entry extracted from vaccines.csv
     Taahir Suleman
     28/02/2022
    */
    String country;
    String date;
    String vaccinations;

    public Vaccine(String line){
        String [] items = line.split(",");
        country = items[0];
        date = items[1];
     if (items.length == 3){
         vaccinations = items[2];
     }
     else{
         vaccinations = "";
     }
    }
    
    public Vaccine(String c, String d){
         country = c;
         date = d;
         vaccinations = "0";
    }
    
    public int compareTo(Vaccine v){
         return (country+date).compareTo(v.country+v.date);
    }   

}