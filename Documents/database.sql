CREATE TABLE personne (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  nom        varchar(255) NOT NULL, 
  prenom     varchar(255), 
  naissance  date, 
  photo      varchar(255), 
  popularite int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE film (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  titre        varchar(255) NOT NULL, 
  annee        int(10) NOT NULL, 
  cout         double, 
  affiche      varchar(255), 
  description  blob, 
  date_maj     timestamp, 
  note_moyenne double, 
  PRIMARY KEY (id));
CREATE TABLE producteurs (
  personneid int(10) NOT NULL, 
  filmid     int(10) NOT NULL, 
  PRIMARY KEY (personneid, 
  filmid));
CREATE TABLE acteurs (
  personneid int(10) NOT NULL, 
  filmid     int(10) NOT NULL, 
  PRIMARY KEY (personneid, 
  filmid));
CREATE TABLE realisateurs (
  personneid int(10) NOT NULL, 
  filmid     int(10) NOT NULL, 
  PRIMARY KEY (personneid, 
  filmid));
CREATE TABLE recompense (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  annee      int(10) NOT NULL, 
  date_maj   timestamp, 
  prixid     int(10) NOT NULL, 
  personneid int(10) NOT NULL, 
  filmid     int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE ceremonie (
  id    int(10) NOT NULL AUTO_INCREMENT, 
  titre varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE prix (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  titre       varchar(255) NOT NULL, 
  ceremonieid int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE pro (
  login            varchar(255) NOT NULL, 
  pass             varchar(255) NOT NULL, 
  date_inscription timestamp NOT NULL, 
  derniere_visite  timestamp NOT NULL, 
  PRIMARY KEY (login));
CREATE TABLE note (
  filmid   int(10) NOT NULL, 
  prologin varchar(255) NOT NULL, 
  valeur   int(10) NOT NULL, 
  PRIMARY KEY (filmid, 
  prologin));
CREATE TABLE personne_temp (
  id               int(10) NOT NULL AUTO_INCREMENT, 
  nom              varchar(255), 
  prenom           varchar(255), 
  naissance        date, 
  photo            varchar(255), 
  suppr_recompense int(10), 
  personneid       int(10), 
  prologin         varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE film_temp (
  id               int(10) NOT NULL AUTO_INCREMENT, 
  titre            varchar(255), 
  annee            int(10), 
  cout             double, 
  affiche          varchar(255), 
  description      blob, 
  suppr_recompense int(10), 
  filmid           int(10), 
  prologin         varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE rel_film_pers (
  id               int(10) NOT NULL AUTO_INCREMENT, 
  edit_realisateur int(10), 
  edit_producteur  int(10), 
  edit_acteur      int(10), 
  filmid           int(10) NOT NULL, 
  PRIMARY KEY (id)) comment='Les champs nommés "edit_..." font référence à des ID de la table personne
Une valeur positive signifie l''ajout de l''élément qui possède cet ID
Une valeur négative signifie la suppression de l''élément dont l''ID est la valeur absolue du champ';
CREATE TABLE recompense_temp (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  annee        int(10), 
  prixid       int(10) NOT NULL, 
  personneid   int(10) NOT NULL, 
  filmid       int(10) NOT NULL, 
  recompenseid int(10), 
  prologin     varchar(255) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE producteurs ADD INDEX FKproducteur504386 (personneid);--, ADD CONSTRAINT FKproducteur504386 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE producteurs ADD INDEX FKproducteur503706 (filmid);--, ADD CONSTRAINT FKproducteur503706 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE acteurs ADD INDEX FKacteurs307990 (personneid);--, ADD CONSTRAINT FKacteurs307990 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE acteurs ADD INDEX FKacteurs700102 (filmid);--, ADD CONSTRAINT FKacteurs700102 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE realisateurs ADD INDEX FKrealisateu339451 (personneid);--, ADD CONSTRAINT FKrealisateu339451 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE realisateurs ADD INDEX FKrealisateu668641 (filmid);--, ADD CONSTRAINT FKrealisateu668641 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE prix ADD INDEX FKprix309252 (ceremonieid);--, ADD CONSTRAINT FKprix309252 FOREIGN KEY (ceremonieid) REFERENCES ceremonie (id);
ALTER TABLE recompense ADD INDEX FKrecompense176992 (prixid);--, ADD CONSTRAINT FKrecompense176992 FOREIGN KEY (prixid) REFERENCES prix (id);
ALTER TABLE recompense ADD INDEX FKrecompense955336 (personneid);--, ADD CONSTRAINT FKrecompense955336 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE recompense ADD INDEX FKrecompense8161 (filmid);--, ADD CONSTRAINT FKrecompense8161 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE note ADD INDEX FKnote966147 (filmid);--, ADD CONSTRAINT FKnote966147 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE note ADD INDEX FKnote901205 (prologin);--, ADD CONSTRAINT FKnote901205 FOREIGN KEY (prologin) REFERENCES pro (login);
ALTER TABLE personne_temp ADD INDEX FKpersonne_t72913 (personneid);--, ADD CONSTRAINT FKpersonne_t72913 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE personne_temp ADD INDEX FKpersonne_t825642 (prologin);--, ADD CONSTRAINT FKpersonne_t825642 FOREIGN KEY (prologin) REFERENCES pro (login);
ALTER TABLE film_temp ADD INDEX FKfilm_temp541723 (prologin);--, ADD CONSTRAINT FKfilm_temp541723 FOREIGN KEY (prologin) REFERENCES pro (login);
ALTER TABLE film_temp ADD INDEX FKfilm_temp364925 (filmid);--, ADD CONSTRAINT FKfilm_temp364925 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE rel_film_pers ADD INDEX FKrel_film_p360755 (filmid);--, ADD CONSTRAINT FKrel_film_p360755 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE recompense_temp ADD INDEX FKrecompense806234 (personneid);--, ADD CONSTRAINT FKrecompense806234 FOREIGN KEY (personneid) REFERENCES personne (id);
ALTER TABLE recompense_temp ADD INDEX FKrecompense201858 (filmid);--, ADD CONSTRAINT FKrecompense201858 FOREIGN KEY (filmid) REFERENCES film (id);
ALTER TABLE recompense_temp ADD INDEX FKrecompense329926 (recompenseid);--, ADD CONSTRAINT FKrecompense329926 FOREIGN KEY (recompenseid) REFERENCES recompense (id);
ALTER TABLE recompense_temp ADD INDEX FKrecompense33027 (prixid);--, ADD CONSTRAINT FKrecompense33027 FOREIGN KEY (prixid) REFERENCES prix (id);
ALTER TABLE recompense_temp ADD INDEX FKrecompense266800 (prologin);--, ADD CONSTRAINT FKrecompense266800 FOREIGN KEY (prologin) REFERENCES pro (login);
