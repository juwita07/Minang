package com.kamusminang;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class KamusBaseAdapter extends BaseAdapter {
	private static ArrayList<EntitasKamus> searchArrayList;

	private LayoutInflater mInflater;

	Bitmap bm;

	public KamusBaseAdapter(Context context, ArrayList<EntitasKamus> results) {
		searchArrayList = results;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return searchArrayList.size();
	}

	@Override
	public Object getItem(int p) {
		return searchArrayList.get(p);
	}

	@Override
	public long getItemId(int p) {
		return p;
	}

	@Override
	public View getView(int p, View v, ViewGroup parent) {
		ViewHolder holder;

		if (v == null) {
			v = mInflater
					.inflate(R.layout.item_custom_listview, null);
			holder = new ViewHolder();

			holder.indo = (TextView) v.findViewById(R.id.outindo);
			holder.minang = (TextView) v.findViewById(R.id.outminang);

			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		holder.indo.setText(searchArrayList.get(p).getIndo());
		holder.minang.setText(searchArrayList.get(p).getMinang());
		return v;
	}

	static class ViewHolder {
		TextView indo, minang;
	}

}