package bll;

public class EventLogic {
    public boolean createNewEvent(String name, String location, String notes)  {
         song = new Song(name,location ,notes);
        return songsDao.createSong(song);
    }
}
