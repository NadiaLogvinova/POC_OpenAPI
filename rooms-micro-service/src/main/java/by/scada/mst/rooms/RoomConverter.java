package by.scada.mst.rooms;

import org.springframework.stereotype.Component;

@Component
public class RoomConverter {

    public RoomDTO convert(Room room) {
        return RoomDTO.builder()
                    .id(room.getId())
                    .address(room.getAddress())
                    .build();
    }

}
