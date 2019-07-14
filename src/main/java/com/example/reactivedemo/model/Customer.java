package com.example.reactivedemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Customer extends ResourceSupport {
    @Id
    private Long cid;
    private String name;
    private String surname;
    private String profession;
}
