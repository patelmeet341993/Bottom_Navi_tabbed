package friendlyitsolution.com.bottom_navi_tabbed.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import friendlyitsolution.com.bottom_navi_tabbed.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    EditText etname;
    TextView tv;
    Button btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(getActivity()).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        etname=root.findViewById(R.id.etname);
        btn=root.findViewById(R.id.btn);
        tv=root.findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dashboardViewModel.mText.setValue(etname.getText().toString());

            }
        });


        dashboardViewModel.mText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                tv.setText(s);

            }
        });
        return root;
    }
}