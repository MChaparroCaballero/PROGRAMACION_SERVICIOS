package Ejer2Bidireccional;

import java.io.*;

public class Hijo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader brhijo = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bwhijo = new BufferedWriter(new OutputStreamWriter(System.out));
		String lineahijo="";
		while (lineahijo !=null && !lineahijo.equalsIgnoreCase("exit")) {
			lineahijo = brhijo.readLine();
			bwhijo.write(lineahijo.toUpperCase());
			
		}
		brhijo.close();
		bwhijo.close();
	}

}
