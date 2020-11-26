package aposfera.general.core.tech;

import aposfera.general.core.tech.types.ObjectPurpose;
import aposfera.general.core.tech.types.TechType;
import lombok.Data;

@Data
public class TechObject {

    protected String objectName;

    protected TechType techType;

    protected ObjectPurpose objectPurpose;

}
