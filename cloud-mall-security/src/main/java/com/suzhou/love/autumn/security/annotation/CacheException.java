/**
 * Copyright (c) 2019-2020
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.suzhou.love.autumn.security.annotation;

import java.lang.annotation.*;

/**
 * @InterfaceName: CacheException
 * @Description: 自定义注解，有该注解的缓存方法会抛出异常
 * @Author: chendq
 * @Date: 2020/5/20 15:25
 * @Version: 1.0
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
