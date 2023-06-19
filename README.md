# BlockToon Comment
[BlockToon Organization 주소](https://github.com/N0T-BAD)

MSA 프로젝트로 6개의 서비스로 구성되어있는데 그 중 댓글 서비스입니다. 해당 링크를 접속하시면 자세한 정보와 세부 내용을 보실 수 있습니다.

주요기능은 클라이언트가 웹툰에 댓글을 남길 수 있는 기능입니다. 추가적으로 댓글 신고 시 관리자 페이지에서 댓글을 검수할 수 있습니다.

해당 서비스에서는 댓글/대댓글 작성, 삭제, 댓글 좋아요/싫어요, 댓글 고정, 댓글 신고, 신고 내용 승인/반려 기능이 있습니다. 

### 환경 변수
연결을 위한 환경 변수 세팅입니다.
<table>
  <tr>
    <td><b>environment</b></td>
    <td><b>description</b></td>
  </tr>
  <tr>
    <td><b>{DB_MASTER_URL}</b></td>
    <td><b>MY SQL MASTER DB URL을 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{DB_SLAVE_URL}</b></td>
    <td><b>MY SQL SLAVE DB URL을 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{DB_USERNAME}</b></td>
    <td><b>MY SQL DB USERNAME을 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{DB_PASSWORD}</b></td>
    <td><b>MY SQL DB PASSWORD를 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{EUREKA_DEFAULT_ZONE}</b></td>
    <td><b>EUREKA DEFAULT ZONE을 입력해주세요</b></td>
  </tr>
  
  <tr>
    <td><b>{KAFKA_BOOTSTRAP_ADDRESS}}</b></td>
    <td><b>Kafka bootstrap 주소를 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{DOCKERHUB_USERNAME}</b></td>
    <td><b>DOCKERHUB 명을 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{DOCKERHUB_PASSWORD}</b></td>
    <td><b>DOCKERHUB 비밀번호를 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{VM_INSTANCE_HOST}</b></td>
    <td><b>VM 인스턴스 Host를 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{SSH_USERNAME}</b></td>
    <td><b>SSH USERNAME을 입력해주세요</b></td>
  </tr>
  <tr>
    <td><b>{SSH_PRIVATE_KEY}</b></td>
    <td><b>SSH PRIVATE KEY를 입력해주세요</b></td>
  </tr>
</table>

* 환경 변수를 바탕으로 application.yml 파일을 생성합니다.

```yml
server:
  port: 8085

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: ${eureka.client.service-url.defaultZone }

spring:
  application:
    name: comment-service

  datasource:
    master:
      driver-class-name: com.mysql.cj.jdbc.Driver
      jdbc-url: ${spring.datasource.master.jdbc-url}
      username: ${spring.datasource.master.username}
      password: ${spring.datasource.master.password}

    slave:
      driver-class-name: com.mysql.cj.jdbc.Driver
      jdbc-url: ${spring.datasource.slave.jdbc-url}
      username: ${spring.datasource.slave.username}
      password: ${spring.datasource.slave.password}

  kafka:
    bootstrapAddress: ${spring.kafka.bootstrapAddress}
    commentTopic: commentCount
    commentGroup: commentCountGroup


  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
        format_sql: true
    hibernate:
      ddl-auto: update
    show-sql: true



```
* 위의 과정을 마치고 프로그램을 실행합니다.

<br>

<br>
