package view;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Tile{
	
	private JLabel label;
	private int x, y;
	
	public Tile(String img, int x, int y)
	{
		Icon imageIcon = new ImageIcon(img);
		Image image = ((ImageIcon) imageIcon).getImage();
		Image img2 = image.getScaledInstance(25,25,1);
		Icon newImageIcon = new ImageIcon(img2);
		label = new JLabel(newImageIcon);
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public JLabel getLabel()
	{
		return label;
	}

}
