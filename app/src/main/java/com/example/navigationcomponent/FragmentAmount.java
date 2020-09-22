package com.example.navigationcomponent;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponent.data.Database;
import com.example.navigationcomponent.databinding.FragmentAmountBinding;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAmount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAmount extends Fragment implements TextWatcher {
    private FragmentAmountBinding binding;
    private String args;
    private HashMap<String,Integer> database;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAmount() {

        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        database  = Database.getDb();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAmount.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAmount newInstance(String param1, String param2) {
        FragmentAmount fragment = new FragmentAmount();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAmountBinding.inflate(inflater,container,false);
        View v = binding.getRoot();
        args = FragmentAmountArgs.fromBundle(getArguments()).getRecipient();
        binding.editTextAmount.addTextChangedListener(this);
        database.put("data",40);

        Log.d("aa",database.get("data").toString());
        return v;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        int amount = Integer.parseInt(charSequence.toString());
        int currentAmount = database.get(args);
database.put(args,currentAmount+amount);
        Log.d("aa",database.get(args).toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}