package com.himotech.recycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {



    private Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        initView();
    }


    private void initView(){

        mToolbar=(Toolbar)findViewById(R.id.toolbar_home);

        setSupportActionBar(mToolbar);

    }




    public void onStartVertical(View mView){

        Intent mStartVertical=new Intent(this,RecycleListActivity.class);

        mStartVertical.putExtra(RecycleListActivity.MANAGER_TYPEKEY, RecycleListActivity.RECYCLE_MANAGER.VERTICAL);

        startActivity(mStartVertical);
    }



    public void onStartHorizon(View mView){

        Intent mStartVertical=new Intent(this,RecycleListActivity.class);

        mStartVertical.putExtra(RecycleListActivity.MANAGER_TYPEKEY, RecycleListActivity.RECYCLE_MANAGER.LINEAR);

        startActivity(mStartVertical);
    }

    public void onStartGrid(View mView){

        Intent mStartVertical=new Intent(this,RecycleListActivity.class);

        mStartVertical.putExtra(RecycleListActivity.MANAGER_TYPEKEY, RecycleListActivity.RECYCLE_MANAGER.GRID);

        startActivity(mStartVertical);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection, menu);
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
