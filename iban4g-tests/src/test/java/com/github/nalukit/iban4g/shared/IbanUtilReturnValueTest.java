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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class IbanUtilReturnValueTest {

  @RunWith(Parameterized.class)
  public static class ValidCheckDigitCalculationTest {

    private final Iban iban;
    private final String expectedIbanString;

    public ValidCheckDigitCalculationTest(Iban iban, String expectedIbanString) {
      this.iban = iban;
      this.expectedIbanString = expectedIbanString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> ibanParameters() {
      return TestDataHelper.getIbanData();
    }

    @Test
    public void checkDigitCalculationWithCountryCodeAndBbanShouldReturnCheckDigit() {
      String checkDigit = IbanUtil.calculateCheckDigit(iban);
      assertThat(checkDigit, is(equalTo(expectedIbanString.substring(2, 4))));
    }
  }

  @RunWith(Parameterized.class)
  public static class InvalidCheckDigitCalculationTest {

    private final Character invalidCharacter;

    public InvalidCheckDigitCalculationTest(Character invalidCharacter) {
      this.invalidCharacter = invalidCharacter;
    }

    @Parameterized.Parameters
    public static Collection<Character[]> invalidCharacters() {
      return Arrays.asList(new Character[][] {{'\u216C'}, {'+'}});
    }

    @Test(expected = IbanFormatException.class)
    public void checkDigitCalculationWithNonNumericBbanShouldThrowException() {

      IbanUtil.calculateCheckDigit("AT000159260" + invalidCharacter + "076545510730339");
    }
  }

  public static class DefaultIbanUtilTest {

    @Test
    public void ibanCountrySupportCheckWithNullShouldReturnFalse() {
      assertThat(IbanUtil.isSupportedCountry(null), is(equalTo(false)));
    }

    @Test
    public void ibanCountrySupportCheckWithSupportedCountryShouldReturnTrue() {
      assertThat(IbanUtil.isSupportedCountry(CountryCode.BE), is(equalTo(true)));
    }

    @Test
    public void ibanCountrySupportCheckWithUnsupportedCountryShouldReturnFalse() {
      assertThat(IbanUtil.isSupportedCountry(CountryCode.AM), is(equalTo(false)));
    }

    @Test
    public void unformattedIbanValidationWithNoneFormattingShouldNotThrowException() {
      IbanUtil.validate("AT611904300234573201", IbanFormat.None);
    }

    @Test
    public void formattedIbanValidationWithDefaultFormattingShouldNotThrowException() {
      IbanUtil.validate("AT61 1904 3002 3457 3201", IbanFormat.Default);
    }
  }

  public static class InvalidIbanValidationTest {

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void ibanValidationWithNullShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate(null));
    }

    @Test
    public void ibanValidationWithEmptyShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate(""));
    }

    @Test
    public void ibanValidationWithOneCharStringShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("A"));
    }

    @Test
    public void ibanValidationWithCountryCodeOnlyShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT"));
    }

    @Test
    public void ibanValidationWithNonDigitCheckDigitShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT4T"));
    }

    @Test
    public void ibanValidationWithCountryCodeAndCheckDigitOnlyShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT48"));
    }

    @Test
    public void ibanValidationWithLowercaseCountryShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("at611904300234573201"));
    }

    @Test
    public void ibanValidationWithEmptyCountryShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate(" _611904300234573201"));
    }

    @Test()
    public void ibanValidationWithNonSupportedCountryShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AM611904300234573201"));
    }

    @Test
    public void ibanValidationWithNonExistingCountryShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("JJ611904300234573201"));
    }

    @Test
    public void ibanValidationWithInvalidCheckDigitShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT621904300234573201"));
    }

    @Test
    public void ibanValidationWithSpaceShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT61 1904300234573201"));
    }

    @Test
    public void ibanValidationWithInvalidLengthShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT621904300"));
    }

    @Test
    public void ibanValidationWithInvalidBbanLengthShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT61190430023457320"));
    }

    @Test
    public void ibanValidationWithInvalidBankCodeShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT611C04300234573201"));
    }

    @Test
    public void ibanValidationWithInvalidAccountNumberShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("DE8937040044053201300A"));
    }

    @Test
    public void ibanValidationWithInvalidNationalCheckDigitShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("IT6010542811101000000123456"));
    }

    @Test
    public void unformattedIbanValidationWithDefaultFormattingShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT611904300234573201", IbanFormat.Default));
    }

    @Test
    public void formattedIbanValidationWithNoneFormattingShouldThrowException() {
      Iban4gConfig.INSTANCE.setReturnMethod(Iban4gConfig.ReturnMethod.RETURN_VALUE);
      assertFalse(IbanUtil.validate("AT61 1904 3002 3457 3201", IbanFormat.None));
    }
  }

  @RunWith(Parameterized.class)
  public static class ValidIbanValidationTest {

    private final String ibanString;

    public ValidIbanValidationTest(Iban iban, String ibanString) {
      this.ibanString = ibanString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> ibanParameters() {
      final Collection<Object[]> data = new ArrayList<Object[]>(TestDataHelper.getIbanData());
      data.addAll(nonStandardButValidIbans());
      return data;
    }

    private static Collection<Object[]> nonStandardButValidIbans() {
      final Collection<Object[]> data = new ArrayList<>();
      // adding custom validation cases.
      // iban with 01 check digit
      data.add(
          new Object[] {
            Iban.builder()
                .countryCode(CountryCode.TR)
                .bankCode("00123")
                .accountNumber("0882101517977799")
                .nationalCheckDigit("0")
                .build(),
            "TR010012300882101517977799"
          });
      // iban with 98 check digit
      data.add(
          new Object[] {
            Iban.builder()
                .countryCode(CountryCode.TR)
                .bankCode("00123")
                .accountNumber("0882101517977799")
                .nationalCheckDigit("0")
                .build(),
            "TR980012300882101517977799"
          });

      return data;
    }

    @Test
    public void ibanValidationWithValidIbanShouldNotThrowException() {
      IbanUtil.validate(ibanString);
    }
  }

  @RunWith(Parameterized.class)
  public static class IbanLengthTest {

    private final Iban iban;
    private final String expectedIbanString;

    public IbanLengthTest(Iban iban, String expectedIbanString) {
      this.iban = iban;
      this.expectedIbanString = expectedIbanString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> ibanParameters() {
      return TestDataHelper.getIbanData();
    }

    @Test
    public void getIbanLengthShouldReturnValidLength() {
      assertThat(
          IbanUtil.getIbanLength(iban.getCountryCode()), is(equalTo(expectedIbanString.length())));
    }
  }

  @Ignore
  public static class IbanFormatViolationMatcher extends TypeSafeMatcher<IbanFormatException> {

    private final IbanFormatException.IbanFormatViolation expectedViolation;
    private IbanFormatException.IbanFormatViolation actualViolation;

    public IbanFormatViolationMatcher(IbanFormatException.IbanFormatViolation violation) {
      expectedViolation = violation;
    }

    @Override
    protected boolean matchesSafely(IbanFormatException e) {
      actualViolation = e.getFormatViolation();
      return expectedViolation.equals(actualViolation);
    }

    public void describeTo(Description description) {
      description
          .appendText("expected ")
          .appendValue(expectedViolation)
          .appendText(" but found ")
          .appendValue(actualViolation);
    }
  }

  @Ignore
  public static class IbanFormatExceptionActualValueMatcher
      extends TypeSafeMatcher<IbanFormatException> {

    private final Object expectedValue;
    private Object actualValue;

    public IbanFormatExceptionActualValueMatcher(Object expectedValue) {
      this.expectedValue = expectedValue;
    }

    @Override
    protected boolean matchesSafely(IbanFormatException e) {
      actualValue = e.getActual();
      return expectedValue.equals(actualValue);
    }

    public void describeTo(Description description) {
      description
          .appendText("expected ")
          .appendValue(expectedValue)
          .appendText(" but found ")
          .appendValue(actualValue);
    }
  }

  @Ignore
  public static class IbanFormatExceptionExpectedValueMatcher
      extends TypeSafeMatcher<IbanFormatException> {

    private final Object expectedValue;
    private Object actualValue;

    public IbanFormatExceptionExpectedValueMatcher(Object expectedValue) {
      this.expectedValue = expectedValue;
    }

    @Override
    protected boolean matchesSafely(IbanFormatException e) {
      actualValue = e.getExpected();
      return expectedValue.equals(actualValue);
    }

    public void describeTo(Description description) {
      description
          .appendText("expected ")
          .appendValue(expectedValue)
          .appendText(" but found ")
          .appendValue(actualValue);
    }
  }
}
