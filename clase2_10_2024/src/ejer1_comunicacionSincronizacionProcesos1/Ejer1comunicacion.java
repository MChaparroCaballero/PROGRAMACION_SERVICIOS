package ejer1_comunicacionSincronizacionProcesos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejer1comunicacion {

	public static void main(String[] args) throws IOException, InterruptedException {
		// estructuramos los procesos//
		ProcessBuilder hijo1 = new ProcessBuilder("cmd","/c","dir");
		ProcessBuilder hijo2= new ProcessBuilder("cmd","/c","findstr", "/i", "d");
		//empezamos el primero y dejamos que haga lo suyo//
		Process process1=hijo1.start();
	
		//abrimos canal por parte del proceso1//
		InputStreamReader nuevo1= new InputStreamReader(process1.getInputStream());
		OutputStream o1 = process1.getOutputStream();
		//guardamos los datos del 1//
		BufferedReader br= new BufferedReader(nuevo1);
		
		//emepzamos el segundo proceso//
		Process process2=hijo2.start();
		OutputStream o2= process2.getOutputStream();
		//abrimos canal por parte del 2 con el 1//
		BufferedWriter bw= new BufferedWriter(o2);
		while(br!=null) {
			//leemos y escribimos//
			int linea=br.read();
			bw.write(linea);
		}
		process1.waitFor();
		
		
	}

}
