package com.github.nalukit.iban4g.shared;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpanishIbanTest {
  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void validSpanishIbanIsValidated() {
    // Validates according to www.iban.com
    IbanUtil.validate("ES7021000418450200051322",
                      IbanFormat.None);
  }

  @Test
  public void invalidSpanishIbanIsNotValidated() {
    // DOES NOT VALIDATE according to www.iban.com
    // The national check digits should be 48, not 45
    expectedException.expectMessage("[ES7821000418450200051322] has invalid check digit: 78, expected check digit is: 70");
    IbanUtil.validate("ES7821000418450200051322",
                      IbanFormat.None);
  }

  @Test
  public void buildRandomSpanishIban() {
    Iban spanishIban = new Iban.Builder().countryCode(CountryCode.ES)
                                         .bankCode("2100")
                                         .branchCode("0418")
                                         .accountNumber("0200051322")
                                         .nationalCheckDigit("48")
                                         .buildRandom();
    assertThat(spanishIban.getNationalCheckDigit(),
               is("48"));
  }
}