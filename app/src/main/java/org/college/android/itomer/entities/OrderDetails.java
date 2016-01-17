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
//Name [Order Details]
public class OrderDetails{
    private int OrderID;
    private int ProductID;
    private double UnitPrice;
    private int Quantity;
    private float Discount;

    public OrderDetails(Cursor cursor) {
        if (cursor == null) return;
        OrderID = cursor.getInt(cursor.getColumnIndex("OrderID"));
        ProductID = cursor.getInt(cursor.getColumnIndex("ProductID"));
        UnitPrice = cursor.getInt(cursor.getColumnIndex("UnitPrice"));
        Quantity = cursor.getInt(cursor.getColumnIndex("Quantity"));
        Discount = cursor.getInt(cursor.getColumnIndex("Discount"));
        OrderID = cursor.getInt(cursor.getColumnIndex("OrderID"));
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "Discount=" + Discount +
                ", OrderID=" + OrderID +
                ", ProductID=" + ProductID +
                ", Quantity=" + Quantity +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
