package com.hancock.SessionPublisher.intrastructure.session;

import com.hancock.SessionPublisher.session.SessionDomain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "sessions")
public class SessionEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "current_stage")
    private int currentStage;

    @Column(name = "total_stage")
    private int totalStage;

    @Column(name = "published")
    private boolean published;

    public SessionEntity(SessionDomain domain) {
        this.id = domain.getId();
        this.title = domain.getTitle();
        this.subTitle = domain.getSubTitle();
        this.currentStage = domain.getCurrentStage();
        this.totalStage = domain.getTotalStage();
        this.published = domain.isPublished();
    }

    public SessionDomain mapToDomain() {
        return new SessionDomain(this.title, this.subTitle, this.currentStage, this.totalStage)
            .bindId(this.id)
            .bindPublishStatus(this.isPublished());
    }
}
