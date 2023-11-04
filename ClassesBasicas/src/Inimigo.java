public class Inimigo extends Personagem {

    boolean detectouPlayer;

    public Inimigo() {
        super();
        this.detectouPlayer = false;
    }

    public void detectarPlayer() {
        this.detectouPlayer = true;
    }

    public boolean getDetectouPlayer() {
        return this.detectouPlayer;
    }
}
