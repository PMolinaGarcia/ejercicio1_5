package dominio;
import java.io.Serializable;

//Definimos la clase Localidad y le añadimos sus atributos. Además, queremos que implemente Serializable para poder serializar todo a un String
public class Localidad implements Serializable {
    //Definimos los tipos de atributos y los mismos
    private String nombre;
    private String numeroDeHabitantes;

    //Constructor
    public Localidad(String nombre, String numeroDeHabitantes) {
        this.nombre = nombre;
        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    //Creamos sus getters y setters
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
    public void setNumeroDeHabitantes(String numeroDeHabitantes){

        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeHabitantes() {
        return numeroDeHabitantes;
    }

    //Añadimos el método toString
    public String toString(){
        return "La localidad se llama"+nombre+" "+" y tiene "+numeroDeHabitantes+" habitantes";
    }
}