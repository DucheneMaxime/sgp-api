insert into departement (libelle) values ('Comptabilité');
insert into departement (libelle) values ('Ressources Humaines');
insert into departement (libelle) values ('Informatique');

insert into banque (nom, iban, bic) values ('Société Générale', '32350151', 'SQNFN55');
insert into banque (nom, iban, bic) values ('Sonyx', '753875', 'REQGRESRGEG5');
insert into banque (nom, iban, bic) values ('Le lynx', '787686', 'TQHSRT5');

insert into collaborateur (matricule, nom, prenom, date_De_Naissance, adresse, numero_De_Securite_Sociale, dep_id, banque_id)
	values ('H01', 'Sony', 'Lauret', '2008-07-04', 'blabla test', '01233520549', '1', '1');
insert into collaborateur (matricule, nom, prenom, date_De_Naissance, adresse, numero_De_Securite_Sociale, dep_id, banque_id)
	values ('H02', 'Sonix', 'Le lynx', '2012-12-12', 'test encore', '0856975252', '2', '2');
