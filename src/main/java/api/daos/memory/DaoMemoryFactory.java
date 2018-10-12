package api.daos.memory;

import api.daos.DaoFactory;

import api.daos.ConductorDao;

public class DaoMemoryFactory extends DaoFactory {

    private ConductorDao conductorDao;

    @Override
    public ConductorDao getConductorDao() {
        if (conductorDao == null) {
            conductorDao = new ConductorDaoMemory();
        }
        return conductorDao;
    }
}