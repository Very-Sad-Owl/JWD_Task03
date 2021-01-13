package by.epam.training.jwd.task03.dao;

import by.epam.training.jwd.task03.dao.exception.DAOException;

import java.util.List;

public interface NodeDao {

    List<String> getData(String filePath) throws DAOException;
}
