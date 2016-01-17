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
public class Product {
    private int ProductID;
    private String ProductName;
    private int SupplierID;
    private int CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private int UnitsInStock;
    private int UnitsOnOrder;
    private int ReorderLevel;

    public Product(Cursor cursor) {
        ProductID = cursor.getInt(cursor.getColumnIndex("ProductID"));
        ProductName = cursor.getString(cursor.getColumnIndex("ProductName"));
        SupplierID = cursor.getInt(cursor.getColumnIndex("SupplierID"));
        CategoryID = cursor.getInt(cursor.getColumnIndex("CategoryID"));
        QuantityPerUnit = cursor.getString(cursor.getColumnIndex("QuantityPerUnit"));
        UnitPrice = cursor.getDouble(cursor.getColumnIndex("UnitPrice"));
        UnitsInStock = cursor.getInt(cursor.getColumnIndex("UnitsInStock"));
        UnitsOnOrder = cursor.getInt(cursor.getColumnIndex("UnitsOnOrder"));
        ReorderLevel = cursor.getInt(cursor.getColumnIndex("ReorderLevel"));

    }

    @Override
    public String toString() {
        return "Product{" +
                "CategoryID=" + CategoryID +
                ", ProductID=" + ProductID +
                ", ProductName='" + ProductName + '\'' +
                ", QuantityPerUnit='" + QuantityPerUnit + '\'' +
                ", ReorderLevel=" + ReorderLevel +
                ", SupplierID=" + SupplierID +
                ", UnitPrice=" + UnitPrice +
                ", UnitsInStock=" + UnitsInStock +
                ", UnitsOnOrder=" + UnitsOnOrder +
                '}';
    }
}
