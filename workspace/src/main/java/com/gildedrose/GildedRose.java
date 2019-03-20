package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			if (items[i].quality > 0) {// RG : - La qualit� d'un article n'est jamais n�gative

				if (items[i].quality < 50 ||  (items[i].name.equals("Sulfuras, Hand of Ragnaros")
						&& items[i].quality <= 80)) { // RG La qualit� d'un article n'est jamais sup�rieure � 50 sauf pour Sulfuras peut atteindre 80

					if (items[i].sellIn < 0) { // RG : Une fois la date limite de vente �coul�e, la qualit� se d�grade
												// deux fois plus vite.

						if (!items[i].name.equals("Aged Brie")) { // RG - La qualit� de "Brie vieilli" augmente
																	// effectivement avec l'�ge

							if (items[i].name.equals("Sulfuras, Hand of Ragnaros") && items[i].quality <= 80) {// La
																												// qualit�
																												// ne
																												// doit
																												// pas
																												// �tre
																												// augment�
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

						items[i].quality = items[i].quality - 2; // D�gradation de deux fois plus.
					}

				}

				else {

					System.out.println(" L'article nomm� : " + items[i] + " a une qualit� sup�rieure � 50");

				}

			}

			else { // Si qualit� n�gative : on affiche message d'erreur.

				System.out.println(" L'article nomm� : " + items[i] + " a une qualit� n�gative");
			}

		}
	}
}