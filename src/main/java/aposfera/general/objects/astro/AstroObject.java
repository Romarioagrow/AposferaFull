package aposfera.general.objects.astro;

import aposfera.general.objects.astro.enums.AstroObjectType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class AstroObject implements Locatable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String objectID;

    private AstroObjectType objectType = AstroObjectType.UNKNOWN;

    private String objectName;

    private Double mass, diameter, age;


    /*@OneToMany(fetch = FetchType.EAGER)
    //@MapKeyColumn(name="object")
    private Map<String, AstroObject> location = new HashMap<String, AstroObject>();*/

    public AstroObject(String name, AstroObjectType type) {
        this.objectID = UUID.randomUUID().toString();
        this.objectName = name;
        this.objectType = type;
    }
}
