package aposfera.general.core.astro.interfaces;

import aposfera.general.core.astro.AstroObject;
import aposfera.general.core.ship.AbstractShip;
import lombok.extern.java.Log;

@Log
public class Ship extends AbstractShip {


    @Override
    public void flightTo(AstroObject astroTarget) {
        setAstroTarget(astroTarget);
        ShipFlighter.autoflight();
    }



    @Override
    public void setAstroTarget(AstroObject astroTarget) {
        this.astroTarget = astroTarget;
    }

    private static class ShipFlighter {


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
