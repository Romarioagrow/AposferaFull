package aposfera.server.services;

import aposfera.general.objects.astro.Planet;
import aposfera.general.objects.astro.enums.AstroObjectType;
import aposfera.server.repos.AstroRepo;
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
    private final AstroRepo astroRepo;

    public List<Star> addNewStar(Map<String, String> data) {
        log.info(data.toString());

        //final String type = "Star";
        String name = data.get("newStarName");

        if (astroRepo.findStarByObjectName(name) != null) return null;

        String starClass = data.get("newStarClass");
        int starTemp = Integer.parseInt(data.get("newStarTemp").trim());

        Star newStar = new Star(name/*,type*/);
        newStar.setSpectralClass(starClass);
        newStar.setTemperature(starTemp);
        //setStarParams();

        log.info(newStar.toString());
        astroRepo.save(newStar);
        return listAllStars();
    }

    public List<Star> listAllStars() {
        log.info(astroRepo.findAllByObjectType(AstroObjectType.STAR).toString());
        return astroRepo.findAllByObjectType(AstroObjectType.STAR);
    }

    public List<Star> addNewPlanetToStar(Map<String, String> data) {
        log.info(data.toString());

        String starName = data.get("starName");
        String newPlanetName = data.get("newPlanetName");
        String newPlanetType = data.get("newPlanetType");

        Star star = astroRepo.findStarByObjectName(starName);
        if (star == null) return null;

        Planet newPlanet = new Planet(newPlanetName);
        newPlanet.setPlanetType(newPlanetType);
        astroRepo.save(newPlanet);

        //String planetName = "Planet " + newPlanetName;
        star.getPlanets().add(newPlanet);
        astroRepo.save(star);
        log.info(star.toString());
        //star.getLocation().put()
        return listAllStars();
    }

    public List<Star> deleteStar(String objectID) {
        log.info(objectID);
        astroRepo.delete(astroRepo.findByObjectID(objectID));
        return listAllStars();
    }

    /*public boolean setStarParams(Star newStar, String starClass, Integer starTemp) {
        newStar.setSpectralClass(starClass);
        newStar.setTemperature(starTemp);
        return objectRepo.sa
        *//*this.spectralClass = starClass;
        this.temperature = starTemp;*//*
    }*/
}
