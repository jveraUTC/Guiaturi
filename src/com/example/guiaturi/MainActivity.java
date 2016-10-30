package com.example.guiaturi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
	private List<String> listGroup;
	private HashMap<String, List<String>> listData;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		buildList();
		
		ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
		expandableListView.setAdapter(new ExpandableAdapter(MainActivity.this, listGroup, listData));
		
		expandableListView.setOnChildClickListener(new OnChildClickListener(){
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Toast.makeText(MainActivity.this, "Group: "+groupPosition+"| Item: "+childPosition, Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		
		expandableListView.setOnGroupExpandListener(new OnGroupExpandListener(){
			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(MainActivity.this, "Group (Expand): "+groupPosition, Toast.LENGTH_SHORT).show();
			}
		});
		
		expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener(){
			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(MainActivity.this, "Group (Collapse): "+groupPosition, Toast.LENGTH_SHORT).show();
			}
		});
		
		expandableListView.setGroupIndicator(getResources().getDrawable(R.drawable.icon_group));
	}
	
	public void buildList(){
		listGroup = new ArrayList<String>();
		listData = new HashMap<String, List<String>>();
		
		// GROUP
			listGroup.add("A donde quieres ir ?");
			
		// CHILDREN
			List<String> auxList = new ArrayList<String>();
			auxList.add("Latacunga");
			auxList.add("Pujili");
			auxList.add("Salcedo");
			auxList.add("Item 4");
			listData.put(listGroup.get(0), auxList);
			
			
	}
}
