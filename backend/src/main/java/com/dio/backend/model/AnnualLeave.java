package com.dio.backend.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
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
public class AnnualLeave {

    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime workDay;
    private BigDecimal workedHours;
    private BigDecimal hoursBalance;

    @OneToOne
    private User user;

}
