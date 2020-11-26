package aposfera.general.core.ship.ships;

import aposfera.general.core.ship.Ship;
import aposfera.general.core.ship.types.ShipType;
import aposfera.general.core.ship.types.ShipSize;

public class AnacondaShip extends Ship {

    public AnacondaShip() {
        super();
        this.shipClass = ShipType.ANACONDA;
        this.shipSize = ShipSize.XL;
        this.shipMass = 420.0;
    }


}
