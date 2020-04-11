package aposfera.general.objects.astro;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Planet extends AstroObject{
    //private final Enum<AstroTypes> objectTYPE = AstroTypes.Planet;
    /*Enum<PlanetTypes> planetType = null;
    Enum<PlanetAtmosphere> atmType = null;*/

    private String planetType, atmType;

    private Double gravity;

    public Planet (String name) {
        super (name, "Planet");
    }
}
