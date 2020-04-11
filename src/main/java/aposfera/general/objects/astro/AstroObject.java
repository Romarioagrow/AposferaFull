package aposfera.general.objects.astro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
//@AllArgsConstructor
public class AstroObject implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String objectID;

    private String objectType = "unknown";

    private String objectName;

    private Double mass, diameter;

    @OneToMany(fetch = FetchType.EAGER)
    //@MapKeyColumn(name="object_nickname")
    private Map<String, AstroObject> location = new HashMap<String, AstroObject>();

    public AstroObject(String name, String type) {
        this.objectID = UUID.randomUUID().toString();
        this.objectName = name;
        this.objectType = type;
    }
}
