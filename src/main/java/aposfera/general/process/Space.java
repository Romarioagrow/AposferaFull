package aposfera.general.process;

import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Data
@ToString
public class Space {

    long x = 0, y = 0, z = 0;

    Cube[][][] cubes = new Cube[10][10][10];

    public Space() {
        log.info("New Space Created!");

        initSpace();
    }

    private void initSpace() {

        for (int i = 0; i < 10; i++) {
            cubes[i][i][i] = new Cube();
        }

    }
    //Cube cube = cubes[1][1][1];

    public Cube getRandomCube() {
        int x = getRandomNumber(0, 9);
        int y = getRandomNumber(0, 9);
        int z = getRandomNumber(0, 9);

        log.info("x:{}", x);
        log.info("y:{}", y);
        log.info("z:{}", z);

        log.info("cubes[x][y][z]:"+cubes[x][y][z]);

        return cubes[x][y][z];
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}
