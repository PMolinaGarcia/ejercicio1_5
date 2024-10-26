package dominio;
import java.util.ArrayList;
import java.io.Serializable;
//Creamos la clase tras importar todo lo necesario e indicar el paquete de la clase
public class Municipio implements Serializable{
    private String nombre;
    //Creamos un ArrayList con las localidades que se añadan al municipio
    private ArrayList<Localidad> localidadesMunicipio;

    //Creamos un objeto de la clase Municipio con un nombre y un ArrayList de las localidades
    public Municipio(String nombre) {
    this.nombre = nombre;
    localidadesMunicipio = new ArrayList <Localidad>();
    }

    //Método para añadir localidades al municipio
    public Municipio add(Localidad localidad){
        //Aquí se añaden objetos localidad al municipio y lo retornan
        localidadesMunicipio.add(localidad);
        return this;
    }
    //Para contar la población. Se establece un valor inicial de 0 al que se le irán sumando los habitantes de cada localidad
    public int getPoblacion(){
        int poblacion = 0;
        for (Localidad localidad : localidadesMunicipio){
            poblacion+=localidad.getPoblacion();
        }
        return poblacion;
    }
    //Para que me diga el tamaño (cantidad de cosas que hay) en el ArrayList de localidades
    public int getLocalidadesMunicipio(){
        return localidadesMunicipio.size();
    }
    //Para que me diga la localidad que ocupa la posición i del ArrayList
    public Localidad getLocalidadMunicipio(int i){
        return localidadesMunicipio.get(i);
    }

    public String getNombre(){
        return nombre;
    }
    //Añadimos el método toString. Será necesario llamarlo para que se imprima con un System.out.print
    public String toString(){
        return getNombre()+" ("+getPoblacion() +" habitantes)]\n"+localidadesMunicipio.toString()+"\n";
    }


}