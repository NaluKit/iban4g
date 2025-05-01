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
package com.github.nalukit.iban4g.shared;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static junit.framework.TestCase.fail;

@J2clTestInput(BicUtilTest.class)
public class BicUtilTest {

  @Test
  public void testBicValidationWithNullShouldThrowException() {
    try {
      BicUtil.validate(null);
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Null can't be a valid Bic")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithEmptyStringShouldThrowException() {
    try {
      BicUtil.validate("");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Empty string can't be a valid Bic")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithLessCharactersShouldThrowException() {
    try {
      BicUtil.validate("DEUTFF");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Bic length must be 8 or 11")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithMoreCharactersShouldThrowException() {
    try {
      BicUtil.validate("DEUTFFDEUTFF");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Bic length must be 8 or 11")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithLowercaseShouldThrowException() {
    try {
      BicUtil.validate("DEUTdeFF");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Bic must contain only upper case letters")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithInvalidBankCodeShouldThrowException() {
    try {
      BicUtil.validate("DEU1DEFF");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Bank code must contain only letters")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithNonExistingCountryCodeShouldThrowException() {
    try {
      BicUtil.validate("DEUTDDFF");
      fail();
    } catch (UnsupportedCountryException e) {
      if (!e.getMessage()
            .contains("Country code 'DD' is not supported.")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithInvalidCountryCodeShouldThrowException() {
    try {
      BicUtil.validate("DEUT_1FF");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Bic country code must contain upper case letters")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithInvalidLocationCodeShouldThrowException() {
    try {
      BicUtil.validate("DEUTDEF ");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Location code must contain only letters or digits")) {
        fail();
      }
    }
  }

  @Test
  public void testBicValidationWithInvalidBranchCodeShouldThrowException() {
    try {
      BicUtil.validate("DEUTDEFF50_");
      fail();
    } catch (BicFormatException e) {
      if (!e.getMessage()
            .contains("Branch code must contain only letters or digits")) {
        fail();
      }
    }
  }
}
