package ejericio_3_con_synchronized;


public class Relevos {

	
	/**creamos un monitor**/
	static final Object testigo = new Object();
	
	/**variable contador, que cuenta cuantos hilos ya han corrido y su orden**/
	public static int contador = 1;

	public static void main(String[] args) {

		/**una booleana que hace de la señal de empezar**/
		boolean empezar;

		/**instanciamos los cuatro hilos corredores**/
		Hilo h1 = new Hilo(1);
		Hilo h2 = new Hilo(2);
		Hilo h3 = new Hilo(3);
		Hilo h4 = new Hilo(4);

		/**cambiamos el valor de la booleana a true**/
		empezar = true;
		
		/**si emepzar esta true empieza al carrera donde ejecutamos los hilos**/
		if (empezar == true) {
			h1.start();
			h2.start();
			h3.start();
			h4.start();
		}

	}

	public static class Hilo extends Thread {
		
		/**parametro que dice que numero de hilo es cada hilo**/
		private int num;

		
		/**constructor**/
		public Hilo(int num) {

			this.num = num;
		}

		public void run() {

			
			/**bloqueamos el monitor**/
			synchronized (testigo) {
				try {
					
					/**mientras que el numero de hilo sea diferente al de contador aka no es el hilo que deberia de ir en ese momento, se va a quedar esperando**/
					while (this.num != contador) {
						testigo.wait();
					}

					
					/**mensaje de que esta corriendo**/
					System.out.println("Soy el corredor  " + num + " y estoy corriendo en la carrera.");
					
					/**duerme un rato para simular que esta corriendo**/
					sleep(2000);
					
					/**mensaje de que termino de correr**/
					System.out.println("Soy el corredor " + num + " y he terminado de correr.");
					
					/**notifica a los demas hilos que estaban esperando para que entre el siguiente**/
					testigo.notifyAll();
					
					/**sumamos uno al contador para que nos actualice la condicion y valla contando ademas cuantos han corrido en ese momento**/
					contador++;

					/**cuando ya contador sea 5 ya habran corrido 5, tiene que ser 5 porque sino terminamos la carrera sin que corra el hilo 4**/
					if (contador == 5) {
						System.out.println("Todos los hilos han terminado de correr");
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}
