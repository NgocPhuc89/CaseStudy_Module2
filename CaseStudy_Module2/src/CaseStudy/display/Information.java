package CaseStudy.display;

import CaseStudy.display.Display;

public class Information {
    private String title ;

    private Display[] informationDetails;

    public Information(String title, Display[] informationDetails) {
        this.title = title;
        this.informationDetails = informationDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Display[] getInformationDetails() {
        return informationDetails;
    }

    public void setInformationDetails(Display[] informationDetails) {
        this.informationDetails = informationDetails;
    }
}
