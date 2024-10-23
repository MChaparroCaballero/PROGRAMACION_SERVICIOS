package ejercicio_2;

import java.util.Scanner;

public class Check {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int enteros[] = new int[10000];

		/** Le mostramos una pantalla de menu con las opciones **/
		System.out.println("\n1.Sincronizado" + "\n2.No sincronizado");

		/**
		 * hacemos el scanner y la variable para guardar la opcion elegida del usuario
		 **/
		Scanner lector = new Scanner(System.in);
		int opcion = lector.nextInt();
		lector.close();
		/**
		 * una booleana que su valor cambia segun la opcio elegida por el usuario del
		 * menu, esto es para pasarle con un valor especifico a los constrcutores de los
		 * hilos cuando los llamemos
		 **/

		boolean monitor;
		if (opcion == 1) {
			monitor = true;
		} else {
			monitor = false;
		}

		/**
		 * hacemos un bucle, del tamaño del array anterior, para que nos haga 10000
		 * rondas de los 10000
		 **/
		for (int j = 0; j < enteros.length; j++) {

			/**
			 * creamos un nuevo hilo escritor donde le pasamos el array para que sepa el
			 * tamaño, el numero que debe escribir y el valor de monitor
			 **/
			HiloEscritor HE = new HiloEscritor(enteros, j, monitor);
			/** lo ejecutamos **/
			HE.start();
			/**
			 * esperamos a que termine de ejecutar antes de que proceda con la siguiente
			 * parte
			 **/
			HE.join();

			/**
			 * creamos un hilo lector y le pasamos el array en el que hemos escrit
			 * supuestamente, y el valor de monitor
			 **/
			HiloLector HL = new HiloLector(enteros, monitor);
			/** lo ejecutamos **/
			HL.start();
			/**
			 * esperamos a que termine de leer antes de que pase a la siguiente iteracion
			 * del bucle
			 **/
			HL.join();

		}
	}

	public static class HiloLector extends Thread {
		private int enteros[];
		private boolean monitor;

		/** constructor **/
		public HiloLector(int[] enteros, boolean monitor) {

			this.enteros = enteros;
			this.monitor = monitor;
		}

		/** setters y getters **/
		public int[] getEnteros() {
			return enteros;
		}

		public void setEnteros(int[] enteros) {
			this.enteros = enteros;
		}

		@Override
		public void run() {

			/**
			 * si monitor que es la variable que nos indica si quieren que ete sincronizado
			 * es true no hace el metodo pero sincronizado, llamamos al synchronized y
			 * bloqueamos enteros hasta que termine
			 **/

			if (monitor == true) {
				synchronized (enteros) {
					/**
					 * hago una variable que contiene el numero al que debe comparar,en principio
					 * deberia ser la que hay en la primera posicion del array
					 **/
					int num = enteros[0];

					/**
					 * hago un contador que inicializo a 0 esto es el contado de cuantas iteraciones
					 * son correctas aka que tengan el mismo numero por iteracion
					 **/
					int contador = 0;

					/**
					 * recorremos el array de enteros y si el numero que contiene el array en
					 * posicion i es igual a el que contiene num me suma 1 al contador, hace esto
					 * con todas las posiciones del array
					 **/
					for (int i = 0; i < enteros.length; i++) {
						if (enteros[i] == num) {
							contador++;
						}
					}

					/**
					 * una vez haya terminado de recorrer el array me compara el valor de contador y
					 * si este es igual a la longitud del array entonces muestra el numero de que se
					 * ejecute correctamente, ya que si es igual a la longitud todos han salido
					 * igual a num
					 **/
					if (contador == enteros.length) {
						System.out.println("Todos los numeros son iguales");
					} else {
						/**
						 * si contador es diferente a la longitud algun numero no es igual dentro del
						 * array y muestra el mensaje de error
						 **/
						System.out.println("Todos los numeros no son iguales");
					}
				}
			}

			/**
			 * en caso de que no hay sido elegido el hacerlo sincronizado hacemos el mimos
			 * codigo pero nos omitimos el bloquear enteros
			 **/
			else {
				int num = enteros[0];
				int contador = 0;
				for (int i = 0; i < enteros.length; i++) {
					if (enteros[i] == num) {
						contador++;
					}
				}
				if (contador == enteros.length) {
					System.out.println("Todos los numeros son iguales");
				} else {
					System.out.println("Todos los numeros no son iguales");
				}
			}
		}

	}

	public static class HiloEscritor extends Thread {
		/**
		 * en parametros ponemos, el array, el num que tenemos que poner para todos y el
		 * valor del monitor
		 **/
		private int enteros[];
		private int num;
		private boolean monitor;

		/** constructor **/
		public HiloEscritor(int[] enteros, int num, boolean monitor) {
			super();
			this.enteros = enteros;
			this.num = num;
			this.monitor = monitor;
		}

		/** setters y getters **/
		public int[] getEnteros() {
			return enteros;
		}

		public void setEnteros(int[] enteros) {
			this.enteros = enteros;
		}

		@Override
		public void run() {

			/**
			 * si monitor es true aka lo queremos sincronizado simplemente añadimos la
			 * nomenclatura synchronized y bloqueamos enteros hasta que termine
			 **/
			if (monitor == true) {
				synchronized (enteros) {

					/** recorre el array entero y los pone todos el mismo numero aka num **/
					for (int i = 0; i < enteros.length; i++) {
						enteros[i] = num;

					}
				}
			} else {
				/**
				 * si no lo queremos sincronizado recorre el array entero y los pone todos el
				 * mismo numero aka num omitiendo el bloqueo de enteros
				 **/
				for (int i = 0; i < enteros.length; i++) {
					enteros[i] = num;

				}
			}

		}

	}
}
