# tdd-introduction
### TDD(Test Driven Development)
선 테스트 후 개발방식의 프로그래밍
자동화된 테스트 코드를 작성한 후 테스트를 통과하기 위한 최소한의 코드를 개발하는 방식

1. 테스트 케이스 작성
2. 테스트 케이스를 통과하는 코드 작성
3. 작성한 코드 리팩터링

궁금증 왜 RestAssured를 사용했을까?
- TestRestTemplate는 spring test에 포함되어있음
  - 커뮤니티 글을 찾아보면 거의 동일한 역할을 한다고 나와있고 TestRestTemplate은 spring에서 제공
- https://tecoble.techcourse.co.kr/post/2020-08-19-rest-assured-vs-mock-mvc/
- https://www.inflearn.com/questions/783421/apitest%EC%97%90%EC%84%9C-mockmvc%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8%EA%B0%80-%EC%95%84%EB%8B%8C
- 결국 스프링 시큐리티를 포함해서 테스트를 하려면 MockMvc로 바꿔야할까?
- RestAssured를 사용하면 Spring의존성 없이 API요청을 테스트해볼 수 있어
