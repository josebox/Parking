
public class Barrera {
	// Controla el paso de los coches
	// clase en realizamos lo metodos de sincronización
	private int[] plazas;
	private int nPlazas;
	private int libres;

	public Barrera(int nPlazas) {
		super();
		plazas = new int[nPlazas];
		for (int i = 0; i < nPlazas; i++) {
			plazas[i] = 0;
		}
		this.nPlazas = nPlazas;
		libres = nPlazas;

	}

	// -----metodos entradas y salida-----//
	// metodo entrada de coches
	public synchronized int entrada() throws InterruptedException {
		estadoParking();
		int id = 0;
		while (libres == 0) {
			System.out.println("Coche " + Thread.currentThread().getName() + " esperando");
			wait();
		}
		//si la plaza es diferente a 0 entra  he incrementa la id 
		while (plazas[id] != 0) {
			id++;

		}
		System.out.println("Coche " + Thread.currentThread().getName() + " Ha aparcado en la plaza " + (id +1));
		//le damos en cada posicion del array de plazas le insertamos el nombre del hilo que en este caso en un número
		plazas[id] = Integer.parseInt(Thread.currentThread().getName());
		//y restamos plaza a libres
		libres--;
		return id;

	}

	// metodo salida coches
	public synchronized void salida(int plaza) {
		plazas[plaza] = 0;
		libres++;
		notify();
		estadoParking();
		System.out.println("Coche " + Thread.currentThread().getName() + " saliendo");

	}

	public int[] getPlazas() {
		return plazas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public int getLibres() {
		return libres;
	}

	// -----------------------------------//

	public void estadoParking() {
		System.out.print("Parking: ");
		for (int i = 0; i < nPlazas; i++) {
			System.out.print("[" + plazas[i] + "] ");
		}
		System.out.println("");
	}

}
