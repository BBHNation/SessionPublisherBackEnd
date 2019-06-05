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
    private String creatorId;

    public SessionDomain(String title, String subTitle, int currentStage, int totalStage, String creatorId) {
        this.id = IdGenerator.newId();
        this.title = title;
        this.subTitle = subTitle;
        this.currentStage = currentStage;
        this.totalStage = totalStage;
        this.published = false;
        this.creatorId = creatorId;
    }

    public SessionDomain bindId(String id) {
        this.id = id;
        return this;
    }
    public SessionDomain bindPublishStatus(Boolean published) {
        this.published = published;
        return this;
    }

    public SessionDomain publish() {
        this.published = true;
        return this;
    }

    public SessionDomain gotoNextStage() {
        if (currentStage < totalStage) {
            currentStage ++;
        }
        return this;
    }

}
