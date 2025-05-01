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
import com.github.nalukit.iban4g.shared.bban.loader.DefaultBbanStructureProviderLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class BbanStructureProvider {

  private static BbanStructureProvider instance;

  private final EnumMap<CountryCode, BbanStructure> structures;

  private BbanStructureProvider() {
    this.structures = new EnumMap<>(CountryCode.class);
  }

  public static BbanStructureProvider get() {
    if (instance == null) {
      instance = new BbanStructureProvider();
      DefaultBbanStructureProviderLoader.get()
                                        .load();
    }
    return instance;
  }

  /**
   * Adds the BBAN structure for the given country code to the list of BBAN structures,
   *
   * @param countryCode   country code
   * @param bbanStructure BBAN structure of the country
   */
  public void addBbanStructure(CountryCode countryCode,
                               BbanStructure bbanStructure) {
    if (this.forCountry(countryCode) == null) {
      this.structures.put(countryCode,
                          bbanStructure);
    } else {
      throw new BbanStructureLoadException("structure for country: >>" + countryCode.getAlpha2() + "<< already exists!");
    }
  }

  /**
   * Returns the BBAN structure for the requesting country code
   *
   * @param countryCode the country code.
   * @return BbanStructure for specified country or null if country is not supported.
   */
  public BbanStructure forCountry(final CountryCode countryCode) {
    return this.structures.get(countryCode);
  }

  /**
   * Get a list of ths supported countries.
   *
   * @return list of supported countries
   */
  public List<CountryCode> supportedCountries() {
    return Collections.unmodifiableList(new ArrayList<>(structures.keySet()));
  }
}
