package com.example.navigationcomponent;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavArgsLazyKt;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponent.data.Database;
import com.example.navigationcomponent.databinding.FragmentChooseRecipientsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChooseRecipients#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChooseRecipients extends Fragment implements TextWatcher {
    private FragmentChooseRecipientsBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentChooseRecipients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentChooseRecipients.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentChooseRecipients newInstance(String param1, String param2) {
        FragmentChooseRecipients fragment = new FragmentChooseRecipients();
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
        binding = FragmentChooseRecipientsBinding.inflate(inflater,container,false);
       View v = binding.getRoot();
        binding.editTextRecipients.addTextChangedListener(this);



        return v;
    }

    private boolean isValidRecipient()
    {
        if(Database.getInstance().getDb().containsKey(binding.editTextRecipients.getText().toString()))
        {
            return true;
        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(isValidRecipient())
        {
            binding.buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentChooseRecipientsDirections.ActionFragmentChooseRecipientsToFragmentAmount  action = FragmentChooseRecipientsDirections.actionFragmentChooseRecipientsToFragmentAmount();
                    action.setRecipient(binding.editTextRecipients.getText().toString());
                    Navigation.findNavController(view).navigate(action);
                }
            });

        }
    }
}