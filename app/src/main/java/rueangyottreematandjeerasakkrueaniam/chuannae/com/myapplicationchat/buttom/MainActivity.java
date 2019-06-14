package rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.buttom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.R;


public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    setTitle("Home");
                    PageOne fragment = new PageOne();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content,fragment,"FragmentName");
                    fragmentTransaction.commit();




                    return true;
                case R.id.navigation_dashboard:

                    // code of fragment
                    setTitle("Private Groups");
                    Pagetwo fragment2 = new Pagetwo();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content,fragment2,"FragmentName");
                    fragmentTransaction2.commit();

                    return true;
                case R.id.navigation_notifications:

                    // code of fragment
                    setTitle("Notification");
                    PageThre fragment3 = new PageThre();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.content,fragment3,"FragmentName");
                    fragmentTransaction3.commit();

                    return true;

                case R.id.page_grain:

                    // code of fragment
                    setTitle("About us");
                    PageGrain fragment4 = new PageGrain();
                    android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.content,fragment4,"FragmentName");
                    fragmentTransaction4.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Page One");
        PageOne fragment = new PageOne();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment,"FragmentName");
        fragmentTransaction.commit();



    }


}