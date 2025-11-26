package com.hhp227.kotlinstudy.`16_dto`

/*
과제1. 동적 Json 처리 연습
테스트 데이터 : 마스크 재고 API

요구사항:
1. 주어진 URL의 JSON 데이터를 담을 수 있는 DTO 작성
   - 모든 필드를 누락없이 포함할 것
   - Nullable 타입 적절히 사용
   - 인공지능의 도움 가능
2. 도메인 모델 클래스 (Store) 정의
   - 필요한 필드만 포함
3. Mapper 구현
   - DTO → 도메인 모델 변환 로직 작성
4. Repository 작성
   - 유효한 데이터만 반환하도록 구현 (remainStat, stockAt, createdAt이 null 또는 빈값인 경우 제외)
   - Mapper 활용

과제2. DTO, Mapper 연습
장표 2, 3의 형태로 Json 데이터가 들어오는 경우를 처리할 수 있도록 다음을 작성하시오

1. DTO 작성
   - JSON 응답 구조와 정확히 매핑되는 PhotoDto 클래스 작성
   - created_at은 String?으로 받기
2. Model 클래스 작성
   - createdAt은 LocalDate 타입 사용
   - type은 enum 클래스로 구현 (Article, Image, Video, Unknown)
3. Mapper 클래스 작성
   - DTO → Model 변환 로직 구현
   - type이 없거나 잘못된 경우 Unknown으로 처리
   - 날짜 형식 변환 처리 (String → LocalDate 변환 처리)
4. Repository 구현
   - MockPhotoDataSourceImpl 를 사용하여 데이터 요청
   - 응답 데이터를 모델로 변환하여 반환
 */