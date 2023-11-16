package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton{
    private static final long serialVersionUID = 1L;
	private final int row;
    private final int column;
    private int imageID;

    public TileButton(String filename, int row, int column, int imageID){
        this.setIcon(new ImageIcon(filename));
        this.row = row;
        this.column = column;
        this.imageID = imageID;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public int getImageID(){
        return this.imageID;
    }
    
    public void setImageID(int newID) {
    	this.imageID = newID;
    }


    public void swap(TileButton other){
        Icon otherIcon = other.getIcon();
        int otherID = other.getImageID();
        other.setIcon(this.getIcon());
        other.imageID = this.imageID;
        this.setIcon(otherIcon);
        this.imageID = otherID;
    }
}
