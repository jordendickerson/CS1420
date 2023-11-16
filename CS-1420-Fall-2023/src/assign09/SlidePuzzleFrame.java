package assign09;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SlidePuzzleFrame extends JFrame implements ActionListener{
    private ArrayList<TileButton> buttonGrid;
    private TileButton emptyTile;
    private JButton shuffleButton;
    private JButton solutionButton;

    public SlidePuzzleFrame(){ 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        buttonGrid = new ArrayList<TileButton>();

        for (int row = 0; row < 4; row++){
            for (int col = 0; col < 4; col++){
                if (row == 0 && col == 0){
                    emptyTile = new TileButton("src/assign09/tile_" + row + "_" + col + ".png", row, col, buttonGrid.size());
                    buttonGrid.add(emptyTile);
                    continue;
                }
                buttonGrid.add(new TileButton("src/assign09/tile_" + row + "_" + col + ".png", row, col, buttonGrid.size()));
            }
        }

        JPanel tilePanel = new JPanel();
        tilePanel.setLayout(new GridLayout(4,4));
        tilePanel.setPreferredSize(new Dimension(720, 720));

        for (int i = 0; i < 16; i++){
            buttonGrid.get(i).addActionListener(this);
            tilePanel.add(buttonGrid.get(i));
        }

        shuffleButton = new JButton("Shuffle");
        solutionButton = new JButton("Solve");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.add(shuffleButton);
        buttonsPanel.add(solutionButton);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(tilePanel);
        containerPanel.add(buttonsPanel);

        this.setTitle("Slide Puzzle");
        this.setContentPane(containerPanel);
        this.setPreferredSize(new Dimension(720, 800));
		this.pack();
        
        
    }

    public void actionPerformed(ActionEvent e){

    }

    private boolean adjacentToEmpty(TileButton tile){
        return Math.abs(tile.getRow() - emptyTile.getRow()) + Math.abs(tile.getColumn() - emptyTile.getColumn()) == 1;
    }

    public void shuffle(){
        Random rng = new Random();
        int direction = rng.nextInt(4);
    }
}
