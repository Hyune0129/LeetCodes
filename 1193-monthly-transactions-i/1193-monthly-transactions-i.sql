# Write your MySQL query statement below
with Approved as(
    select 
        date_format(trans_date, '%Y-%m') as month, 
        country,count(*) as approved_count, 
        sum(amount) as approved_total_amount
    from
        Transactions
    where
        state = 'approved'
    group by
        date_format(trans_date, '%Y-%m'),
        country
),
Total as (
    select
        date_format(trans_date, '%Y-%m') as month, 
        country, 
        count(*) as trans_count, 
        sum(amount) as trans_total_amount
    from
        Transactions
    group by 
        date_format(trans_date, '%Y-%m'), 
        country
)
select 
    Total.month,
    Total.country,
    Total.trans_count,
    coalesce(Approved.approved_count, 0) as approved_count,
    Total.trans_total_amount,
    coalesce(Approved.approved_total_amount, 0) as approved_total_amount
from
    Total
left join Approved
    ON (Total.month = Approved.month AND Total.country = Approved.country)
    OR (Total.country is NULL AND Approved.country is NULL);