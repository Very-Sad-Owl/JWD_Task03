package by.epam.training.jwd.task03.service.impl;

import by.epam.training.jwd.task03.dao.DaoFactory;
import by.epam.training.jwd.task03.dao.NodeDao;
import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.NodeTreeBuilder;
import by.epam.training.jwd.task03.service.parser.NodeParser;

public class NodeTreeBuilderImpl implements NodeTreeBuilder {
    @Override
    public Node parseXML(String filePath) {
        DaoFactory factory = DaoFactory.getInstance();
        NodeDao dao = factory.getNodeDao();

        NodeParser parser = new NodeParser();

        return parser.parse(dao.getData(filePath));
    }
}
