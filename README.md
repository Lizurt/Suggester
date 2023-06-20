# Suggester

## About

A library for getting autocomplete suggestions for a given text of any language that can be described using ANTLR grammar.

The library uses ANTLR (version 4) grammar to generate suggestions, so it uses not only keywords, but also the grammar, word order.

## Usage

### Importing library

Unfortunately, the library hasn't been published on the central Maven repository yet. You'll have to import this library via downloading it from the GitHub repository. You can download the source code or a .jar file published in Releases in the repository.

If you have downloaded the .jar file, you can import it using your favorite tool.

**IntelliJ IDEA** users can [import it using the IDE itself](https://stackoverflow.com/questions/21051991/importing-jar-file-into-intellij-idea) by going into File -> Project Structure -> Libraries.

**Gradle** users can import the .jar by adding a dependency like this one:

```groovy
dependencies {
    implementation files('path/to/library.jar')
}
```

**Maven** users can import the library by adding a dependency in their .pom file like this:

```xml
<dependencies>
    <dependency>
        <groupId>com.lizurt.suggester</groupId>
        <artifactId>Suggester</artifactId>
        <version>2.1</version>
        <scope>system</scope>
        <systemPath>your/path/to/library.jar</systemPath>
    </dependency>
</dependencies>
```

If you use Windows, you probably want to assign the path `D:\\like\\this.jar`.

### Generating suggestions

As you know, this library uses ANTLR4 grammar to generate suggestions. Unfortunately, you cannot use raw .g4 files to generate suggestions and have to generate java classes for the grammar firstly. You can easily generate these classes by using, for example an antlr maven plugin.

After generating grammar classes, you can finally generate suggestions:

```java
LexerAndParserFactory lexerAndParserFactory = new ReflectiveLexerAndParserFactory(
        grammar.JavaLexerRules.class, grammar.JavaParserRules.class
);
Suggester suggester = new Suggester(
        lexerAndParserFactory
        Set.of("Identifier")
);
suggester.setCasePreference(CasePreference.LOWER);

String input = "package test; public class App { pr";
List<String> suggestions = suggester.generateAndGetSuggestions(input);
```

For such java grammar example, the library would spend up to 5 ms to generate suggestions "ivate" and "otected".

LexerAndParserFactory is an interface that can generate lexer and parser instances. The default, already implemented way to generate the instances is using `ReflectiveLexerAndParserFactory` that requires 2 arguments in its constructor: a lexer rules class and a parser rules class. As mentioned earlier, these classes can be generated using maven plugins.

After that, you'll need to create a `Suggester` instance. The first argument is the `LexerAndParserFactory` instance that generates lexer and parser instances. Also, there is a second argument that you can assign. Sometimes it's useful to not generate suggestions for some rules, which we can do by giving a set of lexer rule names as the second argument. If your language supports not only keywords, but also identifiers (function names, variables, etc) like almost all languages do, you probably don't want to see suggestions like "Aa", "Ab", "AA" or other similar ones. An attempt to generate such suggestions will **significantly** increase suggestions generation time (up to 10 s for the example above).

Additionally, you can define your suggestions' case preferences by giving a Suggester's `casePreference` field a new value. In this example, we try to get lower-cased suggestions.

The last code line finally generates a list of suggestions but simply calling `generateAndGetSuggestions` method with an input text fragment argument.


