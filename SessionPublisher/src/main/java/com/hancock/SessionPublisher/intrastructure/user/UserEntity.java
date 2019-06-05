package com.hancock.SessionPublisher.intrastructure.user;

import com.hancock.SessionPublisher.user.UserDomain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "security_code")
    private String securityCode;

    public UserDomain mapToDomain() {
        return new UserDomain(id, email, name, securityCode);
    }

    public UserEntity(UserDomain domain) {
        this.id = domain.getId();
        this.email = domain.getEmail();
        this.name = domain.getName();
        this.securityCode = domain.getSecurityCode();
    }
}
