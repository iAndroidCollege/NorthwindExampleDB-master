package org.college.android.itomer.northwindexampledb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by master on 17/01/16.
 */
public class NorthwindViewHolder extends RecyclerView.ViewHolder {
    TextView tvRow;

    public NorthwindViewHolder(View itemView) {
        super(itemView);
        tvRow = (TextView) itemView.findViewById(R.id.tvRow);
    }
}
