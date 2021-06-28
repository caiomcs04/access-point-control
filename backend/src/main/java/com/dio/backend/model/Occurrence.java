package com.dio.backend.model;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Occurrence {
    @Id
    private long id;
    private String name;
    private String description;
}
