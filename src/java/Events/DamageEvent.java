package Events;

import Entities.Character;
import Managers.EventManager;
import Utils.Events;

public class DamageEvent {
    public Character target;
    public Character instigator;
    public int damage;


    public DamageEvent (Character target, Character instigator, int damage) {
        this.target = target;
        this.instigator = instigator;
        this.damage = damage;
    }

    static DamageEvent e;

    public static <T> void Trigger(Character target, Character instigator, int damage) {
        e = new DamageEvent(target, instigator, damage);
        EventManager.TriggerEvent(e, Events.DamageEvent);
    }
}
