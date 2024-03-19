package bll;

import be.Event;

public class EventLogic {
    public boolean createNewEvent(String name, String location, String notes)  {
         Event = new Event(name,location ,notes);
        return EventDao.createSong(Event);
    }
}
