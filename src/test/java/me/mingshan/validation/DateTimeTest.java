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
package me.mingshan.validation;

import me.mingshan.validation.constraints.DateTime;
import me.mingshan.validation.util.ValidatorUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author mingshan
 */
public class DateTimeTest {

    @Test
    public void test1() {
        InnerBean bean = new InnerBean();
        bean.setDate("2019-11-11 12:00:");
        ValidatorUtil.result(bean);
        assertTrue( true );
    }


    class InnerBean {
        @DateTime
        private String date;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

}
