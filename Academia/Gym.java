import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gym extends Client
{
    private String name;
    private ArrayList<Client> clients;
    
    private TreeMap<String, Client> clientsTree = new TreeMap<String, Client>();
    
    public Gym(){
        clients = new ArrayList<>();
    }
    
        public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public ArrayList<Client> getClients(){
        return this.clients;
    }
    
    public void setClients(ArrayList<Client> clients){
        this.clients = clients;
    }
    
    public HashMap<String, List<Client>> mapClients(){
        HashMap<String, List<Client>> statusClients = new HashMap<String, List<Client>>();  
        
        //Definir status de peso do Client
        statusClients.put("Abaixo do peso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Abaixo do peso"))
        .collect(Collectors
        .toList()));
        
        statusClients.put("Peso adequado", clients
        .stream()
        .filter(c -> c.status()
        .equals("Peso adequado"))
        .collect(Collectors
        .toList()));
        
        statusClients.put("Excesso de peso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Excesso de peso"))
        .collect(Collectors
        .toList()));
        
        statusClients.put("Obeso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Obeso"))
        .collect(Collectors
        .toList()));
        
        statusClients.put("Obesidade mórbida", clients.
        stream()
        .filter(c -> c.status()
        .equals("Obesidade mórbida"))
        .collect(Collectors
        .toList()));
        
        return statusClients;
    }
    
    public Client findClient(String cpf){        
        return clients
        .stream()
        .filter(c -> c.getCpf()
        .equals(cpf))
        .findFirst()
        .get();
    }
    
    public List<Client> birthdays(){
        return clients
        .stream()
        .filter(c -> c.getBirthdate()
        .endsWith("/" + DateTimeFormatter
        .ofPattern("MM/dd")
        .format(LocalDateTime.now())))
        .collect(Collectors.toList());
    }
    
    public List<Client> birthdaysOfTheMonth(String month){
        return clients
        .stream()
        .filter(c -> c.getBirthdate()
        .endsWith("/" + month + "/" + DateTimeFormatter
        .ofPattern("dd")
        .format(LocalDateTime.now())))
        .collect(Collectors.toList());
    }
    
    public List<Client> clientsAdequateWeight(){
        return clients
        .stream()
        .filter(c -> c.status()
        .equals("Peso adequado"))
        .collect(Collectors.toList());
    }
    
    public List<Client> biggestBoobs(){
        double biggerChest = clients
        .stream()
        .max(Comparator
        .comparing(Client::currentChest))
        .get()
        .currentChest();
        
        return clients
        .stream()
        .filter(c -> c.currentChest() == biggerChest)
        .collect(Collectors
        .toList());
    }
    
    public List<Client> bestsBicepsVariation(){
        double bestBicepsVariation = clients
        .stream()
        .max(Comparator.comparing(Client::variationBiceps))
        .get()
        .variationBiceps();
        
        return clients
        .stream()
        .filter(c -> c.variationBiceps() == bestBicepsVariation)
        .collect(Collectors.toList());
    }
    
    public boolean addClient(String name, String cpf, String genre, String birthDate){
        Client c = new Client();
        
        c.setName(name);
        c.setGenre(genre);
        c.setCpf(cpf);
        c.setBirthdate(birthDate);
        clients.add(c);
        
        return true;
    }
    
    public boolean updateClient(String cpf, String name, String genre, String birthDate){
        Client c = findClient(cpf);
        
        if(c != null){
            
            c.update(name, genre, birthDate);
            return true;
        }
        
        return false;
    }
    
    public boolean deleteClient(String cpf){
        Client c = findClient(cpf);
        
        if(c != null){
            clients.remove(c);
            
            return true;
        }
        
        return false;
    }
    
    public void orderMetricsClients(){
        clients
        .stream()
        .forEach(c -> c.orderMetrics());
    }
    
    public TreeMap<String, Client> getClientsTree(){
        return this.clientsTree;
    }
    
    public void setClientsTree(TreeMap<String, Client> clientsTree){
        this.clientsTree = clientsTree;
    }

    public double imcGym()
    {
        double average = 0;
        int parcels = 0, i = 0;
        
        while(i < clients.size()){
            if(clients.get(i).imcCurrent() != -1){
                average += clients.get(i).imcCurrent();
                
                parcels++;
            }
            
            i++;
        }
        return parcels == 0 ? 0 : average/parcels;
    }
    
    public HashMap classificaPesoClients(){
        HashMap<String, List<Client>> pesoClients = new HashMap<String, List<Client>>();
        
        pesoClients.put("Abaixo do peso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Abaixo do peso"))
        .collect(Collectors.toList()));
        
        pesoClients.put("Peso adequado", clients
        .stream()
        .filter(c -> c.status()
        .equals("Peso adequado"))
        .collect(Collectors.toList()));
        
        pesoClients.put("Excesso de peso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Excesso de peso"))
        .collect(Collectors.toList()));
        
        pesoClients.put("Obeso", clients
        .stream()
        .filter(c -> c.status()
        .equals("Obeso"))
        .collect(Collectors.toList()));
        
        pesoClients.put("Obesidade mórbida", clients
        .stream()
        .filter(c -> c.status()
        .equals("Obesidade mórbida"))
        .collect(Collectors.toList()));
        
        return pesoClients;
    }
    
    public HashMap averageCustomerWeightDeviation(){
        HashMap<String, ArrayList<Double>> metricsClients = new HashMap<String, ArrayList<Double>>();
        
        for(Client cli:clients){
            metricsClients.put(cli.getName(), new ArrayList<>());
            
            metricsClients.get(cli
            .getName())
            .add(cli.weightStandardDeviation()); 
            
            metricsClients.get(cli
            .getName())
            .add(cli.averageWeight()); 

        }

        return metricsClients;
    }
    
    public HashMap greaterHeightsPerGenre(){
        HashMap<String, ArrayList<Client>> genreHeights = new HashMap<String, ArrayList<Client>>();
        
        double greaterHeight = 0;
        
        for(Client cli:clients){
            if(cli.currentMetric().getHeight() >= greaterHeight){
                if(genreHeights.get(cli.getGenre()) != null){
                    genreHeights
                    .get(cli.getGenre())
                    .add(cli); 
                    
                }else{
                    genreHeights
                    .put(cli.getGenre(), new ArrayList<>()); 
                    
                    genreHeights
                    .get(cli.getGenre())
                    .add(cli);    
                }
            }
        }

        return genreHeights;
    }
    
    public HashMap clientsPerGenre(){
        HashMap<String, Integer> clientsGenre = new HashMap<String, Integer>();
        
        for(Client cli:clients){
            if(clientsGenre.get(cli.getGenre()) != null){
                clientsGenre
                .put(cli.getGenre(), 
                
                clientsGenre
                .get(cli.getGenre()) + 1); 
                
            }else
                clientsGenre.put(cli.getGenre(), 1); 

        }

        return clientsGenre;
    }
    
}
