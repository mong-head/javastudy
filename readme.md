# Java Study

term : 2021.04.27 ~ 2021.05.14

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
	* getter,setter,접근자 : good, good2, song, tv
	* 생성자 : person, paint
	* 상속 - type casting : person
	* interface : paint (Drawable)

* call by reference : swap

* static : staticmethod
	* instance function 및 variance 와 static function 및 variance 비교

* 예외처리 : exception

* singleton : 객체 하나만 만들 수 있는 것 (chapter04의 Date의 Calendar관련)

## chapter04
API : lang, io, util, net

### lang 

* object

### io

* string, Wrapper

* stream (주, 보조)
	* byte
		* 주 스트림 : InputStream, OutputStream
		* 보조 스트림 : FilterInputStream
	* char
		* 주 스트림 : Reader, Writer
		* 보조 스트림 : BufferedRead
 
 	-> Scanner내부 구조와 비슷함

### util

* Date, Calendar

* collection
	* vector
		* 예전방식(test01)
		* 현재방식(test02) - List(부모 referencing)
	* arraylist, linkedlist : vector코드에서 자료구조만 변경
	
	* HashMap
		* Key : value
		* key 는 Set

## network

### net

InetSocketAddress(socket) = InetAddress(IP) + Port(TCP)

##### 1. InetAddress 연습

* network.test
	* Localhost : (cmd)ipconfig 관련 
* network.util
	* NSLookup : (cmd)nslookup 관련 
	
##### 2. Socket 연습

net.Socket, net.InetSocketAddress, net.ServerSocket

* network.test
	* TCP Client / Server 

* network.echo
	* Echo Server / Client
		* EchoServer : single-thread; client 여러개 연결 못함
		* EchoServer2 : multi-thread; client 여러개 연결; thread 사용
			* EchoServerReceiveThread : Thread 상속받음
		* EchoServer3 : multi-thread; client 여러개 연결; Runnable 사용
			* EchoServerRunnableImpl : Runnable
			
* thread : multi-thread 연습
	* ThreadEx01 : mainThread, DigitThread
	* ThreadEx02 : mainThread, DigitThread, AlphabetThread 
		* mainThread가 먼저끝나도 다른 thread끝날 때까지 끝나지 않음
	* ThreadEx03 : mainThread, DigitThread, AlphabetThread, UppercaseAlphabetThread
		* thread 만드는 2가지 방법
			1. Thread 상속 ; Digit, Alphabet
			2. Runnable ; UppercaseAlphabet

##### 3. webserver

* httpd
	
	<img src="https://user-images.githubusercontent.com/52481037/117239269-7143cd00-ae69-11eb-8b40-4a251b566047.png" width="600" height="300">

	* httpd : eclipse 환경 실행
	* httpd2 : linux 환경 실행
* webapp
	* http, css등등
	

## practice01~05
기본 프로그래밍 문제 풀이
