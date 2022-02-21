package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.service.parser.RecursiveNodePrinter;
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
            Node rootNode = builder.parseXML("cart.xml");
            boolean isAppend = !builder.checkFileEmpty("D:\\botanstvo\\java\\JWD_Task03\\src\\main\\resources\\"+"cart2.xml");
            if (isAppend){
                builder.writeXML("D:\\botanstvo\\java\\JWD_Task03\\src\\main\\resources\\"+"cart2.xml",
                        rootNode.getChildNodes().get(0), isAppend);
            } else {
                builder.writeXML("D:\\botanstvo\\java\\JWD_Task03\\src\\main\\resources\\"+"cart2.xml", rootNode, isAppend);
            }

            System.out.println(RecursiveNodePrinter.getNodeForPrint(rootNode));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
