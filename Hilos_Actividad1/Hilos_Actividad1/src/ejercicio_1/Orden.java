package ejercicio_1;


public class Orden {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		hilo h1 = new hilo(1);
		hilo h2 = new hilo(2);
		
		
		h2.start();
		h2.join();
		h1.start();
	}

	public static class hilo extends Thread {

		private int num;
		
		public hilo(int num) {
			super();
			this.num = num;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public void run() {

			System.out.println("Hola, soy el thread numero " + num);
		}

	}

	
}
