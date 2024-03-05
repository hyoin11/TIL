# Deep Copy
### ObjectMapper를 통한 Deep Copy
- jackson-databind 라이브러리 필요
- 사용방법
  1. mapper 선언
  2. deep copy 할 객체와 데이터 타입을 선언

```
dependencies {
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.16.1'
}
```
```java
ObjectMapper mapper = new ObjectMapper();
Type copy = mapper.readValue(mapper.writeValueAsString(object), Object.class);
```


> 참고  
> https://myborn.tistory.com/23
