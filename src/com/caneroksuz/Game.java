package com.caneroksuz;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scanner = new Scanner(System.in);
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Oyuna hoş geldiniz..");
		System.out.println("Oyuna başlamadan önce isminizi giriniz..");
		String playerName = scanner.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("=========================");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz..");
			System.out.println("1. Güvenli Ev -->> Size ait güvenli bir mekan, düşman yok!!");
			System.out.println("2. Mağara -->> Karşınıza zombi çıkabilir..!!!");
			System.out.println("3. Orman -->> Karşınıza vampir çıkabilir..!!!");
			System.out.println("4. Nehir -->> Karşınıza ayı çıkabilir..!!!");
			System.out.println("5. Mağaza -->> Silay veya Zırh alabilirsiniz..!!!");
			System.out.println("Gitmek istediğiniz yer :");
			int sellectLoc =scanner.nextInt();
			while(sellectLoc <1 || sellectLoc>5) {
				System.out.println("Lütfen geçerli bir yer seçiniz..");
				sellectLoc =scanner.nextInt();
			}
			
			switch (sellectLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player,"Mağaza");
				break;

			default:
				location = new SafeHouse(player);
				break;
			}
			if (location.getName().equals("Güvenli Ev")) {
				if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
					System.out.println("Tebrikler oyunu kazandınız !!");
					break;
				}
			}
			
			if(!location.getLocation()) {
				System.out.println("Oyun Bitti!!");
				break;
			}
		}
	}

}
