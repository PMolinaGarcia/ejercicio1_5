package dominio;
import java.util.ArrayList;
import java.util.*;
import java.io.Serializable;
//Creamos la clase tras importar todo lo necesario y decir el paquete de la clase
public class Municipio implements Serializable{
    //Creamos un ArrayList con las localidades que se añadan al municipio
    private ArrayList<Localidad> localidadesMunicipio = new ArrayList<>();
    //Método para añadir localidades al municipio
    public void añadir (Localidad localidad){
        localidadesMunicipio.add(localidad);
    }

    public ArrayList getLocalidadesMunicipio() {
        return localidadesMunicipio;
    }
    public int contarHabitantes(){
        int suma = 0;
        for (Localidad localidad : localidadesMunicipio) {
            suma += Integer.parseInt(localidad.getNumeroHabitantes());
        }
    }
}


}
