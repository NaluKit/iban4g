/*
 * Copyright 2013 Artur Mkrtchyan
 * Modification Copyright 2017 Frank Hossfeld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.mvp4g.iban4g.shared;

import com.google.gwt.junit.client.GWTTestCase;

public class CountryCodeTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.github.mvp4g.iban4g.Iban4g";
  }

  public void testGetByCodeWithAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithLowerCaseAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2()
                                                      .toLowerCase());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithUpperCaseAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2()
                                                      .toUpperCase());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithAlpha3CodeShouldReturnCountryCode() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithLowerCaseAlpha3CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3()
                                                      .toLowerCase());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithUpperCaseAlpha3CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3()
                                                      .toUpperCase());
      assertEquals(code,
                   newCode);
    }
  }

  public void testGetByCodeWithNullCodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode(null);
    assertNull(code);
  }

  public void testGetByCodeWith4DigitCodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XXXX");
    assertNull(code);
  }

  public void testGetByCodeWithWrongAlpha2CodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XX");
    assertNull(code);
  }

  public void testGetByCodeWithWrongAlpha3CodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XXX");
    assertNull(code);
  }

  public void testGetNameWithDECodeShouldReturnGermany() {
    assertEquals("Germany",
                 CountryCode.DE.getName());
  }

  public void testGetAlpha2WithDECodeShouldReturnGermany() {
    assertEquals("DE",
                 CountryCode.DE.getAlpha2());
  }

  public void testGetAlpha3WithDECodeShouldReturnGermany() {
    assertEquals("DEU",
                 CountryCode.DE.getAlpha3());
  }
}
