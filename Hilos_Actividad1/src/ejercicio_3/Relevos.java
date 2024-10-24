package ejercicio_3;

import java.util.concurrent.Semaphore;

public class Relevos {

	public static int contador = 0;
	public static Semaphore testigo = new Semaphore(1);
	public static Semaphore orden = new Semaphore(1); // Para controlar el orden de ejecución

	public static void main(String[] args) throws InterruptedException {
		/** señal podemos con un if **/

		boolean empezar;
		Hilo h1 = new Hilo(1);
		Hilo h2 = new Hilo(2);
		Hilo h3 = new Hilo(3);
		Hilo h4 = new Hilo(4);

		empezar = true;
		if (empezar == true) {
			h1.start();
			h2.start();
			h3.start();
			h4.start();
		}

		h1.join();
		h2.join();
		h3.join();
		h4.join();

		if (contador == 4) {
			System.out.println("Todos los hilos han terminado de correr");
		}
	}

	public static class Hilo extends Thread {
		private int num;

		public Hilo(int num) {

			this.num = num;
		}

		public void run() {
			
			try {
				orden.acquire();
				System.out.println("hola soy el hilo numero " + num + " y estoy corriendo");
				
				testigo.acquire();
				Thread.sleep(2000);
				testigo.release();
				contador++;
				System.out.println("Hilo número " + num + " ha terminado");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// Liberar el semáforo para que el siguiente hilo pueda correr
				orden.release();
			}
		}

	}
}
