package aposfera.general.objects.astro;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public interface Locatable extends Serializable {

    @OneToMany(fetch = FetchType.EAGER)
    //@MapKeyColumn(name="object")
    Map<String, AstroObject> location = new HashMap<String, AstroObject>();


    static void getLocation(AstroObject astroObject) {

    }

    static void objectInfo() {

    }

}
