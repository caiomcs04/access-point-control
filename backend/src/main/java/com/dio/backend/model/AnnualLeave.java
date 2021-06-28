package com.dio.backend.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class AnnualLeave {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class AnnualLeaveId implements Serializable {
        private Long idOrder;
        private Long idUser;
        private Long idAnnualLeave;
    }

    @EmbeddedId
    @Id
    private AnnualLeaveId id;

    private LocalDateTime workDay;
    private BigDecimal workedHours;
    private BigDecimal hoursBalance;

}
