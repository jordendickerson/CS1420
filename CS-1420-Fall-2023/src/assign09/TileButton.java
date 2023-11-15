package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton {
    private final int row;
    private final int column;
    private int imageID;

    public TileButton(String filename, int row, int column, int imageID){
        super(new ImageIcon(filename));
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

    public void swap(TileButton other){
        Icon otherIcon = other.getIcon();
        other.setIcon(this.getIcon());
        this.setIcon(otherIcon);
    }
}
