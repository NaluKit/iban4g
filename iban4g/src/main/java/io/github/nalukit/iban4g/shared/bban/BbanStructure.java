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
package io.github.nalukit.iban4g.shared.bban;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class which represents bban structure
 */
public class BbanStructure {

  private final BbanStructureEntry[] entries;

  public BbanStructure(final BbanStructureEntry... entries) {
    this.entries = entries;
  }

  public List<BbanStructureEntry> getEntries() {
    return Collections.unmodifiableList(Arrays.asList(entries));
  }

  /**
   * Returns the length of bban.
   *
   * @return int length
   */
  public int getBbanLength() {
    int length = 0;
    for (BbanStructureEntry entry : entries) {
      length += entry.getLength();
    }
    return length;
  }
}
