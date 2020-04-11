package aposfera.controllers;

import aposfera.general.objects.astro.AstroObject;
import aposfera.general.objects.astro.Star;
import aposfera.services.ObjectService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log
@RestController
@AllArgsConstructor
@RequestMapping("/api/general")
public class MainController {
    private final ObjectService objectService;

    @GetMapping("/astro/star")
    private List<Star> listAllStars() {
        return objectService.listAllStars();
    }

    @PostMapping("/astro/star/addPlanet")
    private List<Star> addNewPlanetToStar(@RequestBody Map<String, String> data) {
        return objectService.addNewPlanetToStar(data);
    }

    @PostMapping("/astro/star/new")
    private List<Star> addNewStar(@RequestBody Map<String, String> data) {
        return objectService.addNewStar(data);
    }

    @PostMapping("/astro/star/delete")
    private List<Star> deleteStar(@RequestBody String objectID) {
        return objectService.deleteStar(objectID);
    }


}
