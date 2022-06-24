import java.util.ArrayList;
import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class Client
{
    private String name;
    private String cpf;
    private String genre;
    private ArrayList<Metric> metrics;
    private TreeMap<String, Metric> metricsTree = new TreeMap<String, Metric>();
    private String birthDate;
    private Metric goal;

        public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getBirthdate(){
        return this.birthDate;
    }
    
    public void setBirthdate(String birthDate){
        this.birthDate = birthDate;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public ArrayList<Metric> getMetrics(){
        return this.metrics;
    }
    
    public void setMetrics(ArrayList<Metric> metrics){
        this.metrics = metrics;
    }

    public TreeMap<String, Metric> getMetricsTree(){
        return this.metricsTree;
    }
    
    public void setMetricsTree(TreeMap<String, Metric> metricsTree){
        this.metricsTree = metricsTree;
    }
    
    public Metric getGoal(){
        return this.goal;
    }
    
    public void setGoal(Metric goal){
        this.goal = goal;
    }
    
    public Client(){
        metrics = new ArrayList<>();
    }
    
    public boolean update(String name, String genre, String birthDate){
        this.name = name;
        this.genre = genre;
        this.birthDate = birthDate;
        
        return true;
    }
    
    public Metric searchMetric(String date){        
        return metrics
        .stream()
        .filter(metric -> metric.getDate().equals(date))
        .findFirst()
        .orElse(null);
    }
    
    public boolean addMetric(double weight, double height, double waist, double biceps, double triceps, double chest, String date){
        if(searchMetric(date) == null){
            Metric newMetric = new Metric();
            newMetric.setWeight(weight); 
            newMetric.setHeight(height); 
            newMetric.setWaist(waist); 
            newMetric.setBiceps(biceps); 
            newMetric.setTriceps(triceps); 
            newMetric.setChest(chest); 
            newMetric.setDate(date); 
            metrics.add(newMetric);
            
            return true;
        }
        
        return false;
    }   
    
    public boolean updateMetric(String date, double weight, double height, double waist, double biceps, double triceps, double chest){
        Metric metricFound = searchMetric(date);
        
        if(metricFound != null){
            metricFound.update(weight, height, waist, biceps, triceps, chest);
            return true;
        }
        
        return false;
    }    
    
    public boolean deleteMetric(String date){
        Metric metricFound = searchMetric(date);
        
        if(metricFound != null){
            metrics.remove(metricFound);
            return true;    
        }
        
        return false;
    }
    
    public List<Metric> orderMetrics(){
        this.metrics = new ArrayList<Metric>(metrics
        .stream()
        .sorted((d1, d2) -> d1
        .getDate()
        .compareTo(d2.getDate()))
        .collect(Collectors.toList()));
        
        return metrics
        .stream()
        .sorted((d1, d2) -> d1.getDate().compareTo(d2.getDate()))
        .collect(Collectors.toList());
    }
    
    public double imcCurrent(){
        return currentMetric().imc();
    }
    
    public double currentWeight(){
        return currentMetric().getWeight();
    }
    
    public double currentHeight(){
        return currentMetric().getHeight();
    }
    
    public double currentBiceps(){
        return currentMetric().getBiceps();
    }
    
    public double currentChest(){
        return currentMetric().getChest();
    }
    
    public double initialWeight(){
        return initialMetric().getWeight();
    }

    public double initialHeight(){
        return initialMetric().getHeight();
    
    }
    
    public double initialBiceps(){
        return initialMetric().getBiceps();
    }
    
    public double initialChest(){
        return initialMetric().getChest();
    }
    
    public double variationWeight(){
        return currentWeight() - initialWeight();
    }
    
    public double variationHeight(){
        return currentHeight() - initialHeight();
    }
    
    public double variationBiceps(){
        return currentBiceps() - initialBiceps();
    }
    
    public double variationChest(){
        return currentChest() - initialChest();
    }
    
    public Metric currentMetric(){
        orderMetrics();
        return metrics.get(metrics.size()-1);
    }
    
    public Metric initialMetric(){
        orderMetrics();
        return metrics.get(0);
    }
    
    public String status(){
        if(imcCurrent() < 18.5) return "Abaixo do peso";
        if(imcCurrent() >= 18.5 && imcCurrent() <= 24.9) return "Peso adequado";
        if(imcCurrent() >= 24.9 && imcCurrent() <= 29.9) return "Excesso de peso";
        if(imcCurrent() >= 18.5 && imcCurrent() <= 24.9) return "Obeso ";
        
        else return "Obesidade mórbida";
    } 
    
    public double weightStandardDeviation(){
        int count = 0;
        double standardDeviation = 0;
        
        for(Metric newMetric:metrics){
            standardDeviation += Math.pow(newMetric.getWeight() - averageWeight(), 2);
            count++;
        }
        return Math.sqrt(standardDeviation / (count - 1));
    }
    
    public double averageWeight(){
        return metrics
        .stream()
        .mapToDouble(metric -> metric.getWeight())
        .average()
        .orElse(Double.NaN);
    }
}

