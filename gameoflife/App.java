public class App {
    
    public static void main(String[] args){
        LifeThread l = new LifeThread(60, 60);
        l.start();
    }
}