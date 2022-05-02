package Managers;

import Entities.Human;
import Events.GameEvent;
import Listeners.EventListener;
import Utils.Position;

public class GameManager implements EventListener<GameEvent> {

    private static EventManager eventManager;
    private static GridManager gridManager;
    private static InputManager inputManager;
    private static GameManager instance = null;

    public static GameManager getInstance() {
        return instance == null ? new GameManager() : instance;
    }

    private boolean running;

    public void init() {
        eventManager = EventManager.getInstance();
        gridManager = GridManager.getInstance();
        inputManager = InputManager.getInstance();
    }
    public void run() {

        //display title
        //display intro text
        //create game level
        Human player = new Human(10, 10);
        player.spawn(gridManager.getMap().getTileAtPosition(new Position(0, 0)));

        running = true;

        while(running)
        {
            gridManager.displayMap();
            inputManager.getInput();
        }

    }

    @Override
    public void onEvent(GameEvent eventType) {
        if(eventType.name.equals("End Game")){
            running = false;
        }
    }
}
