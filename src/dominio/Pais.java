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
    public void grabar(){
        try {
            ObjectOuputStream fo = new OutputObjectStream (FileOutputStream ("pais.dat"));
            //No se escribe solo el país. Se escribe todo el ArrayList dentro del archivo. Con una sola orden, se escribe todo el sistema. Estamos guardando todo en el disco
            //Le ponemos .dat porque es un fichero de datos, no tiene por qué ser una extensión en particular, aunque es mejor.
            fo.writeObject(this);
            fo.close();
            }
        catch(IOException e){
            System.out.println("Error: grabar no ha salido bien. Corrija y vuelva a intentarlo.")
            }
    }
    //Abrimos un fichero ya existente. Es estático porque no se lo voy a pedir a ningún objeto. Crea el objeto, me lo devuelve y lo asigna al país. Un servicio de la clase, no del objeto.
    public static Pais leer(){
        try{
            //Lo que hay en el fichero, se abre como fichero para leerlo. El new ObjectInput stream crea un objeto que es un string de objetos.
            ObjectInputStream fi = new ObjectInputStream (FileInputStream ("pais.dat"));
            //Declaro una referencia país (p) y me devuelve un objeto
            Pais p= (Pais) fi.readObject();
            return p;
            }
        catch(IOException e) {
            return new Pais();
            }
        }
    }


}
