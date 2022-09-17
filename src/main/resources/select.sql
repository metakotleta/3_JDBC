select o.* from orders o
join customers c on o.customer_id = c.customer_id
where c.name = ?;