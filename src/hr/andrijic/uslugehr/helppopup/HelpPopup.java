package hr.andrijic.uslugehr.helppopup;


import com.example.helppopup.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class HelpPopup{
	public HelpPopup(final Activity context, View rootView, int x, int y) {
//		final PopupWindow window = new PopupWindow(context);
//		window.setOutsideTouchable(true);
		
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.popup_help, (ViewGroup)rootView.getParent(), true);
//		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
//				FrameLayout.LayoutParams.WRAP_CONTENT);
//		params.leftMargin = 20;
//		params.topMargin = 30;
//		view.setLayoutParams(params);
		
//		window.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
//		window.setContentView(view);
//		window.setBackgroundDrawable(null);
//		
//			
//		window.showAtLocation(rootView, Gravity.CENTER, x, y);
//		
//		
//		window.update();
		
		//((ViewGroup)rootView.getParent()).addView(view);
		
	}
}
