package com.github.davitavorah.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SearchParamsValidator.class})
public @interface ValidSearchParams {

   String order();

   String[] allowedOrders();

   String message() default "O campo [${validatedValue.order}] não é válido para ordenação. Campos disponíveis: {allowedOrders}.";

   Class<?>[] groups() default { };
    
   Class<? extends Payload>[] payload() default { };

}