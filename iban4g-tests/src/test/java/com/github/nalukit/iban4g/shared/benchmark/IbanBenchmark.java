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
package com.github.nalukit.iban4g.shared.benchmark;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.github.nalukit.iban4g.shared.CountryCode;
import com.github.nalukit.iban4g.shared.Iban;
import com.github.nalukit.iban4g.shared.IbanUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class IbanBenchmark {

  private static final long LOOPS_COUNT = 1000000;

  @Rule public TestRule benchmarkRun = new BenchmarkRule();

  @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 1)
  @Test
  public void ibanConstruction() {
    for (int i = 0; i < LOOPS_COUNT; i++) {
      Iban iban =
          Iban.builder()
              .countryCode(CountryCode.DE)
              .bankCode("52060170")
              .accountNumber("0012335785")
              .build();
    }
  }

  @BenchmarkOptions(benchmarkRounds = 3, warmupRounds = 1)
  @Test
  public void ibanValidation() {
    for (int i = 0; i < LOOPS_COUNT; i++) {
      IbanUtil.validate("DE89370400440532013000");
    }
  }
}
