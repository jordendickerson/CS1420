package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton {
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

    public void setImageID(int newID){
        this.imageID = newID;
    }

    public void swap(TileButton other){
        Icon otherIcon = other.getIcon();
        int otherID = other.getImageID();
        other.setIcon(this.getIcon());
        other.setImageID(this.imageID);
        this.setIcon(otherIcon);
        this.setImageID(otherID);
    }
}
