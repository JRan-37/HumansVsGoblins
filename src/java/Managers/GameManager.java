package Managers;

import Entities.Human;
import Events.GameEvent;
import Listeners.EventListener;
import Utils.Position;

public class GameManager{

    private static EventManager eventManager;
    private static GridManager gridManager;
    private static InputManager inputManager;
    private static GameManager instance = new GameManager();
    public int x = 5;

    public static GameManager getInstance() {
        return instance;
    }

    private boolean running;

    public void init() {
        eventManager = EventManager.getInstance();
        gridManager = GridManager.getInstance();
        inputManager = InputManager.getInstance();
    }
    public void run() {
        x = 12;
        //display title
        //display intro text
        //create game level
        Human player = new Human(10, 10);
        player.spawn(gridManager.getMap().getTileAtPosition(new Position(0, 0)));
        player.move(gridManager.getMap().getTileAtPosition(new Position(1, 1)));
        //player.spawn(gridManager.getMap().getTileAtPosition(new Position(2, 2)));

        running = true;

        while(running)
        {
            gridManager.displayMap();
            inputManager.getInput();
        }

        player.spawn(gridManager.getMap().getTileAtPosition(new Position(3, 3)));
        gridManager.displayMap();

    }

    /*@Override
    public void onEvent(GameEvent eventType) {
        if(eventType.name.equals("End Game")){
            running = false;
        }
    }*/
}
