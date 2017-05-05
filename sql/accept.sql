prompt CREATE NEW EMPLOYEE RECORD
prompt
prompt Enter the employees information :
prompt

accept tmp_name  char format a10 prompt 'Last name:'
accept tmp_employee number format '9999' prompt 'Employee #:'
accept tmp_salary number format '99999.99' default '10000.00' prompt 'Salary[1000] :'
accept tmp_commission number format '9999.99' default '0' prompt 'Commission % [0]:'
accept tmp_hire date format 'mm/dd/yyyy' prompt 'Hire date (mm/dd/yyyy):'

select distinct job from emp;
accept tmp_job char format a10 prompt 'Job:'

prompt List of department number and names:

select deptno, dname from dept order by deptno;
accept tmp_dep number format '999999' prompt 'Department #:'

insert into emp(empno,ename,job,hiredate,sal,comm,deptno) values (&tmp_employee,'&tmp_name','&tmp_job',to_date('&tmp_hire','mm/dd/yyyy'),&tmp_salary,&tmp_commission,&tmp_dep);
