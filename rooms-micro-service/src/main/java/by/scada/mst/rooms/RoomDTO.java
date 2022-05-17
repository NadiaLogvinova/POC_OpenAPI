package by.scada.mst.rooms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RoomDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("address")
    private String address;

}
