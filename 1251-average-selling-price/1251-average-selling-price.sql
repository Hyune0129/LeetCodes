/* Write your T-SQL query statement below */
With Incomes as(
select
    Prices.product_id, sum(Prices.price * UnitsSold.units) as income
from 
    Prices
left join UnitsSold on Prices.product_id = UnitsSold.product_id and
UnitsSold.purchase_date between Prices.start_date and Prices.end_date
group by Prices.product_id
)

select 
    Incomes.product_id, coalesce(round((Incomes.income * 1.0) / sum(UnitsSold.units), 2), 0) as average_price
from
    Incomes
left join UnitsSold on Incomes.product_id = UnitsSold.product_id
group by
    Incomes.product_id, Incomes.income;