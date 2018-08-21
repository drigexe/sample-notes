package com.vysocki.yuri.samplenotes;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        setFragment(new NotesListFragment(), false);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = defineSelectedMenuItem(item.getItemId());
                    setFragment(selectedFragment, false);

                    return true;
                }
            };

    private Fragment defineSelectedMenuItem(int menuItemId) {
        Fragment selectedFragment = null;
        switch (menuItemId) {
            case R.id.nav_notes_list:
                selectedFragment = new NotesListFragment();
                break;
            case R.id.nav_new_note:
                selectedFragment = new NewNoteFragment();
                break;
            case R.id.nav_user:
                selectedFragment = new UserProfileFragment();
                break;
        }
        return selectedFragment;
    }

    protected void setFragment(Fragment fragment, boolean toBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (toBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    protected void setBottomNavigationVisibility(boolean visibilityState) {
        if (visibilityState) {
            bottomNav.setVisibility(View.VISIBLE);
        } else {
            bottomNav.setVisibility(View.GONE);
        }
    }

}
