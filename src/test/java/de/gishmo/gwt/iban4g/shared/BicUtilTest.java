package de.gishmo.gwt.iban4g.shared;

import com.google.gwt.junit.client.GWTTestCase;

public class BicUtilTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "de.gishmo.gwt.iban4g.Iban4g";
  }

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

  public void testBicValidationWithNonExistingCountryCodeShouldThrowException() {
    try {
      BicUtil.validate("DEUTDDFF");
      fail();
    } catch (UnsupportedCountryException e) {
      if (!e.getMessage()
            .contains("Country code is not supported")) {
        fail();
      }
    }
  }

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
