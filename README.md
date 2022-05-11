# IBAN4G

![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)  [![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Chat on Gitter](https://badges.gitter.im/hal/elemento.svg)](https://gitter.im/Nalukit42/Lobby) ![CI](https://github.com/NaluKit/iban4g/workflows/CI/badge.svg) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nalukit/iban4g/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.nalukit/iban4g) ![Test](https://github.com/NaluKit/iban4g/workflows/Test/badge.svg)


A port of Artur Mkrtchyan's iban4j project, so that it works in a pure Java project and projects using GWT or J2CL. Artur's project can be found <a href="https://github.com/arturmkrtchyan/iban4j">here</a>

A Java, GWT and J2CL ready library for generation and validation of the International Bank Account Numbers (<a href="http://en.wikipedia.org/wiki/ISO_13616" target="_blank">IBAN ISO_13616</a>) and Business Identifier Codes (<a href="http://en.wikipedia.org/wiki/ISO_9362" target="_blank">BIC ISO_9362</a>). The library can be used on the client and server side!

**The library can be used in a Java-, GWT- or J2CL-environment.**

Documentation and most of the classes are copied from [iban4j](https://github.com/arturmkrtchyan/iban4j).


#### Iban quick examples:

That's the way how to generate an Iban using the 'new' keyword:
```
Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();
```
and that is the way to generate an IBAN without using the 'new' keyword:
```
Iban iban = Iban.builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();
```

Creating an Iban object from String:
```
Iban iban = Iban.valueOf("DE89370400440532013000");
```
and from formatted String:
```
Iban iban = Iban.valueOf("DE89 3704 0044 0532 0130 00", IbanFormat.Default);
```

Generating a random Iban:
```
 // How to generate random Iban
 Iban iban = Iban.random(CountryCode.AT);
 Iban iban = Iban.random();
 Iban iban = Iban.builder()
                 .countryCode(CountryCode.AT)
                 .bankCode("19043")
                 .buildRandom();
```
Validating an Iban:
```
try {
    IbanUtil.validate("AT611904300234573201");
    IbanUtil.validate("DE89 3704 0044 0532 0130 00", IbanFormat.Default);
    // valid
} catch (IbanFormatException |
         InvalidCheckDigitException |
         UnsupportedCountryException e) {
    // invalid
}
```

#### Bic quick examples:

```
 //How to create Bic object from String
 Bic bic = Bic.valueOf("DEUTDEFF");


 //How to validate Bic
 try {
     BicUtil.validate("DEUTDEFF500");
     // valid
 } catch (BicFormatException e) {
     // invalid
 }
```

#### Maven dependency:
```xml
<dependency>
  <groupId>com.github.nalukit</groupId>
  <artifactId>iban4g</artifactId>
  <version>HEAD-SNAPSHOT</version>
</dependency>
```

#### Module dependency:
```xml
<inherits name="com.github.nalukit.iban4g.Iban4g" />
```

#### References

- [Artur Mkrtchyan's IBAN4j project](https://github.com/arturmkrtchyan/iban4j)
- [https://en.wikipedia.org/wiki/ISO_13616](https://en.wikipedia.org/wiki/ISO_13616)
- [https://en.wikipedia.org/wiki/ISO_9362](https://en.wikipedia.org/wiki/ISO_9362)
- [https://www.ecb.europa.eu/paym/retpaym/paymint/sepa/shared/pdf/iban_registry.pdf](https://www.ecb.europa.eu/paym/retpaym/paymint/sepa/shared/pdf/iban_registry.pdf)
- [https://www.swift.com/dsp/resources/documents/IBAN_Registry.pdf](https://www.swift.com/dsp/resources/documents/IBAN_Registry.pdf)
- [https://www.swift.com/resource/iban-registry-pdf](https://www.swift.com/resource/iban-registry-pdf)
- [https://bank.codes/iban/structure](https://bank.codes/iban/structure)

## To get in touch with the developer
Please use the [Nalu Gitter room](https://gitter.im/Nalukit42/Lobby).

## Notes
In case you find a bug, please open an issue.

## License
Copyright 2015 Artur Mkrtchyan

Modifications Copyright 2020 Frank Hossfeld

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
