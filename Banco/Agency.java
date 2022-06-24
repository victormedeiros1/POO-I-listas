import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agency{
    private int id;
    private ArrayList<Account> accounts;
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public Account search(int id){        
        return accounts
        .stream()
        .filter(c -> c.getId() == id)
        .findFirst()
        .get();
    }
    
    public double totalMoney(){
        return accounts
        .stream()
        .mapToDouble(c -> c.getBalance())
        .sum();
    }

    public Agency(){
        accounts = new ArrayList<>();
    }
    
    public void maintencePayment(){
        accounts
        .stream()
        .forEach(c -> c.maintence());
    }
    
    public double totalCreditors(){
        return accounts
        .stream()
        .filter(c -> !c.isDebtor())
        .mapToDouble(c -> c.getBalance())
        .sum();
    }
    
    
    public void currentAccountMaintencePayment(){
        accounts
        .stream()
        .filter(c -> c.getType().equals("Conta Corrente"))
        .forEach(c -> c.maintence());
    }
    
    public void birthdaysRend(){
        birthdays()
        .stream()
        .filter(c -> c.getType().equals("Conta poupança"))
        .forEach(c -> c.render());
    }

    public List<Account> accounts(Integer[] ids){
        return Arrays
        .asList(ids)
        .stream()
        .map(c -> search(c))
        .collect(Collectors.toList());
    }
    
    public double averageBalance(){
        return accounts
        .stream()
        .mapToDouble(c -> c.getBalance())
        .average()
        .orElse(Double.NaN);
    }
    
    public ArrayList<String> getExtract(int id){
        return search(id).getTransitions();
    }
    
    public double getBalance(int id){
        return search(id).getBalance();
    }
    
    public boolean deposit(int id, double value){
        if(search(id).deposit(value)) return true;
        return false;
    }
    
    public boolean transfer(int ori, int dest, double value){
        if(search(ori).transfer(value, search(dest))) return true;
        return false;
    }
    
    public boolean drawOut(int id, double value){
        if(search(id).drawOut(value)) return true;
        return false;
    }
    
    public HashMap<String, List<Account>> mapAccounts(){
        HashMap<String, List<Account>> debitAccounts = new HashMap<String, List<Account>>();        
        debitAccounts.put("Contas devedoras", accounts.stream().filter(c -> c.isDebtor()).collect(Collectors.toList()));
        debitAccounts.put("Contas não devedoras", accounts.stream().filter(c -> !c.isDebtor()).collect(Collectors.toList()));
        return debitAccounts;
    }
    
    public List<Account> devedores(){
        return accounts
        .stream()
        .filter(c -> c.isDebtor())
        .collect(Collectors.toList());
    }
    
    public List<Account> birthdays(){
        return accounts
        .stream()
        .filter(c -> c.getBirthday().startsWith(DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now()) + "/"))
        .collect(Collectors.toList());
    }
    
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
    
    public void setAccounts(ArrayList<Account> accounts){
        this.accounts = accounts;
    }
    
}
