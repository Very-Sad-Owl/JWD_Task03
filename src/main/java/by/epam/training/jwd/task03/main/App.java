package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.NodeTreeBuilder;
import by.epam.training.jwd.task03.service.NodeTreeBuilderFactory;

public class App
{
    public static void main( String[] args )
    {
        NodeTreeBuilderFactory factory = NodeTreeBuilderFactory.getInstance();
        NodeTreeBuilder builder = factory.getBuilder();
        Node rootNode = builder.parseXML("note.xml");
        RecursiveNodePrinter.printNode(rootNode);
    }
}
