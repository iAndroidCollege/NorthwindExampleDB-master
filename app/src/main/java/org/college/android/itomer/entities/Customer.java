package org.college.android.itomer.entities;

import android.database.Cursor;

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
public class Customer {
    private String CustomerID;
    private String CompanyName;
    private String ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String Region;
    private String PostalCode;
    private String Country;
    private String Phone;
    private String Fax;

    public Customer(Cursor cursor) {
        CustomerID = cursor.getString(cursor.getColumnIndex("CustomerID"));
        CompanyName = cursor.getString(cursor.getColumnIndex("CompanyName"));
        ContactName = cursor.getString(cursor.getColumnIndex("ContactName"));
        ContactTitle = cursor.getString(cursor.getColumnIndex("ContactTitle"));
        Address = cursor.getString(cursor.getColumnIndex("Address"));
        City = cursor.getString(cursor.getColumnIndex("City"));
        PostalCode = cursor.getString(cursor.getColumnIndex("PostalCode"));
        Country = cursor.getString(cursor.getColumnIndex("Country"));
        Phone = cursor.getString(cursor.getColumnIndex("Phone"));
        Fax = cursor.getString(cursor.getColumnIndex("Fax"));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", ContactName='" + ContactName + '\'' +
                ", ContactTitle='" + ContactTitle + '\'' +
                ", Country='" + Country + '\'' +
                ", CustomerID='" + CustomerID + '\'' +
                ", Fax='" + Fax + '\'' +
                ", Phone='" + Phone + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", Region='" + Region + '\'' +
                '}';
    }
}
