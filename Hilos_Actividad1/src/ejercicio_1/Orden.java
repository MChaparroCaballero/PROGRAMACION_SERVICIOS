package ejercicio_1;

import ejercicio_1.Orden.hilo2;

public class Orden {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		hilo2 h2 = new hilo2();
		h2.start();
		h2.join();
		hilo1 h1 = new hilo1();
		h1.start();
	}

	public static class hilo1 extends Thread {

		public void run() {

			System.out.println("Hola, soy el thread numero 1");
		}

	}

	public static class hilo2 extends Thread {

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Hola, soy el thread numero 2");
		}
	}
}
