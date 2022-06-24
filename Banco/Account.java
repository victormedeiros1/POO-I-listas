import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class Account{
    private int id;
    private String type;  
    private double balance;  
    private double limit;
    private double maintencePayment;
    private double rendPercent;
    private String birthday;
    private ArrayList<String> transitions = new ArrayList<>();
    
    public Account(){}
        
        
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getBirthday(){
        return this.birthday;
    }
    
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    
    public double getBalance(){
        return this.balance;
    }

    public double getLimit(){
        return this.limit;
    }
    
    public void setLimit(double limit){
        this.limit = limit;
    }
    
    public double getMaintencePayment(){
        return this.maintencePayment;
    }
    
    public void setMaintencePayment(double maintencePayment){
        this.maintencePayment = maintencePayment;
    }
    
    public double getRendPercent(){
        return this.rendPercent;
    }
    
    public void setRendPercent(double rendPercent){
        this.rendPercent = rendPercent;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean isDebtor(){
        return (balance < 0) ? true : false;
    }
    
    public boolean deposit(double value){
        balance = balance + value;
        
        transitions.add("Data: " + LocalDateTime.now() + " - Depósito em reais:" + value + " Saldo em reais:" + balance);
        
        return true;
    }
    
    public boolean maintence(){
        balance = balance - maintencePayment;
        
        if(transitions
        .stream()
        .filter(t -> t.startsWith("Data: "+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()))
         && t.contains("Taxa de Manutenção"))
         .collect(Collectors.toList()).size() < 1){
             
            transitions.add("Data: " + LocalDateTime.now() + " - Taxa de Manutenção em reais:" + maintencePayment + " Saldo: R$" + balance);
            return true; 
        }
        
        return false;
    }
    
    public boolean render(){
        balance += rendPercent * balance;
        transitions.add("Data: " + LocalDateTime.now() + " - Rendimento em reais:" + maintencePayment + " Saldo: R$" + balance);
        
        return true;
    }
    
    public boolean transfer(double value, Account receivedAccount){
        if(value <= limit + balance){
            balance -= value;
            
            receivedAccount.balance += value;
            
            transitions.add("Data: " + LocalDateTime.now() + " - Transferência enviada em reais: " + value + " Saldo em reais:" + balance);
            
            receivedAccount.transitions.add("Data: " + LocalDateTime.now() + " - Transferência recebida em reais: " + value + " Saldo em reais: " + balance);
            
            return true;
        }
        
        return false;
    }

    
    public boolean drawOut(double value){
        if(value <= limit + balance){
            balance -= value;
            transitions.add("Data: " + LocalDateTime.now() + " - Saque: -R$" + value + " Saldo: R$" + balance);
            
            return true;
        }
        
        return false;
    }
    
    public ArrayList<String> getTransitions(){
        return this.transitions;
    }
        
    
}
