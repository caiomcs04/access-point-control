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
public class Operation {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class OperationId implements Serializable {
        private Long idOrder;
        private Long idUser;
    }

    @EmbeddedId
    @Id
    @GeneratedValue
    private OperationId id;

    private LocalDateTime entrance;
    private LocalDateTime exit;
    private BigDecimal workTime;
    private String description;

    @OneToOne
    private Occurrence occurrence;

    @OneToOne
    private Calendar calendar;

}
