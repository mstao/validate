/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.mingshan.validation.constraints;

import me.mingshan.validation.impl.DateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author mingshan
 */
@Documented
@Constraint(validatedBy = { DateTimeValidator.class })
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface DateTime {

    String message() default "不符合的时间格式";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String pattern() default"yyyy-MM-dd HH:mm:ss";

    /**
     * Defines several {@link Digits} annotations on the same element.
     *
     * @see Digits
     */
    @Target({ FIELD, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Digits[] value();
    }
}
