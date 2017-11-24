
public class MainParking {

	public static void main(String[] args) throws InterruptedException {
		// Clase principal donde caragaremos los coches mediante argumento
		int nPlazas =Integer.parseInt(args[0]);
		int nCoches = Integer.parseInt(args[1]);
		Barrera b = new Barrera(nPlazas);

		for (int i = 0; i < nCoches; i++) {
			Coche c = new Coche(b);
			c.setName(String.valueOf(i + 1));
			c.start();
			// c.join();
		}

	}

}
