package com.measure.madness;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

public class listAdapter implements ExpandableListAdapter {

	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}


	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getCombinedChildId(long groupId, long childId) {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getCombinedGroupId(long groupId) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}


	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	public void onGroupCollapsed(int groupPosition) {
		// TODO Auto-generated method stub

	}


	public void onGroupExpanded(int groupPosition) {
		// TODO Auto-generated method stub

	}


	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}


	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

}
