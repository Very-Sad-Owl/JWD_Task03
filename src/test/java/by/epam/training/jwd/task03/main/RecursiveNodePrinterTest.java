package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.parser.NodeParser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecursiveNodePrinterTest {

    private static Method splitRootNode;

    @BeforeClass
    public static void setUp() throws NoSuchMethodException {
        splitRootNode = RecursiveNodePrinter.class
                .getDeclaredMethod("splitRootNode", Node.class, int.class);
        splitRootNode.setAccessible(true);
    }

    @Test
    public void splitRootNode_withoutAttrs_someString() throws InvocationTargetException, IllegalAccessException {
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
                "note\n" +
                        "\tto Tove\n" +
                        "\ttext\n" +
                        "\t\theading Reminder\n" +
                        "\t\tbody Don't forget me this weekend!";

        String actual = (String)splitRootNode.invoke(splitRootNode, node, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void splitRootNode_withAttrs_someString() throws InvocationTargetException, IllegalAccessException {
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
                "note\n" +
                        "\tto Tove\n" +
                        "\ttext\n" +
                        "\t\theading(lvl = 1) Reminder\n" +
                        "\t\tbody Don't forget me this weekend!";

        String actual = (String)splitRootNode.invoke(splitRootNode, node, 0);

        assertEquals(expected, actual);
    }
}