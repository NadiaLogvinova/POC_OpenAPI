package by.scada.mst.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomDTOConverter roomDTOConverter;

    @Autowired
    private RoomConverter roomConverter;

    public List<RoomDTO> getRooms() {
        List<Room> rooms = roomRepository.getRooms();
        return rooms.stream().map(room -> roomConverter.convert(room)).collect(Collectors.toList());
    }

    public RoomDTO getRoom(Long roomId) {
        Room room = roomRepository.getRoom(roomId);
        return roomConverter.convert(room);
    }

    public RoomDTO create(RoomDTO roomDTO) {
        Room room = roomDTOConverter.convert(roomDTO);
        Room savedRoom = roomRepository.saveRoom(room);
        return roomConverter.convert(savedRoom);
    }
}
