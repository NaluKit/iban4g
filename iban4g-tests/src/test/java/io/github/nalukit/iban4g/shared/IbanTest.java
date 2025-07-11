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

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Enclosed.class)
public class IbanTest {

  @RunWith(Parameterized.class)
  public static class IbanGenerationTest1 {

    private final Iban   iban;
    private final String expectedIbanString;

    public IbanGenerationTest1(Iban iban,
                               String expectedIbanString) {
      this.iban               = iban;
      this.expectedIbanString = expectedIbanString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> ibanParameters() {
      return TestDataHelper.getIbanData();
    }

    @Test
    public void ibanConstructionWithSupportedCountriesShouldReturnIban() {
      assertThat(iban.toString(),
                 is(equalTo(expectedIbanString)));
    }

    @Test
    public void ibanConstructionWithValueOfShouldReturnIban() {
      assertThat(Iban.valueOf(expectedIbanString),
                 is(equalTo(iban)));
    }
  }



  public static class IbanGenerationTest2 {

    @Test
    public void ibansWithSameDataShouldBeEqual() {
      Iban iban1 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732012")
                                     .build();
      Iban iban2 = Iban.builder()
                       .countryCode(CountryCode.AT)
                       .bankCode("1904")
                       .accountNumber("102345732012")
                       .build();

      assertThat(iban1,
                 is(equalTo(iban2)));
    }

    @Test
    public void ibansWithDifferentDataShouldNotBeEqual() {
      Iban iban1 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732012")
                                     .build();
      Iban iban2 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732011")
                                     .build();

      assertThat(iban1,
                 is(not(equalTo(iban2))));
    }

    @Test
    public void ibansWithStringValueAndIbanShouldNotBeEqual() {
      Iban iban1 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("19043")
                                     .accountNumber("00234573201")
                                     .build();

      assertNotEquals(iban1,
                      "AT611904300234573201");
    }

    @Test
    public void ibanShouldReturnValidCountryCode() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("19043")
                                    .accountNumber("00234573201")
                                    .build();

      assertThat(iban.getCountryCode(),
                 is(equalTo(CountryCode.AT)));
    }

    @Test
    public void ibanShouldReturnValidBankCode() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("19043")
                                    .accountNumber("00234573201")
                                    .build();

      assertThat(iban.getBankCode(),
                 is(equalTo("19043")));
    }

    @Test
    public void ibanShouldReturnValidAccountNumber() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("19043")
                                    .accountNumber("00234573201")
                                    .build();

      assertThat(iban.getAccountNumber(),
                 is(equalTo("00234573201")));
    }

    @Test
    public void ibanShouldReturnValidBranchCode() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AD)
                                    .bankCode("0001")
                                    .branchCode("2030")
                                    .accountNumber("200359100100")
                                    .build();

      assertThat(iban.getBranchCode(),
                 is(equalTo("2030")));
    }

    @Test
    public void ibanShouldReturnValidNationalCheckDigit() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AL)
                                    .bankCode("212")
                                    .branchCode("1100")
                                    .nationalCheckDigit("9")
                                    .accountNumber("0000000235698741")
                                    .build();
      assertThat(iban.getNationalCheckDigit(),
                 is(equalTo("9")));
    }

    @Test
    public void ibanShouldReturnValidAccountType() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.BR)
                                    .bankCode("00360305")
                                    .branchCode("00001")
                                    .accountNumber("0009795493")
                                    .accountType("P")
                                    .ownerAccountType("1")
                                    .build();
      assertThat(iban.getAccountType(),
                 is(equalTo("P")));
    }

    @Test
    public void ibanShouldReturnValidOwnerAccountType() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.BR)
                                    .bankCode("00360305")
                                    .branchCode("00001")
                                    .accountNumber("0009795493")
                                    .accountType("P")
                                    .ownerAccountType("1")
                                    .build();
      assertThat(iban.getOwnerAccountType(),
                 is(equalTo("1")));
    }

    @Test
    public void ibanShouldReturnValidIdentificationNumber() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.IS)
                                    .bankCode("0159")
                                    .branchCode("26")
                                    .accountNumber("007654")
                                    .identificationNumber("5510730339")
                                    .build();
      assertThat(iban.getIdentificationNumber(),
                 is(equalTo("5510730339")));
    }

    @Test
    public void ibanShouldReturnValidBban() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("19043")
                                    .accountNumber("00234573201")
                                    .build();

      assertThat(iban.getBban(),
                 is(equalTo("1904300234573201")));
    }

    @Test
    public void ibanShouldReturnValidCheckDigit() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("19043")
                                    .accountNumber("00234573201")
                                    .build();

      assertThat(iban.getCheckDigit(),
                 is(equalTo("61")));
    }

    @Test
    public void ibansWithSameDataShouldHaveSameHashCode() {
      Iban iban1 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732012")
                                     .build();
      Iban iban2 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732012")
                                     .build();

      assertThat(iban1.hashCode(),
                 is(equalTo(iban2.hashCode())));
    }

    @Test
    public void ibansWithDifferentDataShouldNotHaveSameHashCode() {
      Iban iban1 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732012")
                                     .build();
      Iban iban2 = new Iban.Builder().countryCode(CountryCode.AT)
                                     .bankCode("1904")
                                     .accountNumber("102345732011")
                                     .build();

      assertThat(iban1.hashCode(),
                 is(not(equalTo(iban2.hashCode()))));
    }

    @Test
    public void ibanToFormattedStringShouldHaveSpacesAfterEach4Character() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("1904")
                                    .accountNumber("102345732012")
                                    .build();
      assertThat(iban.toFormattedString(),
                 is(equalTo("AT14 1904 1023 4573 2012")));
    }

    @Test
    public void ibanConstructionWithShortBankCodeShouldNotThrowExceptionIfValidationIsDisabled() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("1904")
                                    .accountNumber("A0234573201")
                                    .build(false);
      assertThat(iban.toFormattedString(),
                 is(equalTo("AT40 1904 A023 4573 201")));
    }

    @Test
    public void ibanConstructionWithNoneFormattingShouldReturnIban() {
      Iban iban = Iban.valueOf("AT611904300234573201",
                               IbanFormat.None);
      assertThat(iban.toFormattedString(),
                 is(equalTo("AT61 1904 3002 3457 3201")));
    }

    @Test
    public void ibanConstructionWithDefaultFormattingShouldReturnIban() {
      Iban iban = Iban.valueOf("AT61 1904 3002 3457 3201",
                               IbanFormat.Default);
      assertThat(iban.toFormattedString(),
                 is(equalTo("AT61 1904 3002 3457 3201")));
    }
  }



  public static class IbanGenerationExceptionalTest {

    private static void assertIbanUtilRandomWithSeedEquals(String expected,
                                                           int seed) {
      Iban generated = Iban.random(new Random(seed));
      assertEquals("expect that creating an IBAN with seed '" + seed + "' is deterministic",
                   expected,
                   generated.toFormattedString());
    }

    private static void assertIbanBuilderRandomWithSeedEquals(String expected,
                                                              int seed) {
      Iban generated = Iban.random(new Random(seed));
      assertEquals("expect that creating an IBAN with seed '" + seed + "' is deterministic",
                   expected,
                   generated.toFormattedString());
    }

    @Test(expected = UnsupportedCountryException.class)
    public void ibanConstructionWithNonSupportedCountryShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.AM)
                        .bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithInvalidCountryShouldThrowException() {
      Iban.valueOf("ZZ018786767");
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithNullStringShouldThrowException() {
      Iban.valueOf(null);
    }

    @Test(expected = InvalidCheckDigitException.class)
    public void ibanConstructionWithInvalidCheckDigitShouldThrowException() {
      Iban.valueOf("AT621904300234573201");
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithInvalidBbanCharacterShouldThrowException() {
      Iban.valueOf("AZ21NABZ000000001370100_1944");
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithDefaultButInvalidFormatShouldThrowException() {
      Iban.valueOf("AT61 1904 3002 34573201",
                   IbanFormat.Default);
    }

    @Test(expected = IbanFormatException.class)
    public void formattedIbanConstructionWithNoneFormatShouldThrowException() {
      Iban.valueOf("AT61 1904 3002 3457 3201",
                   IbanFormat.None);
    }

    @Test(expected = IbanFormatException.class)
    public void unformattedIbanConstructionWithDefaultFormatShouldThrowException() {
      Iban.valueOf("AT611904300234573201",
                   IbanFormat.Default);
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutCountryShouldThrowException() {
      new Iban.Builder().bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutBankCodeShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.AT)
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutBranchCodeShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.SC)
                        .bankCode("0001")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutAccountNumberShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.AT)
                        .bankCode("0001")
                        .branchCode("2030")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutNationalCheckDigitShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.SM)
                        .bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutAccountTypeShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.SC)
                        .bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutOwnerAccountNumberShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.BR)
                        .bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .accountType("00")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithoutIdentificationNumberShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.IS)
                        .bankCode("0001")
                        .branchCode("2030")
                        .accountNumber("200359100100")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithInvalidCharacterShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.AT)
                        .bankCode("19043")
                        .accountNumber("A0234573201")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithShortBankCodeShouldThrowException() {
      new Iban.Builder().countryCode(CountryCode.AT)
                        .bankCode("1904")
                        .accountNumber("A0234573201")
                        .build();
    }

    @Test(expected = IbanFormatException.class)
    public void ibanConstructionWithShortBankCodeShouldThrowExceptionIfValidationRequested() {
      new Iban.Builder().countryCode(CountryCode.AT)
                        .bankCode("1904")
                        .accountNumber("A0234573201")
                        .build(true);
    }

    @Test
    public void ibanConstructionRandom() {
      for (int i = 0; i < 100; i++) {
        new Iban.Builder().buildRandom();
        Iban.random();
      }
    }

    @Test
    public void ibanConstructionSeeded() {
      assertIbanUtilRandomWithSeedEquals("WF67 8734 4468 89P1 RIYK UO5K 809",
                                         1);
      assertIbanUtilRandomWithSeedEquals("XK91 2079 0697 8464 4467",
                                         2);
      assertIbanUtilRandomWithSeedEquals("XK51 0018 2949 1527 4166",
                                         3);
    }

    @Test
    public void ibanBuilderConstructionSeeded() {
      assertIbanBuilderRandomWithSeedEquals("WF67 8734 4468 89P1 RIYK UO5K 809",
                                            1);
      assertIbanBuilderRandomWithSeedEquals("XK91 2079 0697 8464 4467",
                                            2);
      assertIbanBuilderRandomWithSeedEquals("XK51 0018 2949 1527 4166",
                                            3);
    }

    @Test
    public void ibanSeededExpectUtilAndBuilderGenerateTheSame() {
      for (int i = 0; i < 100; i++) {
        Iban util    = Iban.random(new Random(i));
        Iban builder = Iban.random(new Random(i));
        assertEquals("expect that the same random IBAN is generated from both util and builder methods",
                     util,
                     builder);
      }
    }

    @Test
    public void ibanConstructionRandomAcctRetainsSpecifiedCountry() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .buildRandom();
      assertThat(iban.getCountryCode(),
                 is(equalTo(CountryCode.AT)));

      iban = Iban.random(CountryCode.AT);
      assertThat(iban.getCountryCode(),
                 is(equalTo(CountryCode.AT)));
    }

    @Test
    public void ibanConstructionRandomRetainsSpecifiedBankCode() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .bankCode("12345")
                                    .buildRandom();
      assertThat(iban.getBankCode(),
                 is(equalTo("12345")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteBankAccount() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AT)
                                    .accountNumber("12345678901")
                                    .buildRandom();
      assertThat(iban.getAccountNumber(),
                 is(equalTo("12345678901")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteBranchCode() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AL)
                                    .branchCode("1234")
                                    .buildRandom();
      assertThat(iban.getBranchCode(),
                 is(equalTo("1234")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteNationalCheckDigit() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.AL)
                                    .nationalCheckDigit("1")
                                    .buildRandom();
      assertThat(iban.getNationalCheckDigit(),
                 is(equalTo("1")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteAccountType() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.BR)
                                    .accountType("A")
                                    .buildRandom();
      assertThat(iban.getAccountType(),
                 is(equalTo("A")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteOwnerAccountType() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.BR)
                                    .ownerAccountType("C")
                                    .buildRandom();
      assertThat(iban.getOwnerAccountType(),
                 is(equalTo("C")));
    }

    @Test
    public void ibanConstructionRandomDoesNotOverwriteIdentificationNumber() {
      Iban iban = new Iban.Builder().countryCode(CountryCode.IS)
                                    .identificationNumber("1234567890")
                                    .buildRandom();
      assertThat(iban.getIdentificationNumber(),
                 is(equalTo("1234567890")));
    }
  }
}
