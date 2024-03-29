package friendlyitsolution.com.bottom_navi_tabbed;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import friendlyitsolution.com.bottom_navi_tabbed.ui.dashboard.DashboardFragment;
import friendlyitsolution.com.bottom_navi_tabbed.ui.home.HomeFragment;
import friendlyitsolution.com.bottom_navi_tabbed.ui.notifications.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);*/


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if(menuItem.getItemId()==R.id.navigation_home)
                {

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).commit();

                }
                else if(menuItem.getItemId()==R.id.navigation_dashboard)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new DashboardFragment()).commit();


                }
                else
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new NotificationsFragment()).commit();

                }

                menuItem.setChecked(true);


                return false;
            }
        });


    }

}
