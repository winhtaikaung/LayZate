// Generated code from Butter Knife. Do not modify!
package cControls;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class Custom_Flightlist_Adapter$ViewHolder$$ViewInjector {
  public static void inject(Finder finder, final cControls.Custom_Flightlist_Adapter.ViewHolder target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296268, "field 'flightname'");
    target.flightname = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296270, "field 'arriv_depart_time'");
    target.arriv_depart_time = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296269, "field 'origin_destination'");
    target.origin_destination = (android.widget.TextView) view;
  }

  public static void reset(cControls.Custom_Flightlist_Adapter.ViewHolder target) {
    target.flightname = null;
    target.arriv_depart_time = null;
    target.origin_destination = null;
  }
}
