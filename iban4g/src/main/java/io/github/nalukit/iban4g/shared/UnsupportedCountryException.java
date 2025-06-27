/*
 * Copyright © 2020 Frank Hossfeld, Philipp Kohl
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
package io.github.nalukit.iban4g.shared;

/**
 * Thrown to indicate that requested country is not supported.
 */
public class UnsupportedCountryException
    extends Iban4gException {

  private static final long serialVersionUID = -3733353745417164234L;

  private String countryCode;

  /**
   * Constructs a <code>UnsupportedCountryException</code> with no detail message and cause.
   */
  public UnsupportedCountryException() {
    super();
  }

  /**
   * Constructs a <code>UnsupportedCountryException</code> with the specified country code and
   * detail message.
   *
   * @param countryCode the country code.
   */
  public UnsupportedCountryException(String countryCode) {
    super("Country code '" + countryCode + "' is not supported.");
    this.countryCode = countryCode;
  }

  /**
   * Constructs a <code>UnsupportedCountryException</code> with the specified detail message and
   * cause.
   *
   * @param s the detail message.
   * @param t the cause.
   */
  public UnsupportedCountryException(final String s,
                                     final Throwable t) {
    super(s,
          t);
  }

  /**
   * Constructs a <code>UnsupportedCountryException</code> with the specified cause.
   *
   * @param t the cause.
   */
  public UnsupportedCountryException(final Throwable t) {
    super(t);
  }

  public String getCountryCode() {
    return countryCode;
  }
}
