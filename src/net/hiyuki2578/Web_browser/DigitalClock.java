/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.hiyuki2578.Web_browser;

/**
 *
 * @author hiyuki
 */
import java.util.Calendar;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;



public class DigitalClock extends TextView {


	Calendar mCalendar;
	private final static String m24 = "k:mm:ss";
	private FormatChangeObserver mFormatChangeObserver;


	private Runnable mTicker;
	private Handler mHandler;


	private boolean mTickerStopped = false;


	String mFormat;


	public DigitalClock(Context context) {
		super(context);
		initClock(context);
	}


	public DigitalClock(Context context, AttributeSet attrs) {
		super(context, attrs);
		initClock(context);
	}


	private void initClock(Context context) {


		//Resources r = mContext.getResources();
		if (mCalendar == null) {
			mCalendar = Calendar.getInstance();
		}


		mFormatChangeObserver = new FormatChangeObserver();
		getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, mFormatChangeObserver);


		setFormat();
	}


	@Override
	protected void onAttachedToWindow() {
		mTickerStopped = false;
		super.onAttachedToWindow();
		mHandler = new Handler();


		/**
		* requests a tick on the next hard-second boundary
		*/
		mTicker = new Runnable() {
			public void run() {
				if (mTickerStopped) return;
				mCalendar.setTimeInMillis(System.currentTimeMillis());
				setText(DateFormat.format(mFormat, mCalendar));
				invalidate();
				long now = SystemClock.uptimeMillis();
			long next = now + (1000 - now % 1000);
			mHandler.postAtTime(mTicker, next);
			}
		};
		mTicker.run();
	}


	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mTickerStopped = true;
	}

	private void setFormat() {
		mFormat = m24;
	}

	private class FormatChangeObserver extends ContentObserver {
		public FormatChangeObserver() {
			super(new Handler());
		}


		@Override
		public void onChange(boolean selfChange) {
			setFormat();
		}
	}
}