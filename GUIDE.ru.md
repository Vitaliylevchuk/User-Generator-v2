# User Generator v2

- [Parser](#класс-parser)
    - [ConnectParameter](#класс-connectparameter)
    - [ConnectParameters](#класс-connectparameters)
- [ParsingAlgorithm](#класс-parsingalgorithm)
- [Generator](#класс-generator)
- [People](#класс-people)

### [Класс Parser](src/main/java/org/fbs/user_generator_v2/util/Parser.java)

Служит для извлечения информации с сайта и дальнейшего его возвращения кав объекта типа Document. Для настройки функции `connect()` используется классы типа [ConnectParameter](#класс-connectparameter), и [ConnectParameters](#класс-connectparameters), исключение `timeout` имеющее тип `int`. В классе имеются два метода: `getDocument()` и `getDocumentUsingProxy()`, отличие заключается в том, что в методе `getDocumentUsingProxy()` вместе с другими параметрами передается параметр **proxy** с помощью метода `proxy()`.

Присвоение параметрам их значение происходит в методе `initConnectParameters()`, данный метод имеет модификатор доступа `public`, что позволяет относительно просто присвоить сторонние значения при создании.

```java
Parser parser = new Parser(Website.name_generator_org){
    @Override
    public void initConnectParameters() {
        super.initConnectParameters();
        // Место для переопределения параметров
    }
};
```
Но, параметры имеют свои стандартные параметры:

| Имя параметра | Значение параметра(1) | Значение параметра(2) |
|---------------|-----------------------|-----------------------|
| userAgent     | "Mozilla"             | _Не существует_       |
| cookie        | "cookieValue0"        | "cookieValue1"        |
| referrer      | "https://google.com"  | _Не существует_       |
| header        | "headerValue0"        | "headerValue1"        |
| data          | ""                    | ""                    |
| proxy         | ""                    | _Не существует_       |

#### [Класс ConnectParameter](src/main/java/org/fbs/user_generator_v2/data/ConnectParameter.java)

Представляет собой класс с приватными полями типа `Object` _для значений параметра_, и `String` _для имени параметра_.
```java
private String parameterName;

private Object parameterValue0, parameterValue1;
```

В классе имеются методы для получения или установки значений параметра.

Для получения значений параметра в версии 1.0.0:
```java
    public String getParameterName(){
        return parameterName;
    }

    public @Nullable Object getParameterValue(int index){
        return switch (index) {
            case 0 -> parameterValue0;
            case 1 -> parameterValue1;
            default -> null;
        };
    }
```

Для установки параметров в версии 1.0.0:

```java
    public void setParameterValue(int index, Object value){
        switch (index) {
            case 0 -> parameterValue0 = value;
            case 1 -> parameterValue1 = value;
        };
    }
    
    public void setParameterValue(Object value){
        parameterValue0 = value;
    }
    public void setParameterValues(Object value0, Object value1){
        parameterValue0 = value0;
        parameterValue1 = value1;
    }
```

#### [Класс ConnectParameters](src/main/java/org/fbs/user_generator_v2/data/ConnectParameters.java)

ConnectParameters является массивом [ConnectParameter](#класс-connectparameter), который имеет методы для упрощения работы с ним, как с массивом.

В версии 1.0.0 имеет следующие методы:

```java
public ArrayList<ConnectParameter> getParameters() {
        return parameters;
}

public @Nullable ConnectParameter getByName(String parameterName){
    for (ConnectParameter parameter : parameters){
        if (Objects.equals(parameter.getParameterName(), parameterName)){
            return parameter;
        }
    }
    return null;
}
```

Метод `getByName(String name)`, принимает имя параметра и среди принадлежащих ему параметров ищет и возвращает его как объект класса [ConnectionParameter](#класс-connectparameter).

### [Класс ParsingAlgorithm](/src/main/java/org/fbs/user_generator_v2/data/ParsingAlgorithm.java)

Имеет внутри только один основной метод, возвращающий значение типа Elements, стандартная реализация которого возвращает null
```java
public Elements parsing(Document document){
    return null;
}
```

### [Класс Generator](/src/main/java/org/fbs/user_generator_v2/Generator.java)

Метод `generatePeople()` возвращает значение типа People при этом принимает значения макс./мин. возраст, макс./мин. рост макс./мин. вес.

```java
public People generatePeople(int heightMin, int heightMax, int weightMin, int weightMax, int ageMin, int ageMax) throws IOException {
    int height;
    int weight;
    int age;
    int index;

    try {
        index = (Integer) parsingAlgorithm.getArgs()[0];
    }catch (NullPointerException e){
        index = 0;
    }

    try {
        age = (Integer) parsingAlgorithm.getArgs()[1];
    }catch (NullPointerException e){
        age = ageMin + new Random().nextInt(ageMax - ageMin);
    }

    try{
        weight = (Integer) parsingAlgorithm.getArgs()[2];
    }catch (NullPointerException e){
        weight = weightMin + new Random().nextInt(weightMax - weightMin);
    }

    try{
        height = (Integer) parsingAlgorithm.getArgs()[3];
    }catch (NullPointerException e){
        height = heightMin + new Random().nextInt(heightMax - heightMin);
    }

    String id = String.valueOf(("" + height + weight + age).hashCode()) + elements.get(index).text().replaceAll(" ", "").toLowerCase();

    return new People(Objects.requireNonNull(elements.get(index)).text(), age, height, weight, id);

}
```

Так же параметры берутся из аргументов из ParsingAlgorithm переменной:

| Имя переменной | Индекс аргумента | Стандартное значение                           | Описание                                  |
|----------------|------------------|------------------------------------------------|-------------------------------------------|
| height         | 3                | Случайное значение между heightMin и heightMax | Переменная height выводного класса People |
| weight         | 2                | Случайное значение между weightMin и weightMax | Переменная weight выводного класса People |
| age            | 1                | Случайное значение между ageMin и ageMax       | Переменная age выводного класса People    |
| index          | 0                | 0                                              | Индекс имени                              |


### [Класс People](/src/main/java/org/fbs/user_generator_v2/data/People.java)

### [Класс Website](/src/main/java/org/fbs/user_generator_v2/data/Website.java)
