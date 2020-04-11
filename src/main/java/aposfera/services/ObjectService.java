package aposfera.services;

import aposfera.general.objects.astro.AstroObject;
import aposfera.general.objects.astro.Planet;
import aposfera.repos.ObjectRepo;
import aposfera.general.objects.astro.Star;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log
@Service
@AllArgsConstructor
public class ObjectService {
    private final ObjectRepo objectRepo;

    public List<AstroObject> addNewStar(Map<String, String> data) {

        log.info(data.toString());

        //final String type = "Star";
        String name = data.get("newStarName");

        String starClass = data.get("newStarClass");
        int starTemp = Integer.parseInt(data.get("newStarTemp"));

        Star newStar = new Star(name/*,type*/);
        newStar.setSpectralClass(starClass);
        newStar.setTemperature(starTemp);
        //setStarParams();

        log.info(newStar.toString());
        objectRepo.save(newStar);


        return objectRepo.findAll();
    }

    public List<Star> listAllStars() {
        return objectRepo.findAllByObjectType("Star");
    }

    public List<AstroObject> addNewPlanetToStar(Map<String, String> data) {

        log.info(data.toString());

        String starName = data.get("starName");
        String newPlanetName = data.get("newPlanetName");
        String newPlanetType = data.get("newPlanetType");

        Star star = objectRepo.findStarByObjectName(starName);

        if (star == null) return null;

        Planet newPlanet = new Planet(newPlanetName);
        newPlanet.setPlanetType(newPlanetType);
        objectRepo.save(newPlanet);

        //String planetName = "Planet " + newPlanetName;
        star.getPlanets().add(newPlanet);

        objectRepo.save(star);

        log.info(star.toString());


        //star.getLocation().put()


        return objectRepo.findAll();
    }

    /*public boolean setStarParams(Star newStar, String starClass, Integer starTemp) {

        newStar.setSpectralClass(starClass);
        newStar.setTemperature(starTemp);

        return objectRepo.sa
        *//*this.spectralClass = starClass;
        this.temperature = starTemp;*//*

    }*/


}
