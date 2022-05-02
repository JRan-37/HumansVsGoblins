package Events;

import Utils.Inputs;
import Managers.EventManager;

public class InputEvent {
    public Inputs input;

    public InputEvent (Inputs input) {
        this.input = input;
    }

    public static InputEvent e;

    public static <T> void Trigger(Inputs input) {
        e = new InputEvent(input);
        EventManager.TriggerEvent(e);
    }
}
