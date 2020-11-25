package aposfera.general.core.astro.interfaces;

import aposfera.general.core.astro.AstroObject;
import aposfera.general.core.ship.AbstractShip;
import aposfera.general.core.ship.ObjectTarget;
import aposfera.general.core.ship.ShipLocation;
import aposfera.general.core.ship.StarCoordinates;
import lombok.extern.java.Log;

@Log
public class Ship extends AbstractShip {

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
    public ShipLocation jumpToStar(StarCoordinates starCoordinates) {
        return null;
    }



    /*@Override
    public void flightTo(AstroObject astroTarget) {
        setAstroTarget(astroTarget);
        ShipFlightComputer.autoflight();
    }*/


    private static class ShipFlightComputer {


        public static void autoflight() {


            alignToAstroTarget();

            boostToAstroTarget();

            //getAstroTarget();

        }

        private static void boostToAstroTarget() {
            log.info("boostToAstroTarget proc!");
        }

        private static void alignToAstroTarget() {
            log.info("boostToAstroTarget proc!");

        }
    }


    /*private AstroObject getAstroTarget() {
        return this.astroTarget;
    }*/


}
