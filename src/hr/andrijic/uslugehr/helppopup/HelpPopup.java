package hr.andrijic.uslugehr.helppopup;


import com.example.helppopup.R;
import com.nineoldandroids.view.ViewHelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HelpPopup extends LinearLayout implements OnPreDrawListener{
	
	private View view = null;
	private TextView tv;
	private ImageView upArrow;
	private ImageView downArrow;
	private FrameLayout contentHolder;
	private View refPositionView;
	private int refPositionGravity;
	
	public HelpPopup(final Activity context) {
//		final PopupWindow window = new PopupWindow(context);
//		window.setOutsideTouchable(true);
		super(context);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.popup_help, this, true);
		tv = (TextView)view.findViewById(R.id.tooltip_contenttv);
		upArrow = (ImageView)view.findViewById(R.id.tooltip_pointer_up);
		downArrow = (ImageView)view.findViewById(R.id.tooltip_pointer_down);
		contentHolder = (FrameLayout)view.findViewById(R.id.tooltip_contentholder);
		//root = (RelativeLayout)view.findViewById(R.id.tooltip_root);
		
		getViewTreeObserver().addOnPreDrawListener(this);
	}
	
	public HelpPopup attachToViewGroup(ViewGroup viewGroup){
		viewGroup.addView(this);
		return this;
	}
	
	public HelpPopup positionToBottomOfTargetView(View targetView){
		refPositionView = targetView;
		refPositionGravity = Gravity.BOTTOM;
		
		return this;
	}
	
	private void reposition(){
		if(refPositionView != null && refPositionGravity == Gravity.BOTTOM){
			float x = ViewHelper.getX(refPositionView);
			float y = ViewHelper.getY(refPositionView) + refPositionView.getHeight() + 5;
			
			x -= (refPositionView.getWidth() - contentHolder.getWidth())/2;
			float x_arrow = ViewHelper.getX(refPositionView) - (refPositionView.getWidth() - upArrow.getWidth())/2;
			
			ViewHelper.setX(upArrow, ViewHelper.getX(upArrow));
//			downArrowIsVisible(false);
//			upArrowIsVisible(true);
			
			setPosition(x, y);
		}
	}

	
	public HelpPopup setText(final String text){
		tv.post(new Runnable() {
			
			@Override
			public void run() {
				tv.setText(text);
				
			}
		});
		
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
		upArrow.setVisibility(View.GONE);
		return this;
	}
	
	public HelpPopup downArrowIsVisible(boolean isVisible){
		downArrow.setVisibility(View.GONE);
		return this;
	}
	
	
	public HelpPopup setPosition(float x, float y){
		ViewHelper.setX(this, x);
		ViewHelper.setY(this, y);
		return this;
	}

	@Override
	public boolean onPreDraw() {
		reposition();
		getViewTreeObserver().removeOnPreDrawListener(this);
		return true;
	}
}
