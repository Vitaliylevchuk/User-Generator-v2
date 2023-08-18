# User Generator v2

> English version will be available by August 21st.

- [Главная](#user-generator-v2)
    - [Внимание](#внимание)
    - [Благодарности](#благодарности)

Библиотека "User Generator" - это библиотека для создания объектов класса People хранящие в себе различную информацию, она создана для тестирования различных приложений/ программ/ библиотек/ пакетов/ и тд.

## Пример

![](img/example.png)

Выше приведен пример использования, на нем объект Generator возвращает значение типа People, хранящее в себе случайную информацию. Весь выше-написанный код будет объяснен ниже.

## Принцип

User Generator v2 _(далее - ug2)_ использует библиотеку Jsoup. Ug2 подключается к сайту [name-generator.org](https://www.name-generator.org.uk/quick/) и берет от туда случайные имя и фамилию, которые генерируются при каждом заходе на сайт. Также есть возможность отдельно взять объект типа Document и/или Elements.

### [Класс Parser](src/main/java/com/fbs/util/Parser)



## Внимание

> Эта библиотека создана для случайной генерации человеческих параметров для использования их для тестирования каких либо приложений/ программ/ библиотек/ пакетов/ и тд. Все совпадения с реальными людьми исключительная случайность и автор не пытается унизить или оскорбить кого либо.

## Благодарности

+ [Jsoup](https://github.com/jhy/jsoup)
+ [name-generator.org](https://www.name-generator.org.uk/quick/)
+ [JetBrains (аннотации)](https://github.com/JetBrains/java-annotations)