# Write your MySQL query statement below
with ContestCount as(
select
    contest_id, count(user_id) as contest_count
from
    Register
group by
    contest_id
),
UserCount as (
    select 
        count(user_id) as user_count
    from
        Users
)
-- select *
-- from ContestCount;
select
    contest_id, round(contest_count / UserCount.user_count * 100, 2) as percentage
from
    ContestCount, UserCount
order by percentage desc, contest_id asc;