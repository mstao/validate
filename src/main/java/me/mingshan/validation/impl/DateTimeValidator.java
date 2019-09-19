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
package me.mingshan.validation.impl;

import me.mingshan.validation.constraints.DateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Check that the character sequence is datetime
 *
 * @author mingshan
 */
public class DateTimeValidator implements ConstraintValidator<DateTime, String> {
    private DateTime dateTime;

    @Override
    public void initialize(DateTime constraintAnnotation) {
        dateTime = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }

        String pattern = dateTime.pattern();
        if (pattern.length() == 0) {
            return true;
        }

        try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }
}
