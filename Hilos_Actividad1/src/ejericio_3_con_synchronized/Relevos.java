package ejericio_3_con_synchronized;

import ejercicio_3.Relevos.Hilo;

public class Relevos {
	
	static final Object testigo = new Object();
	public static int contador = 0;
	public static void main(String[] args) {
		
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


		
		

	}
	public static class Hilo extends Thread{
		private int num;

		public Hilo(int num) {
			
			this.num = num;
		}

		
		public void run() {
			synchronized(testigo) {
              
                
                try {
                	
                	System.out.println("Soy el corredor  " + num + " y estoy corriendo en la carrera.");
					sleep(2000);
					 System.out.println("Soy el corredor " + num + " y he terminado de correr.");
					 contador++;
					 
					 if (contador == 4) {
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
