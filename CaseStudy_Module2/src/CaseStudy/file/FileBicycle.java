package CaseStudy.file;

import CaseStudy.object.Bicycle;

import java.util.ArrayList;
import java.util.List;

public class FileBicycle {
    private final static String path = "bicycle.csv";

    public FileBicycle(){}

    public static List<Bicycle> fileData(){
        List<Bicycle> bicycles = new ArrayList<>();
        List<String> list = OperationFile.read(path);
        for (String read: list) {
            Bicycle bicycle = Bicycle.fileBicycle(read);
            bicycles.add(bicycle);
        }
        return bicycles;
    }

    public void add(Bicycle bicycle) {
        List<Bicycle> bicycles = fileData();
        bicycles.add(bicycle);
        OperationFile.writer(path, bicycles);
    }

    public static void updateListBicycle(List<Bicycle> bicycles, List<String> strings){
        for (Bicycle find: bicycles) {
            String update = find.getIdBi() + "," + find.getUsing() + "," + find.getNotUse();
            strings.add(update);
        }
        OperationFile.writer(path,strings);
    }


}
