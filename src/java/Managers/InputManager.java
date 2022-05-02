package Managers;

import Events.GameEvent;
import Events.InputEvent;
import Utils.Inputs;

import java.util.Scanner;

public class InputManager {

    private static InputManager instance = null;

    public static InputManager getInstance() {
        return instance == null ? new InputManager() : instance;
    }

    private Scanner inputReader;

    public InputManager() {
        inputReader = new Scanner(System.in);
    }

    public void getInput() {
        String input;
        boolean invalid = false;
        do {
            input = inputReader.nextLine();
            switch(input.toLowerCase().charAt(0)) {
                case 'w' :
                    InputEvent.Trigger(Inputs.MOVE_UP);
                    invalid = false;
                    break;
                case 'a' :
                    InputEvent.Trigger(Inputs.MOVE_LEFT);
                    invalid = false;
                    break;
                case 's' :
                    InputEvent.Trigger(Inputs.MOVE_DOWN);
                    invalid = false;
                    break;
                case 'd' :
                    InputEvent.Trigger(Inputs.MOVE_RIGHT);
                    invalid = false;
                    break;
                case 'q' :
                    GameEvent.Trigger("End Game");
                    invalid = false;
                    break;
                default :
                    invalid = true;
                    System.out.println("Invalid entry");
            }
        }while (invalid);


    }
}
