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

import java.util.List;

import com.google.gwt.junit.client.GWTTestCase;


public class BicTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.github.mvp4g.iban4g.Iban4g";
  }

  public void testBicConstructionWithInvalidCountryCodeShouldThrowException() {
    try {
      Bic.valueOf("DEUTAAFF500");
      assertFalse("UnsupportedCountryException expected",
                  true);
    } catch (UnsupportedCountryException e) {
    }
  }

  public void testBicsWithSameDataShouldBeEqual() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic1,
                 bic2);
  }

  public void testBicsWithDifferentDataShouldNotBeEqual() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF501");

    assertNotSame(bic1,
                  bic2);
  }

  public void testBicsWithStringValueAndBicShouldNotBeEqual() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertNotSame(bic,
                  "DEUTDEFF500");
  }

  public void testBicsWithSameDataShouldHaveSameHashCode() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic1.hashCode(),
                 bic2.hashCode());
  }

  public void testBicsWithDifferentDataShouldNotHaveSameHashCode() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF501");

    assertNotSame(bic1.hashCode(),
                  bic2.hashCode());
  }

  public void testBicShouldReturnBankCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getBankCode(),
                 "DEUT");
  }

  public void testBicShouldReturnCountryCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getCountryCode(),
                 CountryCode.DE);
  }

  public void testBicShouldReturnBranchCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getBranchCode(),
                 "500");
  }

  public void testBicWithoutBrnachCodeShouldReturnNull() {
    Bic bic = Bic.valueOf("DEUTDEFF");

    assertEquals(bic.getBranchCode(),
                 null);
  }

  public void testBicShouldReturnLocationCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getLocationCode(),
                 "FF");
  }

  public void testBicToStringShouldReturnString() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.toString(),
                 "DEUTDEFF500");
  }

  public void testBicConstructionWithValueOfShouldReturnBic() {
    List<String> listOfBics = TestDataHelper.getBicData();
    for (String bic : listOfBics) {
      assertNotNull(Bic.valueOf(bic));
    }
  }
}