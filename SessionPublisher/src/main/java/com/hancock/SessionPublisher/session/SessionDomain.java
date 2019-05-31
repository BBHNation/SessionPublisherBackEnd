package com.hancock.SessionPublisher.session;

import com.hancock.SessionPublisher.intrastructure.utils.IdGenerator;
import lombok.Getter;

@Getter
public class SessionDomain {
    private String id;
    private String title;
    private String subTitle;
    private int currentStage;
    private int totalStage;
    private boolean published;

    public SessionDomain(String title, String subTitle, int currentStage, int totalStage) {
        this.id = IdGenerator.newId();
        this.title = title;
        this.subTitle = subTitle;
        this.currentStage = currentStage;
        this.totalStage = totalStage;
        this.published = false;
    }

    public void publish() {
        published = true;
    }

    public void gotoNextStage() {
        if (currentStage < totalStage) {
            currentStage ++;
        }
    }

}
