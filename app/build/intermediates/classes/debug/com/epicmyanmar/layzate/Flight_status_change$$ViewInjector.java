// Generated code from Butter Knife. Do not modify!
package com.epicmyanmar.layzate;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Flight_status_change$$ViewInjector {
  public static void inject(Finder finder, final com.epicmyanmar.layzate.Flight_status_change target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230745, "field 'mTimePeriod'");
    target.mTimePeriod = (android.widget.Spinner) view;
    view = finder.findRequiredView(source, 2131230746, "field 'mAirport'");
    target.mAirport = (android.widget.Spinner) view;
    view = finder.findRequiredView(source, 2131230750, "field 'btn_Query'");
    target.btn_Query = (com.getbase.floatingactionbutton.FloatingActionButton) view;
    view = finder.findRequiredView(source, 2131230747, "field 'rdo_groupstatus'");
    target.rdo_groupstatus = (android.widget.RadioGroup) view;
  }

  public static void reset(com.epicmyanmar.layzate.Flight_status_change target) {
    target.mTimePeriod = null;
    target.mAirport = null;
    target.btn_Query = null;
    target.rdo_groupstatus = null;
  }
}
