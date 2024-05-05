package com.example.fgsscanlist.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fgsscanlist.Models.Auth;
import com.example.fgsscanlist.Models.FgsScanList;
import com.example.fgsscanlist.R;
import com.example.fgsscanlist.databinding.FragmentHomeBinding;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM_AUTH = "ARG_PARAM_AUTH";
    private static final String TAG = "demo";

    private Auth mAuth;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(Auth mAuth) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_AUTH, mAuth);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAuth = (Auth) getArguments().getSerializable(ARG_PARAM_AUTH);
        }
    }

    FragmentHomeBinding binding;
    List<FgsScanList> lists = new ArrayList<>();
    private OkHttpClient client;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = new OkHttpClient();

        binding.editTextSearch.setText("N");
        binding.editTextCompanyCode.setText("100");
        binding.editTextCurrentPage.setText("1");
        binding.editTextNumberOfRows.setText("100");
        binding.editTextSortOrder.setText("asc");
        binding.editTextSortColumn.setText("line");
        binding.editTextRefNumber.setText("99289");

        binding.buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = binding.editTextSearch.getText().toString();
                String companyCode = binding.editTextCompanyCode.getText().toString();
                String currentPage = binding.editTextCurrentPage.getText().toString();
                String numberOfRows = binding.editTextNumberOfRows.getText().toString();
                String sortOrder = binding.editTextSortOrder.getText().toString();
                String sortColumn = binding.editTextSortColumn.getText().toString();
                String refNumber = binding.editTextRefNumber.getText().toString();
                if (search.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter", Toast.LENGTH_SHORT).show();
                } else if (companyCode.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Company Code", Toast.LENGTH_SHORT).show();
                } else if (currentPage.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Current Page", Toast.LENGTH_SHORT).show();
                } else if (numberOfRows.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Number Of Rows", Toast.LENGTH_SHORT).show();
                } else if (sortOrder.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Sort Order", Toast.LENGTH_SHORT).show();
                } else if (sortColumn.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Sort Column", Toast.LENGTH_SHORT).show();
                } else if (refNumber.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Ref Number", Toast.LENGTH_SHORT).show();
                } else {
                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("isSearch", search);
                        jsonBody.put("companyCode", companyCode);
                        jsonBody.put("currentPage", currentPage);
                        jsonBody.put("numberOfRows", numberOfRows);
                        jsonBody.put("sortOrder", sortOrder);
                        jsonBody.put("sortColumn", sortColumn);
                        jsonBody.put("refNo", refNumber);
                        Log.d(TAG, "onClick: jsonbody to string = "+jsonBody.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    RequestBody requestBody = RequestBody.create(jsonBody.toString(), MediaType.parse("application/json"));

                    Request request = new Request.Builder()
                            .url("http://192.168.40.25:8080/DBConnector/rest/user/get-fgs-scan-list")
                            .header("Content-Type", "application/json")
                            .header("Accept", "*/*")
                            .header("Access-Control-Allow-Headers", "Content-Type")
                            .header("Authorization", "Bearer " + mAuth.getToken())
                            .post(requestBody)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            if (response.isSuccessful()) {
                                String body = response.body().string();
                                Gson gson = new Gson();
//                                FgsScanList fgsScanList= gson.fromJson(body, FgsScanList.class);
                                FgsScanList[] fgsScanLists = gson.fromJson(body, FgsScanList[].class);
                                Log.d(TAG, "onResponse: list = "+fgsScanLists.length);
                                lists.addAll(Arrays.asList(fgsScanLists));
                                Log.d(TAG, "onResponse: array List = "+lists.size());
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mListener.gotoViewFragment();
                                    }
                                });


                            }else {
                                Log.d(TAG, "onResponse: Error!!!!!"+response.code());
                            }
                        }
                    });
                }
            }
        });
        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.logout();
            }
        });

    }

    HomeFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (HomeFragmentListener) context;
    }

    public interface HomeFragmentListener {
        void gotoViewFragment();

        void logout();
    }
}