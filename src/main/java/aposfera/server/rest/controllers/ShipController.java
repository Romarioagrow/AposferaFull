package aposfera.server.rest.controllers;

import aposfera.server.rest.dto.NewShipDetailDto;
import aposfera.server.rest.dto.ShipDto;
import aposfera.server.rest.services.impl.ShipServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest/ship")
@AllArgsConstructor
public class ShipController {
    private final ShipServiceImpl shipService;

    @PostMapping("/add")
    public ShipDto addShip(@RequestBody(required = false) NewShipDetailDto newShipDetails) {
        return shipService.addShip(newShipDetails);
    }

}
