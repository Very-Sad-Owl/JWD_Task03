package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Node;

import static by.epam.training.jwd.task03.constant.Pattern.*;

public class RecursiveNodePrinter {
// не печатает атрибуты
    public static String splitRootNode(Node rootNode, int innerLvl) {
        StringBuilder result = new StringBuilder();

        if(rootNode.getChildNodes() == null) {
            result.append(String.format(OUTPUT_ELEMENT_PATTERN, rootNode.getName(), rootNode.getContent()));
        } else {
            for(Node childNode : rootNode.getChildNodes()) {
                innerLvl++;
                result.append(splitRootNode(childNode, innerLvl));
                innerLvl--;
            }
        }
        return result.toString();
    }

    public static void printNode(Node node) {
        System.out.println(splitRootNode(node, 0));
    }
}
