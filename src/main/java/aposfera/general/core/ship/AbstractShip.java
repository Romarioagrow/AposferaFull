package aposfera.general.core.ship;

import aposfera.general.core.astro.AstroObject;
import aposfera.general.core.ship.types.ShipSize;
import aposfera.general.core.ship.types.ShipType;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public abstract class AbstractShip implements ShipActions {

    protected String shipName;

    protected ShipSize shipSize;
    protected ShipClass shipClass;
    protected ShipType shipType;

    protected AstroObject astroTarget = null;
    protected ObjectTarget objectTarget = null;

    protected AstroLocation astroLocation = new AstroLocation();

    protected Double shipMass;
    protected Long powerProduction, powerConsumption;

    @Override
    public void setAstroTarget(AstroObject astroTarget) {
        this.astroTarget = astroTarget;
    }

    @Override
    public void setObjectTarget(ObjectTarget objectTarget) {
        this.objectTarget = objectTarget;
    }

    @Override
    public ShipLocation flightToAstroObject(AstroObject astroTarget) {
        return null;
    }

    @Override
    public ObjectTarget flightToObjectTarget(ObjectTarget objectTarget) {
        return null;
    }

    @Override
    public ShipLocation jumpToStar(StarCoordinates starCoordinates) {
        return null;
    }


    /*@Override
    public void flightTo() {

    }

    @Override
    public void setAstroTarget() {

    }*/



}
