package api.daos.memory;

import api.daos.DaoFactory;

import api.daos.ConductorDao;

import api.daos.ControlCalidadDao;

public class DaoMemoryFactory extends DaoFactory {

    private ConductorDao conductorDao;

    private ControlCalidadDao controlCalidadDao;

    @Override
    public ConductorDao getConductorDao() {
        if (conductorDao == null) {
            conductorDao = new ConductorDaoMemory();
        }
        return conductorDao;
    }

    @Override
    public ControlCalidadDao getControlCalidadDao() {
        if (controlCalidadDao == null) {
            controlCalidadDao = new ControlCalidadDaoMemory();
        }
        return controlCalidadDao;
    }

}