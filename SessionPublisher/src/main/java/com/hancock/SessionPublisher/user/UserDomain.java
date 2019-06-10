package com.hancock.SessionPublisher.user;

import com.hancock.SessionPublisher.intrastructure.utils.IdGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDomain {

    private String id;
    private String email;
    private String securityCode;
    private String name;
    private boolean online;

    public UserDomain(String email, String name, String securityCode) {
        this.id = IdGenerator.newId();
        this.email = email;
        this.name = name;
        this.securityCode = securityCode;
        this.online = false;
    }

    public UserDomain(String id, String email, String name, String securityCode, boolean online) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.securityCode = securityCode;
        this.online = online;
    }

    public UserDomain goOnLine() {
        this.online = true;
        return this;
    }

    public UserDomain goOffline() {
        this.online = false;
        return this;
    }
}
