import java.lang.Math;
import java.util.ArrayList;

public class Texto02{
    public Texto02(){
    
    }
    
    public int[] questao2_2(int a, int b){
        if(a < b)
            return new int[] {a,b};
        else
            return new int[]{b,a};
    }
    
     public double[] questao2_3(double a, double b, double c){
        if(a > b & a > c){
            if(b > c) return new double[]{a,b,c};
            return new double[]{a,c,b};
            
        }else if(c > a & c > b){
            if(a > b) return new double[]{c,a,b};
            return new double[]{c,b,a};
            
        }else if(b > a & b > c){
            if(a > c) return new double[]{b,a,c};
            return new double[]{b,c,a};
            
        }
        
        return new double[]{a,b,c};
    }
    
    public double questao2_4(double a){
        return Math.sqrt(a);
    }
    
    public boolean questao2_5(String a, String b){
        boolean resultado = b.indexOf(a) == -1 ? false : true;
        return resultado;
    }
    
    public String questao2_6(String a, String b){
        String resultado = a.compareTo(b) < 0 ? a + " " + b : b + " " + a; 
        return resultado;
    }
    public String[] questao2_7(String a, String b, String c){
        if(a.compareTo(b) < 0 & a.compareTo(c) < 0){
            if(b.compareTo(c) < 0) return new String[]{a,b,c};
            else return new String[]{a,c,b};
        }
        
        if(b.compareTo(a) < 0 & b.compareTo(c) < 0){
            if(a.compareTo(c) < 0) return new String[]{b,a,c};
            else return new String[]{b,c,a};
        }
            
        if(c.compareTo(a) < 0 & b.compareTo(b) < 0){
            if(a.compareTo(b) < 0) return new String[]{c,a,b};
            else return new String[]{c,b,a};
        }
        
        return new String[]{a,b,c};
    }
    
    public String[] questao2_8(String[] sobrenomeNome)
    {   
        String[] nomeSobrenome = new String[sobrenomeNome.length];
        
        for(int i = 0; i < sobrenomeNome.length; i++){
              nomeSobrenome[i] = sobrenomeNome[i].substring(sobrenomeNome[i].indexOf(' ') + 1, 
                                 sobrenomeNome[i].length()) + ", " + 
                                 sobrenomeNome[i].substring(0, 
                                 sobrenomeNome[i].indexOf(' '));
        }
        
        return nomeSobrenome;
    }
    
    public String[] questao2_9(String[] elementos){        
        for(int i = 0; i < elementos.length; i++)
            elementos[i] = elementos[i].toUpperCase();
        
        return elementos;
    }
    
    public String[] questao2_10(String[] elementos){
        String[] elementosMaiusculos = new String[elementos.length];
        
        for(int i = 0; i < elementos.length; i++)
            elementosMaiusculos[i] = elementos[i].toUpperCase();
        
        return elementosMaiusculos;
    }
    
    public int[] questao2_11(int[] elementos){    
        int aux;
        
        for(int i = 0; i < elementos.length - 1; i++){ 
            if(elementos[i] > elementos[i + 1]){
                aux = elementos[i];
                elementos[i] = elementos[i + 1];
                elementos[i + 1] = aux;
            }
        }
        return elementos;
    }
    
    public int questao2_12(int[] elementos){    
        int aux;
        int trocou = 0;
        
        for(int i = 0; i < elementos.length - 1; i++){ 
            if(elementos[i] > elementos[i + 1]){
                trocou++;
                aux = elementos[i];
                elementos[i] = elementos[i + 1];
                elementos[i + 1] = aux;
            }
        }
        return trocou;
    }
    
    public int questao2_13(String[] elementos){    
        int count = 0;
        String aux;
        
        for(int i = 0; i < elementos.length - 1; i++){ 
            if(elementos[i].length() > elementos[i + 1].length()){
                count++;
                aux = elementos[i];
                elementos[i] = elementos[i + 1];
                elementos[i + 1] = aux;
            }
        }
        return count;
    }
    
    public int[] questao2_14(int[] elementos){
        while(questao2_12(elementos) > 0){
            elementos = questao2_11(elementos);
        }
        
        return elementos;
    }
    
    public String[] questao2_15(String[] elementos){
        String aux;
        
        while(questao2_13(elementos) > 0){
            for(int i = 0; i < elementos.length - 1; i++){
                if(elementos[i].compareTo(elementos[i+1]) > 0){
                    aux = elementos[i+1];
                    elementos[i+1] = elementos[i];
                    elementos[i] = aux;
                }
            }
        }
        
        return elementos;
    }
    
    public String[] inverterSobrenomeNome(String[] sobrenomeNome){
        int ind;
        for(int i = 0; i < sobrenomeNome.length; i++){
            ind = sobrenomeNome[i].indexOf(" ");
            sobrenomeNome[i] = sobrenomeNome[i].substring(ind+1,
                               sobrenomeNome[i].length()) + " " + 
                               sobrenomeNome[i].substring(0, ind);
        }
        return sobrenomeNome;
    }
    
    public String[] questao2_16(String[] sobrenomeNome)
    {   
        sobrenomeNome = inverterSobrenomeNome(sobrenomeNome);
        
        sobrenomeNome = questao2_15(sobrenomeNome);
        
        sobrenomeNome = inverterSobrenomeNome(sobrenomeNome);
        
        return sobrenomeNome;
    }
    
    public String[] questao2_17(String[] sobrenomeNome){
        int ind;
        sobrenomeNome = questao2_16(sobrenomeNome);
        
        for(int i = 0; i < sobrenomeNome.length; i++){
            ind = sobrenomeNome[i].indexOf(" ");
            sobrenomeNome[i] = sobrenomeNome[i].substring(ind,
                               sobrenomeNome[i].length()) + ", " + 
                               sobrenomeNome[i].substring(0,ind);
        }
        
        return sobrenomeNome;
    }
}
