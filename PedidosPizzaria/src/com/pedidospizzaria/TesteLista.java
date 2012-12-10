package com.pedidospizzaria;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Intents;
import android.util.Log;

public class TesteLista extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		try {
			ArrayList<String>  pizzasListadasId = Intent.getIntent("lista").getStringArrayListExtra("lista");
			Log.e("debug", "criou segunda lista");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
