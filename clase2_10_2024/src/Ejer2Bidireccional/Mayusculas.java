package Ejer2Bidireccional;

import java.io.*;

public class Mayusculas {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
		ProcessBuilder hijo= new ProcessBuilder("java","-jar","C:\\Users\\MariaChaparroCaballe\\eclipse-workspace\\clase2_10_2024\\src\\Ejer2Bidireccional\\Hijo.jar");
		
		Process processhijo = hijo.start();
		
		System.out.println("Escriba un mensaje, si quiere salir escriba salir");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//main//
		
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(processhijo.getOutputStream()));//concectamos con el subproceso//
		BufferedReader brfinal= new BufferedReader(new InputStreamReader(processhijo.getInputStream()));//metemos los datos en el buffer
		
		String linea;
		String respuesta="";
		while((linea=br.readLine()) !=null  && !linea.equalsIgnoreCase("salir")) {
			bw.write(linea);
			bw.flush();
			respuesta= brfinal.readLine();
			System.out.println(respuesta);
		}

		bw.close();
		br.close();
		processhijo.waitFor();
		
		}catch( Exception a) {
			a.printStackTrace();
		}
	}

}
