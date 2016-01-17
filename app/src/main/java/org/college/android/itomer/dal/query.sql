SELECT c.customerid, SUM(quantity*price) AS totalIncome
FROM Orders AS o
     JOIN Customers AS c
     ON c.CustomerID = o.CustomerID
     JOIN OrderDetails AS od
     ON o.OrderID = od.OrderID
     JOIN Products AS p
     ON p.productID = od.ProductID
GROUP BY c.CustomerID
ORDER BY totalIncome DESC;
