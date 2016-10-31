package com.example.guiaturi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;


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
			listGroup.add("¿Dónde quieres ir?");
			
		// CHILDREN
			List<String> auxList = new ArrayList<String>();
			auxList.add("Manifestaciones Culturales");
			auxList.add("Sitios Naturales");
			auxList.add("Páramos y Aventura");
			listData.put(listGroup.get(0), auxList);
			
	}
	public void sitio(View v){
    	Intent sitio=new Intent (this,Sitio.class);
    	startActivity(sitio);
    }
	public void button3(View v){
		Intent c=  new Intent (this,Contacto.class);
		startActivity(c);
	}
	public void button1(View v){
		Intent c=  new Intent (this,Sitio.class);
		startActivity(c);
	}
}
