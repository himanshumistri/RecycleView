package com.himotech.recycleviewdemo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.himotech.adapters.ListAdapter;
import com.himotech.adapters.ListData;
import com.socialize.Socialize;
import com.socialize.entity.Entity;
import com.socialize.ui.actionbar.ActionBarView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class RecycleListActivity extends AppCompatActivity {




    private ActionBarView mActionBarView;

    private RecyclerView mRecycleView;

    public static enum RECYCLE_MANAGER {LINEAR,VERTICAL,GRID};

    public static final String MANAGER_TYPEKEY="RecycleManagerKey";

    private ArrayList<ListData> mArrayData;

    private ListAdapter mListAdapter;

    private Toolbar mToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_list);

        // Call Socialize in onCreate
        Socialize.onCreate(this, savedInstanceState);
        initView();
    }



    private void initView(){

        mToolBar=(Toolbar)findViewById(R.id.toolbar_home);

        RECYCLE_MANAGER mEnumType=(RECYCLE_MANAGER)getIntent().getSerializableExtra(MANAGER_TYPEKEY);

        //= RECYCLE_MANAGER.valueOf(mRecycleManagerType);

        mRecycleView=(RecyclerView)findViewById(R.id.recycle_view);

        switch(mEnumType){

            case VERTICAL:

                LinearLayoutManager mLlManager=new LinearLayoutManager(this);
               mLlManager.setSmoothScrollbarEnabled(true);
                mLlManager.setOrientation(LinearLayoutManager.VERTICAL);

                mRecycleView.setLayoutManager(mLlManager);
                mToolBar.setTitle("Vertical RecyleView");
                break;

            case LINEAR:

                LinearLayoutManager mHvManager=new LinearLayoutManager(this);
                mHvManager.setSmoothScrollbarEnabled(true);
                mHvManager.setOrientation(LinearLayoutManager.HORIZONTAL);

                mRecycleView.setLayoutManager(mHvManager);
                mToolBar.setTitle("Horizontal RecyleView");
                break;
            case GRID:

                GridLayoutManager mGridLayout=new GridLayoutManager(this,3);
                mRecycleView.setLayoutManager(mGridLayout);
                mToolBar.setTitle("GridLayout RecyleView");
                break;

        }



        mArrayData=new ArrayList<>();


        mActionBarView=(ActionBarView)findViewById(R.id.socializeActionBar);




        for(int i=0;i<15;i++){

            ListData mListData=new ListData();

            mListData.setTxtName("Title here "+ i);
            mListData.setTxtDesc(i+"Description Here");
            mArrayData.add(mListData);

        }

        mListAdapter=new ListAdapter(this,mArrayData);

        mRecycleView.setHasFixedSize(true);

        mRecycleView.setAdapter(mListAdapter);




        //http://r.getsocialize.com/a/617100

        // Your entity key. May be passed as a Bundle parameter to your activity
        String entityKey = "40033004";

        // Create an entity object including a name
        // The Entity object is Serializable, so you could also store the whole object in the Intent
        Entity entity = Entity.newInstance(entityKey, "ImageEnrity");
        entity.setType("text/image");
        entity.setName("Hi i am sahring this in social network");
        entity.setMetaData("https://500px.com/photo/388736/oo-by-besim-mazhiqi");






        mActionBarView.setEntity(entity);

        mActionBarView.refresh();


        // Add code to print out the key hash
        try {

            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.himotech.recycleviewdemo",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }




    @Override
    protected void onPause() {
        super.onPause();

        // Call Socialize in onPause
        Socialize.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Call Socialize in onResume
        Socialize.onResume(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Call Socialize in onStart
        Socialize.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Call Socialize in onStop
        Socialize.onStop(this);
    }

    @Override
    protected void onDestroy() {
        // Call Socialize in onDestroy before the activity is destroyed
        Socialize.onDestroy(this);

        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycle_list, menu);
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
