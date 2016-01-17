package org.college.android.itomer.entities;

import android.database.Cursor;
import android.util.Log;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
public class Orders {
   private int OrderID;
   private String CustomerID;
   private int EmployeeID;
   private Date OrderDate;
   private Date RequiredDate;
   private Date ShippedDate;
   private int ShipVia;
   private double Freight;
   private String ShipName;
   private String ShipAddress;
   private String ShipCity;
   private String ShipRegion;
   private String ShipPostalCode;
   private String ShipCountry;

    public Orders(Cursor cursor) {
        DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OrderID = cursor.getInt(cursor.getColumnIndex("OrderID"));
        CustomerID = cursor.getString(cursor.getColumnIndex("CustomerID"));
        EmployeeID = cursor.getInt(cursor.getColumnIndex("EmployeeID"));

        try {
            OrderDate = iso8601Format.parse(cursor.getString(cursor.getColumnIndex("OrderDate")));
            RequiredDate = iso8601Format.parse(cursor.getString(cursor.getColumnIndex("RequiredDate")));
            ShippedDate = iso8601Format.parse(cursor.getString(cursor.getColumnIndex("ShippedDate")));
        } catch (ParseException e) {
            Log.e("Tomer", "Parsing ISO8601 datetime failed", e);
        }catch (NullPointerException e){
            Log.e("Tomer", "Date is null", e);
        }

        ShipVia = cursor.getInt(cursor.getColumnIndex("ShipVia"));
        Freight = cursor.getDouble(cursor.getColumnIndex("Freight"));
        ShipName = cursor.getString(cursor.getColumnIndex("ShipName"));
        ShipAddress = cursor.getString(cursor.getColumnIndex("ShipAddress"));
        ShipCity = cursor.getString(cursor.getColumnIndex("ShipCity"));
        ShipRegion = cursor.getString(cursor.getColumnIndex("ShipRegion"));
        ShipPostalCode = cursor.getString(cursor.getColumnIndex("ShipPostalCode"));
        ShipCountry = cursor.getString(cursor.getColumnIndex("ShipCountry"));
    }

    @Override
    public String toString() {
        return "Orders{" +
                "CustomerID='" + CustomerID + '\'' +
                ", EmployeeID=" + EmployeeID +
                ", Freight=" + Freight +
                ", OrderDate=" + OrderDate +
                ", OrderID=" + OrderID +
                ", RequiredDate=" + RequiredDate +
                ", ShipAddress='" + ShipAddress + '\'' +
                ", ShipCity='" + ShipCity + '\'' +
                ", ShipCountry='" + ShipCountry + '\'' +
                ", ShipName='" + ShipName + '\'' +
                ", ShippedDate=" + ShippedDate +
                ", ShipPostalCode='" + ShipPostalCode + '\'' +
                ", ShipRegion='" + ShipRegion + '\'' +
                ", ShipVia=" + ShipVia +
                '}';
    }
}
