package project.com.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Joy on 12/13/2017.
 */

    public class Login extends AppCompatActivity implements View.OnClickListener {


    //defining views
    Button btnlogin;
    EditText email;
    EditText password;
    TextView RegisterLink;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //initializing views
        btnlogin = (Button) findViewById(R.id.btnlogin);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        RegisterLink = findViewById(R.id.RegisterLink);

        //if the objects getcurrentuser method is not null
        //means user is already logged in

        progressDialog = new ProgressDialog(this);

        //getting firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //attaching click listener
        btnlogin.setOnClickListener(this);
        RegisterLink.setOnClickListener(this);
    }

    //method for user login
    private void userLogin() {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        }

                    }
                });

}

    @Override
    public void onClick(View view) {
        if (view == btnlogin) {
            userLogin();
        }

        if (view == RegisterLink) {
            startActivity(new Intent(this, RegisterActivity.class));
            }
        }
    }
