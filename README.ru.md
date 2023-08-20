# User Generator v2

> English version of README.md will be available by August 25th.

- [Главная](#user-generator-v2)
  - [Пример, краткое описание](#пример)
  - [Руководство](/GUIDE.ru.md)
  - [Будущие обновления](#будущие-обновления)
  - [Релизы](#релизы)
  - [Внимание](#внимание)
  - [Благодарности](#благодарности)

Библиотека "User Generator" - это библиотека для создания объектов класса People хранящие в себе различную информацию, она создана для тестирования различных приложений/ программ/ библиотек/ пакетов/ и тд.
User Generator v2 использует библиотеку Jsoup. [Parser](/GUIDE.ru.md#класс-parser) подключается к сайту [name-generator.org](https://www.name-generator.org.uk/quick/) и берет от туда случайные имя и фамилию, которые генерируются при каждом заходе на сайт. Также есть возможность отдельно взять объект типа Document и/или Elements.
## Пример

Ситуация: Требуется сгенерировать и вывести в терминал 5 случайных объектов People.

```java
Generator generator = new Generator(
        ParsingAlgorithm.name_generator_orgAlgorithm,
        new Parser(Website.name_generator_org){
            @Override
            public void initConnectParameters() {
                super.initConnectParameters();
                setTimeout(0);
            }
            },
        false);
People[] peoples = new People[5];
for (int i = 0; i < peoples.length; i++) {
    peoples[i] = generator.generatePeople(120, 190, 30, 150, 0, 90);
    generator.getParsingAlgorithm().setArg(0, i);
}

for (People people : peoples) {
    System.out.println(people);
}
```

## Будущие обновления

## Релизы

## Внимание

> Эта библиотека создана для случайной генерации человеческих параметров для использования их для тестирования каких либо приложений/ программ/ библиотек/ пакетов/ и тд. Все совпадения с реальными людьми исключительная случайность и автор не пытается унизить или оскорбить кого либо.

## Благодарности

+ [Jsoup](https://github.com/jhy/jsoup)
+ [name-generator.org](https://www.name-generator.org.uk/quick/)
+ [JetBrains за аннотации](https://github.com/JetBrains/java-annotations)