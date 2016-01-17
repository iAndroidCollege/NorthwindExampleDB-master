 --W3Schools DB:

 --כמות מוצרים שהוזמנו לפי לקוח:

   SELECT c.customerid, SUM(quantity) AS totalQuantity
   FROM Orders AS o
        JOIN Customers AS c
        ON c.CustomerID = o.CustomerID
        JOIN OrderDetails AS od
        ON o.OrderID = od.OrderID
   GROUP BY c.CustomerID
   ORDER BY totalQuantity DESC;



-- הכנסות לפי לקוח:

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



 --Northwind Database:

 --Order Count Per Employee (Having OrderCount > 10)
 SELECT FirstName, LastName, COUNT(OrderID) AS cnt
 FROM Employees AS e
      JOIN Orders AS o
      ON e.EmployeeID = o.EmployeeID
 GROUP BY o.EmployeeID, FirstName, LastName
 HAVING COUNT(OrderID) >= 10
 ORDER BY cnt DESC;



 --for each customer - last order date, Maximum Revenue from a single order:
SELECT ContactName, COUNT(o.OrderID) AS cnt,
       SUM(quantity*unitPrice) AS total,
       MAX(quantity*unitPrice) AS MaxOrder,
       MAX(OrderDate) AS lastOrder
FROM Customers AS c
     JOIN Orders AS o
     ON c.CustomerID = o.CustomerID
     JOIN [Order Details] AS OD
     ON OD.OrderID = O.OrderID
GROUP BY c.CustomerID, ContactName
ORDER BY cnt DESC;


--INSERT...VALUES
INSERT INTO Customers(CompanyName,
                      ContactName, ContactTitle,
                      Address, City, Region, PostalCode,
                      Country, Phone, Fax)
VALUES('Tomer', 'iTomers', 'Eng.', 'Arlozorov 42', 'Beer Sheva',
       'Negev',  '84290', 'Israel', '0507123012', '0507123012');




--INSERT...SELECT
INSERT INTO Customers(CompanyName,
                      ContactName, ContactTitle,
                      Address, City, Region, PostalCode,
                      Country, Phone, Fax)
SELECT CompanyName,ContactName, ContactTitle,
                   Address, City, Region, PostalCode,Country, Phone, Fax " +
                   FROM Customers
                   WHERE CustomerID = 1;



--SubQuery:
SELECT *
FROM Customers
WHERE CustomerID IN
      (SELECT c.CustomerID
       FROM Customers AS c
       JOIN Orders AS o
       ON c.CustomerID = o.CustomerID
       GROUP BY o.CustomerID
       HAVING COUNT(OrderID) > 6);



--Update:

UPDATE Customers
SET City = 'Beer Sheva'
WHERE CustomerID = 1;


--Update with sub query:
UPDATE Customers
SET City = 'Beer Sheva'
WHERE CustomerID IN
      (SELECT c.CustomerID
       FROM Customers AS c
       JOIN Orders AS o
       ON c.CustomerID = o.CustomerID
       GROUP BY o.CustomerID
       HAVING COUNT(OrderID) > 6);


--Delete:

DELETE FROM Customers
WHERE city = 'Hamburg';


-- Delete With Subquery:
DELETE FROM Customers
WHERE city  IN (
                SELECT city
                FROM Customers
                WHERE City LIKE 'L%'
                );


--Case Statements:
SELECT FirstName || ' ' || LastName AS fullName,
       CASE WHEN EmployeeID%3 = 0 THEN 'divides by 3'
       WHEN EmployeeID%3 = 1 THEN 'residue of one'
       WHEN EmployeeID%3 = 2 THEN 'residue of two'
       ELSE 'odd' END AS [even/odd]
FROM Employees;