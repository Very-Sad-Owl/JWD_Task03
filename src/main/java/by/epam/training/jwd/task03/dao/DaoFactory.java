package by.epam.training.jwd.task03.dao;

import by.epam.training.jwd.task03.dao.impl.NodeDaoImpl;

public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final NodeDao nodeDao = new NodeDaoImpl();

    private DaoFactory(){}

    public NodeDao getNodeDao(){
        return nodeDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
