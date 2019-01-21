package com.b2w.lodjinha.menu.view;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.menu.contract.MenuMVP;
import com.b2w.lodjinha.menu.presenter.MenuPresenter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_menu)
public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MenuMVP.MenuView {

    @Bean
    protected MenuPresenter menuPresenter;

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.nav_view)
    protected NavigationView navigationView;

    @ViewById(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @AfterInject
    public void iniciarHome(){
        menuPresenter.seView(this);
    }

    @AfterViews
    public void carregarHome() {
        setSupportActionBar(toolbar);

        carregarMenuLateral();

        menuPresenter.carregarFragmentHome();
    }

    @Override
    public void carregarMenuLateral() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            menuPresenter.carregarFragmentHome();
        } else if (id == R.id.nav_about) {
            menuPresenter.carregarFragmentSobre();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void trocarFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
