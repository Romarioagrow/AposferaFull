package aposfera.general.objects.astro;

import aposfera.general.objects.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Moon extends AstroObject {

    private Double rotationTIME, planetDISTANCE;

    public Moon (String name) {
        super (name, AstroObjectType.MOON); /// AstroTypes.Moon
    }



}
