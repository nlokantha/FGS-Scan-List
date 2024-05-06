package com.example.fgsscanlist.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fgsscanlist.Models.Auth;
import com.example.fgsscanlist.R;
import com.example.fgsscanlist.databinding.FragmentLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    FragmentLoginBinding binding;
    private OkHttpClient client;
    private static final String TAG = "demo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = new OkHttpClient();

//        binding.editTextUserName.setText("b@b.com");
//        binding.editTextPassword.setText("test123");

        binding.editTextUserName.setText("FGS");
        binding.editTextPassword.setText("fgs@user");

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = binding.editTextUserName.getText().toString();
                String password = binding.editTextPassword.getText().toString();

                if (userName.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter User Name", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("username", userName);
                        jsonBody.put("password", password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody requestBody = RequestBody.create(jsonBody.toString(), MediaType.parse("application/json"));

                    Request request = new Request.Builder()
                            .url("http://192.168.40.25:8080/DBConnector/rest/user/authentication")
                            .header("Content-Type", "application/json")
                            .header("Accept", "*/*")
                            .header("Access-Control-Allow-Headers", "Content-Type")
                            .post(requestBody)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NonNull Call call, @NonNull IOException e) {
                            e.printStackTrace();
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getActivity(), "Network Error!!!!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        @Override
                        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                            if (response.isSuccessful()) {
                                String body = response.body().string();
                                Log.d(TAG, "onResponse: login body = " + body);
                                Log.d(TAG, "onResponse: login response code = " + response.code());
                                try {
                                    JSONObject jsonObject = new JSONObject(body);
                                    Auth auth = new Auth(jsonObject);
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            mListener.authSuccessfully(auth);
                                            Toast.makeText(getActivity(), "Login Successful!!!!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                Log.d(TAG, "onResponse: Error is = " + response.code());
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getActivity(), "Please Check Your Email and Password ", Toast.LENGTH_SHORT).show();
                                        loginError();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    private void loginError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View alertDialog = inflater.inflate(R.layout.custom_dialog_login,null);
        builder.setView(alertDialog);

        AlertDialog alert = builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();

        AppCompatButton buttonClose = alertDialog.findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.dismiss();
            }
        });

    }

    LoginFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (LoginFragmentListener) context;
    }

    public interface LoginFragmentListener {
        void authSuccessfully(Auth auth);
    }
}