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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

@J2clTestInput(CountryCodeTest.class)
public class CountryCodeTest {

  @Test
  public void testGetByCodeWithAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithLowerCaseAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2().toLowerCase());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithUpperCaseAlpha2CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha2().toUpperCase());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithAlpha3CodeShouldReturnCountryCode() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithLowerCaseAlpha3CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3().toLowerCase());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithUpperCaseAlpha3CodeShouldReturnCountry() {
    for (CountryCode code : CountryCode.values()) {
      CountryCode newCode = CountryCode.getByCode(code.getAlpha3().toUpperCase());
      assertEquals(code, newCode);
    }
  }

  @Test
  public void testGetByCodeWithNullCodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode(null);
    assertNull(code);
  }

  @Test
  public void testGetByCodeWith4DigitCodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XXXX");
    assertNull(code);
  }

  @Test
  public void testGetByCodeWithWrongAlpha2CodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XX");
    assertNull(code);
  }

  @Test
  public void testGetByCodeWithWrongAlpha3CodeShouldReturnNull() {
    CountryCode code = CountryCode.getByCode("XXX");
    assertNull(code);
  }

  @Test
  public void testGetNameWithDECodeShouldReturnGermany() {
    assertEquals("Germany", CountryCode.DE.getName());
  }

  @Test
  public void testGetAlpha2WithDECodeShouldReturnGermany() {
    assertEquals("DE", CountryCode.DE.getAlpha2());
  }

  @Test
  public void testGetAlpha3WithDECodeShouldReturnGermany() {
    assertEquals("DEU", CountryCode.DE.getAlpha3());
  }
}
