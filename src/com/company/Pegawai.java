package com.company;

import com.company.model.ModelDarah;
import com.company.model.ModelPendonor;

import java.util.ArrayList;

import static com.company.Main.sc;

public class Pegawai {
	ArrayList<ModelDarah> darahs =new ArrayList<>();
	ArrayList<ModelPendonor> pendonorArrayList =new ArrayList<>();
	ArrayList<ModelPendonor> penerima =new ArrayList<>();
	public Pegawai(){
		darahs.add(new ModelDarah("A"));
		darahs.add(new ModelDarah("B"));
		darahs.add(new ModelDarah("AB"));
		darahs.add(new ModelDarah("O"));
		boolean quit = false;
		while (!quit){
			System.out.println("aa \n 1. Menambah Stock Darah \n 2. Melihat Stock Darah \n 3. Mengurangi Stock Darah \n 4. Riwayat Pendonor \n 5. Riwayat Penerima \n 6. Keluar");
			int pilih = sc.nextInt();
			ModelPendonor pendonor;
			switch (pilih){
				case 1:
					pendonor = new ModelPendonor();
					for (ModelDarah darah : darahs) {
						darah.addingDarah(pendonor);
					}
					pendonorArrayList.add(pendonor);
					break;
				case 2:
					for (ModelDarah darah : darahs) {
						darah.showDarah();
					}
					break;
				case 3 :
					pendonor = new ModelPendonor();
					for (ModelDarah darah : darahs) {
						darah.removeDarah(pendonor);
					}
					penerima.add(pendonor);
					break;
				case 4:
					for (ModelPendonor modelPendonor: pendonorArrayList) {
						modelPendonor.showUser();
					}
					break;
				case 5:
					for (ModelPendonor modelPendonor: penerima) {
						modelPendonor.showUser();
					}
					break;
				case 6:
					quit=true;
					break;
			}
		}
	}
}
