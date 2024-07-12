# Write your MySQL query statement below
select b.id from weather a join weather b on DATE_ADD(a.recordDate, interval 1 day) = b.recordDate and a.temperature < b.temperature;