package com.takeiteasy.vip.trymvp.view.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.takeiteasy.vip.trymvp.R;
import com.takeiteasy.vip.trymvp.adapters.DataAdapter;
import com.takeiteasy.vip.trymvp.model.FirebaseDataItem;
import com.takeiteasy.vip.trymvp.presenter.MainPresenter;
import com.takeiteasy.vip.trymvp.presenter.MainPresenterImpl;
import com.takeiteasy.vip.trymvp.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mPresenter;
    private DataAdapter mAdapter;
    private ProgressBar mProgress;

    @Override
    protected void onStart() {
        super.onStart();

        mPresenter.subscribe(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        mPresenter.unsubscribe();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgress = (ProgressBar) findViewById(R.id.progress);
        mProgress.setVisibility(View.GONE);
        setRecyclerView();
        mPresenter = new MainPresenterImpl();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.clean();
                mPresenter.loadData();
            }
        });
    }

    private void setRecyclerView() {
        RecyclerView rvData = (RecyclerView) findViewById(R.id.rv_data);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DataAdapter();
        rvData.setAdapter(mAdapter);
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

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setItems(List<FirebaseDataItem> data) {
        mAdapter.setNewData(data);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
