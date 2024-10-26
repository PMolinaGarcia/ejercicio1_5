package dominio;
import java.io.Serializable;


//Definimos la clase Localidad y le añadimos sus atributos. Además, queremos que implemente Serializable para poder serializar todo a un String
public class Localidad implements Serializable {
    //Definimos los tipos de atributos y los mismos. Un nombre debe ser texto, por lo que utilizamos String; la población es un número entero, así que escogemos int
    private String nombre;
    private int poblacion;

    //Constructor para dar un valor inicial y que luego los demás métodos añadan otro
    public Localidad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    //Creamos sus getters y setters
    public Localidad setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    //Si hiciéramos public Localidad setNombre (String nombre){this.nombre = nombre; return this;}, podríamos hacer operaciones con el objeto

    public Localidad setPoblacion(int poblacion){
        this.poblacion = poblacion;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    //Añadimos el método toString. Será necesario llamarlo para que se imprima con un System.out.print
    //public String toString() return "La localidad se llama "+nombre+" y tiene "+numeroDeHabitantes+" habitantes";

    //Ahora hemos quitado el toString para cambiarlo a un StringBuilder, de tal forma que se vayan añadiendo "palabras" al String
        public String toString() {
            StringBuilder datos = new StringBuilder();

            datos.append("El nombre de la localidad es: ")
                    .append(nombre)
                    .append("; y su número de habitantes es: ")
                    .append(poblacion)
                    .append("\n");
            return datos.toString();
        }
}