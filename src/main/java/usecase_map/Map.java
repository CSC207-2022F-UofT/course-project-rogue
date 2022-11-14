package usecase_map;

import usecase_event.Event;

public class Map {
    private Event[][] event_array;

    public Map(Event[][] event_array){
        this.event_array = event_array;
    }

    public Event getEvent(int[] location){
        return this.event_array[location[0]][location[1]];
    }
}
