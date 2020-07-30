package aposfera.general.objects.astro;

import aposfera.general.objects.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StarSystem extends AstroObject {

    public StarSystem(String name) {
        super (name, AstroObjectType.SYSTEM);
    }

    @OneToMany(fetch = FetchType.EAGER)
    List<Star> stars = new ArrayList<>();




}
