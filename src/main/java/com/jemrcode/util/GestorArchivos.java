package com.jemrcode.util;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public class GestorArchivos {
    private static final String DIRECTORIO_DATA = "data";

    public <T> void guardar(String nombreArchivo, List<T> lista, Function<T, String> serializer) {
        try {
            new File(DIRECTORIO_DATA).mkdirs();
            String rutaCompleta = DIRECTORIO_DATA + File.separator + nombreArchivo;
            try (PrintWriter pw = new PrintWriter(new FileWriter(rutaCompleta))) {
                for (T objeto : lista) {
                    pw.println(serializer.apply(objeto));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public <T> void cargar(String nombreArchivo, LineParser<T> parser) {
        String rutaCompleta = DIRECTORIO_DATA + File.separator + nombreArchivo;
        File archivo = new File(rutaCompleta);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    parser.parse(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar " + nombreArchivo + ": " + e.getMessage());
        }
    }
}