package com.github.nalukit.iban4g.shared.bban;

import com.github.nalukit.iban4g.shared.CountryCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class BbanStructureProvider {

  private static BbanStructureProvider instance;

  private EnumMap<CountryCode, BbanStructure> structures;

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

  public void addBbanStructure(CountryCode countryCode,
                               BbanStructure bbanStructure) {
    this.structures.put(countryCode,
                        bbanStructure);
  }

  /**
   * @param countryCode the country code.
   * @return BbanStructure for specified country or null if country is not supported.
   */
  public BbanStructure forCountry(final CountryCode countryCode) {
    return this.structures.get(countryCode);
  }

  public List<CountryCode> supportedCountries() {
    return Collections.unmodifiableList(new ArrayList<>(structures.keySet()));
  }

}
