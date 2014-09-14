package com.ZeroLinux5.compassview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class CompassActivity extends View{
	private float bearing;
	
	public void setBearing(float _bearing) { 
		bearing = _bearing;
	}
	
	public float getBearing() { 
		return bearing;
	}

	public CompassActivity(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initCompassView();
	}
	
	public CompassActivity(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCompassView();
	}
	
	public CompassActivity(Context context) {
		super(context);
		initCompassView();
	}
	
	protected void initCompassView() { 
		setFocusable(true);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// The compass is a circle that fills as much space as possible.
		// Set the measured dimensions by figuring out the shortest boundary,
		// height or width.
		int measuredWidth = measure(widthMeasureSpec);
		int measuredHeight = measure(heightMeasureSpec);
		
		int d = Math.min(measuredWidth, measuredHeight);
		
		setMeasuredDimension(d, d);
	}
	
	private int measure(int measureSpec) { 
		int result = 0;
		// Decode the measurement specifications.
		int specMode = MeasureSpec.getMode(measureSpec); 
		int specSize = MeasureSpec.getSize(measureSpec);
		if (specMode == MeasureSpec.UNSPECIFIED) {
			// Return a default size of 200 if no bounds are specified. 
			result = 200;
		} else {
			// As you want to fill the available space 
			// always return the full available bounds. 
			result = specSize;
		}
		return result; 
	}
}
