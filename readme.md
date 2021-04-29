# Java Practices

term : 2021.04.27 ~ 

desc: Maven 으로 multi projects 생성

## helloworld
Eclipse 처음 사용해보기

pom.xml 형태 살펴봄
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>com.douzone</groupId>
    <artifactId>javastudy</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <artifactId>helloworld</artifactId>
</project>
```

gitignore file : 깃헙에 올릴 때에는 pom.xml이 올라가는 것이 중요함.(설정파일은 올라가지 않도록 설정)
```
**/.classpath
**/.project
**/.settings/
**/target/
**/build/
```

## chapter03
객체 지향 프로그래밍 연습

* 클래스 연습
	* getter,setter,접근자 : Good, Good2, Song, TV
	* 생성자 : Person, paint

* call by reference : swap

* static : StaticMethod
	* instance function 및 variance 와 static function 및 variance 비교

## chapter04

## practice01~05
기본 프로그래밍 문제 풀이