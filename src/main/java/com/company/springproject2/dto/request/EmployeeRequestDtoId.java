package com.company.springproject2.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestDtoId {
    Long id;
    String name;
    String surname;
    String email;
    Integer salary;
}
