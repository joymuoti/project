package project.com.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Payment extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
        Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        btnLogout = (Button) findViewById(R.id.btnLogout);

        //adding listener to button
        btnLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == btnLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
        }
    }
    }

