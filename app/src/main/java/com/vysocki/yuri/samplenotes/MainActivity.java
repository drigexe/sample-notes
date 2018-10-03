package com.vysocki.yuri.samplenotes;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    protected static final int FRAGMENT_CONTAINER_ID = R.id.fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            NotesListFragment notesListFragment = NotesListFragment.newInstance();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(FRAGMENT_CONTAINER_ID, notesListFragment, notesListFragment.getClass().toString());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = defineSelectedMenuItem(item.getItemId());
                    setFragment(selectedFragment, FRAGMENT_CONTAINER_ID, true);

                    return true;
                }
            };

    private Fragment defineSelectedMenuItem(int menuItemId) {
        Fragment selectedFragment = null;
        switch (menuItemId) {
            case R.id.nav_notes_list:
                selectedFragment = NotesListFragment.newInstance();
                break;
            case R.id.nav_new_note:
                selectedFragment = NewNoteFragment.newInstance();
                break;
            case R.id.nav_user:
                selectedFragment = UserProfileFragment.newInstance();
                break;
        }
        return selectedFragment;
    }

    protected void setFragment(Fragment fragment, int containerId, boolean toBackStack) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(containerId);
        String tag = currentFragment.getTag();
        if (!fragment.getClass().toString().equals(tag)) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(containerId, fragment, fragment.getClass().toString());
            if (toBackStack) {
                fragmentTransaction.addToBackStack(null);
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() < 2) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    protected void setBottomNavigationSelectedItem(int menuItemId) {
        bottomNav.setSelectedItemId(menuItemId);
    }

    protected void setBottomNavigationVisibility(boolean visibilityState) {
        if (visibilityState) {
            bottomNav.setVisibility(View.VISIBLE);
        } else {
            bottomNav.setVisibility(View.GONE);
        }
    }

}
