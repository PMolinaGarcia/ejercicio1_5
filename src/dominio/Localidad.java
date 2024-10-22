package dominio;
import java.io.Serializable;

//Definimos la clase Localidad y le añadimos sus atributos. Además, queremos que implemente Serializable para poder serializar todo a un String
public class Localidad implements Serializable {
    //Definimos los tipos de atributos y los mismos
    private String nombre;
    private int numeroDeHabitantes;

    //Constructor
    public Localidad(String nombre, int numeroDeHabitantes) {
        this.nombre = nombre;
        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    //Creamos sus getters y setters
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    //Si hiciéramos public Localidad setNombre (String nombre){this.nombre = nombre; return this;}, podríamos hacer operaciones con el objeto

    public void setNumeroDeHabitantes(int numeroDeHabitantes){

        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroDeHabitantes() {
        return numeroDeHabitantes;
    }

    //Añadimos el método toString. Será necesario llamarlo para que se imprima con un System.out.print
    //public String toString()//return "La localidad se llama "+nombre+" y tiene "+numeroDeHabitantes+" habitantes";

    //Ahora hemos quitado el toString para cambiarlo a un StringBuilder
        public String toString() {
            StringBuilder datos = new StringBuilder();

            datos.append("El nombre de la localidad es: ")
                    .append(nombre)
                    .append("; y su número de habitantes es: ")
                    .append(numeroDeHabitantes);
            return datos.toString();
        }
}