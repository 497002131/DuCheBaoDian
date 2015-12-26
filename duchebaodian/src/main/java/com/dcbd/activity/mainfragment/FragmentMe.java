package com.dcbd.activity.mainfragment;

import android.widget.TextView;

import com.dcbd.R;
import com.dcbd.base.BaseFragment;

/**
 * 我自己的信息fragment
 */
public class FragmentMe extends BaseFragment   {

	private TextView title_text;

	@Override
	protected void setConvertView() {
		mfragmentview = mfragmentinflater.inflate(R.layout.fragment_me,null);
	}

	@Override
	protected void findViewById() {
		title_text = (TextView)mfragmentview.findViewById(R.id.title_text);
	}

	@Override
	protected void setListener() {

	}

	@Override
	protected void initData() {
		title_text.setText("我");
	}
}
