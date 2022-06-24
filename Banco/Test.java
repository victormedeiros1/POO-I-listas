import java.util.Random;
import java.util.ArrayList;
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test
{
    Random random = new Random();
    
    public Bank globalMount()
    {
        Bank newBank = createBank();
        
        newBank.setAgencies(createAgencies(3));
        
        return newBank;
    }
    
    public ArrayList<Account> createAccounts(int number){
        ArrayList<Account> accountArray = new ArrayList<>();
        
        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = 0; i < number; i++){
            Account Account = new Account(); 
            Account.setId(1 + i);
            
            if(i%2 == 0){
                Account.setType("Conta Corrente");
                Account.setRendPercent(0);
            }
            
            else{
                Account.setType("Account Poupança"); 
                Account.setRendPercent(random.nextDouble());
            }
            Account.setBirthday(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
            Account.setLimit(Account.getBalance() * 0.1);
            Account.deposit(random.nextInt(5000));
            Account.setMaintencePayment(random.nextInt(200) + 10);

            
            accountArray.add(Account);
        }
        return accountArray;
    }
    
    public ArrayList<Agency> createAgencies(int number){
        ArrayList<Agency> agenciesArray = new ArrayList<>();
        
        for (int i = 0; i < number; i++){
            Agency agency = new Agency(); 
            agency.setId(i + 1);
            agency.setAccounts(createAccounts(5));
            
            agenciesArray.add(agency);
        }
        
        return agenciesArray;
    }
    
    public Bank createBank(){
        Bank newBank = new Bank();
        
        newBank.setName("Bank");
        
        return newBank;
    }
}
