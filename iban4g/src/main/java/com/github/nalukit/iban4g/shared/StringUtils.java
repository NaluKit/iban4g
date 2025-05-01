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
package com.github.nalukit.iban4g.shared;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

  public static String format(final String format, final Object... args) {
    String value = format;
    List<String> splits = new ArrayList<>();
    while (value.contains("%s")) {
      int pos = value.indexOf("%s");
      String split = value.substring(0, pos);
      splits.add(split);
      value = value.substring(pos + 2);
    }
    splits.add(value);

    final StringBuilder msg = new StringBuilder();
    for (int pos = 0; pos < splits.size() - 1; ++pos) {
      msg.append(splits.get(pos));
      msg.append(args[pos].toString());
    }
    msg.append(splits.get(splits.size() - 1));
    return msg.toString();
  }
}
