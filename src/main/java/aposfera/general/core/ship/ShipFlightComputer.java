package aposfera.general.core.ship;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor
public class ShipFlightComputer {


    public void autoflight() {

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
