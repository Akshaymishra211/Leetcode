# Write your MySQL query statement below
select w1.id from weather as w1 inner join weather as w2 on datediff(w1.recordDate,w2.recordDate)=1 where w1.temperature>w2.temperature;