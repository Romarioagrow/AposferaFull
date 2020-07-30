package aposfera.general.objects.astro;

import aposfera.general.objects.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Galaxies")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Galaxy extends AstroObject {

    public Galaxy(String name) {
        super (name, AstroObjectType.GALAXY);
    }

    @OneToMany(fetch = FetchType.EAGER)
    Set<StarSystem> stars = new LinkedHashSet<>();

}
