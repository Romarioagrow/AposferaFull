package aposfera.general.core.astro;

import aposfera.general.core.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "Planets")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Planet extends AstroObject{
    //private final Enum<AstroTypes> objectTYPE = AstroTypes.Planet;
    /*Enum<PlanetTypes> planetType = null;
    Enum<PlanetAtmosphere> atmType = null;*/

    private String planetType, atmType;

    private Double gravity;

    public Planet (String name) {
        super (name, AstroObjectType.PLANET);
    }

    // Спутники объекта
    @OneToMany(fetch = FetchType.EAGER)
    List<Moon> moons = new LinkedList<>();


}
