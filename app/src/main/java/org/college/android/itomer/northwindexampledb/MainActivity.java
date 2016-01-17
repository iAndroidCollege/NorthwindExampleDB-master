package org.college.android.itomer.northwindexampledb;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.college.android.itomer.dal.DAO;

public class MainActivity extends AppCompatActivity {

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dao = new DAO(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView rv = (RecyclerView) findViewById(R.id.rvNorthwind);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
/*                rv.setAdapter(new NorthwindAdapter(dao.getCursor(
                        "INSERT INTO Customers(CompanyName," +
                                " ContactName, ContactTitle, " +
                                "Address, City, Region, PostalCode, " +
                                "Country, Phone, Fax)" +
                        "VALUES('Tomer', 'iTomers', 'Eng.', 'Arlozorov 42', 'Beer Sheva'" +
                                ",'Negev',  '84290', 'Israel', '0507123012', '0507123012')"
                )));*/

                rv.setAdapter(new NorthwindAdapter(dao.getCursor(
                "SELECT FirstName || ' ' || LastName " +
                "AS FullName From Employees "

                )));




            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
