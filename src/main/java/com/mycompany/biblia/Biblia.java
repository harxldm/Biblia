package com.mycompany.biblia;
import java.util.Scanner;
import Procesador.Procesos;
import java.io.IOException;

public class Biblia {

    Scanner scanner = new Scanner(System.in);
    Procesos procesos;

    public Biblia(Procesos procesos) {
        this.procesos = procesos;
    }

    private void menu() {
        System.out.println("Bienvenido al menu");
        System.out.println("Elija una opcion");
        System.out.println("1. ¿Cuantas palabras tiene la biblia?");
        System.out.println("2. Encontrar # de coincidencias para una palabra");
        System.out.println("3. Encontrar # de coincidencias para palabras que empiecen con x letra");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        switch (opcion) {
            case 1:
                System.out.println("Palabras en la biblia: " + procesos.contarTotalPalabras());
                break;
            case 2:
                System.out.print("Ingrese palabra: ");
                String palabra = scanner.nextLine();
                System.out.println("Ocurre: " + procesos.contarOcurrencias(palabra));
                break;
            case 3:
                
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void main(String[] args) throws IOException {
        try {
        Procesos procesos = new Procesos();
        procesos.crearTablaDeSimbolos("C:/Users/harxl/Documents/NetBeansProjects/Biblia/src/main/java/Archivos/biblia.txt");
        Biblia interfaz = new Biblia(procesos);
        interfaz.menu();
    } catch (Exception e) {
        System.err.println("🔥 Error en tiempo de ejecución:");
        e.printStackTrace();
    }
    }
}
