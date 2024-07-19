/* Write your T-SQL query statement below */
with manager_count as (
    select 
        managerId, count(managerId) as c
    from
        employee
    group by
        managerId
)

select 
    Employee.name 
from 
    Employee
join
    manager_count
    on manager_count.managerId is not null and manager_count.managerId = Employee.id
where
    manager_count.c >= 5;
    
    
