package com.demons.gallery.utils.result;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class Result {
    private static final String TAG = Result.class.getSimpleName();

    private Result() {

    }

    public static HolderFragment get(FragmentActivity activity) {
        return new Result().getHolderFragment(activity.getSupportFragmentManager());
    }

    public static HolderFragment get(Fragment fragment) {
        return new Result().getHolderFragment(fragment.getChildFragmentManager());
    }

    private HolderFragment getHolderFragment(FragmentManager fragmentManager) {
        HolderFragment holderFragment = findHolderFragment(fragmentManager);
        if (holderFragment == null) {
            holderFragment = new HolderFragment();
            fragmentManager
                    .beginTransaction()
                    .add(holderFragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return holderFragment;
    }

    private HolderFragment findHolderFragment(FragmentManager fragmentManager) {
        return (HolderFragment) fragmentManager.findFragmentByTag(TAG);
    }

}
