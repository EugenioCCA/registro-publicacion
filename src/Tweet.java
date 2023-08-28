
public class Tweet {
    private String contenido, usuario; 
    
    public Tweet(String contenido, String usuario){
        this.contenido = contenido; 
        this.usuario = usuario; 
    }
    
    public String getContenido(){
        return contenido; 
    }
    
    public void setContenido(String contenido){
        this.contenido = contenido; 
    }
    public String getUsuario(){
        return usuario; 
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario; 
    }
    
    
    
    
    public String toString(){
        return "Tweet: "+contenido; 
    }
    
}
