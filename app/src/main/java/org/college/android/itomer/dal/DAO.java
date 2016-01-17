package org.college.android.itomer.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.college.android.itomer.entities.Category;
import org.college.android.itomer.entities.Customer;
import org.college.android.itomer.entities.CustomerCustomerDemo;
import org.college.android.itomer.entities.CustomerDemographics;
import org.college.android.itomer.entities.Employee;
import org.college.android.itomer.entities.EmployeeTerritories;
import org.college.android.itomer.entities.OrderDetails;
import org.college.android.itomer.entities.Orders;
import org.college.android.itomer.entities.Product;
import org.college.android.itomer.entities.Region;
import org.college.android.itomer.entities.Shipper;
import org.college.android.itomer.entities.Supplier;
import org.college.android.itomer.entities.Territory;
import org.college.android.itomer.northwindexampledb.MyDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iTomer on 17/01/2016.
 * Licence GPLv3
 * Copyright (C) 2016  iTomer
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class DAO {

    private final Context context;
    private SQLiteDatabase db;

    public DAO(Context context) {
        this.context = context;
        this.db = new MyDatabase(context).getWritableDatabase();
    }



    public List<EmployeeTerritories> getEmployeeTerritories() {
        ArrayList<EmployeeTerritories> etList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM EmployeeTerritories;", null);
        while (cursor.moveToNext()) {
            EmployeeTerritories employeeTerritories = new EmployeeTerritories(cursor);
            etList.add(employeeTerritories);
        }
        Log.e("Tomer", String.valueOf(etList));
        cursor.close();
        return etList;
    }

    public List<CustomerDemographics> getCustomerDemographics() {
        ArrayList<CustomerDemographics> cdList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM CustomerDemographics;", null);
        while (cursor.moveToNext()) {
            CustomerDemographics customerDemographics = new CustomerDemographics(cursor);
            cdList.add(customerDemographics);
        }
        Log.e("Tomer", String.valueOf(cdList));
        cursor.close();
        return cdList;
    }

    public List<CustomerCustomerDemo> getCustomerCustomerDemo() {
        ArrayList<CustomerCustomerDemo> cdList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM CustomerCustomerDemo;", null);
        while (cursor.moveToNext()) {
            CustomerCustomerDemo customerDemo = new CustomerCustomerDemo(cursor);
            cdList.add(customerDemo);
        }
        Log.e("Tomer", String.valueOf(cdList));
        cursor.close();
        return cdList;
    }

    public List<Shipper> getShippers() {
        ArrayList<Shipper> sList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Shippers;", null);
        while (cursor.moveToNext()) {
            Shipper shipper = new Shipper(cursor);
            sList.add(shipper);
        }
        Log.e("Tomer", String.valueOf(sList));
        cursor.close();
        return sList;
    }

    public List<Employee> getEmployees() {
        ArrayList<Employee> eList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Employees;", null);
        while (cursor.moveToNext()) {
            Employee employee = new Employee(cursor);
            eList.add(employee);
        }
        Log.e("Tomer", String.valueOf(eList));
        cursor.close();
        return eList;
    }


    public List<Region> getRegions() {
        ArrayList<Region> rList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Region;", null);
        while (cursor.moveToNext()) {
            Region region = new Region(cursor);
            rList.add(region);
        }
        Log.e("Tomer", String.valueOf(rList));
        cursor.close();
        return rList;
    }

    public List<Territory> getTerritories() {
        ArrayList<Territory> tList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Territories;", null);
        while (cursor.moveToNext()) {
            Territory territory = new Territory(cursor);
            tList.add(territory);
        }
        Log.e("Tomer", String.valueOf(tList));
        cursor.close();
        return tList;
    }


    public List<Supplier> getSuppliers() {
        ArrayList<Supplier> sList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Suppliers;", null);
        while (cursor.moveToNext()) {
            Supplier supplier = new Supplier(cursor);
            sList.add(supplier);
        }
        Log.e("Tomer", String.valueOf(sList));
        cursor.close();
        return sList;
    }

    public List<Category> getCategories() {
        ArrayList<Category> cList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Categories;", null);
        while (cursor.moveToNext()) {
            Category category = new Category(cursor);
            cList.add(category);
        }
        Log.e("Tomer", String.valueOf(cList));
        cursor.close();
        return cList;
    }


    public List<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Customers;", null);
        while (cursor.moveToNext()) {
            Customer customer = new Customer(cursor);
            customers.add(customer);
        }
        Log.e("Tomer", String.valueOf(customers));
        cursor.close();
        return customers;
    }


    public List<Product> getProducts() {
        ArrayList<Product> pList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM [Products];", null);
        while (cursor.moveToNext()) {
            Product product = new Product(cursor);
            pList.add(product);
        }
        Log.e("Tomer", String.valueOf(pList));
        cursor.close();
        return pList;
    }


    public List<OrderDetails> getOrderDetails() {
        ArrayList<OrderDetails> odList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM [Order Details];", null);
        while (cursor.moveToNext()) {
            OrderDetails orderDetails = new OrderDetails(cursor);
            odList.add(orderDetails);
        }
        Log.e("Tomer", String.valueOf(odList));
        cursor.close();
        return odList;
    }


    public List<Orders> getOrders() {
        Cursor cursor = db.rawQuery("SELECT * FROM ORDERS", null);
        ArrayList<Orders> orders = new ArrayList<>();

        String[] columnNames = cursor.getColumnNames();
        while (cursor.moveToNext()) {
            Orders o = new Orders(cursor);
            orders.add(o);
        }
        System.out.println(orders);
        cursor.close();
        return orders;
    }


    public void rawQuery(String sql) {
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToNext();
        String[] columns = cursor.getColumnNames();
        for (int i = 0; i < columns.length; i++) {
            System.out.printf("%-30s", columns[i]);
        }
        System.out.println();
        while (cursor.moveToNext()) {
            for (int i = 0; i < columns.length; i++) {
                try {
                    System.out.printf("%-30s", cursor.getString(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}
