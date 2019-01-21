package es.iessaladillo.jave92.pr08.ui.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr08.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            navigateToStartFragment();
        }
    }

    private void navigateToStartFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, MainFragment.newInstance(), MainFragment.class.getSimpleName()).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
