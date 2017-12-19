package project.com.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener{
private DatabaseReference databaseReference;
private EditText Name;
private Spinner spinner1;
private EditText phone;
private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Name = (EditText) findViewById(R.id.Name);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        phone = (EditText) findViewById(R.id.phone);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
    }

    private void saveUserInformation(){

        String name1 = Name.getText().toString().trim();
        String spinner2 = spinner1.getSelectedItem().toString().trim();
        String phone1 = phone.getText().toString().trim();


        UserInformation userInformation = new UserInformation(name1, spinner2, phone1);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
        } else {
            // No user is signed in
        }
        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this, "Information Save...", Toast.LENGTH_LONG).show();
    }



    @Override
    public void onClick(View view) {
        if(view == btnSave){
           // saveUserInformation();

            startActivity(new Intent(this, MapsActivity.class));
        }


    }
}
