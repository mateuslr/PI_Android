package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;



import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.PizzaVO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PizzaDAO {
	private static String table_name = "pizza";
	private Context ctx;
	private static String[] columns = {"id","nome"};
	
	
	
	
	public PizzaDAO() {
		super();
	}

	public PizzaDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean insert(PizzaVO vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("nome", vo.getNome());
		
		
		
		return db.insert(table_name, null, ctv) > 0 ;	
		
	}
	
	public List<PizzaVO> getAll() {
		Log.e("debug", "entou na dao");
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();	
		Log.e("debug", "context");
		Cursor rs = db.rawQuery("SELECT * FROM pizza", null);
		Log.e("debug", "fez a query");
		List<PizzaVO> lista = new ArrayList<PizzaVO>();		
		while(rs.moveToNext()){
			Log.e("debug", "a lista tem pizza");
			PizzaVO vo = new PizzaVO(rs.getInt(0),
					rs.getString(1));
			
			lista.add(vo);
		}		
		return lista;
	}
}
