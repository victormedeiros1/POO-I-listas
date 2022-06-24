public class Metric
{
    private double weight;
    private double height;
    private double waist;
    private double biceps;
    private double triceps;
    private double chest;
    private String date;

    public Metric(){}
    
    public double getWeight(){
        return this.weight;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public double getWaist(){
        return this.waist;
    }
    
    public void setWaist(double waist){
        this.waist = waist;
    }
    
    public double getChest(){
        return this.chest;
    }
    
    public void setChest(double chest){
        this.chest = chest;
    }
    
    public double getBiceps(){
        return this.biceps;
    }
    
    public void setBiceps(double biceps){
        this.biceps = biceps;
    }
    
    public double getTriceps(){
        return this.triceps;
    }
    
    public void setTriceps(double triceps){
        this.triceps = triceps;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public boolean update(double weight, double height, double waist, double biceps, double triceps, double chest){
        this.weight = weight;
        this.height = height;
        this.waist = waist;
        this.biceps = biceps;
        this.triceps = triceps;
        this.chest = chest;
        return true;
    }

    public double imc()
    {
        return (height * height) / weight;
    }
}
