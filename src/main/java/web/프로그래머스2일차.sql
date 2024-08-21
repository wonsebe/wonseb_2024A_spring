/*
    프로그래머스 sql 문제
    # 1.[ SUM, MAX, MIN ] 가장 비싼 상품 구하기
    SELECT max(PRICE)
    FROM  PRODUCT

    # 2.[ SUM, MAX, MIN ] 최댓값 구하기
    SELECT max(DATETIME)
    FROM ANIMAL_INS

    # 3.[ SUM, MAX, MIN ] 가격이 제일 비싼 식품의 정보 출력하기
    SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CD, CATEGORY, PRICE
    FROM FOOD_PRODUCT
    WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);

    # 4.[ SUM, MAX, MIN ] 최솟값 구하기
    SELECT min (DATETIME)
    FROM ANIMAL_INS

    # 5.[ SUM, MAX, MIN ] 동물 수 구하기
    SELECT count(*)
    FROM ANIMAL_INS

    # 6.[ SUM, MAX, MIN ] 중복 제거하기
    SELECT COUNT(DISTINCT NAME )
    FROM ANIMAL_INS

    # 7.[ SUM, MAX, MIN ] 조건에 맞는 아이템들의 가격의 총합 구하기
    SELECT sum(PRICE) AS TOTAL_PRICE
    FROM ITEM_INFO
    WHERE RARITY LIKE '%LEGEND%'

    # 8.[SELECT] 조건에 맞는 회원수 구하기
    SELECT COUNT(AGE) AS USERS
    FROM USER_INFO
    WHERE JOINED LIKE '%2021%'
    AND AGE BETWEEN 20 AND 29

    # 9.[SELECT] 잔챙이 잡은 수 구하기
    SELECT COUNT(*) AS FISH_COUNT
    FROM FISH_INFO
    WHERE LENGTH IS NULL

    # 10.[SELECT] 특정 형질을 가지는 대장균 찾기


    # 11.[GROUP BY]자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
    SELECT  CAR_TYPE , COUNT(*) AS CARS
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE OPTIONS LIKE '%시트%'
    GROUP BY CAR_TYPE
    ORDER BY CAR_TYPE ASC

    # 12.[GROUP BY]성분으로 구분한 아이스크림 총 주문량
    SELECT i.INGREDIENT_TYPE,
    SUM(f.TOTAL_ORDER) AS TOTAL_ORDER
    FROM FIRST_HALF f
    JOIN ICECREAM_INFO i ON f.FLAVOR = i.FLAVOR
    GROUP BY i.INGREDIENT_TYPE
    ORDER BY TOTAL_ORDER;

    # 13.[GROUP BY]진료과별 총 예약 횟수 출력하기


    # 14.[GROUP BY]고양이와 개는 몇 마리 있을까

    # 15.[GROUP BY]동명 동물 수 찾기

    # 16. [GROUP BY]조건에 맞는 사원 정보 조회하기

    # 17. [GROUP BY]물고기 종류 별 잡은 수 구하기

    # 18. [JOIN]상품 별 오프라인 매출 구하기





*/