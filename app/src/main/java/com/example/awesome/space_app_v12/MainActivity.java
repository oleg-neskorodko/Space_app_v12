package com.example.awesome.space_app_v12;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.awesome.space_app_v12.history.HistoryFragment;
import com.example.awesome.space_app_v12.info.InfoFragment;
import com.example.awesome.space_app_v12.rockets.RocketsFragment;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    public static String TAG = "tag";

    private String[] mItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private Toolbar mToolbar;
    private CharSequence mTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private ItemModel[] dItems;
    private DrawerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity onCreate");

        mTitle = getTitle();
        mItemTitles = getResources().getStringArray(R.array.drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);


        setupToolbar();
        if (savedInstanceState == null) {
            addFragment();
            getSupportActionBar().setTitle(mItemTitles[0]);
        } else {
            getSupportActionBar().setTitle(savedInstanceState.getString("barTitle", mItemTitles[0]));
            RocketsFragment fRockets = (RocketsFragment) getSupportFragmentManager().findFragmentByTag("rockets");
            if (fRockets != null) {
                Log.d(TAG, "test rockets OK");
                fRockets.setListener(this);
            }
            InfoFragment fInfo = (InfoFragment) getSupportFragmentManager().findFragmentByTag("info");
            if (fInfo != null) {
                Log.d(TAG, "test info OK");
                fInfo.setListener(this);
            }
            HistoryFragment fHistory = (HistoryFragment) getSupportFragmentManager().findFragmentByTag("history");
            if (fHistory != null) {
                Log.d(TAG, "test history OK");
                fHistory.setListener(this);
            }
        }

        dItems = fillDataModel();
        setDrawer();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("barTitle", getSupportActionBar().getTitle().toString());
    }

    public void setDrawer() {
        adapter = new DrawerAdapter(this, R.layout.item_row, dItems);
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setOnItemClickListener(new ItemClickListener(this));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }

    public void addFragment() {
        Fragment fragment = new HistoryFragment();
        ((HistoryFragment) fragment).setListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    // формируем массив с данными для адаптера
    private ItemModel[] fillDataModel() {
        return new ItemModel[]{
                new ItemModel(android.R.drawable.ic_dialog_email, getResources().getStringArray(R.array.drawer_items)[0]),
                new ItemModel(android.R.drawable.ic_dialog_info, getResources().getStringArray(R.array.drawer_items)[1]),
                new ItemModel(android.R.drawable.ic_dialog_map, getResources().getStringArray(R.array.drawer_items)[2])
        };
    }

    @Override
    public void onDetails(String str) {
        Log.d(TAG, "onDetails main");
        detailedHistory(str);
    }

    // по клику на элемент списка устанавливаем нужный фрагмент в контейнер
    private class ItemClickListener implements ListView.OnItemClickListener, FragmentListener {

        private Context context;
        public ItemClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Fragment fragment = null;
            FragmentManager fragmentManager = getSupportFragmentManager();

            // на основании выбранного элемента меню
            // вызываем соответствующий ему фрагмент
            switch (position) {
                case 0:
                    fragment = new HistoryFragment();
                    ((HistoryFragment) fragment).setListener(this);
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, "history").addToBackStack("mainStack").commit();
                    break;
                case 1:
                    fragment = new InfoFragment();
                    ((InfoFragment) fragment).setListener(this);
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, "info").addToBackStack("mainStack").commit();
                    break;
                case 2:
                    fragment = new RocketsFragment();
                    ((RocketsFragment) fragment).setListener(this);
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment, "rockets").addToBackStack("mainStack").commit();
                    break;

                default:
                    break;
            }
            if (fragment != null) {
                mDrawerListView.setItemChecked(position, true);
                mDrawerListView.setSelection(position);
                setTitle(mItemTitles[position]);
                mDrawerLayout.closeDrawer(mDrawerListView);
            }
        }

        @Override
        public void onDetails(String str) {
            Log.d(TAG, "onDetails item");
            detailedHistory(str);
        }
    }

    public void detailedHistory(String str) {
        Fragment fragment = new DetailedHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("mainStack").commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    public void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        // Это необходимо для изменения иконки на основании текущего состояния
        mDrawerToggle.syncState();
    }
}
