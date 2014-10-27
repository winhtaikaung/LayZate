// Generated code from Butter Knife. Do not modify!
package com.epicmyanmar.layzate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Flight_status_change$$ViewInjector {
  public static void inject(Finder finder, final com.epicmyanmar.layzate.Flight_status_change target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296272, "field 'mTimePeriod'");
    target.mTimePeriod = (android.widget.Spinner) view;
    view = finder.findRequiredView(source, 2131296273, "field 'mAirport'");
    target.mAirport = (android.widget.Spinner) view;
    view = finder.findRequiredView(source, 2131296277, "field 'btn_Query'");
    target.btn_Query = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131296274, "field 'rdo_groupstatus'");
    target.rdo_groupstatus = (android.widget.RadioGroup) view;
  }

  public static void reset(com.epicmyanmar.layzate.Flight_status_change target) {
    target.mTimePeriod = null;
    target.mAirport = null;
    target.btn_Query = null;
    target.rdo_groupstatus = null;
  }
}
