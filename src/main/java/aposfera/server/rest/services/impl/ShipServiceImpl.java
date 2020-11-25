package aposfera.server.rest.services.impl;

import aposfera.server.rest.dto.NewShipDetailDto;
import aposfera.server.rest.dto.ShipDto;
import aposfera.server.rest.services.api.ShipServiceApi;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class ShipServiceImpl implements ShipServiceApi {

    @Override
    public ShipDto addShip(NewShipDetailDto newShipDetail) {
        return new ShipDto();
    }
}
