package org.college.android.itomer.northwindexampledb;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by master on 17/01/16.
 */
public class NorthwindAdapter extends RecyclerView.Adapter<NorthwindViewHolder> {
    public NorthwindAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    Cursor cursor;

    @Override
    public NorthwindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_row, parent, false);
        cursor.moveToFirst();
        return new NorthwindViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NorthwindViewHolder holder, int position) {
        StringBuilder builder = new StringBuilder();

        if (position==0){
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                try {
                    builder.append(String.format("%-40s", cursor.getColumnName(i)));
                } catch (Exception e) {
                    builder.append(String.format("%-40s", ""));
                }
            }
        }
        cursor.moveToPosition(position);

        for (int i = 0; i < cursor.getColumnCount(); i++) {
            try {
                builder.append(String.format("%-40s", cursor.getString(i)));
            } catch (Exception e) {
                builder.append(String.format("%-40s", ""));
            }
        }

        holder.tvRow.setText(builder.toString());
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
}
