public class LifeThread extends Thread {

    private Grid g;
    private GameOfLifeGrid gg;
    
    public LifeThread(int raws, int columns){
        super();
        this.g = new Grid(raws, columns);
        this.gg = new GameOfLifeGrid(raws, columns);
    }

    public void run(){
        while(true){
            gg.nextGeneration();
            gg.update();
            g.update(gg);
            try{
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {}
        }
    }
}