package clase_17_9_2024;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MaterialNoEncontradoException {
		Biblioteca nueva = new Biblioteca(null);
		Scanner lector = new Scanner(System.in);
		
		Material uno=new Libro("Harry Potter", 1920, "J.K Rowling", "20PSCL");
		Material dos=new Revista("El corazón", 2024, 20);
		Material tres=new DVD();
		Material cuatro= new Libro();
		int opcion;
		do {
			System.out.println(
					"Pulse 1 si quiere agregar un titulo al almacen, pulse 2 si quiere listar un titulo del almacen, pulse 3 si quiere buscar un titulo del almacen, pulse 4 si quiere salir del menu");
			opcion = lector.nextInt();
			switch (opcion) {
			case 1:
				System.out.println(
						"Si quiere agregar un libro pulse 1, si quiere agregar una revista pulse 2, si quiere agregar un DVD pulse 3");
				int optMaterial = lector.nextInt();
				switch (optMaterial) {
				case 1:
					System.out.println("Teclé el titulo del libro");
					String t = lector.nextLine();
					System.out.println("Teclé el año de publicacion del libro del libro");
					int f = lector.nextInt();
					System.out.println("Teclé el autor del libro del libro");
					String a = lector.nextLine();
					System.out.println("Teclé el isbn del libro");
					String s = lector.nextLine();
					Material l = new Libro(t, f, a, s);
					nueva.agregarMaterial(l);
					break;

				case 2:
					System.out.println("Teclé el titulo de la revista");
					String ti = lector.nextLine();
					System.out.println("Teclé el año de publicacion de la revista");
					int fe = lector.nextInt();
					System.out.println("Teclé el numero de la revista");
					int n = lector.nextInt();
					Material p = new Revista(ti, fe, n);
					nueva.agregarMaterial(p);
					break;

				case 3:
					System.out.println("Teclé el titulo del DVD");
					String tiT = lector.nextLine();
					System.out.println("Teclé el año de publicacion del DVD");
					int feC = lector.nextInt();
					System.out.println("Teclé el director del DVD");
					String d = lector.nextLine();
					Material o = new DVD(tiT, feC, d);
					nueva.agregarMaterial(o);
					break;

				}

				break;

			case 2:
				nueva.listarMaterial();
				break;

			case 3:
				System.out.println("Teclé el titulo del material a buscar");
				String nombre = lector.nextLine();
				nueva.BuscarMaterial(nombre);
				break;

			case 4:
				System.out.println("Adios gracias por usar nuestra app");
				break;
			}
		} while (opcion != 4);
		lector.close();
	}

}