/*
 * Copyright 2013 Artur Mkrtchyan
 * Modification Copyright 2017 Frank Hossfeld
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.mvp4g.iban4g;

import com.github.mvp4g.iban4g.shared.BicTest;
import com.github.mvp4g.iban4g.shared.BicUtilTest;
import com.github.mvp4g.iban4g.shared.CountryCodeTest;
import com.github.mvp4g.iban4g.shared.IbanTest;
import com.github.mvp4g.iban4g.shared.IbanUtilTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;

public class GwtSuite {
  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("Test suite for lib");
    suite.addTestSuite(BicTest.class);
    suite.addTestSuite(BicUtilTest.class);
    suite.addTestSuite(CountryCodeTest.class);
    suite.addTestSuite(IbanTest.class);
    suite.addTestSuite(IbanUtilTest.class);
    return suite;
  }
}
