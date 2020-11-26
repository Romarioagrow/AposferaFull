package aposfera.general.core.tech;

import aposfera.general.core.ship.Ship;
import aposfera.general.core.ship.ShipBlueprint;
import aposfera.general.core.ship.ships.AnacondaShip;
import aposfera.general.core.ship.types.ShipClass;
import aposfera.general.core.tech.types.TechType;

public class Shipyard extends TechObject {

    public Shipyard() {
        super();
        this.techType = TechType.SHIPYARD;
    }

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
