package com.github.nalukit.iban4g.shared.bban;

import com.github.nalukit.iban4g.shared.CountryCode;
import com.github.nalukit.iban4g.shared.bban.loader.BbanStructureLoadException;
import org.junit.Assert;
import org.junit.Test;

public class BbanStructureProviderTest {

  @Test
  public void addBbanStructure() {
    try {
      BbanStructureProvider.get()
                           .addBbanStructure(CountryCode.DE,
                                             new BbanStructure(BbanStructureEntry.bankCode(8,
                                                                                           'n'),
                                                               BbanStructureEntry.accountNumber(10,
                                                                                                'n')));
      Assert.fail("expected exception!");
    } catch (BbanStructureLoadException e) {
    }
  }
}