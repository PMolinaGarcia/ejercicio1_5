package dominio;
import java.util.ArrayList;
import java.io.Serializable;
//Creamos la clase tras importar todo lo necesario y decir el paquete de la clase
public class Provincia implements Serializable{
    private String nombre;
    //Creamos un ArrayList con los municipios que se añadan a la provincia
    private ArrayList<Municipio> municipiosProvincia = new ArrayList<Municipio>();

    //Método para añadir municipios a la provincia
    public Provincia add(Municipio municipio){
        municipiosProvincia.add(municipio);
        return this;
    }
    //Creamos un objeto de la clase Provincia con un nombre y un ArrayList de los municipios
    public Provincia (String nombre){
        this.nombre = nombre;
        municipiosProvincia = new ArrayList<Municipio>();
        }
    //Método para contar la población
    public int getPoblacion(){
        int poblacion=0;
        for (Municipio municipio:municipiosProvincia){
            poblacion+=municipio.getPoblacion();
        }
        return poblacion;
    }


    //Añadimos el método toString. Será necesario llamarlo para que se imprima con un System.out.print
    public String toString(){
        return "La provincia es "+nombre+"."+" La provincia tiene "+getPoblacion()+" habitantes"+" y los municipios siguientes: "+"\n"+municipiosProvincia.toString()+"\n";
    }

    public ArrayList<Municipio> getMunicipiosProvincia(){
        return municipiosProvincia;
    }
    public Municipio getMunicipio(int i) {
        return municipiosProvincia.get(i);
    }

    public String getNombre() {
        return nombre;
    }


    public int size() {
        return municipiosProvincia.size();
    }
}