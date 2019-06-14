package rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.buttom.PageGrain;
import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.buttom.PageOne;
import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.buttom.PageThre;
import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.buttom.Pagetwo;

public class MainActivityBottom extends AppCompatActivity {

    ImageButton maps;
    ImageButton posts;

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

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainch);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        setTitle("Home");
        PageOne fragment = new PageOne();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment,"FragmentName");
        fragmentTransaction.commit();

    }

    public void Post(View view){
        startActivity(new Intent(MainActivityBottom.this, MainActivity.class) );
        Toast.makeText(MainActivityBottom.this,"Posts",Toast.LENGTH_LONG).show();
    }

    public void Maps(View view){
        startActivity(new Intent(MainActivityBottom.this,MainActivityBottom.class) );
        Toast.makeText(MainActivityBottom.this,"Maps",Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_profile:
                if (mUser != null && mAuth != null) {

                    startActivity(new Intent(MainActivityBottom.this, ProfileActivity.class));
                    finish();

                }

                break;
            case R.id.action_signout:

                if (mUser != null && mAuth != null) {
                    mAuth.signOut();

                    startActivity(new Intent(MainActivityBottom.this, LoginActivity.class));
                    finish();

                }
                break;

        }

        return super.onOptionsItemSelected(item);
    }



}
