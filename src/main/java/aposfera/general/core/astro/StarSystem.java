package aposfera.general.core.astro;

import aposfera.general.core.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "StarSystems")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StarSystem extends AstroObject {

    public StarSystem(String name) {
        super (name, AstroObjectType.SYSTEM);
    }

    @OneToMany(fetch = FetchType.EAGER)
    List<Star> stars = new ArrayList<>();




}
