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
