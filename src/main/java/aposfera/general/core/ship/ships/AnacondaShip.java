package aposfera.general.core.ship.ships;

import aposfera.general.core.ship.Ship;
import aposfera.general.core.ship.types.ShipClass;
import aposfera.general.core.ship.types.ShipSize;

public class AnacondaShip extends Ship {

    public AnacondaShip() {
        super();
        this.shipClass = ShipClass.ANACONDA;
        this.shipSize = ShipSize.XL;
        this.shipMass = 420.0;
    }


}
