-- 1. ��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����϶�.

select substr(ename,2,3)
from emp;

-- 2. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��϶�.

select empno,ename,hiredate
from emp
where extract(month from hiredate) = 12;

-- 3. ������ ���� ����� �˻��� �� �ִ�  sql ������ �ۼ��϶�
-- EMPNO        ENAME         �޿�
-- 7369			SMITH     *******800
--  .....
-- 7499			ALLEN     ******1600

select empno,ename,lpad(sal,10,'*') as �޿���
from emp
order by sal;

-- 4.������ ���� ����� �˻��� �� �ִ�  sql ������ �ۼ��϶�
-- EMPNO        ENAME         �Ի���
-- 7369			SMITH     1980-12-17
--  .....
-- 7499			ALLEN     1981-02-20

select empno,ename,to_char(hiredate,'yyyy-mm-dd')
from emp
order by hiredate;

-- 5.������ ���� ����� �˻��� �� �ִ�  sql ������ �ۼ��϶�
-- EMPNO        ENAME         �Ի���
-- 7369			SMITH     1980��12��17��
--  .....
-- 7499			ALLEN     1981��02��20��

select empno,ename,to_char(hiredate,'yyyy"��"mm"��"dd"��"')
from emp
order by hiredate;     

--1. 10�� �μ� ������ ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT      AVG(SAL) AS ���, MAX(SAL) AS �ְ�, MIN(SAL) AS ����, COUNT(*) AS �ο���
FROM        EMP
WHERE       DEPTNO = 10;

--2. �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT      DEPTNO AS �μ���ȣ, AVG(SAL) AS ���, MAX(SAL) AS �ְ�, MIN(SAL) AS ����, COUNT(*) AS �ο���
FROM        EMP
GROUP BY    DEPTNO
ORDER BY    DEPTNO;

--3. �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT      DEPTNO AS �μ���ȣ, JOB AS ������, COUNT(*) AS �ο���
FROM        EMP
GROUP BY    DEPTNO, JOB
ORDER BY    DEPTNO;

--4. ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����϶�.

select d.dname,count(*)
from emp e, dept d
where e.deptno = d.DEPTNO
group by d.dname
having count(*) >= 4;

--5. �� �μ��� ��� ����, ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�.

select d.dname �μ���, trunc(avg(e.sal),2) as ��տ���, sum(e.sal) ��ü����, max(e.sal) �ְ����, min(e.sal) ��������
from dept d,emp e
where d.deptno = e.deptno
group by d.dname
order by avg(e.sal);

-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�.

select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno;

-- 2. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸��� ����϶�

select e.ename, e.job,e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno 
AND d.loc = 'DALLAS';

-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�.

select e.ename, d.dname
from emp e,dept d
where e.deptno = d.deptno AND e.ename like '%A%';

-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�

select e.ename, d.dname, e.sal
from emp e, dept d
where e.deptno = d.deptno AND sal >= 3000 ;

-- 5. ������ 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�.

select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno AND e.job = 'SALESMAN';

-- 6. Ŀ�̼��� å����(������) ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�.

select e.empno �����ȣ,e.ename ����̸�, e.sal ����, e.sal+e.comm �Ǳ޿�, s.grade �޿����
from emp e, salgrade s
where e.comm is not null AND e.sal+e.comm between s.losal AND  s.hisal;

-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e, salgrade s, dept d
where e.deptno = d.deptno AND e.sal between s.losal AND s.hisal;

-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�.

select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e, salgrade s, dept d
where e.deptno = d.deptno AND e.sal between s.losal AND s.hisal AND e.deptno in (10,20)
order by e.deptno,e.sal desc;

-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�.

select e.empno �����ȣ, e.ename ����̸�, e.mgr �����ڹ�ȣ, m.ename �������̸�
from emp e, emp m
where e.mgr = m.empno;

-- 10. ��� �̸�, ��� ��ȣ, �ش� ����� ������ �̸�, ������ ��ȣ�� �Բ�
--ǥ���ϵ�,�����ڰ� ���� king(���)������ ��� ����� ǥ���Ѵ�

select e.empno �����ȣ, e.ename ����̸�, e.mgr �����ڹ�ȣ, m.ename �������̸�
from emp e, emp m
where e.mgr = m.empno(+);

-- 11. ������ ������ ����� ���� ǥ���ϴ� ���Ǹ� �ۼ��Ѵ�.

select job, count(*)
from emp
group by job;

-- 12. ������ ��� ���� ������ ���� ǥ���ϰ� �� �̸���
--NUMBER OF MANAGERS�� ����.

select count(*) as "NUMBER OF MANAGERS"
from emp
where job = 'MANAGER'
group by job;

-- 13.�ش� �μ��� ��� ����� ���� �μ� �̸�, ��ġ, ��� �� �� ��� �޿���
--ǥ���ϴ� ���Ǹ� �ۼ��Ѵ�.
--�� �̸��� ���� DNAME,LOC,NUMBER OF PEOPLE,SALARY�� �Ѵ�.

select d.dname DNAME, d.loc LOC, count(*) as "NUMBER OF PEOPLE", avg(e.sal) SALARY
from emp e, dept d
where e.deptno = d.deptno
group by d.dname, d.loc;

