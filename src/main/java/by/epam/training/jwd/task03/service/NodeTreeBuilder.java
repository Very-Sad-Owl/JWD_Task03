package by.epam.training.jwd.task03.service;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.exception.ServiceException;

public interface NodeTreeBuilder {

    Node parseXML(String filePath) throws ServiceException;
    void writeXML(String filePath, Node node, boolean isActive) throws ServiceException;
    boolean checkFileEmpty(String filePath) throws ServiceException;
}
