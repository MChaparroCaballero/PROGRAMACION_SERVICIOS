package clase13_09_2024;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		// pide un numero de cantidad a insertar, inserta esa cantidad de numeros y
		// luego di cual es el menor, el mayor y cuantas veces se repite cada uno//

		Scanner lector = new Scanner(System.in);// hacemos un scanner para pedir los numeros//
		System.out.println("dime cuantos numeros");
		int num = lector.nextInt();// indice del array de numeros que insertamos//

		// ingresamos los numeros//
		int[] numeros = new int[num];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("dime el dijito");
			numeros[i] = lector.nextInt();
		}

		int[] repeticiones = new int[num];// un array en que sigue el orden del array de los numeros ingresados pero
											// este indica las repeticiones de cada uno

		// inicializamos a el primer dijito del array pare evitar errores de indice al
		// intentar comparar.
		int mayor = numeros[0];
		int menor = numeros[0];

		// empezamos a comparar y remplezara el primer valor de las variables de mayor y
		// menor a el que es menor y mayor en esa iteracion hasta terminar todas, lo de
		// los else es unicamente para que no de error de compilacion, pero se quedaria
		// igual porque no cambia del valor anterior
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}

			else {
				mayor = mayor;
			}

			if (numeros[i] < menor) {
				menor = numeros[i];
			} else {
				menor = menor;
			}

		}

		// hacemos un bucle que recorra de nuevo el array de los numeros//
		for (int i = 0; i < numeros.length; i++) {
			int contador = 0; // Reiniciamos el contador para cada número
			for (int j = 0; j < numeros.length; j++) {
				// hacemos un segundo bucle que permitira compara cada posicion de indice i con
				// toda las posiciones con indice j una vez terminado con j pasa a la siguiente
				// posicion de i y vuelve a empezar
				if (numeros[i] == numeros[j]) {
					contador++; // Si encontramos el mismo número, incrementamos el contador
				}
			}
			repeticiones[i] = contador; // Guardamos el número de repeticiones en la posición i
		}

		for (int i = 0; i < numeros.length; i++) {// recorremos el array de numeros y por cada numero imprimimos el que
													// es y sus repeticiones//
			System.out.println("El número " + numeros[i] + " se repite " + repeticiones[i] + " veces");
		}
		System.out.println("El numero mayor es " + mayor + " el numero menor es " + menor);// por ultimo imprimimos el
																							// numero mayor y menor y
																							// cerramos scanner//
		lector.close();
	}

}
