package by.scada.mst.rooms;

import org.springframework.stereotype.Component;

@Component
public class RoomDTOConverter {

    public Room convert(RoomDTO roomDTO) {
        return Room.builder()
                    .id(roomDTO.getId())
                    .address(roomDTO.getAddress())
                    .build();
    }

}
