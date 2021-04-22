# Session Management in Spring Boot

Session Management is used to to keep track of client's activity across multiple requests. A single user's information on the session is stored in a web container using this mechanism. This repository uses <b> HttpSession </b> to demonstrate Session Management in Spring Boot.
Two approaches are demonstrated here.
1. Using Spring Session JDBC : Provides SessionRepository implementation backed by a relational database and configuration support.
2. Using Spring Session Redis : Provides SessionRepository and ReactiveSessionRepository implementation backed by Redis and configuration support.

### Approach 01 : Using Spring Session JDBC
1. Create a simple application as in this repository
2. Include the following dependency in pom.xml

![image](https://user-images.githubusercontent.com/77454499/115684644-28721b80-a375-11eb-939a-7ded5314db87.png)
3. Also specify <i> spring.session.store-type=jdbc </i> in application.properties

### Testing
Use the credentials Username: Admin and Password: password
The application would simply look like:

![](https://github.com/FathimaShafana/SAD/blob/main/Spring_Session/session_SC/jdbc11.JPG?raw=true)

Sessions are stored in h2 database as follows with the attribute_name MY_MESSAGES:

![](https://github.com/FathimaShafana/SAD/blob/main/Spring_Session/session_SC/spring_session.JPG?raw=true)

### Approach 02 : Using Spring Session Redis
1. Create a simple application as in this repository
2. Include the following dependencies in pom.xml

![image](https://user-images.githubusercontent.com/77454499/115684477-04aed580-a375-11eb-9f08-e1a2cdd77435.png)

3. Also specify the following in application.properties
   <i> spring.session.store-type=redis
    spring.redis.host=localhost
    spring.redis.port=6379 </i>

### Testing
The application would simply look like:

![](https://github.com/FathimaShafana/SAD/blob/main/Spring_Session/session_SC/redis1.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/Spring_Session/session_SC/redis2.JPG?raw=true)

The redis client would have the following output

![](https://github.com/FathimaShafana/SAD/blob/main/Spring_Session/session_SC/redis%20test.JPG?raw=true)


