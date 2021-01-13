package by.epam.training.jwd.task03.service;

import by.epam.training.jwd.task03.entity.Node;
import by.epam.training.jwd.task03.service.exception.ServiceException;

import java.util.List;

public interface NodeTreeBuilder {

    Node parseXML(String filePath) throws ServiceException;
}
