# Write your MySQL query statement below
select a.name as Employee from Employee as a inner join Employee as b on a.managerId=b.id where a.salary>b.salary;
