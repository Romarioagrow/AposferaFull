package aposfera.general.process;

import aposfera.general.core.astro.AstroObject;
import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Arrays;

@Log
@Data
@ToString

public class Cube {

    //Cube[][][] cubes = new Cube[100][100][100];


    public Cube() {
        log.info("New Cube");
    }

    AstroObject astroObject;

    public void showInfo() {

        //log.info("Cubes: " + Arrays.deepToString(cubes));
        log.info("AstroObject: " + astroObject);

    }

}
