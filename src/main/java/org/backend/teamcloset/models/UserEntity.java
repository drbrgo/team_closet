package org.backend.teamcloset.models;

import jakarta.persistence.*;
import org.backend.teamcloset.models.dto.Role;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {


    private String username;

    private String password;

    //maybe does not need to reference a role entity of enum type?
    //private Role role;

    private Role role;

}
