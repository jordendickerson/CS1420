package assign09;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlidePuzzleFrame extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
	private TileButton[][] buttonGrid;
    private TileButton emptyTile;
    private JButton shuffleButton;
    private JButton solutionButton;
    private JLabel messageLabel;

    
    /**
     * Constructs a slide puzzle game with buttons to shuffle the grid and solve the puzzle
     * 
     * @author Jorden Dickerson
     * @version Nov 16 2023
     */
    public SlidePuzzleFrame(){ 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Set up the tile panel
        JPanel tilePanel = new JPanel();
        tilePanel.setLayout(new GridLayout(4,4));
        tilePanel.setPreferredSize(new Dimension(720, 720));
        
        //Create the tiles
        buttonGrid = new TileButton[4][4];
        int ID = 0;
        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                buttonGrid[row][col] = new TileButton("src/assign09/tile_" + row + "_" + col + ".png", row, col, ID);
                buttonGrid[row][col].addActionListener(this);
                tilePanel.add(buttonGrid[row][col]);
                ID++;
            }
        }
        emptyTile = buttonGrid[0][0];
        
        shuffle(); //Shuffle the board

        //Create the panel to display messages
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel();
        messagePanel.setSize(new Dimension(720, 20));
        messagePanel.add(messageLabel);
        messageLabel.setText(" ");
        
        //Initialise buttons
        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(this);
        solutionButton = new JButton("Solve");
        solutionButton.addActionListener(this);
        
        //Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.add(shuffleButton);
        buttonsPanel.add(solutionButton);

        //Create container panel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(tilePanel);
        containerPanel.add(buttonsPanel);
        containerPanel.add(messagePanel);

        //Set up the window
        this.setTitle("Slide Puzzle");
        this.setContentPane(containerPanel);
        this.setPreferredSize(new Dimension(720, 815));
		this.pack();
        
        
    }

    /**
     * Handles any actions performed on the buttons
     */
    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source instanceof TileButton) {
    		TileButton tileClicked = (TileButton)source;
    		if (adjacentToEmpty(tileClicked)) {
    			tileClicked.swap(emptyTile);
    			emptyTile = tileClicked;
    			messageLabel.setText(" ");
    			if(isSolved()) {
        			messageLabel.setText("Congratulations, you solved it!");
        		}
    		}
    		else {
    			messageLabel.setText("You must choose a tile adjacent to the empty tile!");
    		}
    		
    		
    		
    	}
    	else if (source == shuffleButton) {
    		shuffle();
    	}
    	else if (source == solutionButton) {
    		solve();
    		messageLabel.setText("Solved!");
    	}
    }

    /**
     * Checks if the clicked tile is adjacent to the empty tile
     * @param tile - the tile to be checked
     * @return
     */
    private boolean adjacentToEmpty(TileButton tile){
        return Math.abs(tile.getRow() - emptyTile.getRow()) + Math.abs(tile.getColumn() - emptyTile.getColumn()) == 1;
    }

    /**
     * Chooses a random direction, checks if the empty tile can be swapped in that direction, and moves if it can. 
     * Repeats process 500 times to ensure a good shuffle.
     */
    public void shuffle(){
        Random rng = new Random();
        for(int s = 0; s < 500; s++) {
	        for (int j = 0; j < 4; j++) {
		        for (int i = 0; i < 4; i++) {
		        	int direction = rng.nextInt(4);
		        	TileButton curButton = buttonGrid[j][i];
		        	if (adjacentToEmpty(curButton)) {
		        		if(direction == 0 && (emptyTile.getRow() - curButton.getRow()) == -1) {
		        			emptyTile.swap(curButton);
		        			emptyTile = curButton;
		        			break;
		        		}
		        		else if(direction == 1 && (emptyTile.getRow() - curButton.getRow()) == 1) {
		        			emptyTile.swap(curButton);
		        			emptyTile = curButton;
		        			break;
		        		}
		        		else if(direction == 2 && (emptyTile.getColumn() - curButton.getColumn()) == -1) {
		        			emptyTile.swap(curButton);
		        			emptyTile = curButton;
		        			break;
		        		}
		        		else if(direction == 3 && (emptyTile.getColumn() - curButton.getColumn()) == 1) {
		        			emptyTile.swap(curButton);
		        			emptyTile = curButton;
		        			break;
		        		}
		        			
		        	}
		        }
		    }
	    }
    }
    
    /**
     * Resets the board to its solved state.
     */
    public void solve() {
    	int newID = 0;
    	for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                buttonGrid[row][col].setIcon(new ImageIcon("src/assign09/tile_" + row + "_" + col + ".png"));
                buttonGrid[row][col].setImageID(newID);
                newID++;
            }
        }
    	emptyTile = buttonGrid[0][0];
    }
    
    /**
     * Checks whether the board is in the solved state or not
     * @return - true if solved, false if not
     */
    public boolean isSolved() {
    	for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
            	if(buttonGrid[row][col] != buttonGrid[buttonGrid[row][col].getImageID() / 4][buttonGrid[row][col].getImageID() % 4])
            		return false;
            }
        }
    	return true;
    }
}
