package de.gishmo.gwt.iban4g;

import com.google.gwt.junit.tools.GWTTestSuite;
import de.gishmo.gwt.iban4g.shared.*;
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
