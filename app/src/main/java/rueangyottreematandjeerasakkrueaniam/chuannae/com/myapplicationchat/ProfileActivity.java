package rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Button mbtnLogout;
    private GoogleSignInClient mGoogleSignInClient;

    public TextView txtName;
    public TextView txtEmail;
    public TextView txtID;
    public ImageView imageView;

    private FirebaseUser mUser;

  CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtName = (TextView) findViewById(R.id.txtName);
        txtID = (TextView) findViewById(R.id.txtID);
        imageView = (ImageView) findViewById(R.id.imageView);

        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            Glide.with(this).load(user.getPhotoUrl()).into(imageView);
            txtName.setText(user.getDisplayName());
            txtEmail.setText(user.getEmail());
//            txtID.setText(user.getUid());


        }



        mbtnLogout = (Button) findViewById(R.id.btnLogout);

        mbtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                LoginManager.getInstance().logOut();
                updateUI();
            }
        });


    }


    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            updateUI();
        }
    }

    private void updateUI() {
        Toast.makeText(ProfileActivity.this,"You're logged out", Toast.LENGTH_LONG).show();
        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        finish();
    }

    //Button Sign out and Disconnect
    public void btnLogout(View v) {
        FirebaseAuth.getInstance().signOut();
         LoginManager.getInstance().logOut();
        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        Toast.makeText(ProfileActivity.this,"Logged out",Toast.LENGTH_LONG).show();
    }

    public void btnDisconnect(View v) {
        mAuth.signOut();
        mAuth.getCurrentUser().delete();
        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
        Toast.makeText(ProfileActivity.this,"Logged out",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStop(){
        super.onStop();

        if(mAuthStateListener != null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                if (mUser != null && mAuth != null) {

                    startActivity(new Intent(ProfileActivity.this, NewPostActivity.class));
                    finish();

                }
                break;
            case R.id.backmain:
                if (mUser != null && mAuth != null) {

                    startActivity(new Intent(ProfileActivity.this, MainActivityBottom.class));
                    finish();

                }

                break;
            case R.id.action_signout:

                if (mUser != null && mAuth != null) {
                    mAuth.signOut();

                    startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                    finish();

                }
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
