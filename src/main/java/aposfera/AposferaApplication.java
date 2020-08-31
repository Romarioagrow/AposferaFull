package aposfera;
import aposfera.general.process.Cube;
import aposfera.general.process.Space;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class AposferaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AposferaApplication.class, args);

        Space space = new Space();
        log.info("space: " + space);
        Cube coub = space.getRandomCube();
        /*coub.showInfo();*/

    }
}
