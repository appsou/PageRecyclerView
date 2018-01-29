package com.ckr.pageview.view;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by ckr on 2018/1/29.
 */
public class PageHandler extends Handler {
	public static final int MSG_START_LOOPING = 0;
	public static final int MSG_STOP_LOOPING = 1;
	public static final long MSG_DELAY = 3000;
	private WeakReference<PageView> weakReference;

	public PageHandler(WeakReference<PageView> wk) {
		weakReference = wk;
	}

	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		PageView mPageView = weakReference.get();
		if (mPageView == null) {
			return;
		}
		if (mPageView.getHandler().hasMessages(MSG_START_LOOPING)) {
			mPageView.getHandler().removeMessages(MSG_START_LOOPING);
		}
		switch (msg.what) {
			case MSG_START_LOOPING:
				mPageView.setCurrentItem(mPageView.getCurrentItem() + 1);
				mPageView.getHandler().sendEmptyMessageDelayed(MSG_START_LOOPING, MSG_DELAY);
				break;
			case MSG_STOP_LOOPING:
				break;
		}
	}
}
