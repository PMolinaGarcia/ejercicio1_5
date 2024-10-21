
//Definimos el paquete en el que está creada la clase
package aplicacion;
import dominio.*;

//Definimos la clase
public class Principal{
    //Creamos el método main de ejecución
    public static void main(String[] args) {
        //Instanciamos un objeto de la clase localidad al que llamamos lc y le damos los parámetros deseados
        Localidad lc=new Localidad("Albacete", 200000);
        //Es necesario llamar al toString para que se escriba, ya que este método solo serializa. Se imprimen unos caracteres serializados
        System.out.println(lc.toString());
    }

}
