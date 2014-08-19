package com.kamusminang.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;

import java.util.ArrayList;
import java.util.List;

import com.kamusminang.Kamus;

public class DatabaseUtil {

	private static final String _INDONESIA = "indo";
	private static final String _MINANG = "minang";
	private static final String _KETERANGAN = "keterangan";
	private static final String _AKSARA = "aksara";
	private static final String _TABLE_KAMUS = "tbkamusminang";

	private SQLiteDatabase database;
	private CopyDatabase copyDatabase;

	String nama, deskripsi;
	byte[] image;
	private String keterangan;
	private String minang;
	private String indonesia;

	public DatabaseUtil(Context context) {
		copyDatabase = new CopyDatabase(context);
	}

	public void open() { // open database and allow to write data
		database = copyDatabase.getReadableDatabase();
	}

	public void close() { // close database connection
		if (database != null) {
			database.close();
		}
	}

	//
	public List<Kamus> ListAllMakanan() {
		List<Kamus> kamusList = new ArrayList<Kamus>();
		String query = "SELECT * FROM " + _TABLE_KAMUS;

		open();

		Cursor cursor = database.rawQuery(query, null);

		if (cursor.moveToFirst()) {
			Kamus kamus;
			do {
				kamus = new Kamus();

				image = cursor.getBlob(cursor.getColumnIndex(_AKSARA));
				indonesia = cursor.getString(cursor.getColumnIndex(_INDONESIA));
				minang = cursor.getString(cursor.getColumnIndex(_MINANG));
				keterangan = cursor.getString(cursor
						.getColumnIndex(_KETERANGAN));

				// set ke entitas
				kamus.setIndonesia(indonesia);
				kamus.setMinang(minang);
				kamus.setKeterangan(keterangan);
				kamus.setImageAksara(UtilityImage.getImage(image));

				kamusList.add(kamus);
			} while (cursor.moveToNext());
		}
		close();
		return kamusList;
	}
	
	// translate kamus
//	Kamus getKamus(String indonesia) {
//		open();
//		Cursor cursor = database.query(_TABLE_KAMUS, table, columns, selection, new String[]{indonesia}, null, null, null, null, null);
//		
//		returs kamus
//	}

	// public Cursor getByIdMakanan(long id) {
	// return database.query(_TABLE_MAKANAN, null, _ID + "=" + id, null, null,
	// null, null, null);
	// }
	//
	// // KESENIAN
	// public List<Kamus> getAllKesenian() {
	// List<Kamus> KamusList = new ArrayList<Kamus>();
	//
	// String query = "SELECT * FROM kesenian";
	//
	// open();
	//
	// Cursor cursor = database.rawQuery(query, null);
	//
	// if (cursor.moveToFirst()) {
	// Kamus Kamus ;
	// do {
	// Kamus = new Kamus();
	// image = cursor.getBlob(cursor.getColumnIndex("gambar"));
	// nama = cursor.getString(cursor.getColumnIndex("nama_kesenian"));
	// deskripsi = cursor.getString(cursor.getColumnIndex("deskripsi"));
	//
	// Kamus.setGambar(UtilityImage.getImage(image));
	// Kamus.setDeskription(deskripsi);
	// Kamus.setTitle(nama);
	//
	// KamusList.add(Kamus);
	//
	// } while (cursor.moveToNext());
	// }
	// close();
	// return KamusList;
	// }

}
