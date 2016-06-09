package com.example.amoxicilin.myapplication.main;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.example.amoxicilin.myapplication.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private PopupWindow popupwindow;
    private LinearLayout layout;
    private boolean judge=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layout=(LinearLayout)findViewById(R.id.layout_test);
        layout.setVisibility(View.INVISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                if (judge) {
                    fm.beginTransaction().replace(R.id.content_frame, new Fetch_List_Fragment()).commit();
                    judge = !judge;
                } else {
                    fm.beginTransaction().replace(R.id.content_frame, new CallFragment()).commit();
                    judge = !judge;
                }
            }
        });

        Spinner bt1= (Spinner)findViewById(R.id.test_Spinner1);
        Button bt2= (Button)findViewById(R.id.test_Button2);
        bt2.setOnClickListener(this);




        String[] res={"美化","设计","生活","教育"};
        ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,res);
        bt1.setAdapter(adapter);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentManager fm=getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,new CallFragment()).commit();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_Button2:
                if (popupwindow != null&&popupwindow.isShowing()) {
                    popupwindow.dismiss();
                    return;
                } else {
                    initmPopupWindowView();
                    popupwindow.showAsDropDown(v, 0, 5);
                }
                break;
            default:
                break;
        }
    }
;

    public void initmPopupWindowView() {

        // // 获取自定义布局文件pop.xml的视图
        View customView = getLayoutInflater().inflate(R.layout.pop_window,
                null, false);
        // 创建PopupWindow实例,200,150分别是宽度和高度

        WindowManager wm = (WindowManager) getBaseContext()
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();

        popupwindow = new PopupWindow(customView, width, 400);
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]

        // 自定义view添加触摸事件
        customView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupwindow != null && popupwindow.isShowing()) {
                    popupwindow.dismiss();
                    popupwindow = null;
                }

                return false;
            }
        });

        /** 在这里可以实现自定义视图的功能 */

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_call) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new CallFragment()).commit();
            judge=true;
            // Handle the camera action
        } else if (id == R.id.nav_fetch) {

    FragmentManager fm=getFragmentManager();
         fm.beginTransaction().replace(R.id.content_frame,new Fetch_List_Fragment()).commit();
          judge=false;
            layout.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_history) {
            FragmentManager fm=getFragmentManager();
            fm.beginTransaction().replace(R.id.content_frame,new HistoryFragment()).commit();

        } else if (id == R.id.nav_options) {
            Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


