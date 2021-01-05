package by.epam.training.jwd.task03.reader;

import by.epam.training.jwd.task03.exception.NotXmlException;

import java.io.IOException;
import java.util.List;

public interface BasicReader {

    List<String> read() throws IOException, NotXmlException;
}
