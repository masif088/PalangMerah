package com.company.model;

public class ModelDarah {
	protected int jumlah;
	protected String golongan;

	public ModelDarah(String golongan) {
		this.jumlah = 0;
		this.golongan = golongan;
	}
	public ModelDarah (){
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public String getGolongan() {
		return golongan;
	}

	public void setGolongan(String golongan) {
		this.golongan = golongan;
	}

	public void showDarah(){
		System.out.println("Golongan Darah " + golongan +" Jumlah Darah "+jumlah);
	}
	public void addingDarah(ModelPendonor pendonor){
		if (golongan.equals(pendonor.getGolongan())){
			jumlah+=pendonor.getJumlah();
		}
	}
	public void removeDarah(ModelPendonor pendonor){
		if (golongan.equals(pendonor.getGolongan())){
			jumlah-=pendonor.getJumlah();
		}
	}
}
