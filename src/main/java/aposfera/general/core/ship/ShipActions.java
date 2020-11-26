package aposfera.general.core.ship;

import aposfera.general.core.astro.AstroObject;


public interface ShipActions {

    /*
    * Astro interaction
    * */

    void setAstroTarget(AstroObject astroTarget);

    void setObjectTarget(ObjectTarget objectTarget);

    ShipLocation flightToAstroObject(AstroObject astroTarget);

    ObjectTarget flightToObjectTarget(ObjectTarget objectTarget);

    ShipLocation jumpToStar(StarCoordinates starCoordinates);


}
