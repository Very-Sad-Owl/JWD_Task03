package by.epam.training.jwd.task03.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLReader implements BasicReader {
    private String FILE_PATH;

    public XMLReader(){}

    public XMLReader(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public List<String> read() throws IOException {
        List<String> content = new ArrayList<>();
        String line;

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        line = reader.readLine();
        if(line.contains("?xml version")) {
            line = reader.readLine();
        }

        while(line != null) {
            content.add(line);
            line = reader.readLine();
        }

        reader.close();
        fileReader.close();

        return content;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }
}
