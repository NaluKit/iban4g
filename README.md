iban4g
======

<!-- [![Build Status](https://api.travis-ci.org/repositories/arturmkrtchyan/iban4j.png)](https://travis-ci.org/arturmkrtchyan/iban4j) [![Coverage Status](https://img.shields.io/coveralls/arturmkrtchyan/iban4j.svg)](https://coveralls.io/r/arturmkrtchyan/iban4j) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.iban4j/iban4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.iban4j/iban4j) -->
<!-- [![License](http://img.shields.io/:license-Apache 2.0-blue.svg)](https://raw.githubusercontent.com/arturmkrtchyan/iban4j/master/LICENSE.txt) -->

A port of Artur Mkrtchyan's iban4j project to GWT. Artur's project can be found <a href="https://github.com/arturmkrtchyan/iban4j">here</a>

A GWT library for generation and validation of the International Bank Account Numbers (<a href="http://en.wikipedia.org/wiki/ISO_13616" target="_blank">IBAN ISO_13616</a>) and Business Identifier Codes (<a href="http://en.wikipedia.org/wiki/ISO_9362" target="_blank">BIC ISO_9362</a>). The library can be used on the client and server side!

Documentation and most of the classes are copied from [iban4j](https://github.com/arturmkrtchyan/iban4j).


#### Iban quick examples:

```java
 // How to generate Iban
 Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("19043")
                .accountNumber("00234573201")
                .build();


 // How to create Iban object from String
 Iban iban = Iban.valueOf("DE89370400440532013000");

 // How to create Iban object from formatted String
 Iban iban = Iban.valueOf("DE89 3704 0044 0532 0130 00", IbanFormat.Default);

 // How to generate random Iban
 Iban iban = Iban.random(CountryCode.AT);
 Iban iban = Iban.random();
 Iban iban = new Iban.Builder()
                 .countryCode(CountryCode.AT)
                 .bankCode("19043")
                 .buildRandom();

 // How to validate Iban 
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

```java
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
  <groupId>com.github.mvp4g</groupId>
  <artifactId>iban4g</artifactId>
  <version>1.1.0</version>
</dependency>
```

#### Module dependency:
```xml
<inherits name="com.github.mvp4g.iban4g.Iban4g" />
```

#### References

- <a href="https://github.com/arturmkrtchyan/iban4j">Artur Mkrtchyan's IBAN4j project</a>
- http://en.wikipedia.org/wiki/ISO_13616
- http://en.wikipedia.org/wiki/ISO_9362
- http://www.swift.com/dsp/resources/documents/IBAN_Registry.pdf

## License
Copyright 2015 Artur Mkrtchyan

Modifications Copyright 2017 Frank Hossfeld


Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
