package kr.ac.skuniv.choejun_yeong.boostcamp3;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import kr.ac.skuniv.choejun_yeong.boostcamp3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView.LayoutManager rvManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();

    }

    private void setupView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);
        rvManager = new LinearLayoutManager(this);
        binding.mainRv.setLayoutManager(rvManager);
    }


    public void searchOnClick(View view) {
        Toast.makeText(this, "" + binding.mainSearchEdittext.getText(), Toast.LENGTH_SHORT).show();
    }

}
