package Ejer2Bidireccional;

import java.io.*;

public class Hijo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader brhijo = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bwhijo = new BufferedWriter(new OutputStreamWriter(System.out));
		String lineahijo="";
		while ((lineahijo=brhijo.readLine()) !=null  && !lineahijo.equalsIgnoreCase("salir")) {
			
			bwhijo.write(lineahijo.toUpperCase());
			bwhijo.newLine();
			bwhijo.flush();
			
			
		}
		brhijo.close();
		bwhijo.close();
	}

}
