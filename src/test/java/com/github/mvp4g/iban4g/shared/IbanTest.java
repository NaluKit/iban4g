package com.github.mvp4g.iban4g.shared;

import java.util.Map;

import com.google.gwt.junit.client.GWTTestCase;
import org.junit.Test;

public class IbanTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.github.mvp4g.iban4g.Iban4g";
  }

  public void testIbanConstructionWithSupportedCountriesShouldReturnIban() {
    Map<String, Iban> testData = TestDataHelper.getIbanData();
    for (String expectedIban : testData.keySet()) {
      assertEquals(expectedIban,
                   testData.get(expectedIban)
                           .toString());
    }
  }

  public void testIbansWithSameDataShouldBeEqual() {
    Iban iban1 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();
    Iban iban2 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();

    assertEquals(iban1,
                 iban2);
  }

  public void testIbansWithDifferentDataShouldNotBeEqual() {
    Iban iban1 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();
    Iban iban2 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732011")
                   .build();

    assertNotSame(iban1,
                  iban2);
  }

  public void testIbansWithStringValueAndIbanShouldNotBeEqual() {
    Iban iban1 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("19043")
                   .accountNumber("00234573201")
                   .build();

    assertNotSame("AT611904300234573201",
                  iban1);
  }

  public void testIbanShouldReturnValidCountryCode() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("19043")
                  .accountNumber("00234573201")
                  .build();

    assertEquals(CountryCode.AT,
                 iban.getCountryCode());
  }

  public void testIbanShouldReturnValidBankCode() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("19043")
                  .accountNumber("00234573201")
                  .build();

    assertEquals("19043",
                 iban.getBankCode());
  }

  public void testIbanShouldReturnValidAccountNumber() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("19043")
                  .accountNumber("00234573201")
                  .build();

    assertEquals("00234573201",
                 iban.getAccountNumber());
  }

  public void testIbanShouldReturnValidBranchCode() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AD)
                  .bankCode("0001")
                  .branchCode("2030")
                  .accountNumber("200359100100")
                  .build();

    assertEquals("2030",
                 iban.getBranchCode());
  }

  public void testIbanShouldReturnValidNationalCheckDigit() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AL)
                  .bankCode("212")
                  .branchCode("1100")
                  .nationalCheckDigit("9")
                  .accountNumber("0000000235698741")
                  .build();
    assertEquals("9",
                 iban.getNationalCheckDigit());
  }

  public void testIbanShouldReturnValidAccountType() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.BR)
                  .bankCode("00360305")
                  .branchCode("00001")
                  .accountNumber("0009795493")
                  .accountType("P")
                  .ownerAccountType("1")
                  .build();
    assertEquals("P",
                 iban.getAccountType());
  }

  public void testIbanShouldReturnValidOwnerAccountType() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.BR)
                  .bankCode("00360305")
                  .branchCode("00001")
                  .accountNumber("0009795493")
                  .accountType("P")
                  .ownerAccountType("1")
                  .build();
    assertEquals("1",
                 iban.getOwnerAccountType());
  }

  public void testIbanShouldReturnValidIdentificationNumber() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.IS)
                  .bankCode("0159")
                  .branchCode("26")
                  .accountNumber("007654")
                  .identificationNumber("5510730339")
                  .build();
    assertEquals("5510730339",
                 iban.getIdentificationNumber());
  }

  public void testIbanShouldReturnValidBban() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("19043")
                  .accountNumber("00234573201")
                  .build();

    assertEquals("1904300234573201",
                 iban.getBban());
  }

  public void testIbanShouldReturnValidCheckDigit() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("19043")
                  .accountNumber("00234573201")
                  .build();

    assertEquals("61",
                 iban.getCheckDigit());
  }

  public void testIbansWithSameDataShouldHaveSameHashCode() {
    Iban iban1 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();
    Iban iban2 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();

    assertEquals(iban1.hashCode(),
                 iban2.hashCode());
  }

  public void testIbansWithDifferentDataShouldNotHaveSameHashCode() {
    Iban iban1 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732012")
                   .build();
    Iban iban2 = new Iban.Builder()
                   .countryCode(CountryCode.AT)
                   .bankCode("1904")
                   .accountNumber("102345732011")
                   .build();

    assertNotSame(iban1.hashCode(),
                  iban2.hashCode());
  }

  //
  public void testIbanToFormattedStringShouldHaveSpacesAfterEach4Character() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("1904")
                  .accountNumber("102345732012")
                  .build();
    assertEquals("AT14 1904 1023 4573 2012",
                 iban.toFormattedString());
  }

  public void testIbanConstructionWithShortBankCodeShouldNotThrowExceptionIfValidationIsDisabled() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("1904")
                  .accountNumber("A0234573201")
                  .build(false);
    assertEquals("AT40 1904 A023 4573 201",
                 iban.toFormattedString());
  }

  public void testIbanConstructionWithNoneFormattingShouldReturnIban() {
    Iban iban = Iban.valueOf("AT611904300234573201",
                             IbanFormat.None);
    assertEquals("AT61 1904 3002 3457 3201",
                 iban.toFormattedString());
  }

  @Test
  public void testIbanConstructionWithDefaultFormattingShouldReturnIban() {
    Iban iban = Iban.valueOf("AT61 1904 3002 3457 3201",
                             IbanFormat.Default);
    assertEquals("AT61 1904 3002 3457 3201",
                 iban.toFormattedString());
  }

  public void testIbanConstructionWithNonSupportedCountryShouldThrowException() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AM)
        .bankCode("0001")
        .branchCode("2030")
        .accountNumber("200359100100")
        .build();
      fail();
    } catch (UnsupportedCountryException e) {
    }
  }

  public void testIbanConstructionWithInvalidCountryShouldThrowException() {
    try {
      Iban.valueOf("ZZ018786767");
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithNullStringShouldThrowException() {
    try {
      Iban.valueOf(null);
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithInvalidCheckDigitShouldThrowException() {
    try {
      Iban.valueOf("AT621904300234573201");
      fail();
    } catch (InvalidCheckDigitException e) {
    }
  }

  public void testIbanConstructionWithInvalidBbanCharacterShouldThrowException() {
    try {
      Iban.valueOf("AZ21NABZ000000001370100_1944");
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithDefaultButInvalidFormatShouldThrowException() {
    try {
      Iban.valueOf("AT61 1904 3002 34573201",
                   IbanFormat.Default);
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testFormattedIbanConstructionWithNoneFormatShouldThrowException() {
    try {
      Iban.valueOf("AT61 1904 3002 3457 3201",
                   IbanFormat.None);
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void unformattedIbanConstructionWithDefaultFormatShouldThrowException() {
    try {
      Iban.valueOf("AT611904300234573201",
                   IbanFormat.Default);
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithoutCountryShouldThrowException() {
    try {
      new Iban.Builder()
        .bankCode("0001")
        .branchCode("2030")
        .accountNumber("200359100100")
        .build();
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithoutBankCodeShouldThrowException() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AM)
        .branchCode("2030")
        .accountNumber("200359100100")
        .build();
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithoutAccountNumberShouldThrowException() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AM)
        .bankCode("0001")
        .branchCode("2030")
        .build();
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithInvalidCharacterShouldThrowException() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AT)
        .bankCode("19043")
        .accountNumber("A0234573201")
        .build();
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithShortBankCodeShouldThrowException() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AT)
        .bankCode("1904")
        .accountNumber("A0234573201")
        .build();
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanConstructionWithShortBankCodeShouldThrowExceptionIfValidationRequested() {
    try {
      new Iban.Builder()
        .countryCode(CountryCode.AT)
        .bankCode("1904")
        .accountNumber("A0234573201")
        .build(true);
      fail();
    } catch (IbanFormatException e) {
    }
  }

  public void testIbanContructionRandom() {
    for (int i = 0; i < 100; i++) {
      new Iban.Builder().buildRandom();
      Iban.random();
    }
  }

  public void testIbanContructionRandomAcctRetainsSpecifiedCountry() {
    Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                  .buildRandom();
    assertEquals(CountryCode.AT,
                 iban.getCountryCode());

    iban = Iban.random(CountryCode.AT);
    assertEquals(CountryCode.AT,
                 iban.getCountryCode());
  }

  @Test
  public void testIbanContructionRandomRetainsSpecifiedBankCode() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .bankCode("12345")
                  .buildRandom();
    assertEquals("12345",
                 iban.getBankCode());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteBankAccount() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AT)
                  .accountNumber("12345678901")
                  .buildRandom();
    assertEquals("12345678901",
                 iban.getAccountNumber());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteBranchCode() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AL)
                  .branchCode("1234")
                  .buildRandom();
    assertEquals("1234",
                 iban.getBranchCode());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteNationalCheckDigit() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.AL)
                  .nationalCheckDigit("1")
                  .buildRandom();
    assertEquals("1",
                 iban.getNationalCheckDigit());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteAccountType() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.BR)
                  .accountType("A")
                  .buildRandom();
    assertEquals("A",
                 iban.getAccountType());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteOwnerAccountType() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.BR)
                  .ownerAccountType("C")
                  .buildRandom();
    assertEquals("C",
                 iban.getOwnerAccountType());
  }

  @Test
  public void testIbanContructionRandomDoesNotOverwriteIdentificationNumber() {
    Iban iban = new Iban.Builder()
                  .countryCode(CountryCode.IS)
                  .identificationNumber("1234567890")
                  .buildRandom();
    assertEquals("1234567890",
                 iban.getIdentificationNumber());
  }
}