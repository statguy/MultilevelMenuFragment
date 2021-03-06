/*

(c) 2013 Jussi Jousimo, jvj@iki.fi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package com.codeandpop.android.multilevelmenufragment;

import com.codeandpop.android.multilevelmenufragment.MultilevelMenuItem;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

public class MultilevelMenuFragment extends ListFragment {
	Activity menuItemListener;
	
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        menuItemListener = activity;
    }

    @Override
    public void onDetach() {
    	super.onDetach();
    	menuItemListener = null;
    }
    
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		MultilevelMenuItem item = (MultilevelMenuItem)getListAdapter().getItem(position);
		item.onSelected(menuItemListener);
	}
}
