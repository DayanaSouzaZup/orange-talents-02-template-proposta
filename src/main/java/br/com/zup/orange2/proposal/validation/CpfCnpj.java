package br.com.zup.orange2.proposal.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MyValidator.class)
public @interface CpfCnpj {
	
	 String message() default "Documento inválido!";

	  Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};


}
