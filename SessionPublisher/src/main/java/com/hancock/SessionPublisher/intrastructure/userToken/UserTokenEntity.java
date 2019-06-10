package com.hancock.SessionPublisher.intrastructure.userToken;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tokens")
public class UserTokenEntity {
    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "TOKEN")
    private String content;

    @Column(name = "EXPIRE_TIME")
    private Timestamp expireTime;
}
