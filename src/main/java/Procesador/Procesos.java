package Procesador;

import EstructurasDeDatos.TablaDeSimbolos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;

public class Procesos {
    TablaDeSimbolos tablaLimpia = null;
    public void crearTablaDeSimbolos(String filePath) throws IOException {
        TablaDeSimbolos<String, Integer> tabla = new TablaDeSimbolos<>();

        Files.readAllLines(Path.of(filePath)).forEach(linea -> {
            String lineaLimpia = limpiarTexto(linea);
            String[] palabras = lineaLimpia.split("\\s+");

            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    Integer actual = tabla.get(palabra);
                    if (actual == null) {
                        tabla.put(palabra, 1);
                    } else {
                        tabla.put(palabra, actual + 1);
                    }
                }
            }
        });

        tablaLimpia = tabla;
    }

    private String limpiarTexto(String texto) {
        String textoSinTildes = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return textoSinTildes.replaceAll("[^\\p{L}\\p{Zs}]", "").toLowerCase();
    }
    
    public TablaDeSimbolos mostrarTabla() {
        return tablaLimpia;
    }
    
    public int contarTotalPalabras() {
        int total = 0;
        for (Object palabra : tablaLimpia.getKeys()) {
            Integer count = (Integer) tablaLimpia.get(palabra);
            if (count != null) {
                total += count;
            }
        }
        return total;
    }

    public int contarOcurrencias(String palabra) {
        palabra = limpiarTexto(palabra);
        Integer count = (Integer) tablaLimpia.get(palabra);
        return count != null ? count : 0;
    }

    

}
