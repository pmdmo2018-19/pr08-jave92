package es.iessaladillo.jave92.pr08.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import es.iessaladillo.jave92.pr08.ui.detail.DetailFragment;
import es.iessaladillo.jave92.pr08.ui.settings.SettingsFragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    public MainFragment(){
    }
    public static MainFragment newInstance() {
        return new MainFragment();
    }
    FragmentMainBinding b;
    private SharedPreferences settings;
    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = FragmentMainBinding.inflate(inflater, container, false);
        return b.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews(requireView());
        settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        onSharedPreferenceChangeListener = (sharedPreferences, key) -> showSettings();
        showSettings();
    }

    private void showSettings() {
        b.txtLorem.setText(settings.getString(getString(R.string.lpLoremType_key), getString(R.string.main_chiquito_ipsum)));
    }

    private void setupViews(View view) {
        setHasOptionsMenu(true);
        setupToolbar(view);
        b.fabDetail.setOnClickListener(v -> navigateToDetailFragment());
    }

    private void navigateToDetailFragment() {
        requireFragmentManager().beginTransaction()
                .replace(R.id.flContent, DetailFragment.newInstance(), DetailFragment.class.getSimpleName())
                .addToBackStack(DetailFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuSettings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbar);

        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("Lorem");
        }
    }

    private void openSettings() {
        requireFragmentManager().beginTransaction()
        .replace(R.id.flContent, SettingsFragment.newInstance(), SettingsFragment.class.getSimpleName())
        .addToBackStack(SettingsFragment.class.getSimpleName())
        .commit();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


}
