package aposfera.general.core.tech;

import aposfera.general.core.ship.Ship;
import aposfera.general.core.ship.ShipBlueprint;
import aposfera.general.core.ship.ships.AnacondaShip;
import aposfera.general.core.ship.types.ShipClass;

public class Shipyard extends TechObject {

    public Ship constructShip(ShipBlueprint shipBlueprint) {
        ShipClass shipClass = shipBlueprint.getShipClass();

        Ship newShip;

        switch (shipClass) {

            case ANACONDA -> {
                newShip = constructAnacondaShip(shipBlueprint);
            }

            default -> newShip = new Ship();
        }

        newShip.setShipName(shipBlueprint.getShipName());

        persistShip(newShip);

        return newShip;
    }

    private Ship constructAnacondaShip(ShipBlueprint shipBlueprint) {

        Ship newShip = new AnacondaShip();


        return newShip;

    }

    private void persistShip(Ship newShip) {

    }

}
