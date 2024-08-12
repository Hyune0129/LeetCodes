# Write your MySQL query statement below
with FirstLogin as (
    select 
        player_id, 
        min(event_date) as first_login
    from 
        Activity
    group by
        player_id
),
LoggedBack as (
    select
        count(*) as logged_back
    from
        Activity
    left join
        FirstLogin
    on
        FirstLogin.player_id = Activity.player_id
    where
        date_add(first_login, interval 1 day) = event_date
)
select
    round(logged_back / count(distinct(Activity.player_id)), 2) as fraction
from
    Activity
join
    LoggedBack;