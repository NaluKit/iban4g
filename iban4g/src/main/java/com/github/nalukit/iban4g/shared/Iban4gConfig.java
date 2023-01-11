/*
 * Copyright © 2020 ${name}
 *
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
package com.github.nalukit.iban4g.shared;

public class Iban4gConfig {

  public static final Iban4gConfig INSTANCE = new Iban4gConfig();

  private ReturnMethod returnMethod;

  private Iban4gConfig() {
    this.returnMethod = ReturnMethod.EXCEPTION;
  }

  public boolean isUsingExcpetion() {
    return this.returnMethod == ReturnMethod.EXCEPTION;
  }

  public boolean isUsingReturnValue() {
    return this.returnMethod == ReturnMethod.RETURN_VALUE;
  }

  public void setReturnMethod(ReturnMethod returnMethod) {
    this.returnMethod = returnMethod;
  }

  public enum ReturnMethod {
    EXCEPTION,
    RETURN_VALUE;
  }
}
