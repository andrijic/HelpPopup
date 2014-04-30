package hr.andrijic.uslugehr.helppopup;


import com.example.helppopup.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HelpPopup{
	
	private View view = null;
	private TextView tv;
	private ImageView upArrow;
	private ImageView downArrow;
	private FrameLayout contentHolder;
	private RelativeLayout root;
	
	public HelpPopup(final Activity context, View rootView) {
//		final PopupWindow window = new PopupWindow(context);
//		window.setOutsideTouchable(true);
		
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.popup_help, (ViewGroup)rootView.getParent(), true);
		tv = (TextView)view.findViewById(R.id.tooltip_contenttv);
		upArrow = (ImageView)view.findViewById(R.id.tooltip_pointer_up);
		downArrow = (ImageView)view.findViewById(R.id.tooltip_pointer_down);
		contentHolder = (FrameLayout)view.findViewById(R.id.tooltip_contentholder);
		root = (RelativeLayout)view.findViewById(R.id.tooltip_root);
	}
	
	public HelpPopup setText(String text){
		tv.setText(text);
		
		return this;
	}
	
	public HelpPopup setColor(int color){
		upArrow.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
		downArrow.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
		contentHolder.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
		return this;
	}
	
	public HelpPopup setTextColor(int color){
		tv.setTextColor(color);
		return this;
	}
	
	public HelpPopup upArrowIsVisible(boolean isVisible){
		upArrow.setVisibility(0);
		return this;
	}
	
	public HelpPopup downArrowIsVisible(boolean isVisible){
		downArrow.setVisibility(1);
		return this;
	}
	
	public HelpPopup setPosition(int x, int y){
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)root.getLayoutParams();
		
		params.leftMargin = x;
		params.topMargin = y;
		
		root.setLayoutParams(params);
		return this;
	}
}
