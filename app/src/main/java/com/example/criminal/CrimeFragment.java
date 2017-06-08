package com.example.criminal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

import static android.widget.CompoundButton.*;

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    public static final String EXTRA_ID = "com.example.criminal.id";

    //***2017/06/08***
    //extra: ID, formatted as a String
    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        //intentからidを取得する
        String mId = getActivity().getIntent().getStringExtra(CrimeListFragment.EXTRA_ID);
        //UUIDにする
        UUID id = UUID.fromString(mId);
        // CrimeLab object上で必要なget()methodをgetCrime methodと呼ぶ
        CrimeLab crimes = CrimeLab.get(getContext());
        //mCrime=id取得
        mCrime = crimes.getCrime(id);


        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        // setting checkbutton checked if the crime is solved:
        if (mCrime.isSolved() == true) {
            mSolvedCheckBox.setChecked(true);
        }
        else{
            mSolvedCheckBox.setChecked(false);
        }


        mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSolvedCheckBox.setChecked(isChecked);

            }
        });

        return v;

    }

}