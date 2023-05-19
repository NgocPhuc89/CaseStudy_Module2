package CaseStudy.display;

public class Display {
    private int no;
    private String description;

    public Display(int no, String description) {
        this.no = no;
        this.description = description;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
