package aposfera.general.core.ship;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
/*@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor*/
public class Ship extends AbstractShip {

    ShipFlightComputer shipFlightComputer;

    public Ship() {
        this.shipFlightComputer = new ShipFlightComputer();
    }



}
