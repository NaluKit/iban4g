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

import java.util.Arrays;
import java.util.Collection;

final class TestDataHelper {

  private TestDataHelper() {
  }

  public static Collection<Object[]> getIbanData() {
    return Arrays.asList(new Object[][] { { Iban.builder()
                                                .countryCode(CountryCode.AD)
                                                .bankCode("0001")
                                                .branchCode("2030")
                                                .accountNumber("200359100100").build(),
                                            "AD1200012030200359100100" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.AL)
                                                .bankCode("212")
                                                .branchCode("1100")
                                                .accountNumber("0000000235698741")
                                                .nationalCheckDigit("9").build(),
                                            "AL47212110090000000235698741" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.AT)
                                                .bankCode("19043")
                                                .accountNumber("00234573201").build(),
                                            "AT611904300234573201" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.AX)
                                                .bankCode("987654")
                                                .accountNumber("0002033")
                                                .nationalCheckDigit("5").build(),
                                            "AX7898765400020335" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.AZ)
                                                .bankCode("NABZ")
                                                .accountNumber("00000000137010001944").build(),
                                            "AZ21NABZ00000000137010001944" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BH)
                                                .bankCode("SCBL")
                                                .accountNumber("BHD18903608801").build(),
                                            "BH72SCBLBHD18903608801" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BA)
                                                .bankCode("129")
                                                .branchCode("007")
                                                .accountNumber("94010284")
                                                .nationalCheckDigit("94").build(),
                                            "BA391290079401028494" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BE)
                                                .bankCode("539")
                                                .accountNumber("0075470")
                                                .nationalCheckDigit("34").build(),
                                            "BE68539007547034" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BL)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "BL391234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BR)
                                                .bankCode("00360305")
                                                .branchCode("00001")
                                                .accountNumber("0009795493")
                                                .accountType("P")
                                                .ownerAccountType("1").build(),
                                            "BR9700360305000010009795493P1" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BG)
                                                .bankCode("BNBG")
                                                .branchCode("9661")
                                                .accountNumber("20345678")
                                                .accountType("10").build(),
                                            "BG80BNBG96611020345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.BY)
                                                .bankCode("NBRB")
                                                .branchCode("3600")
                                                .accountNumber("900000002Z00AB00").build(),
                                            "BY13NBRB3600900000002Z00AB00" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.CR)
                                                .bankCode("0152")
                                                .accountNumber("02001026284066").build(),
                                            "CR05015202001026284066" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.HR)
                                                .bankCode("1001005")
                                                .accountNumber("1863000160").build(),
                                            "HR1210010051863000160" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.CV)
                                                .bankCode("0005")
                                                .branchCode("0000")
                                                .accountNumber("0020108215144").build(),
                                            "CV64000500000020108215144" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.CY)
                                                .bankCode("002")
                                                .branchCode("00128")
                                                .accountNumber("0000001200527600").build(),
                                            "CY17002001280000001200527600" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.CZ)
                                                .bankCode("0800")
                                                .accountNumber("0000192000145399").build(),
                                            "CZ6508000000192000145399" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.DK)
                                                .bankCode("0040")
                                                .accountNumber("0440116243").build(),
                                            "DK5000400440116243" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.DO)
                                                .bankCode("BAGR")
                                                .accountNumber("00000001212453611324").build(),
                                            "DO28BAGR00000001212453611324" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.EE)
                                                .bankCode("22")
                                                .branchCode("00")
                                                .accountNumber("22102014568")
                                                .nationalCheckDigit("5").build(),
                                            "EE382200221020145685" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.EG)
                                                .bankCode("0019")
                                                .branchCode("0005")
                                                .accountNumber("00000000263180002").build(),
                                            "EG380019000500000000263180002" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.FI)
                                                .bankCode("123456")
                                                .accountNumber("0000078")
                                                .nationalCheckDigit("5").build(),
                                            "FI2112345600000785" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.FR)
                                                .bankCode("20041")
                                                .branchCode("01005")
                                                .accountNumber("0500013M026")
                                                .nationalCheckDigit("06").build(),
                                            "FR1420041010050500013M02606" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GE)
                                                .bankCode("NB")
                                                .accountNumber("0000000101904917").build(),
                                            "GE29NB0000000101904917" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.DE)
                                                .bankCode("37040044")
                                                .accountNumber("0532013000").build(),
                                            "DE89370400440532013000" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GF)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "GF121234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GG)
                                                .bankCode("INGB")
                                                .branchCode("238859")
                                                .accountNumber("12345678").build(),
                                            "GG65INGB23885912345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GI)
                                                .bankCode("NWBK")
                                                .accountNumber("000000007099453").build(),
                                            "GI75NWBK000000007099453" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GP)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "GP791234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GR)
                                                .bankCode("011")
                                                .branchCode("0125")
                                                .accountNumber("0000000012300695").build(),
                                            "GR1601101250000000012300695" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GT)
                                                .bankCode("TRAJ")
                                                .accountNumber("01020000001210029690").build(),
                                            "GT82TRAJ01020000001210029690" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.HU)
                                                .bankCode("117")
                                                .branchCode("7301")
                                                .accountNumber("1111101800000000")
                                                .nationalCheckDigit("6").build(),
                                            "HU42117730161111101800000000" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IE)
                                                .bankCode("AIBK")
                                                .branchCode("931152")
                                                .accountNumber("12345678").build(),
                                            "IE29AIBK93115212345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IL)
                                                .bankCode("010")
                                                .branchCode("800")
                                                .accountNumber("0000099999999").build(),
                                            "IL620108000000099999999" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IM)
                                                .bankCode("HBUK")
                                                .branchCode("401276")
                                                .accountNumber("12345678").build(),
                                            "IM20HBUK40127612345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IQ)
                                                .nationalCheckDigit("98")
                                                .bankCode("NBIQ")
                                                .branchCode("850")
                                                .accountNumber("123456789012").build(),
                                            "IQ98NBIQ850123456789012" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IS)
                                                .bankCode("0159")
                                                .branchCode("26")
                                                .accountNumber("007654")
                                                .identificationNumber("5510730339").build(),
                                            "IS140159260076545510730339" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IT)
                                                .bankCode("05428")
                                                .branchCode("11101")
                                                .nationalCheckDigit("X")
                                                .accountNumber("000000123456").build(),
                                            "IT60X0542811101000000123456" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.JE)
                                                .bankCode("DEUT")
                                                .branchCode("405081")
                                                .accountNumber("12345678").build(),
                                            "JE51DEUT40508112345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.JO)
                                                .bankCode("CBJO")
                                                .branchCode("0010")
                                                .accountNumber("000000000131000302").build(),
                                            "JO94CBJO0010000000000131000302" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.KZ)
                                                .bankCode("125")
                                                .accountNumber("KZT5004100100").build(),
                                            "KZ86125KZT5004100100" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.KW)
                                                .bankCode("CBKU")
                                                .accountNumber("0000000000001234560101").build(),
                                            "KW81CBKU0000000000001234560101" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LC)
                                                .bankCode("HEMM")
                                                .accountNumber("000100010012001200023015").build(),
                                            "LC55HEMM000100010012001200023015" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LV)
                                                .bankCode("BANK")
                                                .accountNumber("0000435195001").build(),
                                            "LV80BANK0000435195001" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LB)
                                                .bankCode("0999")
                                                .accountNumber("00000001001901229114").build(),
                                            "LB62099900000001001901229114" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LI)
                                                .bankCode("08810")
                                                .accountNumber("0002324013AA").build(),
                                            "LI21088100002324013AA" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LT)
                                                .bankCode("10000")
                                                .accountNumber("11101001000").build(),
                                            "LT121000011101001000" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.LU)
                                                .bankCode("001")
                                                .accountNumber("9400644750000").build(),
                                            "LU280019400644750000" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MC)
                                                .bankCode("11222")
                                                .branchCode("00001")
                                                .accountNumber("01234567890")
                                                .nationalCheckDigit("30").build(),
                                            "MC5811222000010123456789030" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MF)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "MF551234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MK)
                                                .bankCode("250")
                                                .accountNumber("1200000589")
                                                .nationalCheckDigit("84").build(),
                                            "MK07250120000058984" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MQ)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "MQ221234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MT)
                                                .bankCode("MALT")
                                                .branchCode("01100")
                                                .accountNumber("0012345MTLCAST001S").build(),
                                            "MT84MALT011000012345MTLCAST001S" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MR)
                                                .bankCode("00020")
                                                .branchCode("00101")
                                                .accountNumber("00001234567")
                                                .nationalCheckDigit("53").build(),
                                            "MR1300020001010000123456753" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MU)
                                                .bankCode("BOMM01")
                                                .branchCode("01")
                                                .accountNumber("101030300200000MUR").build(),
                                            "MU17BOMM0101101030300200000MUR" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MD)
                                                .bankCode("AG")
                                                .accountNumber("000225100013104168").build(),
                                            "MD24AG000225100013104168" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MC)
                                                .bankCode("11222")
                                                .branchCode("00001")
                                                .accountNumber("01234567890")
                                                .nationalCheckDigit("30").build(),
                                            "MC5811222000010123456789030" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.ME)
                                                .bankCode("505")
                                                .accountNumber("0000123456789")
                                                .nationalCheckDigit("51").build(),
                                            "ME25505000012345678951" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.MG)
                                                .bankCode("91389")
                                                .branchCode("12738")
                                                .accountNumber("36945544212")
                                                .nationalCheckDigit("12").build(),
                                            "MG5791389127383694554421212" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.NC)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "NC551234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.NL)
                                                .bankCode("ABNA")
                                                .accountNumber("0417164300").build(),
                                            "NL91ABNA0417164300" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.NO)
                                                .bankCode("8601")
                                                .accountNumber("111794")
                                                .nationalCheckDigit("7").build(),
                                            "NO9386011117947" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PF)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "PF281234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PM)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "PM071234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PK)
                                                .bankCode("SCBL")
                                                .accountNumber("0000001123456702").build(),
                                            "PK36SCBL0000001123456702" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PS)
                                                .bankCode("PALS")
                                                .accountNumber("000000000400123456702").build(),
                                            "PS92PALS000000000400123456702" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PL)
                                                .bankCode("109")
                                                .branchCode("0101")
                                                .accountNumber("0000071219812874")
                                                .nationalCheckDigit("4").build(),
                                            "PL61109010140000071219812874" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.PT)
                                                .bankCode("0002")
                                                .branchCode("0123")
                                                .accountNumber("12345678901")
                                                .nationalCheckDigit("54").build(),
                                            "PT50000201231234567890154" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.RE)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "RE131234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.RO)
                                                .bankCode("AAAA")
                                                .accountNumber("1B31007593840000").build(),
                                            "RO49AAAA1B31007593840000" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.QA)
                                                .bankCode("DOHB")
                                                .accountNumber("00001234567890ABCDEFG").build(),
                                            "QA58DOHB00001234567890ABCDEFG" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SC)
                                                .bankCode("SSCB")
                                                .branchCode("1101")
                                                .accountNumber("0000000000001497")
                                                .accountType("USD").build(),
                                            "SC18SSCB11010000000000001497USD" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SM)
                                                .bankCode("03225")
                                                .branchCode("09800")
                                                .accountNumber("000000270100")
                                                .nationalCheckDigit("U").build(),
                                            "SM86U0322509800000000270100" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.ST)
                                                .bankCode("0001")
                                                .branchCode("0001")
                                                .accountNumber("0051845310112").build(),
                                            "ST68000100010051845310112" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SA)
                                                .bankCode("80")
                                                .accountNumber("000000608010167519").build(),
                                            "SA0380000000608010167519" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.RS)
                                                .bankCode("260")
                                                .branchCode("26")
                                                .accountNumber("0056010016113")
                                                .nationalCheckDigit("79").build(),
                                            "RS35260005601001611379" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SK)
                                                .bankCode("1200")
                                                .accountNumber("0000198742637541").build(),
                                            "SK3112000000198742637541" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SV)
                                                .bankCode("CENR")
                                                .accountNumber("00000000000000700025").build(),
                                            "SV62CENR00000000000000700025" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SI)
                                                .bankCode("26")
                                                .branchCode("330")
                                                .accountNumber("00120390")
                                                .nationalCheckDigit("86").build(),
                                            "SI56263300012039086" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.ES)
                                                .bankCode("2100")
                                                .branchCode("0418")
                                                .accountNumber("0200051332")
                                                .nationalCheckDigit("45").build(),
                                            "ES9121000418450200051332" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.SE)
                                                .bankCode("500")
                                                .accountNumber("00000058398257466").build(),
                                            "SE4550000000058398257466" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.CH)
                                                .bankCode("00762")
                                                .accountNumber("011623852957").build(),
                                            "CH9300762011623852957" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.TF)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "TF891234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.TN)
                                                .bankCode("10")
                                                .branchCode("006")
                                                .accountNumber("035183598478831").build(),
                                            "TN5910006035183598478831" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.TR)
                                                .bankCode("00061")
                                                .accountNumber("0519786457841326")
                                                .nationalCheckDigit("0").build(),
                                            "TR330006100519786457841326" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.WF)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "WF621234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.AE)
                                                .bankCode("033")
                                                .accountNumber("1234567890123456").build(),
                                            "AE070331234567890123456" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GB)
                                                .bankCode("NWBK")
                                                .branchCode("601613")
                                                .accountNumber("31926819").build(),
                                            "GB29NWBK60161331926819" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.VG)
                                                .bankCode("VPVG")
                                                .accountNumber("0000012345678901").build(),
                                            "VG96VPVG0000012345678901" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.TL)
                                                .bankCode("008")
                                                .accountNumber("00123456789101")
                                                .nationalCheckDigit("57").build(),
                                            "TL380080012345678910157" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.XK)
                                                .bankCode("10")
                                                .branchCode("00")
                                                .accountNumber("0000000000")
                                                .nationalCheckDigit("53").build(),
                                            "XK051000000000000053" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.IR)
                                                .bankCode("017")
                                                .accountNumber("0000000000123456789").build(),
                                            "IR200170000000000123456789" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.FO)
                                                .bankCode("5432")
                                                .accountNumber("038889994")
                                                .nationalCheckDigit("4").build(),
                                            "FO9754320388899944" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GL)
                                                .bankCode("6471")
                                                .accountNumber("0001000206").build(),
                                            "GL8964710001000206" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.UA)
                                                .bankCode("354347")
                                                .accountNumber("0006762462054925026").build(),
                                            "UA573543470006762462054925026" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.VA)
                                                .bankCode("001")
                                                .accountNumber("123000012345678").build(),
                                            "VA59001123000012345678" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.YT)
                                                .bankCode("12345")
                                                .branchCode("12345")
                                                .accountNumber("123456789AB")
                                                .nationalCheckDigit("13").build(),
                                            "YT021234512345123456789AB13" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.RU)
                                                .bankCode("044525600")
                                                .branchCode("40702")
                                                .accountNumber("810412345678901").build(),
                                            "RU0204452560040702810412345678901" },
                                          { Iban.builder()
                                                .countryCode(CountryCode.GA)
                                                .bankCode("40001")
                                                .branchCode("09080")
                                                .accountNumber("0008120005890").build(),
                                            "GA2140001090800008120005890" } });
  }

  public static Collection<Object[]> getBicData() {
    return Arrays.asList(new Object[][] { { "DEUTDEFF" },
                                          { "DEUTDEFF500" },
                                          { "NEDSZAJJXXX" },
                                          { "DABADKKK" },
                                          { "UNCRIT2B912" },
                                          { "DSBACNBXSHA" },
                                          { "BNORPHMM" } });
  }
}
