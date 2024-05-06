package com.example.fgsscanlist.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fgsscanlist.Models.FgsScanList;
import com.example.fgsscanlist.R;
import com.example.fgsscanlist.databinding.FragmentViewBinding;

import java.util.ArrayList;

public class ViewFragment extends Fragment {
    private static final String TAG = "demo";
    private static final String ARG_PARAM_LIST = "ARG_PARAM_LIST";

    private ArrayList<FgsScanList> mLists;

    public ViewFragment() {
        // Required empty public constructor
    }
    public static ViewFragment newInstance(ArrayList<FgsScanList> mLists) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_LIST, mLists);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLists = (ArrayList<FgsScanList>) getArguments().getSerializable(ARG_PARAM_LIST);

        }
    }
    FragmentViewBinding binding;
    ViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentViewBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated: array list size is = "+mLists.size());
        if (mLists != null){
            adapter = new ViewAdapter(mLists);
            binding.recyclerView.setAdapter(adapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoHomeFragment();
            }
        });
    }

    class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.DbViewHolder>{
        ArrayList<FgsScanList> lists;

        public ViewAdapter(ArrayList<FgsScanList> lists) {
            this.lists = lists;
        }

        @NonNull
        @Override
        public DbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
            return new DbViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DbViewHolder holder, int position) {
            FgsScanList fgsScanList = lists.get(position);
            holder.textViewCurrentPage.setText(fgsScanList.getCurrentPage());
            holder.textViewNumberOfRows.setText(fgsScanList.getNumberOfRows());
            holder.textViewSortOrder.setText(fgsScanList.getSortOrder());
            holder.textViewSortColumn.setText(fgsScanList.getSortColumn());
            holder.textViewIsSearch.setText(fgsScanList.getIsSearch());
            holder.textViewIsSearch.setText(fgsScanList.getIsSearch());
            holder.textViewOperation.setText(fgsScanList.getOperation());
            holder.textViewField.setText(fgsScanList.getField());
            holder.textViewRefNo.setText(String.valueOf(fgsScanList.getRefNo()));
            holder.textViewLine.setText(String.valueOf(fgsScanList.getLine()));
            holder.textViewCompanyCode.setText(fgsScanList.getCompanyCode());
            holder.textViewBuyerPO.setText(fgsScanList.getBuyerPO());
            holder.textViewSalesOrderCounterCode.setText(fgsScanList.getSalesOrderCounterCode());
            holder.textViewSalesOrderCode.setText(fgsScanList.getSalesOrderCode());
            holder.textViewOrderLine.setText(String.valueOf(fgsScanList.getOrderLine()));
            holder.textViewSubLine.setText(String.valueOf(fgsScanList.getSubLine()));
            holder.textViewComponentOrderLine.setText(String.valueOf(fgsScanList.getComponentOrderLine()));
            holder.textViewCustomerSupplierType.setText(fgsScanList.getCustomerSupplierType());
            holder.textViewCustomerSupplierCode.setText(fgsScanList.getCustomerSupplierCode());
            holder.textViewUpcID.setText(String.valueOf(fgsScanList.getUpcId()));
            holder.textViewCartonType.setText(String.valueOf(fgsScanList.getCartonType()));
            holder.textViewCartonType.setText(String.valueOf(fgsScanList.getCartonType()));
            holder.textViewPackingFlag.setText(fgsScanList.getPackingFlag());
            holder.textViewWeight.setText(String.valueOf(fgsScanList.getWeight()));
            holder.textViewLength.setText(String.valueOf(fgsScanList.getLength()));
            holder.textViewWidth.setText(String.valueOf(fgsScanList.getWidth()));
            holder.textViewHeight.setText(String.valueOf(fgsScanList.getHeight()));
            holder.textViewUnitPerPKg.setText(String.valueOf(fgsScanList.getUnitPerPkg()));
            holder.textViewStatus.setText(String.valueOf(fgsScanList.getStatus()));
        }
        @Override
        public int getItemCount() {
            return lists.size();
        }

        class DbViewHolder extends RecyclerView.ViewHolder{

            TextView textViewCurrentPage,textViewNumberOfRows,
                    textViewSortOrder,
                    textViewSortColumn,textViewIsSearch,textViewOperation,textViewField,textViewRefNo,
                    textViewLine,textViewCompanyCode,
                    textViewBuyerPO,textViewSalesOrderCounterCode,
                    textViewSalesOrderCode,textViewOrderLine,textViewSubLine,
                    textViewComponentOrderLine,textViewCustomerSupplierType,textViewCustomerSupplierCode,
                    textViewUpcID,textViewCartonType,textViewPackingFlag,textViewWeight,
                    textViewLength,textViewWidth,textViewHeight,
                    textViewUnitPerPKg,textViewStatus;
            /*
              String buyerPO;
    String salesOrderCounterCode;
    String salesOrderCode;
     String customerSupplierType;
    String customerSupplierCode
    packingFlag
             */

            public DbViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewCurrentPage = itemView.findViewById(R.id.textViewCurrentPage);
                textViewNumberOfRows = itemView.findViewById(R.id.textViewNumberOfRows);
                textViewSortOrder = itemView.findViewById(R.id.textViewSortOrder);
                textViewSortColumn = itemView.findViewById(R.id.textViewSortColumn);
                textViewIsSearch = itemView.findViewById(R.id.textViewIsSearch);
                textViewOperation = itemView.findViewById(R.id.textViewOperation);
                textViewField = itemView.findViewById(R.id.textViewField);
                textViewRefNo = itemView.findViewById(R.id.textViewRefNo);
                textViewLine = itemView.findViewById(R.id.textViewLine);
                textViewCompanyCode = itemView.findViewById(R.id.textViewCompanyCode);
                textViewBuyerPO = itemView.findViewById(R.id.textViewBuyerPO);
                textViewSalesOrderCounterCode = itemView.findViewById(R.id.textViewSalesOrderCounterCode);
                textViewSalesOrderCode = itemView.findViewById(R.id.textViewSalesOrderCode);
                textViewOrderLine = itemView.findViewById(R.id.textViewOrderLine);
                textViewSubLine = itemView.findViewById(R.id.textViewSubLine);
                textViewComponentOrderLine = itemView.findViewById(R.id.textViewComponentOrderLine);
                textViewCustomerSupplierType = itemView.findViewById(R.id.textViewCustomerSupplierType);
                textViewCustomerSupplierCode = itemView.findViewById(R.id.textViewCustomerSupplierCode);
                textViewUpcID = itemView.findViewById(R.id.textViewUpcID);
                textViewCartonType = itemView.findViewById(R.id.textViewCartonType);
                textViewPackingFlag = itemView.findViewById(R.id.textViewPackingFlag);
                textViewWeight = itemView.findViewById(R.id.textViewWeight);
                textViewLength = itemView.findViewById(R.id.textViewLength);
                textViewWidth = itemView.findViewById(R.id.textViewWidth);
                textViewHeight = itemView.findViewById(R.id.textViewHeight);
                textViewUnitPerPKg = itemView.findViewById(R.id.textViewUnitPerPKg);
                textViewStatus = itemView.findViewById(R.id.textViewStatus);

            }
        }
    }

    ViewFragmentListener mListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ViewFragmentListener) context;
    }

    public interface ViewFragmentListener{
        void gotoHomeFragment();
    }
}