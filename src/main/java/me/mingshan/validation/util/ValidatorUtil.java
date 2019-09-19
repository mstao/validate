package me.mingshan.validation.util;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


public class ValidatorUtil {


    /**
     * 配置hibernate_validator和快速失败模式
     */
    private static Validator validator =
            Validation.byProvider(HibernateValidator.class)
                    .configure()
                    .failFast(true)
                    .buildValidatorFactory()
                    .getValidator();


    /**
     * 参数校验，若未匹配约束，则通过已将将之前定义的`message`抛出
     * @param object 参数
     * @param groups 属于组
     */
    public static void result(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations =
                validator.validate(object, groups);
        if (constraintViolations.size() > 0) {
            String message = constraintViolations.iterator().next().getMessage();
            throw new RuntimeException(message);
        }
    }
}