package Ejer2Bidireccional;

import java.io.*;

public class Mayusculas {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String classPath=System.getProperty("java.class.path");
		ProcessBuilder hijo= new ProcessBuilder("java","-cp","bin","Hijo");
		
		Process processhijo=hijo.start();
		
		System.out.println("Escriba un mensaje, si quiere salir escriba exit");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//main//
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(processhijo.getOutputStream()));//concectamos con el subproceso//
		BufferedReader brfinal= new BufferedReader(new InputStreamReader(processhijo.getInputStream()));//metemos los datos en el buffer
		String linea;
		while(!(linea=br.readLine()).isEmpty()) {
			bw.write(linea);
			bw.newLine();
			bw.flush();
		}
		bw.write("exit");
		processhijo.waitFor();
		br.close();
		bw.close();
		
		System.out.println(brfinal.readLine());
	}

}
