package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			if (items[i].quality > 0) {// RG : - La qualité d'un article n'est jamais négative

				if (items[i].quality < 50 ||  (items[i].name.equals("Sulfuras, Hand of Ragnaros")
						&& items[i].quality <= 80)) { // RG La qualité d'un article n'est jamais supérieure à 50 sauf pour Sulfuras peut atteindre 80

					if (items[i].sellIn < 0) { // RG : Une fois la date limite de vente écoulée, la qualité se dégrade
												// deux fois plus vite.

						if (!items[i].name.equals("Aged Brie")) { // RG - La qualité de "Brie vieilli" augmente
																	// effectivement avec l'âge

							if (items[i].name.equals("Sulfuras, Hand of Ragnaros") && items[i].quality <= 80) {// La
																												// qualité
																												// ne
																												// doit
																												// pas
																												// être
																												// augmenté
																												// si on
																												// atteint
																												// le
																												// 50.sauf
																												// pour
																												// sulfurace

								items[i].quality = items[i].quality + 1;
							} else if (items[i].quality <= 50) {

								items[i].quality = items[i].quality + 1;

								if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
									if (items[i].sellIn < 11) {
										items[i].quality = items[i].quality + 1;
									}

									if (items[i].sellIn < 6) {
										items[i].quality = items[i].quality + 1;
									}
								}
							}
						}

					} else {

						items[i].quality = items[i].quality - 2; // Dégradation de deux fois plus.
					}

				}

				else {

					System.out.println(" L'article nommé : " + items[i] + " a une qualité supérieure à 50");

				}

			}

			else { // Si qualité négative : on affiche message d'erreur.

				System.out.println(" L'article nommé : " + items[i] + " a une qualité négative");
			}

		}
	}
}