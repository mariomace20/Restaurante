-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-07-2017 a las 00:46:19
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dmbase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antece_farmacologicos`
--

CREATE TABLE IF NOT EXISTS `antece_farmacologicos` (
  `num_ef` int(11) NOT NULL AUTO_INCREMENT,
  `num_hiscaf` varchar(5) NOT NULL,
  `toma_1` varchar(20) NOT NULL,
  `toma_2` varchar(20) NOT NULL,
  `toma_3` varchar(20) NOT NULL,
  `toma_4` varchar(20) NOT NULL,
  `toma_5` varchar(20) NOT NULL,
  `toma_6` varchar(20) NOT NULL,
  `aloxano` varchar(2) NOT NULL,
  `estrepto` varchar(2) NOT NULL,
  `pentamidina` varchar(2) NOT NULL,
  `vacor` varchar(2) NOT NULL,
  `aci_nico` varchar(2) NOT NULL,
  `tiroxina` varchar(2) NOT NULL,
  `interferon` varchar(2) NOT NULL,
  `tiazidas` varchar(2) NOT NULL,
  PRIMARY KEY (`num_ef`),
  KEY `num_hiscaf` (`num_hiscaf`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `antece_farmacologicos`
--

INSERT INTO `antece_farmacologicos` (`num_ef`, `num_hiscaf`, `toma_1`, `toma_2`, `toma_3`, `toma_4`, `toma_5`, `toma_6`, `aloxano`, `estrepto`, `pentamidina`, `vacor`, `aci_nico`, `tiroxina`, `interferon`, `tiazidas`) VALUES
(1, 'p0003', 'drogas', '', '', '', '', '', 'SI', 'NO', 'NO', 'NO', 'NO', 'NO', 'SI', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE IF NOT EXISTS `diagnostico` (
  `num_diag` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcdiag` varchar(5) NOT NULL,
  `resultado` varchar(50) NOT NULL,
  PRIMARY KEY (`num_diag`),
  KEY `num_hcdiag` (`num_hcdiag`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `diagnostico`
--

INSERT INTO `diagnostico` (`num_diag`, `num_hcdiag`, `resultado`) VALUES
(1, 'p0003', 'PREDIABETES ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exam_complementario`
--

CREATE TABLE IF NOT EXISTS `exam_complementario` (
  `num_ec` int(11) NOT NULL AUTO_INCREMENT,
  `num_hiscec` varchar(5) NOT NULL,
  `hb_glicosilada` double NOT NULL,
  `hdl` double NOT NULL,
  `ldl` double NOT NULL,
  `col_total` double NOT NULL,
  `tgc` int(11) NOT NULL,
  `gluco_ayu` double NOT NULL,
  `total_gluco` double NOT NULL,
  PRIMARY KEY (`num_ec`),
  KEY `num_hiscec` (`num_hiscec`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `exam_complementario`
--

INSERT INTO `exam_complementario` (`num_ec`, `num_hiscec`, `hb_glicosilada`, `hdl`, `ldl`, `col_total`, `tgc`, `gluco_ayu`, `total_gluco`) VALUES
(1, 'p0003', 7, 12, 12, 12, 123, 123, 140);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_cardiovascular`
--

CREATE TABLE IF NOT EXISTS `e_cardiovascular` (
  `num_efc` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcec` varchar(5) NOT NULL,
  `i10` varchar(2) NOT NULL,
  `i20` varchar(2) NOT NULL,
  `i21` varchar(2) NOT NULL,
  `i30` varchar(2) NOT NULL,
  `i40` varchar(2) NOT NULL,
  `i48` varchar(2) NOT NULL,
  `i70` varchar(2) NOT NULL,
  `i71` varchar(2) NOT NULL,
  `i74` varchar(2) NOT NULL,
  `i95` varchar(2) NOT NULL,
  PRIMARY KEY (`num_efc`),
  KEY `num_hcec` (`num_hcec`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_cardiovascular`
--

INSERT INTO `e_cardiovascular` (`num_efc`, `num_hcec`, `i10`, `i20`, `i21`, `i30`, `i40`, `i48`, `i70`, `i71`, `i74`, `i95`) VALUES
(1, 'p0003', 'NO', 'NO', 'SI', 'SI', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_c_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_c_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(30) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `e_c_pastillas`
--

INSERT INTO `e_c_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'i10', 'Hipertensión arterial esencial ', 'amlodipino ratiopharm efg'),
(2, 'i10', 'Hipertensión arterial esencial', 'adalat oros'),
(3, 'i10', 'Hipertensión arterial esencial', 'acuprel'),
(4, 'i20', 'Angina de pecho', 'amlodipino aurovitas spain'),
(5, 'i20', 'Angina de pecho', 'amlodipino bd-mabo'),
(6, 'i20', 'Angina de pecho', 'angiodrox'),
(7, 'i21', 'Infarto agudo de miocardio  ', 'atenolol alter efg'),
(8, 'i21', 'Infarto agudo de miocardio  ', 'beloken'),
(9, 'i21', 'Infarto agudo de miocardio  ', 'cafinitrina'),
(10, 'i30', 'Pericarditis aguda', 'penibiot'),
(11, 'i30', 'Pericarditis aguda', 'sodiopen'),
(12, 'i40', 'Miocarditis aguda', 'digoxina kern pharma'),
(13, 'i48', 'Fibrilación atrial y pálpitos', 'trangorex'),
(14, 'i70', 'Aterosclerosis', 'colesvir'),
(15, 'i70', 'Aterosclerosis', 'fluvastatina apotex'),
(16, 'i70', 'Aterosclerosis', 'lovastatina cinfa efg'),
(17, 'i71', 'Aneurisma y disección aórtica', 'hydrapres'),
(18, 'i74', 'Embolia arterial y trombosis', 'hemovas'),
(19, 'i74', 'Embolia arterial y trombosis', 'heparina hospira'),
(20, 'i74', 'Embolia arterial y trombosis', 'sermion'),
(21, 'i95', 'Hipotensión', 'noradrenalina braun'),
(22, 'i95', 'Hipotensión', 'noradrenalina normon'),
(23, 'i95', 'Hipotensión', 'norages');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_endocrinologicas`
--

CREATE TABLE IF NOT EXISTS `e_endocrinologicas` (
  `num_ee` int(11) NOT NULL AUTO_INCREMENT,
  `num_hce` varchar(5) NOT NULL,
  `e02` varchar(2) NOT NULL,
  `e03` varchar(2) NOT NULL,
  `e06` varchar(2) NOT NULL,
  `e20` varchar(2) NOT NULL,
  `e24` varchar(2) NOT NULL,
  PRIMARY KEY (`num_ee`),
  KEY `num_hce` (`num_hce`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_endocrinologicas`
--

INSERT INTO `e_endocrinologicas` (`num_ee`, `num_hce`, `e02`, `e03`, `e06`, `e20`, `e24`) VALUES
(1, 'p0003', 'NO', 'NO', 'SI', 'SI', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_e_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_e_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `e_e_pastillas`
--

INSERT INTO `e_e_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'e02', 'hipotiroidismo', 'levotiroxina'),
(2, 'e02', 'hipotiroidismo', 'tiroxina sintetica p'),
(3, 'e02', 'hipotiroidismo', 'tiamazol'),
(4, 'e05', 'tirotoxicosis', 'metimazol'),
(5, 'e05', 'tirotoxicosis', 'natecal'),
(6, 'e05', 'tirotoxicosis', 'propranolol'),
(7, 'e06', 'tiroiditis', 'dexametasona'),
(8, 'e06', 'tiroiditis', 'trigon depot'),
(9, 'e06', 'tiroiditis', 'levotiroxina sanofi'),
(10, 'e20', 'hipoparatiroidismo', 'hidroferol'),
(11, 'e20', 'hipoparatiroidismo', 'rocaltrol'),
(12, 'e20', 'hipoparatiroidismo', 'natecal'),
(13, 'e24', 'síndrome de cushing', 'metopirone'),
(14, 'e24', 'síndrome de cushing', 'signifor'),
(15, 'e24', 'síndrome de cushing', 'ketoconazol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_infecciosas`
--

CREATE TABLE IF NOT EXISTS `e_infecciosas` (
  `num_ei` int(11) NOT NULL AUTO_INCREMENT,
  `num_hci` varchar(5) NOT NULL,
  `a00` varchar(2) NOT NULL,
  `a01` varchar(2) NOT NULL,
  `a03` varchar(2) NOT NULL,
  `a15` varchar(2) NOT NULL,
  `a22` varchar(2) NOT NULL,
  `a51` varchar(2) NOT NULL,
  `a82` varchar(2) NOT NULL,
  `b00` varchar(2) NOT NULL,
  `b19` varchar(2) NOT NULL,
  `b20` varchar(2) NOT NULL,
  PRIMARY KEY (`num_ei`),
  KEY `num_hci` (`num_hci`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_infecciosas`
--

INSERT INTO `e_infecciosas` (`num_ei`, `num_hci`, `a00`, `a01`, `a03`, `a15`, `a22`, `a51`, `a82`, `b00`, `b19`, `b20`) VALUES
(1, 'p0003', 'NO', 'NO', 'NO', 'NO', 'SI', 'NO', 'SI', 'NO', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_i_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_i_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(30) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `e_i_pastillas`
--

INSERT INTO `e_i_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'a00', 'Cólera', 'dukoral'),
(2, 'a01', 'Fiebre tifoidea', 'ciprofloxacino bluepharma'),
(3, 'a01', 'Fiebre tifoidea', 'ciprofloxacino tevagen'),
(4, 'a01', 'Fiebre tifoidea', 'doxipil'),
(5, 'a03', 'Shigellosis', 'ciprofloxacina'),
(6, 'a15', 'Tuberculosis respiratoria', 'aci paraaminosalicílico lucane'),
(7, 'a15', 'Tuberculosis respiratoria', 'ansatipin'),
(8, 'a15', 'Tuberculosis respiratoria', 'capastat'),
(9, 'a22', 'Carbunco o ántrax', 'araxacina'),
(10, 'a22', 'Carbunco o ántrax', 'baycip'),
(11, 'a22', 'Carbunco o ántrax', 'cetraxal'),
(12, 'a51', 'Sífilis precoz', 'benzetacil'),
(13, 'a51', 'Sífilis precoz', 'penicilina de la benzatina g'),
(14, 'a82', 'Rabia', 'rabipur'),
(15, 'a82', 'Rabia', 'rabipur'),
(16, 'a82', 'Rabia', 'eritromicina'),
(17, 'b00', 'Infecciones herpéticas, herpes simple', 'aciclostad'),
(18, 'b00', 'Infecciones herpéticas, herpes simple', 'aciclovir accord'),
(19, 'b00', 'Infecciones herpéticas, herpes simple', 'aciclovir aristo'),
(20, 'b19', 'Hepatitis viral', 'dacortin'),
(21, 'b19', 'Hepatitis viral', 'lisozima'),
(22, 'b19', 'Hepatitis viral', 'policolinosil gragea'),
(23, 'b20', 'Virus de la inmunodeficiencia humana (VIH)', 'kaletra'),
(24, 'b20', 'Virus de la inmunodeficiencia humana (VIH)', 'celsentri '),
(25, 'b20', 'Virus de la inmunodeficiencia humana (VIH)', 'canadiol');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_neoplasia`
--

CREATE TABLE IF NOT EXISTS `e_neoplasia` (
  `num_en` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcn` varchar(5) NOT NULL,
  `c15` varchar(2) NOT NULL,
  `c16` varchar(2) NOT NULL,
  `c17` varchar(2) NOT NULL,
  `c25` varchar(2) NOT NULL,
  `c33` varchar(2) NOT NULL,
  `c34` varchar(2) NOT NULL,
  `c69` varchar(2) NOT NULL,
  `c81` varchar(2) NOT NULL,
  `c90` varchar(2) NOT NULL,
  `c91` varchar(2) NOT NULL,
  PRIMARY KEY (`num_en`),
  KEY `num_hcn` (`num_hcn`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_neoplasia`
--

INSERT INTO `e_neoplasia` (`num_en`, `num_hcn`, `c15`, `c16`, `c17`, `c25`, `c33`, `c34`, `c69`, `c81`, `c90`, `c91`) VALUES
(1, 'p0003', 'NO', 'SI', 'SI', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_n_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_n_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `e_n_pastillas`
--

INSERT INTO `e_n_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'c15', 'Neoplasias malignas de esófago', 'carboplatino'),
(2, 'c15', 'Neoplasias malignas de esófago', 'cisplatino'),
(3, 'c15', 'Neoplasias malignas de esófago', 'capecitabina'),
(4, 'c16', 'Neoplasias malignas de estómago', 'docetaxel'),
(5, 'c16', 'Neoplasias malignas de estómago', 'herceptin'),
(6, 'c16', 'Neoplasias malignas de estómago', 'mitomicina C'),
(7, 'c17', 'Neoplasias malignas de intestino delgado', 'capecitabina'),
(8, 'c17', 'Neoplasias malignas de intestino delgado', '5-fluorouracilo'),
(9, 'c17', 'Neoplasias malignas de intestino delgado', 'oxaliplatina'),
(10, 'c25', 'Neoplasias malignas de páncreas', 'abraxane'),
(11, 'c25', 'Neoplasias malignas de páncreas', 'afinitor'),
(12, 'c25', 'Neoplasias malignas de páncreas', 'everolimus'),
(13, 'c33', 'Neoplasias malignas de la tráquea', 'cisplatino'),
(14, 'c33', 'Neoplasias malignas de la tráquea', 'carboplatino'),
(15, 'c33', 'Neoplasias malignas de la tráquea', 'docetaxel'),
(16, 'c34', 'Neoplasias malignas de bronquios y pulmón', 'crizotinib'),
(17, 'c34', 'Neoplasias malignas de bronquios y pulmón', 'bevacizumab'),
(18, 'c34', 'Neoplasias malignas de bronquios y pulmón', 'alectinib'),
(19, 'c69', 'Neoplasias malignas del sistema nervioso ', 'carboplatino'),
(20, 'c69', 'Neoplasias malignas del sistema nervioso ', 'ciclofosfamida'),
(21, 'c69', 'Neoplasias malignas del sistema nervioso ', 'metotrexato'),
(22, 'c81', 'Enfermedad de Hodgkin', 'bleomicina'),
(23, 'c81', 'Enfermedad de Hodgkin', 'etopósido'),
(24, 'c81', 'Enfermedad de Hodgkin', 'adriamicina'),
(25, 'c90', 'Mieloma múltiple y neoplasias malignas de células ', 'fluorouracilo'),
(26, 'c90', 'Mieloma múltiple y neoplasias malignas de células ', 'cisplatino'),
(27, 'c90', 'Mieloma múltiple y neoplasias malignas de células ', 'capecitabina'),
(28, 'c91', 'Leucemia ', 'imatinib'),
(29, 'c91', 'Leucemia ', 'nilotinib'),
(30, 'c91', 'Leucemia ', 'dasatinib');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_piel`
--

CREATE TABLE IF NOT EXISTS `e_piel` (
  `num_ep` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcp` varchar(5) NOT NULL,
  `l01` varchar(2) NOT NULL,
  `l20` varchar(2) NOT NULL,
  `l40` varchar(2) NOT NULL,
  `l70` varchar(2) NOT NULL,
  `l80` varchar(2) NOT NULL,
  PRIMARY KEY (`num_ep`),
  KEY `num_hcp` (`num_hcp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_piel`
--

INSERT INTO `e_piel` (`num_ep`, `num_hcp`, `l01`, `l20`, `l40`, `l70`, `l80`) VALUES
(1, 'p0003', 'NO', 'SI', 'NO', 'SI', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_pi_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_pi_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `e_pi_pastillas`
--

INSERT INTO `e_pi_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'l01', 'Impétigo', 'acido fusidico'),
(2, 'l01', 'Impétigo', 'altargo'),
(3, 'l01', 'Impétigo', 'bactroban'),
(4, 'l20', 'Dermatitis atópica', 'adventan'),
(5, 'l20', 'Dermatitis atópica', 'armaya fuerte'),
(6, 'l20', 'Dermatitis atópica', 'bacisporin'),
(7, 'l40', 'Psoriasis', 'alfitar'),
(8, 'l40', 'Psoriasis', 'batmen'),
(9, 'l40', 'Psoriasis', 'bertanel'),
(10, 'l70', 'Acné', 'dercutane'),
(11, 'l70', 'Acné', 'flexresan'),
(12, 'l70', 'Acné', 'isdiben'),
(13, 'l80', 'Vitíligo', 'novo-dermoquinona'),
(14, 'l80', 'Vitíligo', 'psoralenos'),
(15, 'l80', 'Vitíligo', 'fenitoina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_psiquiatria`
--

CREATE TABLE IF NOT EXISTS `e_psiquiatria` (
  `num_eps` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcps` varchar(5) NOT NULL,
  `f00` varchar(2) NOT NULL,
  `f20` varchar(2) NOT NULL,
  `f31` varchar(2) NOT NULL,
  `f42` varchar(2) NOT NULL,
  `f51` varchar(2) NOT NULL,
  PRIMARY KEY (`num_eps`),
  KEY `num_hcps` (`num_hcps`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_psiquiatria`
--

INSERT INTO `e_psiquiatria` (`num_eps`, `num_hcps`, `f00`, `f20`, `f31`, `f42`, `f51`) VALUES
(1, 'p0003', 'SI', 'NO', 'NO', 'NO', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_ps_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_ps_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `e_ps_pastillas`
--

INSERT INTO `e_ps_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'f00', 'Demencia en la enfermedad de Alzheimer', 'galantamina'),
(2, 'f00', 'Demencia en la enfermedad de Alzheimer', 'donepezilo'),
(3, 'f00', 'Demencia en la enfermedad de Alzheimer', 'memantina'),
(4, 'f20', 'Esquizofrenia', 'haloperidol'),
(5, 'f20', 'Esquizofrenia', 'clozapina'),
(6, 'f20', 'Esquizofrenia', 'risperidona'),
(7, 'f31', 'Trastorno bipolar afectivo', 'citalopram'),
(8, 'f31', 'Trastorno bipolar afectivo', 'olanzapina'),
(9, 'f31', 'Trastorno bipolar afectivo', 'quetiapina'),
(10, 'f42', 'Trastorno obsesivo-compulsivo', 'clomipramina'),
(11, 'f42', 'Trastorno obsesivo-compulsivo', 'fluoxetina'),
(12, 'f42', 'Trastorno obsesivo-compulsivo', 'paroxetina'),
(13, 'f51', 'Trastornos del sueño no orgánicos', 'clonazepam'),
(14, 'f51', 'Trastornos del sueño no orgánicos', 'alprozalam'),
(15, 'f51', 'Trastornos del sueño no orgánicos', 'lorazepam');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_reumatologicas`
--

CREATE TABLE IF NOT EXISTS `e_reumatologicas` (
  `num_er` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcr` varchar(5) NOT NULL,
  `m00` varchar(2) NOT NULL,
  `m05` varchar(2) NOT NULL,
  `m07` varchar(2) NOT NULL,
  `m08` varchar(2) NOT NULL,
  `m10` varchar(2) NOT NULL,
  `m15` varchar(2) NOT NULL,
  `m34` varchar(2) NOT NULL,
  `m65` varchar(2) NOT NULL,
  `m86` varchar(2) NOT NULL,
  PRIMARY KEY (`num_er`),
  KEY `num_hcr` (`num_hcr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_reumatologicas`
--

INSERT INTO `e_reumatologicas` (`num_er`, `num_hcr`, `m00`, `m05`, `m07`, `m08`, `m10`, `m15`, `m34`, `m65`, `m86`) VALUES
(1, 'p0003', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'SI', 'SI', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_r_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_r_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Volcado de datos para la tabla `e_r_pastillas`
--

INSERT INTO `e_r_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'm00', 'Artritis piógena', 'cefadroxilo'),
(2, 'm00', 'Artritis piógena', 'cefazolina'),
(3, 'm00', 'Artritis piógena', 'cefuroxima'),
(4, 'm05', 'Artritis reumatoide seropositiva', 'celecoxib'),
(5, 'm05', 'Artritis reumatoide seropositiva', 'etoricoxib'),
(6, 'm05', 'Artritis reumatoide seropositiva', 'leflunomida'),
(7, 'm07', 'Artropatías psoriásicas y enteropáticas', 'metotrexato'),
(8, 'm07', 'Artropatías psoriásicas y enteropáticas', 'salazoprina'),
(9, 'm07', 'Artropatías psoriásicas y enteropáticas', 'infliximab'),
(10, 'm08', 'Artritis juvenil', 'bertanel'),
(11, 'm08', 'Artritis juvenil', 'diclofenaco'),
(12, 'm08', 'Artritis juvenil', 'dipirona'),
(13, 'm10', 'Gota', 'corticocosteroides'),
(14, 'm10', 'Gota', 'colchicina'),
(15, 'm10', 'Gota', 'corticocosteroides'),
(16, 'm15', 'Poliartrosis', 'meloxican'),
(17, 'm15', 'Poliartrosis', 'glucosamina'),
(18, 'm15', 'Poliartrosis', 'condroitin sulfato'),
(19, 'm34', 'Esclerosis sistémica', 'bosetan'),
(20, 'm34', 'Esclerosis sistémica', 'sildenafilo'),
(21, 'm34', 'Esclerosis sistémica', 'calcioantagonistas'),
(22, 'm65', 'Sinovitis y tenosinovitis', 'bluxam'),
(23, 'm65', 'Sinovitis y tenosinovitis', 'feldegel'),
(24, 'm65', 'Sinovitis y tenosinovitis', 'colchimax'),
(25, 'm86', 'Osteomielitis', 'amoxicilina'),
(26, 'm86', 'Osteomielitis', 'ácido clavulanico my'),
(27, 'm86', 'Osteomielitis', 'cefazolina normon ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sangre`
--

CREATE TABLE IF NOT EXISTS `e_sangre` (
  `num_es` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcs` varchar(5) NOT NULL,
  `d50` varchar(2) NOT NULL,
  `d56` varchar(2) NOT NULL,
  `d60` varchar(2) NOT NULL,
  `d66` varchar(2) NOT NULL,
  `d67` varchar(2) NOT NULL,
  `d690` varchar(2) NOT NULL,
  `d693` varchar(2) NOT NULL,
  `d70` varchar(2) NOT NULL,
  `d750` varchar(2) NOT NULL,
  `d751` varchar(2) NOT NULL,
  PRIMARY KEY (`num_es`),
  KEY `num_hcs` (`num_hcs`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_sangre`
--

INSERT INTO `e_sangre` (`num_es`, `num_hcs`, `d50`, `d56`, `d60`, `d66`, `d67`, `d690`, `d693`, `d70`, `d750`, `d751`) VALUES
(1, 'p0003', 'NO', 'NO', 'NO', 'NO', 'NO', 'SI', 'NO', 'NO', 'SI', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sa_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_sa_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(5) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(25) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `e_sa_pastillas`
--

INSERT INTO `e_sa_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'd50', 'Anemia por deficiencia de hierro', 'cromatonbic ferro'),
(2, 'd50', 'Anemia por deficiencia de hierro', 'fero-gradumet'),
(3, 'd50', 'Anemia por deficiencia de hierro', 'ferplex 40'),
(4, 'd60', 'Aplasia pura de glóbulos rojos ', 'globulina anti-timocito'),
(5, 'd66', 'Hemofilia A', 'advate'),
(6, 'd66', 'Hemofilia A', 'beriate'),
(7, 'd66', 'Hemofilia A', 'fanhdi'),
(8, 'd67', 'Hemofilia B', 'alprolix'),
(9, 'd67', 'Hemofilia B', 'benefix'),
(10, 'd67', 'Hemofilia B', 'novoseven'),
(11, 'd69.0', 'Púrpura alérgica', 'prednisona alonga'),
(12, 'd69.0', 'Púrpura alérgica', 'prednisona kern pharma'),
(13, 'd69.0', 'Púrpura alérgica', 'prednisona pensa efg'),
(14, 'd69.3', 'Púrpura trombocitopénica idiopática', 'cortidene depot'),
(15, 'd69.3', 'Púrpura trombocitopénica idiopática', 'dexametasona kern pharma'),
(16, 'd69.3', 'Púrpura trombocitopénica idiopática', 'flebogamma dif'),
(17, 'd70', 'Agranulocitosis', 'pentazocina'),
(18, 'd75.0', 'Eritrocitosis familiar', 'pentazocina'),
(19, 'd75.1', 'Policitemia secundaria', 'busulfano aspen'),
(20, 'd75.1', 'Policitemia secundaria', 'hydrea'),
(21, 'd75.1', 'Policitemia secundaria', 'jakavi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sid_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_sid_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(30) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Volcado de datos para la tabla `e_sid_pastillas`
--

INSERT INTO `e_sid_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'k20', 'Esofagitis', 'famotidina ratiopharm efg'),
(2, 'k20', 'Esofagitis', 'gelodrox'),
(3, 'k20', 'Esofagitis', 'magión'),
(4, 'k25', 'Gastritis ', 'aciphex'),
(5, 'k25', 'Gastritis ', 'aeroflat'),
(6, 'k25', 'Gastritis ', 'alquen'),
(7, 'k27', 'Úlcera péptica', 'zoltum'),
(8, 'k27', 'Úlcera péptica', 'vizerul'),
(9, 'k27', 'Úlcera péptica', 'ulcenol'),
(10, 'k29', 'Gastritis y duodenitis', 'aeroflat'),
(11, 'k29', 'Gastritis y duodenitis', 'gastrodenol'),
(12, 'k29', 'Gastritis y duodenitis', 'iberogast'),
(13, 'k50', 'Enfermedad de Crohn ', 'asacol'),
(14, 'k50', 'Enfermedad de Crohn ', 'cortidene depot'),
(15, 'k50', 'Enfermedad de Crohn ', 'deflazacort cinfa'),
(16, 'k51', 'Colitis ulcerosa', 'claversal'),
(17, 'k51', 'Colitis ulcerosa', 'cortidene depot'),
(18, 'k51', 'Colitis ulcerosa', 'dacortin'),
(19, 'k70', 'Enfermedad del hígado alcohólica', 'legalon'),
(20, 'k74', 'Fibrosis y cirrosis del hígado', 'aldactone'),
(21, 'k74', 'Fibrosis y cirrosis del hígado', 'ameride'),
(22, 'k74', 'Fibrosis y cirrosis del hígado', 'diuzine'),
(23, 'k80', 'Colelitiasis', 'bilifalk'),
(24, 'k80', 'Colelitiasis', 'lebersal'),
(25, 'k80', 'Colelitiasis', 'ursobilane'),
(26, 'k85', 'Pancreatitis aguda', 'pancreatina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sir_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_sir_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `e_sir_pastillas`
--

INSERT INTO `e_sir_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'j12', 'Neumonía', 'azitromicina'),
(2, 'j12', 'Neumonía', 'amoxicilina'),
(3, 'j12', 'Neumonía', 'levofloxacino'),
(4, 'j20', 'Bronquitis aguda ', 'doxiciclona'),
(5, 'j20', 'Bronquitis aguda ', 'prednisona'),
(6, 'j20', 'Bronquitis aguda ', 'levofloxacin'),
(7, 'j43', 'Enfisema', 'broncodilator'),
(8, 'j43', 'Enfisema', 'teoflins'),
(9, 'j43', 'Enfisema', 'difilina'),
(10, 'j80', 'Síndrome de distrés respiratorio agudo', 'ambroxol'),
(11, 'j80', 'Síndrome de distrés respiratorio agudo', 'acetilcisteína'),
(12, 'j80', 'Síndrome de distrés respiratorio agudo', 'prednisona'),
(13, 'j81', 'Edema agudo de pulmón', 'furosemida'),
(14, 'j81', 'Edema agudo de pulmón', 'morfina'),
(15, 'j81', 'Edema agudo de pulmón', 'nitroglicerina'),
(16, 'j90', 'Derrame pleural', 'dexametasona'),
(17, 'j90', 'Derrame pleural', 'aspirina'),
(18, 'j90', 'Derrame pleural', 'hidrocortisona');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sistema_digestivo`
--

CREATE TABLE IF NOT EXISTS `e_sistema_digestivo` (
  `num_esd` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcsd` varchar(5) NOT NULL,
  `k20` varchar(2) NOT NULL,
  `k25` varchar(2) NOT NULL,
  `k27` varchar(2) NOT NULL,
  `k29` varchar(2) NOT NULL,
  `k50` varchar(2) NOT NULL,
  `k51` varchar(2) NOT NULL,
  `k70` varchar(2) NOT NULL,
  `k74` varchar(2) NOT NULL,
  `k80` varchar(2) NOT NULL,
  `k85` varchar(2) NOT NULL,
  PRIMARY KEY (`num_esd`),
  KEY `num_hcsd` (`num_hcsd`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_sistema_digestivo`
--

INSERT INTO `e_sistema_digestivo` (`num_esd`, `num_hcsd`, `k20`, `k25`, `k27`, `k29`, `k50`, `k51`, `k70`, `k74`, `k80`, `k85`) VALUES
(1, 'p0003', 'NO', 'NO', 'NO', 'SI', 'NO', 'SI', 'NO', 'NO', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sistema_respiratorio`
--

CREATE TABLE IF NOT EXISTS `e_sistema_respiratorio` (
  `num_esr` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcsr` varchar(5) NOT NULL,
  `j12` varchar(2) NOT NULL,
  `j20` varchar(2) NOT NULL,
  `j43` varchar(2) NOT NULL,
  `j80` varchar(2) NOT NULL,
  `j81` varchar(2) NOT NULL,
  `j90` varchar(2) NOT NULL,
  `j93` varchar(2) NOT NULL,
  PRIMARY KEY (`num_esr`),
  KEY `num_hcsr` (`num_hcsr`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_sistema_respiratorio`
--

INSERT INTO `e_sistema_respiratorio` (`num_esr`, `num_hcsr`, `j12`, `j20`, `j43`, `j80`, `j81`, `j90`, `j93`) VALUES
(1, 'p0003', 'SI', 'NO', 'NO', 'SI', 'NO', 'NO', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_sistema_urinario`
--

CREATE TABLE IF NOT EXISTS `e_sistema_urinario` (
  `num_esu` int(11) NOT NULL AUTO_INCREMENT,
  `num_hcsu` varchar(5) NOT NULL,
  `n00` varchar(2) NOT NULL,
  `n03` varchar(2) NOT NULL,
  `n04` varchar(2) NOT NULL,
  `n12` varchar(2) NOT NULL,
  `n17` varchar(2) NOT NULL,
  `n20` varchar(2) NOT NULL,
  `n21` varchar(2) NOT NULL,
  `n30` varchar(2) NOT NULL,
  `n34` varchar(2) NOT NULL,
  PRIMARY KEY (`num_esu`),
  KEY `num_hcsu` (`num_hcsu`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `e_sistema_urinario`
--

INSERT INTO `e_sistema_urinario` (`num_esu`, `num_hcsu`, `n00`, `n03`, `n04`, `n12`, `n17`, `n20`, `n21`, `n30`, `n34`) VALUES
(1, 'p0003', 'NO', 'NO', 'NO', 'SI', 'SI', 'NO', 'NO', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `e_siu_pastillas`
--

CREATE TABLE IF NOT EXISTS `e_siu_pastillas` (
  `num_p` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(4) NOT NULL,
  `nom_e` varchar(50) NOT NULL,
  `pastilla` varchar(20) NOT NULL,
  PRIMARY KEY (`num_p`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `e_siu_pastillas`
--

INSERT INTO `e_siu_pastillas` (`num_p`, `cod_enf`, `nom_e`, `pastilla`) VALUES
(1, 'n03', 'Síndrome nefrítico', 'deflazacort'),
(2, 'n03', 'Síndrome nefrítico', 'prednisolona'),
(3, 'n03', 'Síndrome nefrítico', 'metilprednisolona'),
(4, 'n04', 'Síndrome nefrótico', 'Deflazacor'),
(5, 'n04', 'Síndrome nefrótico', 'furosemida'),
(6, 'n04', 'Síndrome nefrótico', 'espironolactona'),
(7, 'n12', 'Nefritis tubulointersticial', 'alopurinol'),
(8, 'n12', 'Nefritis tubulointersticial', 'furosemida'),
(9, 'n12', 'Nefritis tubulointersticial', 'ciprofloxacino'),
(10, 'n17', 'Insuficiencia renal aguda', 'furosemida'),
(11, 'n17', 'Insuficiencia renal aguda', 'manitol'),
(12, 'n17', 'Insuficiencia renal aguda', 'dialamine'),
(13, 'n20', 'Cálculo del riñón y del uréter', 'alopurinol'),
(14, 'n20', 'Cálculo del riñón y del uréter', 'bicarbonato de sodio'),
(15, 'n20', 'Cálculo del riñón y del uréter', 'tamsulosina'),
(16, 'n21', 'Cálculo de las vías urinarias inferiores', 'tamsulosina'),
(17, 'n21', 'Cálculo de las vías urinarias inferiores', 'levofloxacina'),
(18, 'n21', 'Cálculo de las vías urinarias inferiores', 'azitromicina'),
(19, 'n30', 'Cistitis', 'trimetoprim-sulfamet'),
(20, 'n30', 'Cistitis', 'ciprofloxacina'),
(21, 'n30', 'Cistitis', 'ampicilina'),
(22, 'n34', 'Uretritis y síndrome uretral', 'nitrofurantoína'),
(23, 'n34', 'Uretritis y síndrome uretral', 'ciprofloxacina'),
(24, 'n34', 'Uretritis y síndrome uretral', 'levofloxacina'),
(25, 'n45', 'Orquitis y epididimitis', 'ceftriaxona'),
(26, 'n45', 'Orquitis y epididimitis', 'ciprofloxacina'),
(27, 'n45', 'Orquitis y epididimitis', 'naproxeno'),
(28, 'n70', 'Salpingitis y ooforitis', 'doxiciclina'),
(29, 'n70', 'Salpingitis y ooforitis', 'azitromicina'),
(30, 'n70', 'Salpingitis y ooforitis', 'levofloxacino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_total_enfermedades`
--

CREATE TABLE IF NOT EXISTS `lista_total_enfermedades` (
  `num_le` int(11) NOT NULL AUTO_INCREMENT,
  `cod_enf` varchar(5) NOT NULL,
  `tipo_enf` varchar(50) NOT NULL,
  `nom_enf` varchar(50) NOT NULL,
  PRIMARY KEY (`num_le`),
  KEY `cod_enf` (`cod_enf`,`nom_enf`),
  KEY `nom_enf` (`nom_enf`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=91 ;

--
-- Volcado de datos para la tabla `lista_total_enfermedades`
--

INSERT INTO `lista_total_enfermedades` (`num_le`, `cod_enf`, `tipo_enf`, `nom_enf`) VALUES
(1, 'A00', 'Enfermedades Infecciosas', 'Cólera'),
(2, 'A01', 'Enfermedades Infecciosas', 'Fiebre tifoidea'),
(3, 'A03', 'Enfermedades Infecciosas', 'Shigellosis'),
(4, 'A15', 'Enfermedades Infecciosas', 'Tuberculosis respiratoria'),
(5, 'A22', 'Enfermedades Infecciosas', 'Carbunco o ántrax'),
(6, 'A51', 'Enfermedades Infecciosas', 'Sífilis precoz'),
(7, 'A82', 'Enfermedades Infecciosas', 'Rabia'),
(8, 'B00', 'Enfermedades Infecciosas', 'Infecciones herpéticas, herpes simple'),
(9, 'B19', 'Enfermedades Infecciosas', 'Hepatitis viral '),
(10, 'B20', 'Enfermedades Infecciosas', 'Virus de la inmunodeficiencia humana (VIH)'),
(11, 'C15', 'Enfermedades Neoplásicas', 'Neoplasias malignas de esófago'),
(12, 'C16', 'Enfermedades Neoplásicas', 'Neoplasias malignas de estómago'),
(13, 'C17', 'Enfermedades Neoplásicas', 'Neoplasias malignas de intestino delgado'),
(14, 'C25', 'Enfermedades Neoplásicas', 'Neoplasias malignas de páncreas'),
(15, 'C33', 'Enfermedades Neoplásicas', 'Neoplasias malignas de la tráquea'),
(16, 'C34', 'Enfermedades Neoplásicas', 'Neoplasias malignas de bronquios y pulmón'),
(17, 'C69', 'Enfermedades Neoplásicas', 'Neoplasias malignas del sistema nervioso '),
(18, 'C81', 'Enfermedades Neoplásicas', 'Enfermedad de Hodgkin'),
(19, 'C90', 'Enfermedades Neoplásicas', 'Neoplasias malignas de células plasmáticas'),
(20, 'C91', 'Enfermedades Neoplásicas', 'Leucemia '),
(21, 'D50', 'Enfermedades de la Sangre', 'Anemia por deficiencia de hierro'),
(22, 'D56', 'Enfermedades de la Sangre', 'Talasemia'),
(23, 'D60', 'Enfermedades de la Sangre', 'Aplasia pura de glóbulos rojos '),
(24, 'D66', 'Enfermedades de la Sangre', 'Hemofilia A'),
(25, 'D67', 'Enfermedades de la Sangre', 'Hemofilia B'),
(26, 'D69.0', 'Enfermedades de la Sangre', 'Púrpura alérgica'),
(27, 'D69.3', 'Enfermedades de la Sangre', 'Púrpura trombocitopénica idiopática'),
(28, 'D70', 'Enfermedades de la Sangre', 'Agranulocitosis'),
(29, 'D75.0', 'Enfermedades de la Sangre', 'Eritrocitosis familiar'),
(30, 'D75.1', 'Enfermedades de la Sangre', 'Policitemia secundaria'),
(31, 'E02', 'Enfermedades Endocrinológicas', 'Hipotiroidismo '),
(32, 'E03', 'Enfermedades Endocrinológicas', 'Hipertiroidismo '),
(33, 'E06', 'Enfermedades Endocrinológicas', 'Tiroiditis'),
(34, 'E20', 'Enfermedades Endocrinológicas', 'Hipoparatiroidismo'),
(35, 'E24', 'Enfermedades Endocrinológicas', 'Síndrome de Cushing'),
(36, 'F00', 'Transtornos Mentales y del Comportamiento', 'Demencia en la enfermedad de Alzheimer'),
(37, 'F20', 'Transtornos Mentales y del Comportamiento', 'Esquizofrenia'),
(38, 'F31', 'Transtornos Mentales y del Comportamiento', 'Trastorno bipolar afectivo'),
(39, 'F42', 'Transtornos Mentales y del Comportamiento', 'Trastorno obsesivo-compulsivo'),
(40, 'F51', 'Transtornos Mentales y del Comportamiento', 'Trastornos del sueño no orgánicos'),
(41, 'I10', 'Enfermedades del Sistema Circulatorio', 'Hipertensión arterial esencial '),
(42, 'I20', 'Enfermedades del Sistema Circulatorio', 'Angina de pecho'),
(43, 'I21', 'Enfermedades del Sistema Circulatorio', 'Infarto agudo de miocardio  '),
(44, 'I30', 'Enfermedades del Sistema Circulatorio', 'Pericarditis aguda'),
(45, 'I40', 'Enfermedades del Sistema Circulatorio', 'Miocarditis aguda'),
(46, 'I48', 'Enfermedades del Sistema Circulatorio', 'Fibrilación atrial y pálpitos'),
(47, 'I70', 'Enfermedades del Sistema Circulatorio', 'Aterosclerosis'),
(48, 'I71', 'Enfermedades del Sistema Circulatorio', 'Aneurisma y disección aórtica'),
(49, 'I74', 'Enfermedades del Sistema Circulatorio', 'Embolia arterial y trombosis'),
(50, 'I95', 'Enfermedades del Sistema Circulatorio', 'Hipotensión'),
(51, 'J12', 'Enfermedades del Sistema Respiratorio', 'Neumonía '),
(52, 'J20', 'Enfermedades del Sistema Respiratorio', 'Bronquitis aguda '),
(53, 'J43', 'Enfermedades del Sistema Respiratorio', 'Enfisema'),
(54, 'J80', 'Enfermedades del Sistema Respiratorio', 'Síndrome de distrés respiratorio agudo'),
(55, 'J81', 'Enfermedades del Sistema Respiratorio', 'Edema agudo de pulmón'),
(56, 'J90', 'Enfermedades del Sistema Respiratorio', 'Derrame pleural'),
(57, 'J93', 'Enfermedades del Sistema Respiratorio', 'Neumotórax'),
(58, 'K20', 'Enfermedades del Sistema Disgestivo', 'Esofagitis'),
(59, 'K25', 'Enfermedades del Sistema Disgestivo', 'Gastritis '),
(60, 'K27', 'Enfermedades del Sistema Disgestivo', 'Úlcera péptica'),
(61, 'K29', 'Enfermedades del Sistema Disgestivo', 'Gastritis y duodenitis'),
(62, 'K50', 'Enfermedades del Sistema Disgestivo', 'Enfermedad de Crohn '),
(63, 'K51', 'Enfermedades del Sistema Disgestivo', 'Colitis ulcerosa'),
(64, 'K70', 'Enfermedades del Sistema Disgestivo', 'Enfermedad del hígado alcohólica'),
(65, 'K74', 'Enfermedades del Sistema Disgestivo', 'Fibrosis y cirrosis del hígado'),
(66, 'K80', 'Enfermedades del Sistema Disgestivo', 'Colelitiasis'),
(67, 'K85', 'Enfermedades del Sistema Disgestivo', 'Pancreatitis aguda'),
(68, 'L01', 'Enfermedades de la Piel', 'Impétigo'),
(69, 'L20', 'Enfermedades de la Piel', 'Dermatitis atópica'),
(70, 'L40', 'Enfermedades de la Piel', 'Psoriasis'),
(71, 'L70', 'Enfermedades de la Piel', 'Acné'),
(72, 'L80', 'Enfermedades de la Piel', 'Vitíligo'),
(73, 'M00', 'Enfermedades Reumatológicas', 'Artritis piógena'),
(74, 'M05', 'Enfermedades Reumatológicas', 'Artritis reumatoide seropositiva'),
(75, 'M07', 'Enfermedades Reumatológicas', 'Artropatías psoriásicas y enteropáticas'),
(76, 'M08', 'Enfermedades Reumatológicas', 'Artritis juvenil'),
(77, 'M10', 'Enfermedades Reumatológicas', 'Gota'),
(78, 'M15', 'Enfermedades Reumatológicas', 'Poliartrosis'),
(79, 'M34', 'Enfermedades Reumatológicas', 'Esclerosis sistémica'),
(80, 'M65', 'Enfermedades Reumatológicas', 'Sinovitis y tenosinovitis'),
(81, 'M86', 'Enfermedades Reumatológicas', 'Osteomielitis'),
(82, 'N00', 'Enfermedades del Sistema Urinario', 'Síndrome nefrítico agudo'),
(83, 'N03', 'Enfermedades del Sistema Urinario', 'Síndrome nefrítico crónico'),
(84, 'N04', 'Enfermedades del Sistema Urinario', 'Síndrome nefrótico'),
(85, 'N12', 'Enfermedades del Sistema Urinario', 'Nefritis tubulointersticial'),
(86, 'N17', 'Enfermedades del Sistema Urinario', 'Insuficiencia renal aguda'),
(87, 'N20', 'Enfermedades del Sistema Urinario', 'Cálculo del riñón y del uréter'),
(88, 'N21', 'Enfermedades del Sistema Urinario', 'Cálculo de las vías urinarias inferiores'),
(89, 'N30', 'Enfermedades del Sistema Urinario', 'Cistitis'),
(90, 'N34', 'Enfermedades del Sistema Urinario', 'Uretritis y síndrome uretral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos_diabetes`
--

CREATE TABLE IF NOT EXISTS `medicamentos_diabetes` (
  `num_m` int(11) NOT NULL AUTO_INCREMENT,
  `nom_m_favor` varchar(30) NOT NULL,
  `nom_m_contra` varchar(30) NOT NULL,
  PRIMARY KEY (`num_m`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `medicamentos_diabetes`
--

INSERT INTO `medicamentos_diabetes` (`num_m`, `nom_m_favor`, `nom_m_contra`) VALUES
(1, 'GLIMEPERIDA', 'ANTICONCEPTIVOS'),
(2, 'GLIMEPERIDA', 'ENALAPRIL'),
(3, 'GLIMEPIRIDA', 'ANTICOAGULANTE'),
(4, 'GLIMEPIRIDA', 'GLUCAGON'),
(5, 'GLIMEPIRIDA', 'ASPARARAGINASA'),
(6, 'NATEGLINIDA', 'IMAO'),
(7, 'NATEGLINIDA', 'METFORMIDA'),
(8, 'NATEGLINIDA', 'WARFORMINA'),
(9, 'NATEGLINIDA', 'SALICILATOS'),
(10, 'NATEGLINIDA', 'DIGOXINA'),
(11, 'LISPRO', 'ACARBOSA'),
(12, 'LISPRO', 'ANFERPRAMENA'),
(13, 'LISPRO', 'BISOPRELOL'),
(14, 'LISPRO', 'CAPTOPRIL'),
(15, 'LISPRO', 'CELIPRELOL'),
(16, 'GLIPIZIDA', 'DEXKETOPROFENO'),
(17, 'GLIPIZIDA', 'FOSFOSAL'),
(18, 'GLIPIZIDA', 'MIGLITOL'),
(19, 'GLIPIZIDA', 'OXACEPROL'),
(20, 'GLIPIZIDA', 'RANITIDINA'),
(21, 'GLIBENCLAMIDA', 'FOSFOSAL'),
(22, 'GLIBENCLAMIDA', 'CLORGILINA'),
(23, 'GLIBENCLAMIDA', 'ETODOLAC'),
(24, 'GLIBENCLAMIDA', 'ACITRETINA'),
(25, 'GLIBENCLAMIDA', 'VARDENAFIL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `num_hisc` varchar(5) NOT NULL,
  `nom_pac` varchar(20) NOT NULL,
  `apep_pac` varchar(15) NOT NULL,
  `apem_pac` varchar(15) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `fec_nac` varchar(10) NOT NULL,
  `dni_pac` int(8) NOT NULL,
  `telefono` int(9) NOT NULL,
  `est_civil` varchar(7) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `peso` double NOT NULL,
  `talla` double NOT NULL,
  `dia_cint` double NOT NULL,
  `embarazo` varchar(2) NOT NULL,
  `ocupacion` varchar(25) NOT NULL,
  `etnia` varchar(30) NOT NULL,
  `imc` double NOT NULL,
  PRIMARY KEY (`num_hisc`),
  UNIQUE KEY `dni_pac` (`dni_pac`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`num_hisc`, `nom_pac`, `apep_pac`, `apem_pac`, `sexo`, `fec_nac`, `dni_pac`, `telefono`, `est_civil`, `direccion`, `peso`, `talla`, `dia_cint`, `embarazo`, `ocupacion`, `etnia`, `imc`) VALUES
('p0001', 'jack eber', 'ore', 'palomino', 'Masculino', '31/10/1995', 76602652, 966199155, 'Soltero', '9 de junio 2do sector', 64, 165, 80, 'NO', 'estudiante', 'Europa y Medio Oriente', 23.507805325987146),
('p0002', 'Mario', 'CORTEZ', 'ESCARATE', 'Masculino', '20/06/1998', 71732613, 961849244, 'Casado', 'CALLE HORTENCIA CEVALLO 461', 68, 170, 100, 'NO', 'estudiante', 'Latinos', 23.529411764705884),
('p0003', 'Karen', 'Muñoz', 'Zavaleta', 'Femenino', '03/10/2017', 76094143, 961849244, 'Soltero', 'Fortaleza 109', 55, 165, 50, 'NO', 'Estudiante', 'Latinos', 20.202020202020204),
('p0007', 'carlos', 'cortez', 'escarate', 'Masculino', '20/06/1998', 71732599, 961849244, 'Soltero', 'HORTENCIAS CEVALLOS 461 CERCADO', 68, 170, 100, 'NO', 'estudiante', 'Latinos', 23.529411764705884);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE IF NOT EXISTS `recetas` (
  `num_rec` int(11) NOT NULL AUTO_INCREMENT,
  `pacient_cod` varchar(5) NOT NULL,
  `receta_1` varchar(20) NOT NULL,
  `receta_2` varchar(20) NOT NULL,
  PRIMARY KEY (`num_rec`),
  KEY `pacient_cod` (`pacient_cod`),
  KEY `pacient_cod_2` (`pacient_cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `recetas`
--

INSERT INTO `recetas` (`num_rec`, `pacient_cod`, `receta_1`, `receta_2`) VALUES
(1, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(2, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(3, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(4, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(5, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(6, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(7, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(8, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(9, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(10, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA'),
(11, 'p0003', 'GLIMEPERIDA', 'NATEGLINIDA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintomas`
--

CREATE TABLE IF NOT EXISTS `sintomas` (
  `num_sin` int(11) NOT NULL AUTO_INCREMENT,
  `num_hiscs` varchar(5) NOT NULL,
  `poliurea` varchar(2) NOT NULL,
  `polifagia` varchar(2) NOT NULL,
  `polidipsia` varchar(2) NOT NULL,
  `perd_peso` varchar(2) NOT NULL,
  `astenia` varchar(2) NOT NULL,
  `fam_p_grado` varchar(2) NOT NULL,
  `nac_peso` varchar(2) NOT NULL,
  `diag_diages` varchar(2) NOT NULL,
  `acantosis` varchar(2) NOT NULL,
  `paraestesia` varchar(2) NOT NULL,
  `disestesia` varchar(2) NOT NULL,
  `dis_agu_visual` varchar(2) NOT NULL,
  `prurito` varchar(2) NOT NULL,
  `miastenia` varchar(2) NOT NULL,
  `pas` int(11) NOT NULL,
  `pad` int(11) NOT NULL,
  `fr` int(11) NOT NULL,
  `fc` int(11) NOT NULL,
  PRIMARY KEY (`num_sin`),
  KEY `num_hiscs` (`num_hiscs`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `sintomas`
--

INSERT INTO `sintomas` (`num_sin`, `num_hiscs`, `poliurea`, `polifagia`, `polidipsia`, `perd_peso`, `astenia`, `fam_p_grado`, `nac_peso`, `diag_diages`, `acantosis`, `paraestesia`, `disestesia`, `dis_agu_visual`, `prurito`, `miastenia`, `pas`, `pad`, `fr`, `fc`) VALUES
(1, 'p0003', 'SI', 'SI', 'SI', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 120, 80, 21, 60);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `antece_farmacologicos`
--
ALTER TABLE `antece_farmacologicos`
  ADD CONSTRAINT `antece_farmacologicos_ibfk_1` FOREIGN KEY (`num_hiscaf`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`num_hcdiag`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `exam_complementario`
--
ALTER TABLE `exam_complementario`
  ADD CONSTRAINT `exam_complementario_ibfk_1` FOREIGN KEY (`num_hiscec`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_cardiovascular`
--
ALTER TABLE `e_cardiovascular`
  ADD CONSTRAINT `e_cardiovascular_ibfk_1` FOREIGN KEY (`num_hcec`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_endocrinologicas`
--
ALTER TABLE `e_endocrinologicas`
  ADD CONSTRAINT `e_endocrinologicas_ibfk_1` FOREIGN KEY (`num_hce`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_infecciosas`
--
ALTER TABLE `e_infecciosas`
  ADD CONSTRAINT `e_infecciosas_ibfk_1` FOREIGN KEY (`num_hci`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_neoplasia`
--
ALTER TABLE `e_neoplasia`
  ADD CONSTRAINT `e_neoplasia_ibfk_1` FOREIGN KEY (`num_hcn`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_piel`
--
ALTER TABLE `e_piel`
  ADD CONSTRAINT `e_piel_ibfk_1` FOREIGN KEY (`num_hcp`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_psiquiatria`
--
ALTER TABLE `e_psiquiatria`
  ADD CONSTRAINT `e_psiquiatria_ibfk_1` FOREIGN KEY (`num_hcps`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_reumatologicas`
--
ALTER TABLE `e_reumatologicas`
  ADD CONSTRAINT `e_reumatologicas_ibfk_1` FOREIGN KEY (`num_hcr`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_sangre`
--
ALTER TABLE `e_sangre`
  ADD CONSTRAINT `e_sangre_ibfk_1` FOREIGN KEY (`num_hcs`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_sistema_digestivo`
--
ALTER TABLE `e_sistema_digestivo`
  ADD CONSTRAINT `e_sistema_digestivo_ibfk_1` FOREIGN KEY (`num_hcsd`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_sistema_respiratorio`
--
ALTER TABLE `e_sistema_respiratorio`
  ADD CONSTRAINT `e_sistema_respiratorio_ibfk_1` FOREIGN KEY (`num_hcsr`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `e_sistema_urinario`
--
ALTER TABLE `e_sistema_urinario`
  ADD CONSTRAINT `e_sistema_urinario_ibfk_1` FOREIGN KEY (`num_hcsu`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `recetas_ibfk_1` FOREIGN KEY (`pacient_cod`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sintomas`
--
ALTER TABLE `sintomas`
  ADD CONSTRAINT `sintomas_ibfk_1` FOREIGN KEY (`num_hiscs`) REFERENCES `paciente` (`num_hisc`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
