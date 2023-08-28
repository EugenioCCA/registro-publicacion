
public class Usuario {
    
    private String nombre,correo, password ; 
    
    
    public Usuario(String nombre, String correo, String contraseña){
        this.nombre = nombre; 
        this.correo = correo; 
        this.password = contraseña; 
    }
    
    
    public String getNombre(){
        return nombre; 
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    public String getCorreo(){
        return correo; 
    }
    
    public void setCorreo(String correo){
        this.correo = correo; 
    }
    
    public String getPassword(){
        return password; 
    }
    
    public void setPassword(String contraseña){
        this.password = contraseña; 
    }
    
}
