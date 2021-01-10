package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.parser.NodeParser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecursiveNodePrinterTest {

    @Test
    public void splitRootNode_withoutAttrs_someString() {
        ArrayList<String> data = new ArrayList<>();
        data.add("<note>");
        data.add("<to>Tove</to>");
        data.add("<text>");
        data.add("<heading>Reminder</heading>");
        data.add("<body>Don't forget me this weekend!</body>");
        data.add("</text>");
        data.add("</note>");
        Node node = new NodeParser().parse(data);
        String expected =
                "{ to : Tove }\n" +
                        "{ heading : Reminder }\n" +
                        "{ body : Don't forget me this weekend! }\n";

        String actual = RecursiveNodePrinter.splitRootNode(node, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void splitRootNode_withAttrs_someString() {
        ArrayList<String> data = new ArrayList<>();
        data.add("<note>");
        data.add("<to>Tove</to>");
        data.add("<text>");
        data.add("<heading lvl = \"1\">Reminder</heading>");
        data.add("<body>Don't forget me this weekend!</body>");
        data.add("</text>");
        data.add("</note>");
        Node node = new NodeParser().parse(data);
        String expected =
                "{ to : Tove }\n" +
                        "{ heading((lvl = 1)) : Reminder }\n" +
                        "{ body : Don't forget me this weekend! }\n";

        String actual = RecursiveNodePrinter.splitRootNode(node, 0);
        System.out.println(actual);

        assertEquals(expected, actual);
    }
}