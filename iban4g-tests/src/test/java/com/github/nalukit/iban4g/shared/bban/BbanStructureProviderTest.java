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
