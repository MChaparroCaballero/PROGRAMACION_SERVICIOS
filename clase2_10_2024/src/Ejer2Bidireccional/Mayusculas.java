package Ejer2Bidireccional;

import java.io.*;

public class Mayusculas {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		try {
		String ruta = System.getProperty("user.dir");
		String classpath = ruta + "/bin";
		
		ProcessBuilder hijo= new ProcessBuilder("java","-cp", classpath, "Ejer2Bidireccional.Hijo");
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
		brfinal.close();
		
		}catch( Exception a) {
			a.printStackTrace();
		}
	}

}
