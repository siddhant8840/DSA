# Write your MySQL query statement belo
select max(salary) AS SecondHighestSalary from Employee
where 
salary<(select max(salary)  from Employee
);