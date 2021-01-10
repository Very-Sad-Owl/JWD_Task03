package by.epam.training.jwd.task03.service;

import by.epam.training.jwd.task03.service.impl.NodeTreeBuilderImpl;

public class NodeTreeBuilderFactory {

    private static final NodeTreeBuilderFactory instance = new NodeTreeBuilderFactory();
    private final NodeTreeBuilder builder = new NodeTreeBuilderImpl();

    private NodeTreeBuilderFactory(){}

    public static NodeTreeBuilderFactory getInstance() {
        return instance;
    }

    public NodeTreeBuilder getBuilder() {
        return builder;
    }
}
