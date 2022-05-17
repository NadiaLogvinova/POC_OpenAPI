package by.scada.mst.rooms;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RoomRepository {

    private HashMap<Long, Room> storage = new HashMap<>();

    {
        storage.put(0L, Room.builder().id(0L).address("Room_#0").build());
        storage.put(1L, Room.builder().id(1L).address("Room_#1").build());
    }

    public List<Room> getRooms() {
        return new ArrayList<>(storage.values());
    }

    public Room getRoom(Long roomId) {
        return storage.get(roomId);
    }

    public Room saveRoom(Room room) {
        room.setId((long) storage.size());
        storage.put(room.getId(), room);
        return room;
    }
}
