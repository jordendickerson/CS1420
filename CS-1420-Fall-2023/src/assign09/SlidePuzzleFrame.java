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

    public SlidePuzzleFrame(){ 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel tilePanel = new JPanel();
        tilePanel.setLayout(new GridLayout(4,4));
        tilePanel.setPreferredSize(new Dimension(720, 720));
        
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
        
        shuffle();

        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel();
        messagePanel.setSize(new Dimension(720, 20));
        messagePanel.add(messageLabel);
        messageLabel.setText(" ");
        
        
        shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(this);
        solutionButton = new JButton("Solve");
        solutionButton.addActionListener(this);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.add(shuffleButton);
        buttonsPanel.add(solutionButton);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(tilePanel);
        containerPanel.add(buttonsPanel);
        containerPanel.add(messagePanel);

        this.setTitle("Slide Puzzle");
        this.setContentPane(containerPanel);
        this.setPreferredSize(new Dimension(720, 815));
		this.pack();
        
        
    }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source instanceof TileButton) {
    		TileButton tileClicked = (TileButton)source;
    		if (adjacentToEmpty(tileClicked)) {
    			tileClicked.swap(emptyTile);
    			emptyTile = tileClicked;
    			messageLabel.setText(" ");
    			System.out.println(isSolved());
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

    private boolean adjacentToEmpty(TileButton tile){
        return Math.abs(tile.getRow() - emptyTile.getRow()) + Math.abs(tile.getColumn() - emptyTile.getColumn()) == 1;
    }

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
