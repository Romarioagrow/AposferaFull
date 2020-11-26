package aposfera.general.core.astro;

import aposfera.general.core.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Moons")
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Moon extends AstroObject {

    private Double rotationTIME, planetDISTANCE;

    public Moon (String name) {
        super (name, AstroObjectType.MOON); /// AstroTypes.Moon
    }
}
