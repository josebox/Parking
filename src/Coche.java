
public class Coche extends Thread{
	//tendremos el metodo run
	private Barrera b;
	//private int idPlaza;


	public Coche( Barrera b) {
		super();
		this.b = b;
	}

	public void run() {
		try {
			//dormimos el coche antes de entrar en el parking
			Thread.sleep(Math.round(Math.random() * 5000));
			int id = b.entrada();
			//dormimos el coche dentro del  el parking
			Thread.sleep(Math.round(Math.random() * 5000));
			b.salida(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
