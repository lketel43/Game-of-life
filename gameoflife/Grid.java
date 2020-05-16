import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame{

    private static final long serialVersionUID = 1L;

    private JPanel pane;

    public Grid(int raws, int columns){
        super();
        this.setSize(800, 800);
        this.pane = new JPanel();
        GridLayout layout = new GridLayout(raws, columns);
        layout.preferredLayoutSize(pane);
        this.pane.setLayout(layout);
        for(int i = 0; i < raws; i++){
            for(int j = 0; j < columns; j++){
                ColoredCell c = new ColoredCell(i, j);
                pane.add(c);
            }
        }
        this.add(pane);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public ColoredCell get(int x, int y){
        for(Component child : this.pane.getComponents()){
            if(child instanceof ColoredCell){
                if(((ColoredCell)child).getXCoor() == x && ((ColoredCell)child).getYCoor() == y) return (ColoredCell) child;
            }
        }
        return null;
    }

    public void update(GameOfLifeGrid g){
        for(int i = 1; i < g.getGrid().length - 1; i++){
            for(int j = 1; j < g.getGrid()[i].length - 1; j++){
                this.get(i - 1, j - 1).setColor(g.getGrid()[i][j].getIsAlive());
            }
        }
    }

    class ColoredCell extends JPanel{

        private static final long serialVersionUID = 1L;

        private final int xCoor;
        private final int yCoor;

        public int getXCoor(){
            return this.xCoor;
        }

        public int getYCoor(){
            return this.yCoor;
        }
        
        public ColoredCell(int x, int y) {
            super();
            this.xCoor = x;
            this.yCoor = y;
            //Border b = BorderFactory.createLineBorder(Color.black, 1);          
            //this.setBorder(b);
        }

        public void setColor(boolean b){
            Color c = b ? Color.BLACK : Color.WHITE;
            this.setBackground(c);
        }
    }
}