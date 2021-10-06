-- 함수 : 날짜 함수

-- CURDATE(), CURRENT_DATE : 오늘 날짜를 YYYY-MM-DD나 YYYYMMDD 형식으로 반환한다.
select CURDATE(), CURRENT_DATE;

-- CURTIME(), CURRENT_TIME : 현재 시각을 HH:MM:SS나 HHMMSS 형식으로 환한다.
select CURTIME(), CURRENT_TIME;

-- now() vs sysdate()
select now(), sysdate();
select now(), sleep(2), now();
select sysdate(), sleep(2), sysdate();

-- date_format(date, format) : 입력된 date를 format 형식으로 반환한다.
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초');
select date_format(now(), '%Y년 %c월 %d일 %h시 %i분 %s초');

-- period_diff : 두 인자 개월의 수 차이를 구한다
-- YYMM, YYYYMM
-- 예) 근무 개월 수를 출력
select first_name,
	   period_diff(date_format(curdate(), '%Y%m'), date_format(hire_date, '%Y%m')) as month
  from employees
order by month desc;

-- date_add(= adddate), data_sub(= subdate)
-- 날짜를 date에 type(day, month, year) 형식으로 더하거나 뺀다.
-- 예제) 각 사원들의 근무 년수가 5년이 되는 날은 언제인가?
select first_name,
	   hire_date,
       date_add(hire_date, interval 5 year)
  from employees;
  
-- cast (형변환)
-- CAST 함수의 사용법 :  CAST(expression AS type) 또는
--                    CONVERT(expression,type)
select '12345' + 10, cast('12345' as int) + 10;
select date_format(cast('2021-10-01' as date), '%Y-%m-%d');
select cast(1-2 as unsigned); -- unsigned(integer) : 
select cast(cast(1-2 as unsigned) as signed);

-- mysql type
-- varchar, char, text, CLOB(Character Large Object)
-- signd(unsigned), int(integer), medium int, big int, int(11)
-- float, double
-- time,, date, datetime
-- LOB : CLOB, BLOB












