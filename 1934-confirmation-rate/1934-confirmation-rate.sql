/* Write your T-SQL query statement below */
with confirmed_count as (
    select 
        user_id, count(user_id)  as c
    from
        Confirmations
    group by 
        user_id, action
    having
        action = 'confirmed'
),
tried_count as(
    select
        user_id, count(*) as c
    from
        Confirmations
    group by
        user_id
)

select
    Signups.user_id, 
    round(convert(float,isnull(confirmed_count.c, 0.00)) / isnull(tried_count.c, 1.00), 2) as confirmation_rate
from
    Signups
left join confirmed_count on Signups.user_id = confirmed_count.user_id
left join tried_count on Signups.user_id = tried_count.user_id;