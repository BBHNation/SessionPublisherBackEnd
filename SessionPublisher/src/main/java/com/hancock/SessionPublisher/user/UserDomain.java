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

    public UserDomain(String email, String name, String identityCode) {
        this.id = IdGenerator.newId();
        this.email = email;
        this.name = name;
        this.securityCode = identityCode;
    }

    public UserDomain(String id, String email, String name, String identityCode) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.securityCode = identityCode;
    }
}
