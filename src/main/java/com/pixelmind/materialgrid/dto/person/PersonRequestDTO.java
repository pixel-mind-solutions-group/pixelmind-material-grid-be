package com.pixelmind.materialgrid.dto.person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequestDTO {

    private Integer personId;
    private String firstName;
    private String lastName;
    private String createdBy;

}
