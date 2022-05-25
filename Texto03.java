import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;

public class Texto03
{
    public Texto03(){}
    
    public String questao3_1(){
        Date dataAtual = new Date();
        
        return dataAtual + "";
    }
    
    public String questao3_2(String data){
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        
        try {
            Date dia = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            String dataFormatada = formato.format(dia);
            
            return dataFormatada;
            
        } catch(Exception e) {
            return null;
        }
    }
    
    public String[] questao3_3(String caminho){
        File arquivo = new File(caminho);
        String[] listaDeArquivos = arquivo.list();
        
        return listaDeArquivos;
    }

    public String[] questao3_4(String caminho){
        File diretorio = new File(caminho);
        String[] listaDeArquivos = diretorio.list();
        
        if(diretorio.exists()){
            for(int i = 0; i < listaDeArquivos.length; i++){
                
                File arquivo = new File(caminho + "/" + listaDeArquivos[i]);
                if(arquivo.isDirectory())
                    listaDeArquivos[i] = "[D]" + listaDeArquivos[i];
                if(arquivo.isFile())
                    listaDeArquivos[i] = "[A]" + listaDeArquivos[i]; 
            }  
            
            return listaDeArquivos;
        }
        
        return null;
    }
    
    public String questao3_5(String caminho){
        File diretorio = new File(caminho);
        String[] listaDeArquivos = diretorio.list();
        
        if(diretorio.exists()){
            diretorio.delete();
            
            return diretorio + " foi excluído.";
        }
        
        return null;
    }
    
    public void questao3_6(){
        JFrame tela = new JFrame("Janela");
        tela.setSize(400, 400);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar barraDeMenu = new JMenuBar();
        
        tela.setJMenuBar(barraDeMenu);
        JMenu arquivo = new JMenu("Arquivo");
        JMenu editar = new JMenu("Editar");
        
        barraDeMenu.add(arquivo);
        barraDeMenu.add(editar);
        tela.setVisible(true);
    }
    
    public void questao3_7(String caminho){
        String[] comando = {"cmd", "/c", "start", caminho };
        
        try {
            Runtime.getRuntime().exec(comando);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void questao3_8(String caminho){
        String[] comando = {"notepad", "/c", "start", caminho };
        
        try {
            Runtime.getRuntime().exec(comando);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void questao3_9(){

        JFrame tela = new JFrame("Janela");
        tela.setExtendedState(tela.MAXIMIZED_BOTH);
        tela.setVisible(true);
    }
    
    public String questao3_10(String data1, String data2){
        try {
            Date data1Formatada = new SimpleDateFormat("dd/MM/yyyy").parse(data1);
            Date data2Formatada = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
            
            if(data1Formatada.compareTo(data2Formatada) > 0)
                return data1;
            else return data2;
            
        }catch(Exception e){
            return null;
        }
        
    }
    
    public String[] questao3_11(String[] datas){  
        String aux;
        
        return datas;
    }
    
    public String questao3_12(String data){
        SimpleDateFormat formato = new SimpleDateFormat("EEEE");
        
        try {
            Date dia = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            String dataFormatada = formato.format(dia);
            
            return dataFormatada;
            
        } catch(Exception e) {
            return null;
        }
    }
}
