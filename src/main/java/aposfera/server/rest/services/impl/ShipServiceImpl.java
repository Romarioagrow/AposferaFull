package aposfera.server.rest.services.impl;

import aposfera.general.core.astro.interfaces.Ship;
import aposfera.server.rest.dto.NewShipDetailDto;
import aposfera.server.rest.dto.ShipDto;
import aposfera.server.rest.services.api.ShipServiceApi;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class ShipServiceImpl implements ShipServiceApi {

    @Override
    public ShipDto addShip(NewShipDetailDto newShipDetail) {

        Ship ship = new Ship();

        return new ShipDto();
    }

    @Override
    public ShipDto loadShip(String shipID) {
        return new ShipDto();
    }
}
