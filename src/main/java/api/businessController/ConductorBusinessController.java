package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ConductorDto;
import api.entities.Conductor;

public class ConductorBusinessController {

    public String create(ConductorDto conductorDto) {
        Conductor conductor = new Conductor(conductorDto.getNombre(), null);
        DaoFactory.getFactory().getConductorDao().save(conductor);
        return conductor.getId();
    }
}