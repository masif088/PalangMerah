package com.company.model;

import static com.company.Main.sc;

public class ModelPendonor extends ModelDarah{
	private String nama;
	public ModelPendonor(String nama, String golongan, int jumlah) {
		this.nama = nama;
		this.golongan = golongan;
		this.jumlah = jumlah;
	}

	public ModelPendonor (){
		System.out.println("Masukkan Namanya");
		nama=sc.nextLine();
		System.out.println("Masukkan Golongan darah (A/B/AB/O)");
		golongan=sc.nextLine();
		System.out.println("Banyaknnya");
		jumlah=sc.nextInt();
		System.out.println("Berhasil Diinput");
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getGolongan() {
		return golongan;
	}

	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public void showUser(){
		System.out.println("Nama :"+nama);
		System.out.println("Golongan :"+golongan);
		System.out.println("jumlah :"+ jumlah);
	}
}
