package org.college.android.itomer.entities;

import android.database.Cursor;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class Employee {
    int EmployeeID;
    String LastName;
    String FirstName;
    String Title;
    String TitleOfCourtesy;
    Date BirthDate;
    Date HireDate;
    String Address;
    String City;
    String Region;
    String PostalCode;
    String Country;
    String HomePhone;
    String Extension;
    byte[] Photo;
    String Notes;
    int ReportsTo;
    String PhotoPath;

    public Employee(Cursor cursor) {
        EmployeeID = cursor.getInt(cursor.getColumnIndex("EmployeeID"));
        LastName = cursor.getString(cursor.getColumnIndex("LastName"));
        FirstName = cursor.getString(cursor.getColumnIndex("FirstName"));
        Title = cursor.getString(cursor.getColumnIndex("Title"));
        TitleOfCourtesy = cursor.getString(cursor.getColumnIndex("TitleOfCourtesy"));

        DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            BirthDate = iso8601Format.parse(cursor.getString(cursor.getColumnIndex("BirthDate")));
            HireDate = iso8601Format.parse(cursor.getString(cursor.getColumnIndex("HireDate")));
        } catch (ParseException e) {
            Log.e("Tomer", "Parsing ISO8601 datetime failed", e);
        } catch (NullPointerException e) {
            Log.e("Tomer", "Date is null", e);
        }

        Address = cursor.getString(cursor.getColumnIndex("Address"));
        City = cursor.getString(cursor.getColumnIndex("City"));
        Region = cursor.getString(cursor.getColumnIndex("Region"));
        PostalCode = cursor.getString(cursor.getColumnIndex("PostalCode"));
        Country = cursor.getString(cursor.getColumnIndex("Country"));
        HomePhone = cursor.getString(cursor.getColumnIndex("HomePhone"));
        Extension = cursor.getString(cursor.getColumnIndex("Extension"));
        Photo = cursor.getBlob(cursor.getColumnIndex("Photo"));

        Notes = cursor.getString(cursor.getColumnIndex("Notes"));
        ReportsTo = cursor.getInt(cursor.getColumnIndex("ReportsTo"));
        PhotoPath = cursor.getString(cursor.getColumnIndex("PhotoPath"));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Address='" + Address + '\'' +
                ", BirthDate=" + BirthDate +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", EmployeeID=" + EmployeeID +
                ", Extension='" + Extension + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", HireDate=" + HireDate +
                ", HomePhone='" + HomePhone + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Notes='" + Notes + '\'' +
                ", PhotoPath='" + PhotoPath + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", Region='" + Region + '\'' +
                ", ReportsTo=" + ReportsTo +
                ", Title='" + Title + '\'' +
                ", TitleOfCourtesy='" + TitleOfCourtesy + '\'' +
                '}';
    }
}
