package Models;

public class Estudiante {

    private String nombre;
    private long telefono;
    private Boolean estado;

    public Estudiante(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = false;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getSestado() {
        String respuesta = "";
        if(estado == false){
            respuesta = "Libre";
        }else{
            respuesta = "Bloqueado";
        }
        return respuesta;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }
    
    
    


    
}
