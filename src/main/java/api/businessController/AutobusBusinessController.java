package api.businessController;

import api.daos.DaoFactory;
import api.dtos.AutobusDto;
import api.entities.Autobus;

public class AutobusBusinessController {

    public String create(AutobusDto autobusDto) {
        Autobus autobus = new Autobus (autobusDto.getCapacidad(), null);
        DaoFactory.getFactory().getAutobusDao().save(autobus);
        return autobus.getId();
    }
}