[![Support](https://img.shields.io/badge/Support-Community%20(no%20active%20support)-orange.svg)](https://docs.mendix.com/developerportal/app-store/app-store-content-support)
[![Studio](https://img.shields.io/badge/Studio%20version-8.0%2B-blue.svg)](https://appstore.home.mendix.com/link/modeler/)
![GitHub release](https://img.shields.io/github/release/JelteMX/mendix-math-module)
![GitHub issues](https://img.shields.io/github/issues/JelteMX/mendix-math-module)

# Math Module for Mendix

![Icon](/assets/AppStoreIcon.png)

Do you feel the need to do more complex calculations in Mendix, but see a lack in capabilities in your Microflows? No worries, the Math Module is here to help you out. This uses the excellent [mXparser libary](https://mathparser.org/) to extend your workflows with more complex calculations.

> **See a demo in action [HERE](https://mathenginetestapp-sandbox.mxapps.io/p/simple)!**

> I am looking for skilled Mendix+Java developers to help me make this even greater. The current set of Java actions are very flexible, but we can make more complex and dedicated actions available in the future. Feel free to contact me on Gitthub or through my [Mendix Developer profile](https://developer.mendixcloud.com/link/profile/overview/24785)

![screenshot](/assets/screenshot-simple.png)
![screenshot](/assets/screenshot-complex.png)

## Java Actions

### Expressions

- **SimpleExpression** - calculate a simple expression that uses a formula you define as a String
- **ComplexExpression** - calculate a more complex expression that uses Arguments

### Function

- **RecursiveFunction** - Do you need to calculate `f(10)` for `f(n)=f(n-2)+f(n-1)`? A recursive function might help you out

### Decimals

- **MoveDecimalPoint** - Move a decimal point in a Decimal

### Conversion

- **ConvertIntToBaseString** - Do you need to represent an Integer (base10) into another form, for example Octal (base8) or Hex (base16)?

## Syntax

The expressions and functions you write can use a whole range of built-in functions and constants. These can be found at [https://github.com/mariuszgromada/MathParser.org-mXparser#built-in-tokens](https://github.com/mariuszgromada/MathParser.org-mXparser#built-in-tokens)

## Libraries used

- mXparser library
    - Version 4.3.3
    - License: Simplified BSD - Mariusz Gromada
    - [link](https://github.com/mariuszgromada/MathParser.org-mXparser/blob/master/LICENSE.txt)

## Adding new Java Actions

You can create new Java Actions using the mXparser library. See [API docs](http://mathparser.org/api/org/mariuszgromada/math/mxparser/package-summary.html).

## License

Apache 2