/*
 * Copyright 2017 Frank Hossfeld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.gishmo.gwt.iban4g.shared;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.regexp.shared.SplitResult;

public class StringUtils {
  public static String format(final String format,
                              final Object... args) {
    final RegExp regex = RegExp.compile("%[a-z]");
    final SplitResult split = regex.split(format);
    final StringBuffer msg = new StringBuffer();
    for (int pos = 0; pos < split.length() - 1; ++pos) {
      msg.append(split.get(pos));
      msg.append(args[pos].toString());
    }
    msg.append(split.get(split.length() - 1));
    return msg.toString();
  }
}
