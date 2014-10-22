// Generated code from Butter Knife. Do not modify!
package com.epicmyanmar.layzate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Flight_status_change$$ViewInjector {
  public static void inject(Finder finder, final com.epicmyanmar.layzate.Flight_status_change target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296271, "field 'mTimePeriod'");
    target.mTimePeriod = (android.widget.Spinner) view;
  }

  public static void reset(com.epicmyanmar.layzate.Flight_status_change target) {
    target.mTimePeriod = null;
  }
}
