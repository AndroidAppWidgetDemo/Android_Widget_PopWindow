package com.example.android_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	View textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		textview = findViewById(R.id.textview);
		textview.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

				List<PopWindowUtils.PopWindowItem> mItem = new ArrayList<PopWindowUtils.PopWindowItem>();

				PopWindowUtils.PopWindowItem item = new PopWindowUtils.PopWindowItem();
				item.name = "adfadf";

				mItem.add(item);
				mItem.add(item);
				mItem.add(item);

				PopWindowUtils.showPopWindow(textview,mItem);
			}
		});

	}

}
