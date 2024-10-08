package ejer1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejer1 {

	 public static void main(String[] args) throws IOException, InterruptedException {
	        // estructuramos los procesos
	        ProcessBuilder hijo1 = new ProcessBuilder("cmd", "/c", "dir");
	        ProcessBuilder hijo2 = new ProcessBuilder("cmd", "/c", "findstr", "/i", "d");

	        // empezamos el primer proceso
	        Process process1 = hijo1.start();

	        // Abrimos el canal de lectura de la salida del proceso1
	        BufferedReader br = new BufferedReader(new InputStreamReader(process1.getInputStream()));

	        // empezamos el segundo proceso
	        Process process2 = hijo2.start();

	        // Abrimos el canal de escritura hacia el proceso2
	        OutputStream o2 = process2.getOutputStream();
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(o2));

	        // Leemos del primer proceso y escribimos en el segundo
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            bw.write(linea);
	            bw.newLine();  // Aseguramos que las líneas se terminen correctamente
	        }

	        // Cerramos el BufferedWriter para que el segundo proceso procese la entrada
	        bw.close();

	        // Esperamos a que el primer proceso termine
	        process1.waitFor();

	        // Leemos la salida del segundo proceso (lo que ha filtrado findstr)
	        BufferedReader br2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
	        String salida;
	        while ((salida = br2.readLine()) != null) {
	            System.out.println(salida);
	        }

	        // Esperamos a que el segundo proceso termine
	        process2.waitFor();
	    }
	}