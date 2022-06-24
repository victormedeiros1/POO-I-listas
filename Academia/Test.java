import java.util.Random;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test
{
    Random rand = new Random();
    
    public Gym globalMount()
    {
        Gym newGym = createGym();
        ArrayList<Client> clients = createClients(2);
        
        newGym.setClients(clients);
        newGym.setClientsTree(createClientsTree(clients));
        
        for (Client c: newGym.getClients()){
            ArrayList<Metric> metrics = createMetrics(5);
            
            c.setMetrics(metrics);
            c.setMetricsTree(createMetricsTree(metrics));
            c.setGoal(createMetrics(1).get(0));
        }
        
        return newGym;
    }

    public ArrayList<Metric> createMetrics(int num)
    {
        ArrayList<Metric> metricArray = new ArrayList<>();
        
        for (int i = 0; i < num; i++){
            Metric metric = new Metric();
            
            metric.setHeight(0.3 + 1.8 * rand.nextDouble()); 
            metric.setWeight(73 + rand.nextInt(60)); 
            metric.setWaist(46 + rand.nextInt(60)); 
            metric.setDate(DateTimeFormatter.ofPattern("yyyy/MM/").format(LocalDateTime.now())+(rand.nextInt(28)+1)); 
            metric.setChest(30 + rand.nextInt(60)); 
            metric.setBiceps(41 + rand.nextInt(60)); 
            metric.setTriceps(32 + rand.nextInt(60)); 
            
            metricArray.add(metric);
        }
        
        return metricArray;
    }
    
    public TreeMap<String, Metric> createMetricsTree(ArrayList<Metric> metrics)
    {
        TreeMap<String, Metric> metricArray = new TreeMap<>();
        
        for (Metric metric:metrics){
            metricArray.put(metric.getDate(), metric); 
        }
        return metricArray;
    }
    
    public ArrayList<Client> createClients(int num)
    {
        ArrayList<Client> clientArray = new ArrayList<>();
        
        for (int i=0; i<num; i++){
            Client client = new Client();
            client.setName("New Client "+(i + 1)); 
            client.setCpf("XXXXXXXX"+(i + 1));
            client.setBirthdate(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now()));
            
            // Gerar sexo aleatório, 1 é masculino e 2 é feminino
            int sex = rand.nextInt(2);
            
            client.setGenre(sex == 1 ? "M" : "F");
            
            clientArray.add(client);
        }
        return clientArray;
    }
    
    public TreeMap<String, Client> createClientsTree(ArrayList<Client> clients)
    {
        TreeMap<String, Client> clientArray = new TreeMap<>();
        
        for (Client client:clients){
            clientArray.put(client.getCpf(), client);
        }
        return clientArray;
    }
    
    public Gym createGym()
    {
        Gym newGym = new Gym();
        
        newGym.setName("Gym UFRN");
        
        return newGym;
    }
}
