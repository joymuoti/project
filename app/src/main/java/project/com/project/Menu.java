package project.com.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eokinyi on 12/19/2017.
 */

public class Menu {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_profile:
                onCreateOptionsMenu(Menu menu);
                return true;
            case R.id.payment1:
                showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
