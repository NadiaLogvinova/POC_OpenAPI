package by.scada.mst.rooms;

import jdk.jfr.ContentType;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @SneakyThrows
    @GetMapping(value = "/rooms")
    public List<RoomDTO> getAll() {
        return roomService.getRooms();
    }

    @SneakyThrows
    @GetMapping(value = "/rooms/{id}")
    public RoomDTO get(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

    @SneakyThrows
    @PostMapping(value = "/rooms")
    public RoomDTO create(@RequestBody RoomDTO roomDTO) {
        return roomService.create(roomDTO);
    }

}
