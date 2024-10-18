package dominio;
import java.util.ArrayList;
import java.util.*;
import java.io.Serializable;
//Creamos la clase tras importar todo lo necesario y decir el paquete de la clase
public class Provincia implements Serializable{
    //Creamos un ArrayList con los municipios que se añadan a la provincia
    private ArrayList<Municipio> municipiosProvincia = new ArrayList<>();
    //Método para añadir municipios a la provincia
    public void añadir (Municipio municipio){
        municipiosProvincia.add(municipio);
    }

    public ArrayList getMunicipiosProvincia() {
        return municipiosProvincia;
    }
    public int contarHabitantes(){
        int suma = 0;
        for (Municipio municipio : municipiosProvincia) {
            suma += Integer.parseInt(municipio.contarHabitantes());
        }
    }
    //Añadimos el método toString. Será necesario llamarlo para que se imprima con un System.out.print
    public String toString(){
        return "La provincia tiene "+suma+" habitantes";
    }
}