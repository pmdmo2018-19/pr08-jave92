package es.iessaladillo.jave92.pr08.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    public DetailFragment() {
    }
    public static DetailFragment newInstance(){ return new DetailFragment(); }

    FragmentDetailBinding b;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews(requireView());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = FragmentDetailBinding.inflate(inflater, container, false);
        return b.getRoot();
    }

    private void setupViews(View view) {
        setupToolbar(view);
        b.fabSave.setOnClickListener(v -> Toast.makeText(requireContext(),"Guardado", Toast.LENGTH_SHORT).show());
    }

    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbarDetail);
        CollapsingToolbarLayout collapsingToolbarLayout = ViewCompat.requireViewById(view,
                R.id.collapsingToolbarDetail);
        collapsingToolbarLayout.setTitle("Detail");
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
