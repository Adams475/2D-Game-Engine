import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveGame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4287195984679809145L;
	private transient Handler handler;
	
	public SaveGame(Handler handler) {
		this.handler = handler;
	}
	
	public void saveWorlds() {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream("res/worlds/saveTest.txt");
			oos = new ObjectOutputStream(fos);
			State.setState(null);
			handler.getGame().getG().dispose();
			oos.writeObject(handler.getWorld());
			
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
