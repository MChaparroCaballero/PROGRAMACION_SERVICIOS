package ejer1_comunicacionSincronizacionProcesos1;


import java.io.*;

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
		//abrimos canal por parte del 2 con el 1 y writer porque son caracteres//
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(o2));
		String linea;
		while((linea=br.readLine())!=null) {
			//leemos y escribimos//
			bw.write(linea);
			bw.newLine();//separador de lineas//
			
			
		}
		//cerramos todo para que no nos de errores//
		br.close();
		bw.close();
		
		//antes de continuar hacemos una comprovacion de que el prcess 1 ha terminado lo hacemos aquie por que en estepunto ya es indispensable y antes podria haber terminado o no ya//
		process1.waitFor();
		
		BufferedReader br2= new BufferedReader(new InputStreamReader(process2.getInputStream()));//metemos los datos del process2 en el buffer que el input y buffer deben ser reader porque leen caracteres//
		String linea2;
		while((linea2=br2.readLine())!=null) {
			System.out.println(linea2);//imprimimos y salto de linea//
		System.out.println();
		}
		process2.waitFor();//antes de cerrar el buffer comprovamos que el process2 haya terminado//
		br2.close();
		
	}

}
