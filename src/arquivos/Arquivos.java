package arquivos;

import java.io.File;
import java.io.IOException;

public class Arquivos {

    public static void main(String[] args) {
        
        // 1 - Creo el directorio 'arquivosdir' na ruta '/home/oracle/NetBeansProjects/arquivos/'
        
        File arquivosdir = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/");
        arquivosdir.mkdir();
        
        // 2 - Creo el archivo Products1.txt

        File productos = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        try {
            productos.createNewFile();
        } catch (IOException ex) {}
        
        // 3 - Compruebo que existe el archivo creado
        
        System.out.println(productos.exists() + " / " + productos.getAbsoluteFile());

        // 4 - Creo el directorio 'subdir' si no existe anteriormente
        
        File subdir = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/subdir");
        
        if (!subdir.exists()){
            
            subdir.mkdir();
        }
        
        // 5 - Muestro los archivos y subdirectorios

        String[] ficheros = arquivosdir.list();
        
        for (String fichero: ficheros) {
            
            System.out.println(fichero);
        }
        
        // 6 - muestra la ruta
        
        System.out.println(arquivosdir.getAbsolutePath());
        
        // 7 - Muestra la información
        
        System.out.println("Nome: " + productos.getName());
        System.out.println("Ruta:" + productos.getAbsolutePath());
        System.out.println("Exists :" + productos.exists());
        
        if (arquivosdir.exists()) {
            System.out.println("Si e posible ou non escribir nel" + productos.canWrite());
            System.out.println("Si e posible ou non ler del" + productos.canRead());
            System.out.println("A sua lonxitude en bytes:" + productos.length());
        }

        // 8 - Edito permisos del directorio para solo lectura
        
        productos.setWritable(false);

        // 9 - Edito permisos del directorio para tener escritura

        productos.setWritable(true);
        
        // 10 - Borro el archivo
        
        productos.delete();
        
        // 11 Borro archivos y directorios creados anteriormente

        borrar(arquivosdir); 
    }
    
    public static void borrar(File fich){
        
        File[] ficherosBorrar = fich.listFiles();
 
        for (File fichero: ficherosBorrar){
            
            if (fichero.isDirectory()) {
                borrar(fichero);
            }
            
            fichero.delete();
        }  
    }
}
