-- 코드를 입력하세요
SELECT T1.FLAVOR
FROM FIRST_HALF T1
JOIN ICECREAM_INFO T2 ON T1.FLAVOR = T2.FLAVOR
WHERE T2.INGREDIENT_TYPE = 'fruit_based' AND T1.TOTAL_ORDER > 3000