package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.BebidaVO;
import com.pedidospizzaria.vo.PizzaVO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BebidaDAO {
	private static String table_name = "bebida";
	private Context ctx;
	private static String[] columns = {"id","nome","descricao"};
	
	public BebidaDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public BebidaDAO(){
		
	}
	
	public boolean insert(BebidaVO vo){
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("nome"    , vo.getNome());
		ctv.put("descricao"   , vo.getDesc());
		
		
		return db.insert(table_name, null, ctv) > 0 ;
	}
	
	public List<BebidaVO> getAll(){
		BebidaVO bebida;
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM bebida", null);
		List<BebidaVO> bebidas = new ArrayList<BebidaVO>();
		while(rs.moveToNext()){
			bebida = new BebidaVO(rs.getInt(0),rs.getString(1),rs.getString(2));
			bebidas.add(bebida);
		}
		return bebidas;
	}
	
}
