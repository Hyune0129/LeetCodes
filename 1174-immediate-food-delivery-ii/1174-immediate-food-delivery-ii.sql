# Write your MySQL query statement below
with FirstOrder as (
    select
        customer_id,
        min(order_date) as order_date
    from
        Delivery
    group by 
        customer_id
),
ImmediateCount as (
select 
    count(*) as cnt
    from
        FirstOrder
    left join
        Delivery
    on 
        Delivery.customer_id = FirstOrder.customer_id 
        and Delivery.order_date =FirstOrder.order_date
    where 
        Delivery.order_date = Delivery.customer_pref_delivery_date
)
select 
    round( ImmediateCount.cnt / coalesce(count(*), 1) * 100, 2) as immediate_percentage
from 
    FirstOrder, ImmediateCount;