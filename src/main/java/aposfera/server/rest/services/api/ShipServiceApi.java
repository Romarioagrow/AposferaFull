package aposfera.server.rest.services.api;

import aposfera.server.rest.dto.NewShipDetailDto;
import aposfera.server.rest.dto.ShipDto;

public interface ShipServiceApi {

    ShipDto addShip(NewShipDetailDto newShipDetail);

}
