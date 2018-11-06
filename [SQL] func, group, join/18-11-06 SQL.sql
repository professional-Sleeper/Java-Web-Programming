-- 1. 사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하라.

select substr(ename,2,3)
from emp;

-- 2. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하라.

select empno,ename,hiredate
from emp
where extract(month from hiredate) = 12;

-- 3. 다음과 같은 결과를 검색할 수 있는  sql 문장을 작성하라
-- EMPNO        ENAME         급여
-- 7369			SMITH     *******800
--  .....
-- 7499			ALLEN     ******1600

select empno,ename,lpad(sal,10,'*') as 급여일
from emp
order by sal;

-- 4.다음과 같은 결과를 검색할 수 있는  sql 문장을 작성하라
-- EMPNO        ENAME         입사일
-- 7369			SMITH     1980-12-17
--  .....
-- 7499			ALLEN     1981-02-20

select empno,ename,to_char(hiredate,'yyyy-mm-dd')
from emp
order by hiredate;

-- 5.다음과 같은 결과를 검색할 수 있는  sql 문장을 작성하라
-- EMPNO        ENAME         입사일
-- 7369			SMITH     1980년12년17일
--  .....
-- 7499			ALLEN     1981년02월20일

select empno,ename,to_char(hiredate,'yyyy"년"mm"월"dd"일"')
from emp
order by hiredate;     

--1. 10번 부서 월급의 평균, 최고, 최저, 인원수를 구하여 출력하라.
SELECT      AVG(SAL) AS 평균, MAX(SAL) AS 최고, MIN(SAL) AS 최저, COUNT(*) AS 인원수
FROM        EMP
WHERE       DEPTNO = 10;

--2. 각 부서별 급여의 평균, 최고, 최저, 인원수를 구하여 출력하라.
SELECT      DEPTNO AS 부서번호, AVG(SAL) AS 평균, MAX(SAL) AS 최고, MIN(SAL) AS 최저, COUNT(*) AS 인원수
FROM        EMP
GROUP BY    DEPTNO
ORDER BY    DEPTNO;

--3. 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 출력하라.
SELECT      DEPTNO AS 부서번호, JOB AS 업무명, COUNT(*) AS 인원수
FROM        EMP
GROUP BY    DEPTNO, JOB
ORDER BY    DEPTNO;

--4. 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하라.

select d.dname,count(*)
from emp e, dept d
where e.deptno = d.DEPTNO
group by d.dname
having count(*) >= 4;

--5. 각 부서별 평균 월급, 전체 월급, 최고 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하라.

select d.dname 부서명, trunc(avg(e.sal),2) as 평균월급, sum(e.sal) 전체월급, max(e.sal) 최고월급, min(e.sal) 최저월급
from dept d,emp e
where d.deptno = e.deptno
group by d.dname
order by avg(e.sal);

-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.

select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno;

-- 2. DALLAS에서 근무하는 사원의 이름, 업무, 부서번호, 부서이름을 출력하라

select e.ename, e.job,e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno 
AND d.loc = 'DALLAS';

-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.

select e.ename, d.dname
from emp e,dept d
where e.deptno = d.deptno AND e.ename like '%A%';

-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라

select e.ename, d.dname, e.sal
from emp e, dept d
where e.deptno = d.deptno AND sal >= 3000 ;

-- 5. 업무가 'SALESMAN'인 사원들의 업무와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.

select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno AND e.job = 'SALESMAN';

-- 6. 커미션이 책정된(정해진) 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.

select e.empno 사원번호,e.ename 사원이름, e.sal 연봉, e.sal+e.comm 실급여, s.grade 급여등급
from emp e, salgrade s
where e.comm is not null AND e.sal+e.comm between s.losal AND  s.hisal;

-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e, salgrade s, dept d
where e.deptno = d.deptno AND e.sal between s.losal AND s.hisal;

-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e, salgrade s, dept d
where e.deptno = d.deptno AND e.sal between s.losal AND s.hisal AND e.deptno in (10,20)
order by e.deptno,e.sal desc;

-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.

select e.empno 사원번호, e.ename 사원이름, e.mgr 관리자번호, m.ename 관리자이름
from emp e, emp m
where e.mgr = m.empno;

-- 10. 사원 이름, 사원 번호, 해당 사원의 관리자 이름, 관리자 번호를 함께
--표시하되,관리자가 없는 king(사원)포함한 모든 사원을 표시한다

select e.empno 사원번호, e.ename 사원이름, e.mgr 관리자번호, m.ename 관리자이름
from emp e, emp m
where e.mgr = m.empno(+);

-- 11. 업무가 동일한 사람의 수를 표시하는 질의를 작성한다.

select job, count(*)
from emp
group by job;

-- 12. 관리자 목록 없이 관리자 수만 표시하고 열 이름을
--NUMBER OF MANAGERS로 지정.

select count(*) as "NUMBER OF MANAGERS"
from emp
where job = 'MANAGER'
group by job;

-- 13.해당 부서의 모든 사원에 대한 부서 이름, 위치, 사원 수 및 평균 급여를
--표시하는 정의를 작성한다.
--열 이름을 각각 DNAME,LOC,NUMBER OF PEOPLE,SALARY로 한다.

select d.dname DNAME, d.loc LOC, count(*) as "NUMBER OF PEOPLE", avg(e.sal) SALARY
from emp e, dept d
where e.deptno = d.deptno
group by d.dname, d.loc;

