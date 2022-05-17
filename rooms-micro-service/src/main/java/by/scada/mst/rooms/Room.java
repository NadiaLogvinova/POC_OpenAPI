package by.scada.mst.rooms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Room {

    private Long id;

    private String address;

}
