package com.example.fgsscanlist.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fgsscanlist.Models.Auth;
import com.example.fgsscanlist.R;
import com.example.fgsscanlist.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM_AUTH = "ARG_PARAM_AUTH";

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoViewFragment();

//                String search = binding.editTextSearch.getText().toString();
//                String companyCode = binding.editTextCompanyCode.getText().toString();
//                String currentPage = binding.editTextCurrentPage.getText().toString();
//                String numberOfRows = binding.editTextNumberOfRows.getText().toString();
//                String sortOrder = binding.editTextSortOrder.getText().toString();
//                String sortColumn = binding.editTextSortColumn.getText().toString();
//                String refNumber = binding.editTextRefNumber.getText().toString();
//                if (search.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter", Toast.LENGTH_SHORT).show();
//                } else if (companyCode.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Company Code", Toast.LENGTH_SHORT).show();
//                } else if (currentPage.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Current Page", Toast.LENGTH_SHORT).show();
//                } else if (numberOfRows.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Number Of Rows", Toast.LENGTH_SHORT).show();
//                } else if (sortOrder.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Sort Order", Toast.LENGTH_SHORT).show();
//                } else if (sortColumn.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Sort Column", Toast.LENGTH_SHORT).show();
//                } else if (refNumber.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please Enter Ref Number", Toast.LENGTH_SHORT).show();
//                }else {

//
//                }
            }
        });
        binding.buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Logout Successful", Toast.LENGTH_SHORT).show();
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