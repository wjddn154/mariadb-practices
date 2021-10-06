-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
  from salaries
 where to_date = '9999-01-01'
   and salary > (select avg(salary)
				   from salaries);

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름' , d.dept_name as '부서', s.salary as '연봉'
  from employees e, salaries s, dept_emp de, departments d
 where e.emp_no = s.emp_no
   and e.emp_no = de.emp_no
   and de.dept_no = d.dept_no
   and s.to_date = '9999-01-01'
   and de.to_date = '9999-01-01'
   and (de.dept_no, salary) in (select de.dept_no, max(s.salary)
							   	   from salaries s, dept_emp de
								  where de.emp_no = s.emp_no
								    and s.to_date = '9999-01-01'
								    and de.to_date = '9999-01-01'
							   group by de.dept_no)
order by s.salary desc;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름' , s.salary as '연봉'
  from employees e
  join dept_emp de 
    on e.emp_no = de.emp_no
  join (select dept_no, avg(salary) as dept_avg_sal
          from salaries s 
          join dept_emp de 
            on s.emp_no = de.emp_no
         where s.to_date = '9999-01-01'
           and de.to_date = '9999-01-01'
      group by dept_no) avg_sal 
    on de.dept_no = avg_sal.dept_no
  join salaries s 
    on e.emp_no = s.emp_no 
   and salary >= avg_sal.dept_avg_sal
   and de.to_date = '9999-01-01' 
   and s.to_date = '9999-01-01'
   order by s.salary;                            
  
-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름' , d.dept_name as '부서', manager.last_name as '매니저 이름'
  from employees e, dept_emp de, departments d, (select dm.dept_no, dm.emp_no, e.last_name
													  from dept_manager dm, employees e
													 where dm.emp_no = e.emp_no
													   and to_date = '9999-01-01') manager
 where e.emp_no = de.emp_no
   and de.dept_no = manager.dept_no
   and de.dept_no = d.dept_no
order by e.emp_no;

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름' , t.title, s.salary
  from employees e, salaries s, titles t, dept_emp de
 where e.emp_no = s.emp_no
   and e.emp_no = t.emp_no
   and e.emp_no = de.emp_no
   and s.to_date = '9999-01-01'
   and t.to_date = '9999-01-01'
   and de.to_date = '9999-01-01'
   and de.dept_no = (select dept_no
					   from salaries s, dept_emp de
					  where s.emp_no = de.emp_no
				   group by dept_no
				   order by max(salary) desc
					  limit 0, 1)
order by s.salary desc;
                      
-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 

-- 문제7.
-- 평균 연봉이 가장 높은 직책?

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.


