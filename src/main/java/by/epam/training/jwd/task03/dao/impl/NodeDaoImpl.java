package by.epam.training.jwd.task03.dao.impl;

import by.epam.training.jwd.task03.dao.NodeDao;
import by.epam.training.jwd.task03.dao.preedit.SplitterByTags;
import by.epam.training.jwd.task03.dao.reader.XMLReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeDaoImpl implements NodeDao {
    @Override
    public List<String> getData(String filePath) {
        List<String> data = new ArrayList<>();
        XMLReader reader = new XMLReader(filePath);
        try {
            SplitterByTags splitter = new SplitterByTags();
            data = splitter.split(reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
