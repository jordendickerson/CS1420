package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton{
    private static final long serialVersionUID = 1L;
	private final int row;
    private final int column;
    private int imageID;

    /**
     * Constructs a TileButton to be used in the game
     * @param filename - the path to the icon image (will be swapped)
     * @param row - the row of the tile
     * @param column - the column of the tile
     * @param imageID - the ID of the tile's image (will be swapped)
     */
    public TileButton(String filename, int row, int column, int imageID){
        this.setIcon(new ImageIcon(filename));
        this.row = row;
        this.column = column;
        this.imageID = imageID;
    }

    /**
     * Gets the row of the tile
     * @return - the row
     */
    public int getRow(){
        return this.row;
    }

    /**
     * Gets the column of the tile
     * @return - the column
     */
    public int getColumn(){
        return this.column;
    }

    /**
     * Returns the image ID
     * @return - imageID
     */
    public int getImageID(){
        return this.imageID;
    }
    
    /**
     * Sets the image ID
     * @param newID - the new ID to be set
     */
    public void setImageID(int newID) {
    	this.imageID = newID;
    }


    /**
     * Swaps the Icon and Image ID with another tile
     * @param other - the tile to swap with
     */
    public void swap(TileButton other){
        Icon otherIcon = other.getIcon();
        int otherID = other.getImageID();
        other.setIcon(this.getIcon());
        other.imageID = this.imageID;
        this.setIcon(otherIcon);
        this.imageID = otherID;
    }
}
