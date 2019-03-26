package com.mgtv.nunaios.tabinsert;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.mgtv.nunaios.tabimpl.NunaiTabDemoFragment;
import com.mgtv.tv.base.core.fragment.DesktopFragment;

public class MainActivity extends FragmentActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        DesktopFragment cunstomerFragment = new NunaiTabDemoFragment();

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, cunstomerFragment);
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            Log.e(TAG, "replacefragment exception:" + e.toString());
        }
    }
}
