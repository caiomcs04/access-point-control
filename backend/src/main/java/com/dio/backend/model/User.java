package com.dio.backend.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*Anotation from lombok plugin*/
@Getter /*Create get method for all atributes*/
@Setter /*Create set method for all atributes*/
@AllArgsConstructor /*Create the constructor with all args*/
@NoArgsConstructor /*Create the constructor with no args*/
@EqualsAndHashCode /*Override methods*/
@Builder
/*Anotatiom end*/

/*As an option there is @Data from lombok plugin. this will do all those anotation.
 * But is better to read more about thar tool before use it*/

@Entity
@Audited
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    private UserCategory userCategory;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private Workday workday;


    private BigDecimal tolerance;
    private LocalDateTime entrance;
    private LocalDateTime exit;
}
