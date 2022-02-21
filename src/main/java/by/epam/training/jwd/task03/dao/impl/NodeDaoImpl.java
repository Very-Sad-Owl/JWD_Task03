package by.epam.training.jwd.task03.dao.impl;

import by.epam.training.jwd.task03.dao.NodeDao;
import by.epam.training.jwd.task03.dao.exception.DAOException;
import by.epam.training.jwd.task03.dao.reader.impl.SplitterByTags;
import by.epam.training.jwd.task03.dao.reader.XMLReader;
import by.epam.training.jwd.task03.dao.writer.XMLWriter;

import java.io.IOException;
import java.util.List;

public class NodeDaoImpl implements NodeDao {
    @Override
    public List<String> getData(String filePath) throws DAOException {
        List<String> data;
        XMLReader reader = new XMLReader(filePath);
        try {
            SplitterByTags splitter = new SplitterByTags();
            data = splitter.split(reader.read());
        } catch (IOException e) {
            throw new DAOException("DAO Exception was occurred", e);
        }
        return data;
    }

    @Override
    public void writeData(String filePath, String content, boolean isAppend) throws DAOException {
        XMLWriter writer = new XMLWriter(filePath);
        try{
            writer.write(content, isAppend);
        } catch (IOException e) {
            throw new DAOException("DAO Exception was occurred", e);
        }
    }

    @Override
    public boolean isFileEmpty(String filePath) throws DAOException {
        XMLWriter writer = new XMLWriter(filePath);
        try {
            return writer.isFileEmpty();
        } catch (IOException e) {
            throw new DAOException("DAO Exception was occurred", e);
        }
    }
}
