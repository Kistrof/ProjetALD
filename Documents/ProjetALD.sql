CREATE TABLE `acteurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `ceremonie` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

CREATE TABLE `film` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `annee` int(10) NOT NULL DEFAULT '0',
  `cout` double NOT NULL DEFAULT '0',
  `affiche` varchar(255) DEFAULT NULL,
  `description` text,
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note_moyenne` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

CREATE TABLE `film_temp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) DEFAULT NULL,
  `annee` int(10) NOT NULL DEFAULT '0',
  `cout` double NOT NULL DEFAULT '0',
  `affiche` varchar(255) DEFAULT NULL,
  `description` text,
  `suppr_recompense` int(10) DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `filmid` int(10) DEFAULT '0',
  `prologin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `note` (
  `filmid` int(10) NOT NULL,
  `prologin` varchar(255) NOT NULL,
  `valeur` int(10) NOT NULL,
  PRIMARY KEY (`filmid`,`prologin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `personne` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `naissance` date DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `popularite` int(10) NOT NULL DEFAULT '0',
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `personne_temp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `naissance` date DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `suppr_recompense` int(10) DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `personneid` int(10) DEFAULT '0',
  `prologin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `prix` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `ceremonieid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

CREATE TABLE `pro` (
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `date_inscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `derniere_visite` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `producteurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `realisateurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `recompense` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `annee` int(10) NOT NULL DEFAULT '0',
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `prixid` int(10) NOT NULL DEFAULT '0',
  `personneid` int(10) NOT NULL DEFAULT '0',
  `filmid` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `recompense_temp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `annee` int(10) NOT NULL DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prixid` int(10) NOT NULL DEFAULT '0',
  `personneid` int(10) NOT NULL DEFAULT '0',
  `filmid` int(10) NOT NULL DEFAULT '0',
  `recompenseid` int(10) DEFAULT '0',
  `prologin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `rel_film_pers` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ajout_realisateur` int(10) NOT NULL DEFAULT '0',
  `suppr_realisateur` int(10) NOT NULL DEFAULT '0',
  `ajout_producteur` int(10) NOT NULL DEFAULT '0',
  `suppr_producteur` int(10) NOT NULL DEFAULT '0',
  `ajout_acteur` int(10) NOT NULL DEFAULT '0',
  `suppr_acteur` int(10) NOT NULL DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `filmid` int(10) NOT NULL DEFAULT '0',
  `prologin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
