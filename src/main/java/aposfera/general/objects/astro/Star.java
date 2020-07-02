package aposfera.general.objects.astro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Star extends AstroObject {
    //private final String = "Star";

    private String spectralClass;
    private Double age;
    private Integer temperature;

    public Star (String name) {
        super (name, "star");
    }

    @OneToMany(fetch = FetchType.EAGER)
    List<Planet> planets = new LinkedList<>();





    /*public void setStarParams(String starClass, Integer starTemp) {
        this.spectralClass = starClass;
        this.temperature = starTemp;
    }*/
    //LinkedList<Planet> planets = new LinkedList<>();
}
