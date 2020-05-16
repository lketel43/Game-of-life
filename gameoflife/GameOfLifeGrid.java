public class GameOfLifeGrid {
    
    private Cell[][] grid;

    public Cell[][] getGrid(){
        return this.grid;
    }

    public GameOfLifeGrid(int raws, int columns){
        this.grid = new Cell[raws + 2][columns + 2];
        for(int i = 0; i < this.grid.length; i++){
            for(int j = 0; j < this.grid[i].length; j++){
                this.grid[i][j] = new Cell();
            }
        }
        this.grid[26][25].setIsAlive(true);
        this.grid[26][26].setIsAlive(true);
        this.grid[26][27].setIsAlive(true);
        this.grid[25][25].setIsAlive(true);
        this.grid[24][25].setIsAlive(true);
        this.grid[25][27].setIsAlive(true);
        this.grid[24][27].setIsAlive(true);
    }

    public void nextGeneration(){
        for(int i = 1; i < this.grid.length - 1; i++){
            for(int j = 1; j < this.grid[i].length - 1; j++){
                int aliveAround = 0;
                aliveAround += this.grid[i - 1][j - 1].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i][j - 1].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i + 1][j - 1].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i - 1][j].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i + 1][j].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i - 1][j + 1].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i][j + 1].getIsAlive() ? 1 : 0;
                aliveAround += this.grid[i + 1][j + 1].getIsAlive() ? 1 : 0;
                this.grid[i][j].setWillBeAlive((aliveAround == 3) || (this.grid[i][j].getIsAlive() == true && aliveAround == 2));
            }
        }
    }

    public void update(){
        for(int i = 1; i < this.grid.length - 1; i++){
            for(int j = 1; j < this.grid[i].length - 1; j++){
                this.grid[i][j].setIsAlive(this.grid[i][j].getWillBeAlive());
            }
        }
    }

    public void printGrid(){
        for(int i = 1; i < this.grid.length - 1; i++){
            for(int j = 1; j < this.grid[i].length - 1; j++){
                char msg = this.grid[i][j].getIsAlive() ? 'O' : 'X';
                System.out.print(msg);
            }
            System.out.println();
        }
    }

    public static class Cell{
        
        private boolean isAlive;
        private boolean willBeAlive;

        public boolean getIsAlive(){
            return this.isAlive;
        }

        public boolean getWillBeAlive(){
            return this.willBeAlive;
        }

        public void setIsAlive(boolean b){
            this.isAlive = b;
        }

        public void setWillBeAlive(boolean b){
            this.willBeAlive = b;
        }

        public Cell(){
            this.isAlive = false;
            this.willBeAlive = false;
        }
    }
}