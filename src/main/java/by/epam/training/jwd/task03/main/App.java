package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.NodeTreeBuilder;
import by.epam.training.jwd.task03.service.NodeTreeBuilderFactory;
import by.epam.training.jwd.task03.service.exception.ServiceException;

public class App
{
    public static void main( String[] args )
    {
        try {
            NodeTreeBuilderFactory factory = NodeTreeBuilderFactory.getInstance();
            NodeTreeBuilder builder = factory.getBuilder();
            Node rootNode = builder.parseXML("note2.xml");
            RecursiveNodePrinter.printNode(rootNode);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
