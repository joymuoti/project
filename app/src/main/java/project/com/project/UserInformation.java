package project.com.project;

import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Joy on 12/19/2017.
 */

public class UserInformation {
    public String Name;
    public Spinner spinner1;
    public String phone;
    public String city;

    public UserInformation(String Name, Spinner spinner1, String phone, String city){
        this.Name = Name;
        this.spinner1 = spinner1;
        this.phone = phone;
        this.city= city;

    }



}
