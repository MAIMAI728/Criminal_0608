package com.example.criminal;


import android.support.v4.app.Fragment;

/**
 * Created by mai on 2017/06/03.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}