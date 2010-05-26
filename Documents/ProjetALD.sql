-- phpMyAdmin SQL Dump
-- version 3.3.2
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Mer 26 Mai 2010 à 23:23
-- Version du serveur: 5.1.45
-- Version de PHP: 5.3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `ald`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteurs`
--

CREATE TABLE IF NOT EXISTS `acteurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ceremonie`
--

CREATE TABLE IF NOT EXISTS `ceremonie` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE IF NOT EXISTS `film` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `annee` int(10) NOT NULL DEFAULT '0',
  `cout` double NOT NULL DEFAULT '0',
  `affiche` varchar(255) DEFAULT NULL,
  `description` text,
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note_moyenne` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `film_temp`
--

CREATE TABLE IF NOT EXISTS `film_temp` (
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `filmid` int(10) NOT NULL,
  `prologin` varchar(255) NOT NULL,
  `valeur` int(10) NOT NULL,
  PRIMARY KEY (`filmid`,`prologin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `naissance` date DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `popularite` int(10) NOT NULL DEFAULT '0',
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `personne_temp`
--

CREATE TABLE IF NOT EXISTS `personne_temp` (
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

-- --------------------------------------------------------

--
-- Structure de la table `prix`
--

CREATE TABLE IF NOT EXISTS `prix` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `ceremonieid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `pro`
--

CREATE TABLE IF NOT EXISTS `pro` (
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `date_inscription` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `derniere_visite` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `producteurs`
--

CREATE TABLE IF NOT EXISTS `producteurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `realisateurs`
--

CREATE TABLE IF NOT EXISTS `realisateurs` (
  `personneid` int(10) NOT NULL,
  `filmid` int(10) NOT NULL,
  PRIMARY KEY (`personneid`,`filmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `recompense`
--

CREATE TABLE IF NOT EXISTS `recompense` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `annee` int(10) NOT NULL DEFAULT '0',
  `date_maj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `prixid` int(10) NOT NULL DEFAULT '0',
  `personneid` int(10) NOT NULL DEFAULT '0',
  `filmid` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `recompense_temp`
--

CREATE TABLE IF NOT EXISTS `recompense_temp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `annee` int(10) NOT NULL DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prixid` int(10) NOT NULL DEFAULT '0',
  `personneid` int(10) DEFAULT '0',
  `filmid` int(10) DEFAULT '0',
  `recompenseid` int(10) DEFAULT '0',
  `prologin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

-- --------------------------------------------------------

--
-- Structure de la table `rel_film_pers`
--

CREATE TABLE IF NOT EXISTS `rel_film_pers` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ajout_realisateur` int(10) DEFAULT '0',
  `suppr_realisateur` int(10) DEFAULT '0',
  `ajout_producteur` int(10) DEFAULT '0',
  `suppr_producteur` int(10) DEFAULT '0',
  `ajout_acteur` int(10) DEFAULT '0',
  `suppr_acteur` int(10) DEFAULT '0',
  `soumission` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `filmid` int(10) NOT NULL DEFAULT '0',
  `prologin` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;
