package de.gishmo.gwt.iban4g.shared;

import com.google.gwt.junit.client.GWTTestCase;

public class CountryCodeTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "de.gishmo.gwt.iban4g.Iban4g";
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
