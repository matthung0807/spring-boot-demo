package com.abc.demo.controller.validation.annotation;

import com.abc.demo.controller.validation.validator.PasswordValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {

    String message() default "密碼格式錯誤"; // 預設驗證錯誤訊息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
