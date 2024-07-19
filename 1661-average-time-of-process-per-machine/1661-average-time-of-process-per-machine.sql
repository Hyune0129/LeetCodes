# Write your MySQL query statement below

select b.machine_id, ROUND(AVG(b.timestamp - a.timestamp), 3) as processing_time from Activity a right join Activity b on a.machine_id = b.machine_id and a.process_id = b.process_id and a.activity_type = 'start' and b.activity_type = 'end'
group by machine_id;