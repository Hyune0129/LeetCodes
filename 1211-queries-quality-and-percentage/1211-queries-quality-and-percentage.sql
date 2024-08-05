# Write your MySQL query statement below
with ResultQuality as(
select
    query_name, sum(rating / position) / count(query_name) as quality
from
    Queries
group by
    query_name
),
PoorQuery as (
    select
        query_name, count(result) as poorCnt
    from
        Queries
    where
        rating < 3
    group by 
        query_name

)

select
    Queries.query_name,
    round(ResultQuality.quality, 2) as quality,
    coalesce(round(PoorQuery.poorCnt / count(Queries.query_name)* 100, 2), 0) as poor_query_percentage
from
    Queries
Left join
    ResultQuality on Queries.query_name = ResultQuality.query_name
Left join
    PoorQuery on Queries.query_name = PoorQuery.query_name
where Queries.query_name is not null
group by
    Queries.query_name;