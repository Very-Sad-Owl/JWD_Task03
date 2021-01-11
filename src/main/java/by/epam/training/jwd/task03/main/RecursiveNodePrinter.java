package by.epam.training.jwd.task03.main;

import by.epam.training.jwd.task03.entity.Attribute;
import by.epam.training.jwd.task03.entity.Node;

import java.util.List;

import static by.epam.training.jwd.task03.constant.Pattern.*;

class RecursiveNodePrinter {

    private static String splitRootNode(Node rootNode, int innerLvl) {
        StringBuilder result = new StringBuilder();

        result.append(calculateTabulation(innerLvl));
        result.append(rootNode.getName());
        if(rootNode.getChildNodes() == null) {
            result.append(attributesToFormattedString(rootNode.getAttributes()));
            result.append(" ");
            result.append(rootNode.getContent());
        } else {
            for(Node childNode : rootNode.getChildNodes()) {
                innerLvl++;
                result.append("\n");
                result.append(splitRootNode(childNode, innerLvl));
                innerLvl--;
            }
        }
        return result.toString();
    }

    private static String attributesToFormattedString(List<Attribute> attributes) {
        StringBuilder attrs = new StringBuilder();
        if (attributes != null) {
            for (Attribute attribute : attributes) {
                attrs.append(String.format(ATTRIBUTE_PATTERN, attribute.getName(), attribute.getContent()));
            }
        }
        return attrs.toString();
    }


    private static String calculateTabulation(int lvl) {
        StringBuilder tabulation = new StringBuilder();
        for (int i = 0 ; i < lvl ; i++) {
            tabulation.append("\t");
        }
        return tabulation.toString();
    }

    static void printNode(Node node) {
        System.out.println(splitRootNode(node, 0));
    }

}
