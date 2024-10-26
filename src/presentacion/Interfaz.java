package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class Interfaz {
    private Pais p=new Pais();
    //Creamos un acortamiento para el método Scanner que escanee lo que le digamos
    private  Scanner sc = new Scanner(System.in);

    public Interfaz(){
        //Le pido a la clase Pais que me lea y se lo asigne al objeto p de Pais
        p=Pais.leer();
    }
    //Invocamos a la función grabar de Pais
    public void grabar(){
       p.grabar();
    }
    //Escribimos un mensaje de ayuda con las instrucciones que acepta el programa
    public static void ayuda(){
        System.out.println("introduzca una de las siguientes peticiones: \n addProvindia: añadir provincia\n addMunicipio: añadir Municipio\n addLocalidad: añadir Localidad\n list: listar el contenido\n read: lectura inicial\n exit: salir\n");

    }
    //Creamos un boolean para que se ejecute mientras todo sea verdadero. En el momento en el que se ejecuta "exit", tras llamar al método grabar, se retorna un valor falso, de forma que finaliza el programa
    public  boolean procesarPeticion (String [] p){
        if (p.length==1)
            if 	(p[0].equals("addProvincia")) aniadirProvincia();
            else if (p[0].equals("addMunicipio"))
                aniadirMunicipio();
            else if (p[0].equals("addLocalidad"))
                aniadirLocalidad();
            else if (p[0].equals("read"))
                leer();
            else if (p[0].equals("list"))
                System.out.println (this.p);
            else if (p[0].equals("help"))
                ayuda();
            else if (p[0].equals("exit")){
                grabar();
                return false;//no se procesarán más peticiónes
            }
            //Cuando se escribe algo que no "cabe" en la estructura determinada, se muestra un mensaje de error y se ejecuta la función de ayuda
            else {
                System.out.println("Petición erronea");
                ayuda();
            }
        else {
            System.out.println("Petición erronea");
            ayuda();
        }
        return true;//En todos los casos debe seguir pidiendo y procesando peticiones salvo en exit, que retorna false y finaliza el programa
    }
    public  void aniadirProvincia(){
        System.out.print ("Nombre de la provincia: ");
        //nextLine me devuelve hasta un salto de línea. next sería hasta el separador
        String nombre = sc.nextLine();
        System.out.print("La provincia es " +nombre);
        p.add(new Provincia(nombre));
    }

    public  void aniadirMunicipio(){
        //Queremos que se escriban los nombres con un numerito
        System.out.println("El listado de provincias contiene: ");
        for (int i=0;i<p.size();i++)
            System.out.println(i+".- "+p.getProvincia(i).getNombre());
        System.out.print("Número de provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre del municipio: ");
        String nombre = sc.nextLine();
        p.getProvincia(i).add(new Municipio (nombre));
    }

    public  void aniadirLocalidad(){
        System.out.println("El listado de provincias contiene: ");
        for (int i=0;i<p.size();i++){
            System.out.println(i+".- "+p.getProvincia(i).getNombre());
        }
        int i=sc.nextInt();
        Provincia pr=p.getProvincia(i);
        sc.nextLine();
        System.out.print("Listado de municipios de la provincia de "+ pr.getNombre()+": "+"\n");
        for (i=0;i<pr.size();i++)
            System.out.println(i+".- "+pr.getMunicipio(i));
        System.out.print("Número de municipio: ");
        i=sc.nextInt();
        sc.nextLine();
        Municipio mn = pr.getMunicipio(i);
        System.out.print("Nombre de la localidad : ");
        String nombre = sc.nextLine();
        System.out.print("Número de la habitantes: ");
        int poblacion = sc.nextInt();
        sc.nextLine();
        mn.add(new Localidad(nombre,poblacion));
    }
    public String [] leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena.split(" ");
    }

    public void leer(){
        String nombreP, nombreM, nombreL;
        p.setNombre("España");
        do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar): ");
            nombreP=sc.nextLine();
            if(!nombreP.equals("")){
                Provincia provincia=new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar): ");
                    nombreM=sc.nextLine();
                    if(!nombreM.equals("")){
                        Municipio municipio=new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar): ");
                            nombreL=sc.nextLine();
                            if(!nombreL.equals("")){
                                System.out.print("Introduce la población de la localidad (<enter> para finalizar): ");
                                int poblacion=sc.nextInt();
                                sc.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                p.add(provincia);
            }
        }
        while (!nombreP.equals(""));

    }

}