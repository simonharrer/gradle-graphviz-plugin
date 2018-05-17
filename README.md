# gradle-modernizer-plugin [![Build Status](https://travis-ci.org/simonharrer/gradle-graphviz-plugin.svg?branch=master)](https://travis-ci.org/simonharrer/gradle-modernizer-plugin)

Converts your src/main/graphviz/*.dot to build/graphviz/*.png. It does nothing else.

Uses the great [graphviz-java](https://github.com/nidi3/graphviz-java) library for conversion.

## Usage

Add to your gradle script

```groovy
plugins {
   id "com.simonharrer.graphviz" version "0.0.1"
}
```

and use it from the command line

```bash
$ gradle graphviz
```

## Configuration

No configuration possible. It just converts your src/main/graphviz/*.dot to build/graphviz/*.png.

## License

[MIT license](https://tldrlegal.com/license/mit-license). See the [LICENSE.md](LICENSE.md) for the full MIT license.

