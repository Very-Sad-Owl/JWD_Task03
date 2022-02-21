package by.epam.training.jwd.task03.service.impl;

import by.epam.training.jwd.task03.dao.DaoFactory;
import by.epam.training.jwd.task03.dao.NodeDao;
import by.epam.training.jwd.task03.dao.exception.DAOException;
import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.NodeTreeBuilder;
import by.epam.training.jwd.task03.service.exception.ServiceException;
import by.epam.training.jwd.task03.service.parser.NodeParser;
import by.epam.training.jwd.task03.service.parser.RecursiveNodePrinter;

public class NodeTreeBuilderImpl implements NodeTreeBuilder {

    private static final DaoFactory factory = DaoFactory.getInstance();

    @Override
    public Node parseXML(String filePath) throws ServiceException {
        NodeDao dao = factory.getNodeDao();
        NodeParser parser = new NodeParser();
        try {
            return parser.parse(dao.getData(filePath));
        } catch (DAOException e) {
            throw new ServiceException("Service exception was occurred.");
        }
    }

    @Override
    public void writeXML(String filePath, Node node, boolean isActive) throws ServiceException {
        NodeDao dao = factory.getNodeDao();
        try {
            String content = RecursiveNodePrinter.getNodeForPrint(node);
            dao.writeData(filePath, content, isActive);
        } catch (DAOException e) {
            throw new ServiceException("Service exception was occurred.");
        }
    }

    @Override
    public boolean checkFileEmpty(String filePath) throws ServiceException {
        NodeDao dao = factory.getNodeDao();
        try {
            return dao.isFileEmpty(filePath);
        } catch (DAOException e) {
            throw new ServiceException("Service exception was occurred.");
        }
    }
}
