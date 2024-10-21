package dominio;
import java.util.ArrayList;
public class Pais {
    private String nombre;
    private ArrayList<Provincia> provincias;
    public Pais add(Provincia provincia){
        provincias.add(provincia);
        return this;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPoblacion(){
        int poblacion=0;
        for(Provincia provincia:provincias){
            poblacion+=provincia.getPoblacion();
        }
        return poblacion;
    }
    public ArrayList<Provincia> getProvincias(){
        return provincias;
    }
    public Provincia getProvincia(int i){
        return provincias.get(i);
    }
    public String toString(){
        return "Pais: "+nombre+" Población: "+getPoblacion() +" habitantes\n"+provincias.toString()+"\n";
    }
    public int size(){
        return provincias.size();
    }



}
