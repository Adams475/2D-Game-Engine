import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LoadGame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8537180468690014923L;
	private transient Handler handler;
	
	public LoadGame(Handler handler) {
		this.handler = handler;
	}
	
	public void loadGame() {
		
		FileInputStream fos = null;
		ObjectInputStream oos = null;
		
		try {
			
			fos = new FileInputStream("res/worlds/saveTest.txt");
			oos = new ObjectInputStream(fos);
			handler.setWorld((World)oos.readObject());
			
			
		} catch (Exception ex){
			ex.printStackTrace();
		} finally {
			
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}

}


