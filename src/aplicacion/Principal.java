
//Definimos el paquete en el que está creada la clase
package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.io.Serializable;


//Definimos la clase
public class Principal{
    //Creamos el método main de ejecución
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String [] peticion;
        //LLamamos a la función ayuda para que aparezca al principio
        interfaz.ayuda();
        //Comenzamos un bucle do while para que se ejecute la primera petición y luego se inicie el bucle
        do{
            peticion = interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));

    }

}
