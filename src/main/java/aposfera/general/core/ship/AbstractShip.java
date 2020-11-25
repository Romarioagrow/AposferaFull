package aposfera.general.core.ship;

import aposfera.general.core.astro.AstroObject;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public abstract class AbstractShip implements ShipActions {

    private String shipName;

    private ShipType shipType;
    private ShipClass shipClass;

    protected AstroObject astroTarget = null;
    protected ObjectTarget objectTarget = null;

    private AstroLocation astroLocation = new AstroLocation();

    private Integer shipMass;
    private Long powerProduction, powerConsumption;




    /*@Override
    public void flightTo() {

    }

    @Override
    public void setAstroTarget() {

    }*/



}
