package Procesador;

import EstructurasDeDatos.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;

public class Procesos {
    
    public String leerArchivo(String rutaArchivo) {
        Path path = Paths.get(rutaArchivo);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + rutaArchivo, e);
        }
    }
    
    public String limpiarTexto(String texto) {
        String textoSinTildes = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return textoSinTildes.replaceAll("[^\\p{L}\\p{Zs}]", "").toLowerCase();
    }
    
    public static List<String> convertirStringALista(String texto) {
        String[] palabras = texto.trim().split("\\s+");
        List<String> lista = new List<>(palabras.length); 

        for (int i = 0; i < palabras.length; i++) {
            lista.add(palabras[i], i); 
        }

        return lista;
    }
    
    
    
}
