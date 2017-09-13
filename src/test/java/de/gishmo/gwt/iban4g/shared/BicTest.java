package de.gishmo.gwt.iban4g.shared;

import com.google.gwt.junit.client.GWTTestCase;

import java.util.List;


public class BicTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "de.gishmo.gwt.iban4g.Iban4g";
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