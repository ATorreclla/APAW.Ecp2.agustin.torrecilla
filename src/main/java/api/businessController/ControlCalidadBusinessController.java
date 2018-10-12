package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ControlCalidadDto;
import api.entities.ControlCalidad;

public class ControlCalidadBusinessController {

    public String create(ControlCalidadDto controlCalidadDto) {
        ControlCalidad controlCalidad = new ControlCalidad(controlCalidadDto.getTexto(), null);
        DaoFactory.getFactory().getControlCalidadDao().save(controlCalidad);
        return controlCalidad.getId();
    }
}