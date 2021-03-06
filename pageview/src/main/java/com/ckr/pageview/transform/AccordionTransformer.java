/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ckr.pageview.transform;

import android.support.v4.view.ViewCompat;
import android.view.View;

import com.ckr.pageview.adapter.OnPageDataListener;

public class AccordionTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position, boolean forwardDirection, int mOrientation) {
		if (mOrientation == OnPageDataListener.HORIZONTAL) {
			ViewCompat.setPivotX(view, position < 0 ? view.getWidth() : 0);
			ViewCompat.setScaleX(view, position < 0 ? 1f + position : (1f - position));
		} else {
			ViewCompat.setPivotY(view, position < 0 ? view.getHeight() : 0);
			ViewCompat.setPivotX(view, view.getWidth());
			ViewCompat.setScaleY(view, position < 0 ? 1f + position : (1f - position));
		}
	}

}
