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

import java.util.Map;

import com.google.gwt.junit.client.GWTTestCase;

import static com.github.mvp4g.iban4g.shared.IbanFormatException.IbanFormatViolation;

public class IbanUtilTest
  extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.github.mvp4g.iban4g.Iban4g";
  }

  public void testCheckDigitCalculationWithCountryCodeAndBbanShouldReturnCheckDigit() {
    Map<String, Iban> testData = TestDataHelper.getIbanData();
    for (String iban : testData.keySet()) {
      String checkDigit = IbanUtil.calculateCheckDigit(iban);
      assertEquals(iban.substring(2,
                                  4),
                   checkDigit);
    }
  }

  public void testCheckDigitCalculationWithNonNumericBbanShouldThrowException() {
    char[] characterList = new char[] { '\u216C', '+' };
    for (char invalidCharacter : characterList) {
      try {
        IbanUtil.calculateCheckDigit("AT000159260" + invalidCharacter + "076545510730339");
        fail();
      } catch (IbanFormatException e) {
      }
    }
  }

  public void testIbanCountrySupportCheckWithNullShouldReturnFalse() {
    assertFalse(IbanUtil.isSupportedCountry(null));
  }

  public void testIbanCountrySupportCheckWithSupportedCountryShouldReturnTrue() {
    assertTrue(IbanUtil.isSupportedCountry(CountryCode.BE));
  }

  public void testIbanCountrySupportCheckWithUnsupportedCountryShouldReturnFalse() {
    assertFalse(IbanUtil.isSupportedCountry(CountryCode.AM));
  }

  public void testUnformattedIbanValidationWithNoneFormattingShouldNotThrowException() {
    IbanUtil.validate("AT611904300234573201",
                      IbanFormat.None);
  }

  public void testFormattedIbanValidationWithDefaultFormattingShouldNotThrowException() {
    IbanUtil.validate("AT61 1904 3002 3457 3201",
                      IbanFormat.Default);
  }

  public void testIbanValidationWithNullShouldThrowException() {
    try {
      IbanUtil.validate(null);
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Null can't be a valid Iban")) {
        fail();
      }
      IbanFormatViolationMatcher matcher = new IbanFormatViolationMatcher(IbanFormatViolation.IBAN_NOT_NULL);
      assertTrue(matcher.describeTo(),
                 matcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithEmptyShouldThrowException() {
    try {
      IbanUtil.validate("");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Empty string can't be a valid Iban")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.IBAN_NOT_EMPTY);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithOneCharStringShouldThrowException() {
    try {
      IbanUtil.validate("A");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban must contain 2 char country code.")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.COUNTRY_CODE_TWO_LETTERS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher("A");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithCountryCodeOnlyShouldThrowException() {
    try {
      IbanUtil.validate("AT");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban must contain 2 digit check digit.")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.CHECK_DIGIT_TWO_DIGITS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher("");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithNonDigitCheckDigitShouldThrowException() {
    try {
      IbanUtil.validate("AT4T");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban's check digit should contain only digits.")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.CHECK_DIGIT_ONLY_DIGITS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher("4T");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithCountryCodeAndCheckDigitOnlyShouldThrowException() {
    try {
      IbanUtil.validate("AT48");
      fail();
    } catch (IbanFormatException e) {
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.BBAN_LENGTH);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher("0");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
      IbanFormatExceptionExpectedValueMatcher ibanFormatExceptionExpectedValueMatcher = new IbanFormatExceptionExpectedValueMatcher("16");
      assertTrue(ibanFormatExceptionExpectedValueMatcher.describeTo(),
                 ibanFormatExceptionExpectedValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithLowercaseCountryShouldThrowException() {
    try {
      IbanUtil.validate("at611904300234573201");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban country code must contain upper case letters")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.COUNTRY_CODE_UPPER_CASE_LETTERS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher("at");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithEmptyCountryShouldThrowException() {
    try {
      IbanUtil.validate(" _611904300234573201");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban country code must contain upper case letters")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.COUNTRY_CODE_UPPER_CASE_LETTERS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
      IbanFormatExceptionActualValueMatcher ibanFormatExceptionActualValueMatcher = new IbanFormatExceptionActualValueMatcher(" _");
      assertTrue(ibanFormatExceptionActualValueMatcher.describeTo(),
                 ibanFormatExceptionActualValueMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithNonSupportedCountryShouldThrowException() {
    try {
      IbanUtil.validate("AM611904300234573201");
      fail();
    } catch (UnsupportedCountryException e) {
    }
  }

  public void testIbanValidationWithNonExistingCountryShouldThrowException() {
    try {
      IbanUtil.validate("JJ611904300234573201");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban contains non existing country code.")) {
        fail();
      }
      IbanFormatViolationMatcher ibanFormatViolationMatcher = new IbanFormatViolationMatcher(IbanFormatViolation.COUNTRY_CODE_EXISTS);
      assertTrue(ibanFormatViolationMatcher.describeTo(),
                 ibanFormatViolationMatcher.matchesSafely(e));
    }
  }

  public void testIbanValidationWithInvalidCheckDigitShouldThrowException() {
    try {
      IbanUtil.validate("AT621904300234573201");
      fail();
    } catch (InvalidCheckDigitException e) {
      if (!e.getMessage()
            .contains("invalid check digit: 62")) {
        fail();
      }
      if (!e.getMessage()
            .contains("expected check digit is: 61")) {
        fail();
      }
      if (!e.getMessage()
            .contains("AT621904300234573201")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithSpaceShouldThrowException() {
    try {
      IbanUtil.validate("AT61 1904300234573201");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("length is 17")) {
        fail();
      }
      if (!e.getMessage()
            .contains("expected BBAN length is: 16")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithInvalidLengthShouldThrowException() {
    try {
      IbanUtil.validate("AT621904300");
      fail();
    } catch (IbanFormatException ignored) {
    }
  }

  public void testIbanValidationWithInvalidBbanLengthShouldThrowException() {
    try {
      IbanUtil.validate("AT61190430023457320");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("expected BBAN length is:")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithInvalidBankCodeShouldThrowException() {
    try {
      IbanUtil.validate("AT611C04300234573201");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("must contain only digits")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithInvalidAccountNumberShouldThrowException() {
    try {
      IbanUtil.validate("DE8937040044053201300A");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("must contain only digits")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithInvalidNationalCheckDigitShouldThrowException() {
    try {
      IbanUtil.validate("IT6010542811101000000123456");
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("must contain only upper case letters")) {
        fail();
      }
    }
  }

  public void testUnformattedIbanValidationWithDefaultFormattingShouldThrowException() {
    try {
      IbanUtil.validate("AT611904300234573201",
                        IbanFormat.Default);
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("Iban must be formatted using 4 characters and space")) {
        fail();
      }
    }
  }

  public void testFormattedIbanValidationWithNoneFormattingShouldThrowException() {
    try {
      IbanUtil.validate("AT61 1904 3002 3457 3201",
                        IbanFormat.None);
      fail();
    } catch (IbanFormatException e) {
      if (!e.getMessage()
            .contains("expected BBAN length is: 16")) {
        fail();
      }
    }
  }

  public void testIbanValidationWithValidIbanShouldNotThrowException() {
    Map<String, Iban> testData = TestDataHelper.getIbanData();
    testData.putAll(TestDataHelper.getNonStandardButValidIbans());
    for (String ibanString : testData.keySet()) {
      IbanUtil.validate(ibanString);
    }
  }

  public void testGetIbanLengthShouldReturnValidLength() {
    Map<String, Iban> testData = TestDataHelper.getIbanData();
    for (String ibanString : testData.keySet()) {
      assertEquals(ibanString.length(),
                   IbanUtil.getIbanLength(testData.get(ibanString)
                                                  .getCountryCode()));
    }
  }

  public static class IbanFormatViolationMatcher {

    private final IbanFormatViolation expectedViolation;
    private       IbanFormatViolation actualViolation;

    IbanFormatViolationMatcher(IbanFormatViolation violation) {
      expectedViolation = violation;
    }

    boolean matchesSafely(IbanFormatException e) {
      actualViolation = e.getFormatViolation();
      return expectedViolation.equals(actualViolation);
    }

    String describeTo() {
      return "expected " + expectedViolation + " but found " + actualViolation;
    }
  }

  public static class IbanFormatExceptionActualValueMatcher {

    private final String expectedValue;
    private       String actualValue;

    IbanFormatExceptionActualValueMatcher(String expectedValue) {
      this.expectedValue = expectedValue;
    }

    boolean matchesSafely(IbanFormatException e) {
      actualValue = e.getActual();
      return expectedValue.equals(actualValue);
    }

    String describeTo() {
      return "expected " + expectedValue + " but found " + actualValue;
    }
  }

  public static class IbanFormatExceptionExpectedValueMatcher {

    private final String expectedValue;
    private       String actualValue;

    IbanFormatExceptionExpectedValueMatcher(String expectedValue) {
      this.expectedValue = expectedValue;
    }

    boolean matchesSafely(IbanFormatException e) {
      actualValue = e.getExpected();
      return expectedValue.equals(actualValue);
    }

    String describeTo() {
      return "expected " + expectedValue + " but found " + actualValue;
    }
  }
}
