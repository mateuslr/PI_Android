package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;


import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.PedidoVO;
import com.pedidospizzaria.vo.PizzaVO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PedidoDAO {
	private static String table_name = "pedido";
	private Context ctx;
	
	public PedidoDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean salva(PedidoVO vo){
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("mesa", vo.getMesa());
		ctv.put("id_pizza", vo.getPizza().getId());
		ctv.put("id_bebida", vo.getBebida().getId());
		
		return db.insert(table_name, null, ctv)>0;
	}
	
	public List<PedidoVO> getAll() {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM pedido", null);		
		List<PedidoVO> lista = new ArrayList<PedidoVO>();		
		while(rs.moveToNext()){
			
			
		}		
		return lista;
	}
}