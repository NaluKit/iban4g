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

import static junit.framework.TestCase.*;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.List;
import org.junit.Test;

@J2clTestInput(BicTest.class)
public class BicTest {

  @Test
  public void testBicConstructionWithInvalidCountryCodeShouldThrowException() {
    try {
      Bic.valueOf("DEUTAAFF500");
      fail("UnsupportedCountryException expected");
    } catch (UnsupportedCountryException e) {
    }
  }

  @Test
  public void testBicsWithSameDataShouldBeEqual() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic1, bic2);
  }

  @Test
  public void testBicsWithDifferentDataShouldNotBeEqual() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF501");

    assertNotSame(bic1, bic2);
  }

  @Test
  public void testBicsWithStringValueAndBicShouldNotBeEqual() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertNotSame(bic, "DEUTDEFF500");
  }

  @Test
  public void testBicsWithSameDataShouldHaveSameHashCode() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic1.hashCode(), bic2.hashCode());
  }

  @Test
  public void testBicsWithDifferentDataShouldNotHaveSameHashCode() {
    Bic bic1 = Bic.valueOf("DEUTDEFF500");
    Bic bic2 = Bic.valueOf("DEUTDEFF501");

    assertNotSame(bic1.hashCode(), bic2.hashCode());
  }

  @Test
  public void testBicShouldReturnBankCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getBankCode(), "DEUT");
  }

  @Test
  public void testBicShouldReturnCountryCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getCountryCode(), CountryCode.DE);
  }

  @Test
  public void testBicShouldReturnBranchCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getBranchCode(), "500");
  }

  @Test
  public void testBicWithoutBrnachCodeShouldReturnNull() {
    Bic bic = Bic.valueOf("DEUTDEFF");

    assertEquals(bic.getBranchCode(), null);
  }

  @Test
  public void testBicShouldReturnLocationCode() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getLocationCode(), "FF");
  }

  @Test
  public void testBicToStringShouldReturnString() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.toString(), "DEUTDEFF500");
  }

  @Test
  public void testBicConstructionWithValueOfShouldReturnBic() {
    List<String> listOfBics = TestDataHelper.getBicData();
    for (String bic : listOfBics) {
      assertNotNull(Bic.valueOf(bic));
    }
  }

  @Test
  public void bicShouldReturnBic8Code() {
    Bic bic = Bic.valueOf("DEUTDEFF500");

    assertEquals(bic.getBic8(), "DEUTDEFF");
  }
}
