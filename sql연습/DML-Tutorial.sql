-- Basic Query

-- 테이블 삭제
drop table pet;

-- 테이블 생성
create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);

-- scheme 확인
desc pet;

-- 조회
select name, owner, species, gender, birth, death from pet;

-- insert
insert into pet value ('성탄이', '선생님', 'dog', 'm', '2018-12-25', null);

-- 데이터 삭제 (delete)
delete from pet where name = '성탄이';

-- load data local infile
load data local infile 'c:\\pet.txt' into table pet;


