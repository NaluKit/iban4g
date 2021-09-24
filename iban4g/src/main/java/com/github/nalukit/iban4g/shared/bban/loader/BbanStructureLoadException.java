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
package com.github.nalukit.iban4g.shared.bban.loader;

import com.github.nalukit.iban4g.shared.Iban4gException;

/**
 * Thrown to indicate that the application has attempted to convert a string to Iban, but that the
 * string does not have the appropriate format.
 */
public class BbanStructureLoadException
    extends Iban4gException {

  /**
   * Constructs a <code>IbanFormatException</code> with no detail message.
   */
  public BbanStructureLoadException() {
    super();
  }

  /**
   * Constructs a <code>IbanFormatException</code> with the specified detail message.
   *
   * @param s the detail message.
   */
  public BbanStructureLoadException(final String s) {
    super(s);
  }

}
