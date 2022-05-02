package Managers;

import Entities.Goblin;
import Entities.Human;
import Events.GameEvent;
import Listeners.EventListener;
import Utils.Events;
import Utils.Position;

public class GameManager implements EventListener<GameEvent>{

    private static EventManager eventManager;
    private static GridManager gridManager;
    private static InputManager inputManager;
    private static GameManager instance = new GameManager();

    public static GameManager getInstance() {
        return instance;
    }

    private boolean running;

    public void init() {
        eventManager = EventManager.getInstance();
        gridManager = GridManager.getInstance();
        inputManager = InputManager.getInstance();

        EventListener.EventStartListening(this, Events.GameEvent);
    }
    public void run() {

        //display title
        //display intro text
        //create game level
        Human player = new Human(25, 8, 3 , 85);
        player.spawn(gridManager.getMap().getTileAtPosition(new Position(0, 0)));

        Goblin enemy1 = new Goblin(10, 5, 1, 60);
        enemy1.spawn(gridManager.getMap().getTileAtPosition(new Position(3, 3)));
        //player.spawn(gridManager.getMap().getTileAtPosition(new Position(2, 2)));

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
