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
  soumission       timestamp, 
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
  soumission       timestamp, 
  filmid           int(10), 
  prologin         varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE rel_film_pers (
  id                int(10) NOT NULL AUTO_INCREMENT, 
  ajout_realisateur int(10), 
  suppr_realisateur int(10), 
  ajout_producteur  int(10), 
  suppr_producteur  int(10), 
  ajout_acteur      int(10), 
  suppr_acteur      int(10), 
  soumission        timestamp NOT NULL, 
  filmid            int(10) NOT NULL, 
  prologin          varchar(255) NOT NULL UNIQUE, 
  PRIMARY KEY (id));
CREATE TABLE recompense_temp (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  annee        int(10), 
  soumission   timestamp, 
  prixid       int(10) NOT NULL, 
  personneid   int(10) NOT NULL, 
  filmid       int(10) NOT NULL, 
  recompenseid int(10), 
  prologin     varchar(255) NOT NULL, 
  PRIMARY KEY (id));
