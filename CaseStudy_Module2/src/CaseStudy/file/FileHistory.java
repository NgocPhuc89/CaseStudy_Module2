package CaseStudy.file;


import CaseStudy.object.History;

import java.util.ArrayList;
import java.util.List;



public class FileHistory {
    private final static String file = "history.csv";

    public FileHistory(){}
    public static List<History> fileHistory(){
        List<History> histories = new ArrayList<>();
        List<String> list = OperationFile.read(file);
        for (String read: list) {
            History history = History.fileHistory(read);
            histories.add(history);
        }
        return histories;
    }


    public void add(History history) {

        List<History> histories = fileHistory();
        histories.add(history);
        OperationFile.writer(file, histories);
    }
}
