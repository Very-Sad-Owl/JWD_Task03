package by.epam.training.jwd.task03.dao.writer;

import java.io.*;

public class XMLWriter {

    private String filePath;

    public XMLWriter(){}

    public XMLWriter(String fileName) {
        this.filePath = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void write(String txtContent, boolean append) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(filePath);

        FileWriter fwriter = new FileWriter(file, true);
        BufferedWriter bfwriter = new BufferedWriter(fwriter);

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        StringBuilder newConent = new StringBuilder();
        boolean flag = true;
        if (append) {
            String line;
            while ((line = br.readLine()) != null) {
                newConent.append(line);
                if (line.contains("<") && flag){
                    newConent.append(System.lineSeparator());
                    newConent.append("\t" + txtContent);
                    flag = false;
                }
                newConent.append(System.lineSeparator());
            }
            bfwriter.close();
            fwriter = new FileWriter(file, false);
            bfwriter = new BufferedWriter(fwriter);
            bfwriter.write(newConent.toString());
        } else {
            bfwriter.write(txtContent);
        }
        bfwriter.flush();
        bfwriter.close();
        br.close();
    }

    public boolean isFileEmpty() throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isBlank()){
                br.close();
                return false;
            }
        }
        br.close();
        return true;
    }
}
