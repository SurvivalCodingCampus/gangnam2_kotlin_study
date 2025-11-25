package com.hhp227.kotlinstudy.`15_http`

/*
연습문제1. RemoteDataSource 구현 (CRUD)
JSONPlaceholder API를 사용하여 게시글 데이터를 처리하는 RemoteDataSource 인터페이스와 구현체를 작성
Response<T> 형태의 응답 객체를 사용하여 HTTP 상태 코드, 헤더, 바디(T)를 포함할 것.

다음 메서드를 구현합니다
a.getPosts()
b.getPost(id)
c.createPost(post)
d.updatePost(id, post)
e.patchPost(id, post),
f.deletePost(id)

연습문제2. RemoteDataSource 테스트 코드 작성
HTTP Mock 객체를 사용하여 각 CRUD 메서드의 테스트 코드를 작성할 것
데이터소스의 성공 및 실패 케이스를 모두 테스트하고, 응답 데이터를 검증할 것
“ktor 클라이언트의 mock client 예시” 를 인공지능에 검색하고 활용 가능

테스트 케이스

1. 각 성공 케이스
2. 네트워크 에러 케이스
3. 존재하지 않는 ID 요청 케이스

연습문제3. Repository 패턴 적용 및 데이터 가공
RemoteDataSource를 생성자로 주입받아 사용하는 PostRepositoryImpl 클래스를 구현합니다.
getPostsByKeyword(String keyword) 메서드를 구현하여 모든 게시글을 가져온 후, 제목(title)에 특정 keyword가 포함된 게시글만 필터링하여 반환합니다.
Repository의 테스트 코드를 작성하여 데이터 가공 로직을 검증합니다.

연습문제4. 사진 다운로드 기능
네트워크 상의 사진 파일을 다운로드 받는 기능을 작성한다. ByteArray 는 byte[ ] 다. 즉, 메모리에 쓸 수 있는 가장 원초적인 타입이다.

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}

다음의 기능을 구현한다

interface ImageRepository {
    // URL에서 이미지를 다운로드하여 저장된 경로에 저장
    suspend fun saveImage(url: String, path: String)
    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    suspend fun saveImages(urls: List<String>, directory: String)
    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}
 */