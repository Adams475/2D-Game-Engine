import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class FontHandler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8054738958766190061L;

	public static void drawFont(Graphics g, String text, Rectangle rect, Font font) {
		g.setFont(font);
		FontMetrics metrics = g.getFontMetrics(font);
	
		//makes a list of words and then moves them into an array list
		ArrayList<String> words = new ArrayList<String>();
		String temp[] = text.split(" ");
		for(int i = 0; i < temp.length; i++) {
			words.add(temp[i]);
		}
		
		//finds how many times text needs to wrap
	    int wrapAmount = 0;
		if(metrics.stringWidth(text) > rect.width) {
			wrapAmount = (int) Math.ceil( (double) metrics.stringWidth(text) / (double) rect.width );	
		} else {
			g.drawString(text, rect.x, ( rect.y + metrics.getAscent() ) );
		}
		
		//initialize array of lines
		String lines[] = new String[wrapAmount];
		
		int newStarting = 0;
		
		for(int i = 0; i < lines.length; i++) {
			String tempW = "";
			
			for(int z = 0; z < words.size(); z++) {
				if(z + newStarting < words.size() && metrics.stringWidth(tempW + words.get(z + newStarting)) < rect.width + 40) { 
					//the +40 is there because some words that should fit don't get added so this make the width a little bigger to let them sneak in.
					tempW = tempW + words.get(z + newStarting) + " ";
					
				} else {
					newStarting = z + newStarting;
					break;
					
				}
			}
			
			lines[i] = tempW;
			
		}
		
		//draws lines (could put this in for loop)
		for(int i = 0; i < lines.length; i++) {
			g.setFont(font);
			g.drawString(lines[i], rect.x, ( rect.y + 24 * i + metrics.getAscent() ) );
		}
		
	}
}