package com.example.reactivedemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.Identifiable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Customer implements Identifiable<Long> {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String profession;
}
