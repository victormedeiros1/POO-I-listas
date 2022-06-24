import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bank{
    private String name;
    private ArrayList<Agency> agencies;
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Bank(){
        agencies = new ArrayList<>();
    }
    
    public double totalMoney(){
        return agencies
        .stream().mapToDouble(a -> a.totalMoney())
        .sum();
    }
    
    public void birthdaysRend(){
        agencies
        .stream().forEach(a -> a.birthdaysRend());
    }
    
    public ArrayList<Agency> getAgencies(){
        return this.agencies;
    }
    
    public void setAgencies(ArrayList<Agency> agencies){
        this.agencies = agencies;
    }
    
}
