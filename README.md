# The-ultimate-chess-battle-2-java-edition
Another chess game but this time in java :D

Donation System
Proiectul meu este o mica aplicatie de management pentru un sistem de donatii de sange. Utiliazatorul poate sa vizualizeze toti donatorii din baza de date, pot cauta donatorii cu o anumita grupa de sange si pot verifica daca un donator(id) poate dona in ziua respectiva.

Aplicatia foloseste ca limbaje de programare java si plsql. Acesta are o componenta grafica (o interfata creata folosing pachetul java swing) si o baza de date Oracle.

In baza de date exista tabelele:
    - Donator (id, nume, blood type, nr contact, eligibility)
    - Inventory (id_donor, idBag) 
    - Donation (id_donor, date, id_donation)

Interfata grafica contine:
    - Butonul <<View Donors>>, apeleaza functia view, ce creaza un frame nou in care sunt afisati donatorii intr-un tabel.
  
![picture](https://github.com/Ifty18/The-ultimate-chess-battle-2-java-edition/blob/main/screenshots/picture.png)
  
    - Un Combo Box cu grupele de sange ce foloseste inputul in functia check pentru a selecta din tabelul DONOR donatorii cu grupa de sange selectata. 
    - Butonul <<Search Donors>> apleaza functia check,  ce verifica intai daca exista donatii cu grupa de sange aleasa cu ajutorul functiei plsql "countbagnums" ce afiseaza cantitatea de sange valabila , in caz contrar, se v-a afisa mesajul "No blood avalible". In cazul in care exista sange pentru grupa de sange aleasa, se afiseaza lista de donatori de la care a fost extras sangele, intr-un tabel, intr-un frame nou.
    - Butonul <<Verify>> apeleaza functia verify, ce verifica, cu ajutorul functiei plsql "isEligible", daca donatorul cu id cautat are posibilitatea de a dona sange in ziua actuala. Functia "isEligible" modifica in tabelul DONOR coloana Eligibility, daca ultima donatie inregistrata de donatorul cu id-ul respectiv este la o distanta de minim 6 luni fata de data de azi.
    - Butonul <<Close>> inchide frame-ul.

![picture](https://github.com/Ifty18/The-ultimate-chess-battle-2-java-edition/blob/main/screenshots/picture.png)
