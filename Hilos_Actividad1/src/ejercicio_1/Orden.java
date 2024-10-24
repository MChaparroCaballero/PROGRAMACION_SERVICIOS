package ejercicio_1;

public class Orden {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/** instanciamos 2 hilos **/
		hilo h1 = new hilo(1);
		hilo h2 = new hilo(2);

		/** empezamos el segundo hilo primero **/
		h2.start();

		/** le decimos que espere a que termine de ejecutar el 2 **/
		h2.join();

		/** emepzamos el hilo 1 **/
		h1.start();
	}

	public static class hilo extends Thread {

		/** variable el numero de hilo **/
		private int num;

		public hilo(int num) {

			this.num = num;
		}

		/** setters y getters **/
		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public void run() {
			/** mensaje que dice que hilo es **/
			System.out.println("Hola, soy el thread numero " + num);
		}

	}

}
