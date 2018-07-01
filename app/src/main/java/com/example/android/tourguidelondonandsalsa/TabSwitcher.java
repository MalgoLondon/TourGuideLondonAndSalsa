package com.example.android.tourguidelondonandsalsa;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link TabSwitcher} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Items} objects.
 */
public class TabSwitcher extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link TabSwitcher} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public TabSwitcher(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AboutFragment();
        } else if (position == 1) {
            return new PlacesFragment();
        } else if (position == 2) {
            return new RestaurantsFagment();
        } else {
            return new SalsaFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_about);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_places);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_restaurants);
        } else {
            return mContext.getString(R.string.tab_salsa);
        }
    }
}