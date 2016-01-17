SELECT e.FirstName, e.LastName, c.firstName, c.LastName
FROM Employees AS e
     JOIN Customers AS c
     ON c.City = e.city;