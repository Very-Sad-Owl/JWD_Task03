package by.epam.training.jwd.task03.dao;

import by.epam.training.jwd.task03.dao.exception.DAOException;
import by.epam.training.jwd.task03.entity.Node;

import java.util.List;

public interface NodeDao {

    List<String> getData(String filePath) throws DAOException;
    void writeData(String filePath, String content, boolean isActive) throws DAOException;
    boolean isFileEmpty(String filePath) throws DAOException;
}
