package CaseStudy.object;

import CaseStudy.file.FileBicycle;

public class Bicycle {
    private long idBi;
    private int using = 0;
    private int notUse;
    private int totalBicycle = 100;

    public  Bicycle(){}

    public static Bicycle fileBicycle(String newBicycle){
        String [] data = newBicycle.split(",");
        long id = Long.parseLong(data[0]);
        int using = Integer.parseInt(data[1]);
        int notUse = Integer.parseInt(data[2]);
        Bicycle bicycle = new Bicycle()
                .setIdBi(id)
                .setUsing(using)
                .setNotUse(notUse);

        return bicycle;
    }

    public long getIdBi() {
        return idBi;
    }

    public Bicycle setIdBi(long id) {
        this.idBi = id;
        return  this;
    }

    public int getUsing() {
        return using;
    }

    public Bicycle setUsing(int using) {
        this.using = using;
        return this;
    }

    public  int getNotUse() {
        int num= 0;
        int notUse;
        for (Bicycle bicycle: FileBicycle.fileData()) {
            num += bicycle.getUsing();
        }
        notUse = totalBicycle - num;
        return notUse;
    }

    public Bicycle setNotUse(int notUse) {
        this.notUse = notUse;
        return this;
    }

    public int getTotalBicycle() {
        return  this.totalBicycle ;
    }

    public Bicycle setTotalBicycle(int totalBicycle) {
        this.totalBicycle = totalBicycle;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",idBi,using,notUse);
    }
}

