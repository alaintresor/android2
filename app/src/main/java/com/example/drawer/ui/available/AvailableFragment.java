package com.example.drawer.ui.available;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.drawer.R;
import com.example.drawer.SingleCategory;
import com.example.drawer.catAdpter;
import com.example.drawer.catSetData;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AvailableFragment extends Fragment {

    private AvailableViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(AvailableViewModel.class);
        View root = inflater.inflate(R.layout.fragment_available, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        ListView listView=root.findViewById(R.id.MyList);

       LinearLayout linearLayout=root.findViewById(R.id.cat1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SingleCategory.class);
                startActivity(intent);
            }
        });

//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                FetchData fetchData = new FetchData("http://192.168.43.208/android/products.php");
//                if (fetchData.startFetch()) {
//                    if (fetchData.onComplete()) {
////                        String result = fetchData.getResult();
////                        //End ProgressBar (Set visibility to GONE)
////                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
//
//
//
//                        try {
//                            JSONArray array = new JSONArray(fetchData.getResult());
////                            Toast.makeText(getApplicationContext(),array.length(),Toast.LENGTH_LONG).show();
//                            for (int i = 0; i < array.length(); i++) {
//                                JSONObject object = array.getJSONObject(i);
//                                String id = object.getString("id");
//                                String name = object.getString("name");
//                                String qty = object.getString("qty");
//                                String price = object.getString("price");
//                                String description = object.getString("description");
//                                String image = object.getString("image");
//
//                                catSetData.add(new catSetData(data1));
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        });


        String data1="IMBUTO";
        String data2="IMBOGA";
        String data3="AMATUNGO";
        String data4="IMBUTO";
        String data5="IMBUTO";
        final List<catSetData> catSetData;
        catSetData = new ArrayList<>();
        catSetData.add(new catSetData(data1));
        catSetData.add(new catSetData(data1));
        catSetData.add(new catSetData(data1));
        catSetData.add(new catSetData(data1));

        catAdpter catAdpter = new catAdpter(getContext(), R.layout.recentpro, catSetData);
        listView.setAdapter(catAdpter);
        return root;
    }
}