package dominio;
import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;
public class Pais implements Serializable {
    private String nombre;
    //Creamos el ArrayList de provincias, al que luego llamaremos
    private ArrayList<Provincia> provincias = new ArrayList<Provincia>();
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

    public Pais setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    //Llamamos al ArrayList para que me devuelva lo que tiene dentro
    public ArrayList<Provincia> getProvincias(){
        return provincias;
    }
    public Provincia getProvincia(int i){
        return provincias.get(i);
    }

    public String toString(){
        return "Pais: "+getNombre()+" Población: "+getPoblacion() +" habitantes\n"+provincias.toString()+"\n";
    }

    public int size(){
        return provincias.size();
    }
    //La función de grabar para crear un archivo en el que se guarde todo el ArrayList en el que hemos añadido todos los datos
    public void grabar(){
        //Utilizamos un try and catch porque esperamos posibles errores, y antes de que dé un fallo el programa, preferimos reconducir la excepción a un mensaje escrito por nosotros.
        try {
            ObjectOutputStream fo = new ObjectOutputStream (new FileOutputStream("pais.ser"));
            //No se escribe solo el país. Se escribe todo el ArrayList dentro del archivo. Con una sola orden, se escribe todo el sistema. Estamos guardando todo en el disco
            //Le ponemos .dat porque es un fichero de datos, no tiene por qué ser una extensión en particular, aunque es mejor.
            fo.writeObject(this);
            fo.close();
            } catch(Exception e){
                e.printStackTrace(); // Esto imprimirá los detalles de la excepción
                System.out.println("Error: grabar no ha salido bien. Corrija y vuelva a intentarlo.");
            }
    }

    //Abrimos un fichero ya existente. Es estático porque no se lo voy a pedir a ningún objeto. Crea el objeto, me lo devuelve y lo asigna al país. Un servicio de la clase, no del objeto.
    public static Pais leer(){
        try{
            //Lo que hay en el fichero se abre como fichero para leerlo. El new ObjectInput stream crea un objeto que es un string de objetos.
            ObjectInputStream fi = new ObjectInputStream (new FileInputStream("pais.dat"));
            //Declaro una referencia país (p) y me devuelve un objeto
            Pais p= (Pais) fi.readObject();
            fi.close();
            return p;
            }
        catch(IOException | ClassNotFoundException e) {
            return new Pais();
            }
        }

}

