import Managers.*;

public class Main {

    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
	// write your code here
        GameManager gm = GameManager.getInstance();

        gm.init();

        gm.run();

    }
}
