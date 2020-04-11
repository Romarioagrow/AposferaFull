package aposfera.repos;

import aposfera.general.objects.astro.AstroObject;
import aposfera.general.objects.astro.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepo extends JpaRepository<AstroObject, String> {

    List<Star> findAllByObjectType(String type);

    Star findStarByObjectName(String name);

}
