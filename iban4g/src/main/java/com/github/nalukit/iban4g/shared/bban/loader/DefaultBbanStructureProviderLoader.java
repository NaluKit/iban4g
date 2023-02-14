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
package com.github.nalukit.iban4g.shared.bban.loader;

import com.github.nalukit.iban4g.shared.CountryCode;
import com.github.nalukit.iban4g.shared.bban.BbanStructure;
import com.github.nalukit.iban4g.shared.bban.BbanStructureEntry;
import com.github.nalukit.iban4g.shared.bban.BbanStructureProvider;

/** Class which represents bban structure */
public class DefaultBbanStructureProviderLoader {

  private static DefaultBbanStructureProviderLoader instance;

  private DefaultBbanStructureProviderLoader() {}

  public static DefaultBbanStructureProviderLoader get() {
    if (instance == null) {
      instance = new DefaultBbanStructureProviderLoader();
    }
    return instance;
  }

  public void load() {
    BbanStructureProvider provider = BbanStructureProvider.get();

    provider.addBbanStructure(
        CountryCode.AD,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(12, 'c')));

    provider.addBbanStructure(
        CountryCode.AE,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.AL,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n'),
            BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.AT,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'), BbanStructureEntry.accountNumber(11, 'n')));

    provider.addBbanStructure(CountryCode.AX, this.defaultFinlandStructure());

    provider.addBbanStructure(
        CountryCode.AZ,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(20, 'c')));

    provider.addBbanStructure(
        CountryCode.BA,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(3, 'n'),
            BbanStructureEntry.accountNumber(8, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.BE,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.accountNumber(7, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.BG,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountType(2, 'n'),
            BbanStructureEntry.accountNumber(8, 'c')));

    provider.addBbanStructure(
        CountryCode.BH,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(14, 'c')));

    provider.addBbanStructure(CountryCode.BL, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.BR,
        new BbanStructure(
            BbanStructureEntry.bankCode(8, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(10, 'n'),
            BbanStructureEntry.accountType(1, 'a'),
            BbanStructureEntry.ownerAccountNumber(1, 'c')));

    provider.addBbanStructure(
        CountryCode.BY,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'c'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.CH,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'), BbanStructureEntry.accountNumber(12, 'c')));

    provider.addBbanStructure(
        CountryCode.CR,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(14, 'n')));

    provider.addBbanStructure(
        CountryCode.CV,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(13, 'c')));

    provider.addBbanStructure(
        CountryCode.CY,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.CZ,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(
        CountryCode.DE,
        new BbanStructure(
            BbanStructureEntry.bankCode(8, 'n'), BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.DK,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.DO,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'c'), BbanStructureEntry.accountNumber(20, 'n')));

    provider.addBbanStructure(
        CountryCode.EE,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'n'),
            BbanStructureEntry.branchCode(2, 'n'),
            BbanStructureEntry.accountNumber(11, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n')));

    provider.addBbanStructure(
        CountryCode.EG,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(17, 'n')));

    provider.addBbanStructure(
        CountryCode.ES,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n'),
            BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.FO,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.accountNumber(9, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n')));

    provider.addBbanStructure(CountryCode.FI, this.defaultFinlandStructure());

    provider.addBbanStructure(CountryCode.FR, this.defaultFrenchStructure());

    provider.addBbanStructure(CountryCode.GB, this.defaultUnitedKingdomStructure());

    provider.addBbanStructure(
        CountryCode.GE,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'a'), BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(CountryCode.GG, this.defaultUnitedKingdomStructure());

    provider.addBbanStructure(CountryCode.GF, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.GI,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(15, 'c')));

    provider.addBbanStructure(
        CountryCode.GL,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(CountryCode.GP, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.GR,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.GT,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'c'), BbanStructureEntry.accountNumber(20, 'c')));

    provider.addBbanStructure(
        CountryCode.HU,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n'),
            BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(
        CountryCode.HR,
        new BbanStructure(
            BbanStructureEntry.bankCode(7, 'n'), BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.IE,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(6, 'n'),
            BbanStructureEntry.accountNumber(8, 'n')));

    provider.addBbanStructure(
        CountryCode.IL,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(3, 'n'),
            BbanStructureEntry.accountNumber(13, 'n')));

    provider.addBbanStructure(CountryCode.IM, this.defaultUnitedKingdomStructure());

    provider.addBbanStructure(
        CountryCode.IQ,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(3, 'n'),
            BbanStructureEntry.accountNumber(12, 'n')));

    provider.addBbanStructure(
        CountryCode.IR,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(19, 'n')));

    provider.addBbanStructure(
        CountryCode.IS,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(2, 'n'),
            BbanStructureEntry.accountNumber(6, 'n'),
            BbanStructureEntry.identificationNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.IT,
        new BbanStructure(
            BbanStructureEntry.nationalCheckDigit(1, 'a'),
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(12, 'c')));

    provider.addBbanStructure(CountryCode.JE, this.defaultUnitedKingdomStructure());

    provider.addBbanStructure(
        CountryCode.JO,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(18, 'c')));

    provider.addBbanStructure(
        CountryCode.KW,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(22, 'c')));

    provider.addBbanStructure(
        CountryCode.KZ,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(13, 'c')));

    provider.addBbanStructure(
        CountryCode.LB,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(20, 'c')));

    provider.addBbanStructure(
        CountryCode.LC,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(24, 'c')));

    provider.addBbanStructure(
        CountryCode.LI,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'), BbanStructureEntry.accountNumber(12, 'c')));

    provider.addBbanStructure(
        CountryCode.LT,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'), BbanStructureEntry.accountNumber(11, 'n')));

    provider.addBbanStructure(
        CountryCode.LU,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(13, 'c')));

    provider.addBbanStructure(
        CountryCode.LV,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(13, 'c')));

    provider.addBbanStructure(
        CountryCode.MC,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(11, 'c'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.MD,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'c'), BbanStructureEntry.accountNumber(18, 'c')));

    provider.addBbanStructure(
        CountryCode.ME,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.accountNumber(13, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(CountryCode.MF, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.MG,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(11, 'c'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.MK,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.accountNumber(10, 'c'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(CountryCode.MQ, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.MR,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(11, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.MT,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(18, 'c')));

    provider.addBbanStructure(
        CountryCode.MU,
        new BbanStructure(
            BbanStructureEntry.bankCode(6, 'c'),
            BbanStructureEntry.branchCode(2, 'n'),
            BbanStructureEntry.accountNumber(18, 'c')));

    provider.addBbanStructure(CountryCode.NC, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.NL,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(10, 'n')));

    provider.addBbanStructure(
        CountryCode.NO,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.accountNumber(6, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n')));

    provider.addBbanStructure(CountryCode.PF, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.PK,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'c'), BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(
        CountryCode.PL,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'n'),
            BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(CountryCode.PM, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.PS,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(21, 'c')));

    provider.addBbanStructure(
        CountryCode.PT,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(11, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.QA,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(21, 'c')));

    provider.addBbanStructure(CountryCode.RE, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.RO,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.RS,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.accountNumber(13, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.RU,
        new BbanStructure(
            BbanStructureEntry.bankCode(9, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(15, 'c')));

    provider.addBbanStructure(
        CountryCode.SA,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'n'), BbanStructureEntry.accountNumber(18, 'c')));

    provider.addBbanStructure(
        CountryCode.SC,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(16, 'n'),
            BbanStructureEntry.accountType(3, 'a')));

    provider.addBbanStructure(
        CountryCode.SE,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(17, 'n')));

    provider.addBbanStructure(
        CountryCode.SI,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'n'),
            BbanStructureEntry.branchCode(3, 'n'),
            BbanStructureEntry.accountNumber(8, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.SK,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'), BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(
        CountryCode.SM,
        new BbanStructure(
            BbanStructureEntry.nationalCheckDigit(1, 'a'),
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.branchCode(5, 'n'),
            BbanStructureEntry.accountNumber(12, 'c')));

    provider.addBbanStructure(
        CountryCode.ST,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'n'),
            BbanStructureEntry.branchCode(4, 'n'),
            BbanStructureEntry.accountNumber(13, 'n')));

    provider.addBbanStructure(
        CountryCode.SV,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(20, 'n')));

    provider.addBbanStructure(CountryCode.TF, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.TL,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'),
            BbanStructureEntry.accountNumber(14, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(
        CountryCode.TN,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'n'),
            BbanStructureEntry.branchCode(3, 'n'),
            BbanStructureEntry.accountNumber(15, 'c')));

    provider.addBbanStructure(
        CountryCode.TR,
        new BbanStructure(
            BbanStructureEntry.bankCode(5, 'n'),
            BbanStructureEntry.nationalCheckDigit(1, 'c'),
            BbanStructureEntry.accountNumber(16, 'c')));

    provider.addBbanStructure(
        CountryCode.UA,
        new BbanStructure(
            BbanStructureEntry.bankCode(6, 'n'), BbanStructureEntry.accountNumber(19, 'n')));

    provider.addBbanStructure(
        CountryCode.VA,
        new BbanStructure(
            BbanStructureEntry.bankCode(3, 'n'), BbanStructureEntry.accountNumber(15, 'n')));

    provider.addBbanStructure(
        CountryCode.VG,
        new BbanStructure(
            BbanStructureEntry.bankCode(4, 'a'), BbanStructureEntry.accountNumber(16, 'n')));

    provider.addBbanStructure(CountryCode.WF, this.defaultFrenchStructure());

    provider.addBbanStructure(
        CountryCode.XK,
        new BbanStructure(
            BbanStructureEntry.bankCode(2, 'n'),
            BbanStructureEntry.branchCode(2, 'n'),
            BbanStructureEntry.accountNumber(10, 'n'),
            BbanStructureEntry.nationalCheckDigit(2, 'n')));

    provider.addBbanStructure(CountryCode.YT, this.defaultFrenchStructure());
  }

  /* French sub-territories may use their own */
  /* country code (BL,RE,NC,...) or FR for    */
  /* their IBAN. Structure is the same, only  */
  /* the IBAN checksum differ.                */
  private BbanStructure defaultFrenchStructure() {
    return new BbanStructure(
        BbanStructureEntry.bankCode(5, 'n'),
        BbanStructureEntry.branchCode(5, 'n'),
        BbanStructureEntry.accountNumber(11, 'c'),
        BbanStructureEntry.nationalCheckDigit(2, 'n'));
  }

  /* Finland sub-territorie may use           */
  /* its own country code (AX)                */
  /* or FI for their IBAN. Structure is the   */
  /* same, only the IBAN checksum differ.     */
  private BbanStructure defaultFinlandStructure() {
    return new BbanStructure(
        BbanStructureEntry.bankCode(6, 'n'),
        BbanStructureEntry.accountNumber(7, 'n'),
        BbanStructureEntry.nationalCheckDigit(1, 'n'));
  }

  /* Great Britain sub-territories may use    */
  /* their own country code (IM, GG, JE,...)  */
  /* or GB for their IBAN. Structure is the   */
  /* same, only the IBAN checksum differ.     */
  private BbanStructure defaultUnitedKingdomStructure() {
    return new BbanStructure(
        BbanStructureEntry.bankCode(4, 'a'),
        BbanStructureEntry.branchCode(6, 'n'),
        BbanStructureEntry.accountNumber(8, 'n'));
  }
}
