package org.leibnizcenter.rechtspraak.markup.docs.features.patterns;

import org.junit.Test;
import org.leibnizcenter.rechtspraak.tagging.crf.features.info.InfoPatterns;
import org.leibnizcenter.rechtspraak.tagging.crf.features.quote.PreBlockQuotePattrns;
import org.leibnizcenter.rechtspraak.tagging.crf.features.title.TitlePatterns;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by Maarten on 3/7/2016.
 */
public class TestPatterns {
    @Test
    public void testInfoSignifiers() {
        assertTrue(InfoPatterns.InfoPatternsUnormalizedContains.CONTAINS_BRACKETED_TEXT.matches("[some 69 brachteket text]"));
        assertFalse(InfoPatterns.InfoPatternsUnormalizedContains.CONTAINS_BRACKETED_TEXT.matches("[some 69: brachteket text]"));
        assertTrue(InfoPatterns.InfoPatternsUnormalizedContains.CONTAINS_BRACKETED_TEXT.matches("some [ b r a c k e t e d ] text"));
        assertTrue(InfoPatterns.InfoPatternsUnormalizedContains.CONTAINS_LIKELY_ZAAKNR.matches("this: 69/666 looks like zaaknummer"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_WITH_COURT.matches("het gerechtshof beslist"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_WITH_COURT.matches("de rechtbank beslist"));
        assertFalse(InfoPatterns.InfoPatternsNormalizedContains.START_WITH_COURT.matches("beslist de rechtbank"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.RAAD_VAN_STATE.matches("de raad van state"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.STARTS_WITH_RAAD.matches("hoge raad van beroep"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.STARTS_WITH_RAAD.matches("het college van beroep"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.EN_VS_CONTRA.matches("en"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.EN_VS_CONTRA.matches("tegen"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.EN_VS_CONTRA.matches("vs"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.EN_VS_CONTRA.matches("contra"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedMatches.INZAKE.matches("inzake"));
        assertFalse(InfoPatterns.InfoPatternsNormalizedMatches.INZAKE.matches("inzake x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_INZAKE.matches("inzake x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_AFDELING.matches("afdeling x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_SECTOR.matches("sector x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_HIERNA.matches("hierna x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_LOCATIE.matches("locatie x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_ZAAK_ROL_NR.matches("zaaknr."));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_ZAAKNR.matches("zaaknr."));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_WONEND_GEVESTIGD.matches("wonende"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_DATUM.matches("datum 22-xx-9990"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.START_W_PATT.matches("in de zaak van van x"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.END_W_KAMER.matches("meervoudige kamer"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.END_W_ROLE.matches("a, gedaagde"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.END_W_ROLE.matches("a, appelant"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.END_W_ROLE.matches("a, verweerder"));
        assertTrue(InfoPatterns.InfoPatternsNormalizedContains.END_W_ROLE.matches("a, advocaat te rotterdam"));
    }

    @Test
    public void testCase() {
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("het geding in beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("het geding in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("het geschil"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding"));
    }

    @Test
    public void testProceedings() {
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("de procedure"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("de procesgang"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("het procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procesverloop en de processtukken"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("feiten en procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("feiten en het procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("inleiding feiten en procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procesgang"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procesverloop in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procesverloop in eerste aanleg en vaststaande feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("verder procesverloop in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("verdere procesverloop in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("voorgeschiedenis en het procesverloop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("ontstaan en loop van het geding"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("ontstaan en loop van de procedure"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("ontstaan en loop van de gedingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("ontstaan en loop van het geding voor verwijzing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("verdere procesgang in hoger beroep"));
    }

    @Test
    public void testJudgment() {
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beoordeling van het geschil en de motivering van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beoordeling van het verzoek en de motivering van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing afwijzing vordering verlenging terbeschikkingstelling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing de rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing het gerechtshof"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing in conventie en in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing in het incident"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing in kort geding"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing inzake het bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing met betrekking tot de voorlopige hechtenis"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing na voorwaardelijke veroordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing op de vordering van de benadeelde partij"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing op de vordering van de benadeelde partij feit"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing op de vordering van de benadeelde partij slachtoffer"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing op het hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing op het principale en het incidentele hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing van de kantonrechter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing van de rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing van de voorzitter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing verlenging terbeschikkingstelling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissing voorwaardelijk einde verpleging van overheidswege"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissingen in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("beslissingen op de vorderingen van de benadeelde partijen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("bestreden beslissing op bezwaar"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("bewijsbeslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("bewijsbeslissingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("feiten het geschil en de beslissing in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("feiten het geschil en de motivering van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("geschil en de beslissing in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("geschil en de beslissing van de kantonrechter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("geschil en de beslissing van de rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("geschil en de beslissing van de voorzieningenrechter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("geschil in eerste aanleg en de beslissing van de voorzieningenrechter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("gronden van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("gronden voor de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("motivering van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("motivering van de beslissing in het incident"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("motivering van de beslissing in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("motivering van de beslissing na voorwaardelijke veroordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("slotsom"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("slotsom en conclusie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("slotsom en kosten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("slotsom en proceskosten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("verdere beoordeling van het geschil en de gronden van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("verdere motivering van de beslissing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("verdere motivering van de beslissing in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("voortgezette motivering van de beslissing in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vordering en de beslissing daarop in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vordering en de beslissing in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vordering in eerste aanleg en de beslissing daarop"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vorderingen en de beslissing in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vorderingen en de beslissingen in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("vorderingen in eerste aanleg en de beslissing daarop"));
    }

    @Test
    public void testNull() {
// "a"  //281
// "a hij in de periode van juli tot en met augustus inde boerderij adres te tripscompagnie ter uitvoering van het door verdachte voorgenomen misdrijf om tezamen en in vereniging met anderen met het oogmerk om zich enof een anderen wederrechtelijk te bevoordelen door geweld enof bedreiging met geweld een persoon genaamd benadeelde te dwingen tot de afgifte van geld met dat oogmerk tezamen en in vereniging met verdachtes mededaders"  //6
// "aanduiding bestreden besluit"  //29
// "aanduiding van het geschil"  //8
// "aanhechten draagkrachtberekeningen"  //46
// "aanleiding"  //8
// "aanleiding van het geschil"  //14
// "aanslag beschikking bezwaar en geding in eerste aanleg"  //58
// "aanslag beschikkingen bezwaar en geding in eerste aanleg"  //21
// "aanslag bezwaar en beroep"  //6
// "aanslag bezwaar en geding in eerste aanleg"  //67
// "aanslagen beschikkingen bezwaar en geding in eerste aanleg"  //31
// "aanslagen beschikkingen bezwaren en geding in eerste aanleg"  //6
// "aanslagen bezwaar en geding in eerste aanleg"  //17
// "aanvraag tot herziening"  //61
// "achtergrond"  //6
// "achtergrond van de geschillen"  //8
// "achtergrond van het geschil"  //6
// "ad"  //12
// "ad a"  //12
// "ad b"  //9
// "adoptie"  //9
// "adres"  //18
// "advies"  //20
// "afdeling civiel recht"  //40
// "afdeling strafrecht"  //98
// "afdoening"  //11
// "afronding"  //12
// "afschrift verzonden aan partijen op"  //7
// "afschrift verzonden op"  //16
// "afstand van rechtsmiddelen"  //7
// "afwijzing verlenging ondertoezichtstelling"  //6
// "ag"  //24
// "agreement"  //12
// "algemeen"  //35
// "algemeen rechtskader"  //14
// "algemene uiteenzetting gang van zaken en december"  //8
// "algemene voorwaarden"  //8
// "alimentatie"  //17
// "als verklaring van betrokkene"  //10
// "als verklaring van betrokkene afgelegd op juni"  //6
// "als verklaring van verbalisant"  //9
// "als verklaring van verdachte"  //9
// "analyse"  //6
// "ap"  //239
// "appellant"  //499
// "appellant en"  //14
// "appellant sub"  //165
// "appellant sub en"  //19
// "appellant sub wonende te woonplaats"  //8
// "appellant wonende te woonplaats"  //74
// "appellante"  //152
// "appellante sub"  //35
// "appellante wonende te woonplaats"  //16
// "arrest"  //577
// "arrest dd april"  //33
// "arrest dd augustus"  //10
// "arrest dd december"  //12
// "arrest dd februari"  //21
// "arrest dd januari"  //20
// "arrest dd juli"  //24
// "arrest dd juni"  //22
// "arrest dd maart"  //28
// "arrest dd mei"  //22
// "arrest dd november"  //12
// "arrest dd oktober"  //18
// "arrest dd september"  //23
// "arrest in dit geding"  //7
// "arrest van april"  //46
// "arrest van augustus"  //31
// "arrest van de economische kamer van het gerechtshof shertogenbosch"  //9
// "arrest van de familiekamer dd april"  //7
// "arrest van de familiekamer dd juni"  //9
// "arrest van de familiekamer dd november"  //7
// "arrest van de meervoudige kamer voor strafzaken"  //160
// "arrest van de meervoudige kamer voor strafzaken van het gerechtshof"  //428
// "arrest van de meervoudige kamer voor strafzaken van het gerechtshof te"  //13
// "arrest van december"  //29
// "arrest van februari"  //39
// "arrest van januari"  //31
// "arrest van juli"  //67
// "arrest van juni"  //60
// "arrest van maart"  //56
// "arrest van mei"  //45
// "arrest van november"  //36
// "arrest van oktober"  //35
// "arrest van september"  //49
// "article echr"  //6
// "artikel"  //52
// "artikel belastbaar feit"  //12
// "artikel belastingplicht"  //6
// "artikel bw"  //12
// "artikel tarieven"  //7
// "artikel van de olw"  //7
// "asielrelaas"  //6
// "aw"  //6
// "awb nummers en namen eisers"  //6
// "b"  //183
// "b e s l i s s i n g"  //12
// "beantwoording van de prejudicile vraag"  //8
// "beantwoording van de prejudicile vragen"  //13
// "beantwoording van de vragen"  //10
// "bedreiging met enig misdrijf tegen het leven gericht"  //42
// "bedreiging met enig misdrijf tegen het leven gericht meermalen gepleegd"  //19
// "bedreiging met zware mishandeling"  //9
// "bedrijf"  //20
// "behandeling"  //9
// "behandeling in raadkamer"  //38
// "behandeling ter terechtzitting"  //11
// "behandeling van de klachten"  //9
// "behandeling van de middelen"  //22
// "behandeling van de zaak"  //7
// "behandeling van het geschil door het hof"  //6
// "behandeling van het hoger beroep"  //13
// "behandeling van het middel"  //10
// "behoefte"  //9
// "beklaagde"  //16
// "beklag"  //31
// "belaging"  //11
// "belanghebbende"  //100
// "belanghebbende sub"  //24
// "belanghebbenden"  //9
// "benadeelde partij"  //547
// "benadeelde partij benadeelde"  //29
// "benadeelde partij en de schadevergoedingsmaatregel"  //52
// "benadeelde partij minderjarige zaak"  //9
// "benadeelde partij slachtoffer"  //68
// "benadeelde partij slachtoffer feit"  //9
// "benadeelde partijen"  //256
// "benadeelde partijen en de schadevergoedingsmaatregel"  //7
// "beoordeling"  //196
// "beoordeling van de zaak"  //11
// "beoordeling van het bewijs"  //100
// "beoordeling van het eerste middel"  //9
// "beoordeling van het geschil"  //8
// "beoordeling van het geschil en de motivering van de beslissing"  //8
// "beoordeling van het hoger beroep"  //368
// "beoordeling van het incident"  //7
// "beoordeling van het middel"  //12
// "beoordeling van het principale en het incidentele hoger beroep"  //7
// "beoordeling van het verzoek"  //13
// "berechtingsrapport"  //6
// "beroep"  //6
// "beroep is ongegrond"  //12
// "beroep op noodweerexces"  //6
// "beschikkende"  //29
// "beschikking"  //41
// "beschikking aanslag bezwaar en geding in eerste aanleg"  //69
// "beschikking bezwaar en beroep"  //10
// "beschikking bezwaar en geding in eerste aanleg"  //31
// "beschikking dd augustus"  //6
// "beschikking in de zaak van"  //38
// "beschikking ontbinding arbeidsovereenkomst"  //20
// "beschikking op het op april ingekomen verzoek van"  //12
// "beschikking op het op april ingekomen verzoekschrift van"  //11
// "beschikking op het op augustus ingekomen verzoek van"  //9
// "beschikking op het op augustus ingekomen verzoekschrift van"  //13
// "beschikking op het op december ingekomen verzoek van"  //13
// "beschikking op het op december ingekomen verzoekschrift van"  //10
// "beschikking op het op februari ingekomen verzoek van"  //8
// "beschikking op het op februari ingekomen verzoekschrift van"  //11
// "beschikking op het op januari ingekomen verzoek van"  //6
// "beschikking op het op januari ingekomen verzoekschrift van"  //12
// "beschikking op het op juli ingekomen verzoek van"  //16
// "beschikking op het op juli ingekomen verzoekschrift van"  //10
// "beschikking op het op juni ingekomen verzoek van"  //15
// "beschikking op het op juni ingekomen verzoekschrift van"  //12
// "beschikking op het op maart ingekomen verzoek van"  //10
// "beschikking op het op maart ingekomen verzoekschrift van"  //11
// "beschikking op het op mei ingekomen verzoek van"  //12
// "beschikking op het op mei ingekomen verzoekschrift van"  //16
// "beschikking op het op november ingekomen verzoek van"  //10
// "beschikking op het op november ingekomen verzoekschrift van"  //7
// "beschikking op het op oktober ingekomen verzoek van"  //14
// "beschikking op het op oktober ingekomen verzoekschrift van"  //7
// "beschikking op het op september ingekomen verzoek van"  //7
// "beschikking op het op september ingekomen verzoekschrift van"  //10
// "beschikking van april"  //8
// "beschikking van augustus"  //8
// "beschikking van de kantonrechter"  //15
// "beschikking van juli"  //9
// "beschikking van mei"  //6
// "beschikking van oktober"  //7
// "beschikking van september"  //8
// "beschikkingen aanslagen bezwaar en geding in eerste aanleg"  //19
// "beschikkingen bezwaar en geding in eerste aanleg"  //9
// "beschikt"  //7
// "beschouwing"  //44
// "beschouwing rechtbank"  //16
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.BESLAG.matches("beslag"));

//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("beslissing"));

// "beslist"  //12
// "besloten vennootschap"  //11
// "besloten vennootschap met beperkte aansprakelijkheid"  //117
// "beslssing"  //7
// "bespreking cassatiemiddel"  //8
// "bespreking en waardering van bewijsmiddelen"  //10
// "bespreking middel onafhankelijkheid en onpartijdigheid van de rechter"  //6
// "bespreking van bewijsverweren"  //8
// "bespreking van de cassatieklachten"  //7
// "bespreking van de cassatiemiddelen"  //52
// "bespreking van de gevoerde verweren"  //8
// "bespreking van de grieven"  //63
// "bespreking van de klachten"  //18
// "bespreking van de middelen"  //10
// "bespreking van de overige grieven"  //6
// "bespreking van de verweren"  //8
// "bespreking van een verweer"  //10
// "bespreking van het bewijsverweer"  //6
// "bespreking van het cassatieberoep"  //27
// "bespreking van het cassatiemiddel"  //348
// "bespreking van het incidenteel cassatieberoep"  //8
// "bespreking van het incidentele cassatieberoep"  //7
// "bespreking van het middel"  //31
// "bespreking van het principaal cassatieberoep"  //13
// "bespreking van het principaal cassatiemiddel"  //8
// "bespreking van het principale cassatieberoep"  //11
// "bespreking van het principale cassatiemiddel"  //13
// "bespreking van middel op de zaak betrekking hebbende stukken"  //6
// "bestreden beschikking"  //14
// "bestreden besluit"  //8
// "bestreden tuchtuitspraak"  //7
// "bestreden uitspraak"  //23
// "bestreden uitspraak op bezwaar"  //79
// "bestreden uitspraken op bezwaar"  //9
// "betrokkene"  //56
// "betrokkene betrokkene"  //7
// "betrokkene feit"  //6
// "bevestigt de aangevallen uitspraak"  //33
// "bevindingen"  //6
// "bevoegdheid"  //12
// "bevoegdheid van de rechtbank"  //20
// "bevoegdheid van het hof"  //8

        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PROVE.matches("bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PROVE.matches("bewijsmiddelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PROVE.matches("bewezenverklaring en bewijsvoering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PROVE.matches("bewezenverklaring"));
// "bewijsmiddelen"  //269
// "bewijsaanbod"  //15
// "bewijsbeslissingen"  //35
// "bewijsmiddelen en de beoordeling daarvan"  //8
// "bewijsmiddelen feit"  //7
// "bewijsmotivering"  //6
// "bewijsoverweging"  //139
// "bewijsoverweging feit"  //9
// "bewijsoverweging ten aanzien van feit"  //9
// "bewijsverweer"  //13
// "bewijsverweren"  //10
// "bewijsvoering"  //34
// "bewijsvraag"  //216
// "bewijswaarde van de verklaringen van medeverdachte"  //7
// "bezwaar en beroep"  //15
// "bijlage"  //43
// "bijlage a"  //6
// "bijlage i"  //8
// "bijlage i bij vonnis van november"  //6
// "bijlage i bij vonnis van oktober"  //7
// "bijlage i bij vonnis van september"  //6
// "bijlagen"  //35
// "bijzondere bewijsoverweging"  //8
// "bijzondere voorwaarden"  //7
// "bnb"  //8
// "bureau jeugdzorg drenthe"  //7
// "bureau jeugdzorg flevoland"  //8
// "bureau jeugdzorg friesland"  //11
// "bv"  //14
// "c"  //128
// "cak"  //40
// "cassatieberoep"  //11
// "cassatiemiddel"  //30
// "centrale raad van beroep"  //7
// "ciz"  //55
// "college"  //6
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("conclusie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("uitspraak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("conclusies"));
// "conclusie in het principale en incidentele cassatieberoep"  //6
// "conclusie van de advocaatgeneraal"  //21
// "conclusies"  //13
// "conclusies van partijen"  //439
// "curator"  //6
// "cvg"  //127
// "d"  //95
// "dadelijke uitvoerbaarheid"  //7
// "dcision"  //46
// "de man"  //102
// "de man wonende te woonplaats"  //27
// "de minderjarige geboren op geboortedatum te geboorteplaats"  //6
// "de moeder"  //94
// "de pleegouders"  //12
// "de vader"  //103
// "de vrouw"  //87
// "deelgeschil"  //53
// "deelneming aan een organisatie die tot oogmerk heeft het plegen van misdrijven"  //14
// "deprocedure"  //23
// "derde middel"  //49
// "diefstal"  //39
// "diefstal door twee of meer verenigde personen"  //21
// "diefstal meermalen gepleegd"  //10
// "dochter m"  //8
// "doodslag"  //38
// "door de rechtbank gebruikte bewijsmiddelen"  //6
// "door de verdediging ingediende verzoeken"  //7
// "door het hof gebruikte bewijsmiddelen"  //7
// "draagkracht"  //15
// "draagkracht man"  //9
// "draagkracht van de man"  //18
// "draagkracht van de vrouw"  //6
// "e"  //37
// "eendaadse samenloop van"  //18
// "eerste en het tweede middel"  //7
// "eerste geding in cassatie"  //91
// "eerste middel"  //78
// "eerste middelfaalt"  //8
// "eh"  //102
// "eigen schuld"  //6
// "eis officier van justitie"  //111
// "eis van de officier van justitie"  //148
// "eisende partij"  //6
// "eiser"  //475
// "eiser a"  //8
// "eiser sub"  //143
// "eiser te woonplaats eiser"  //6
// "eiser wonende te plaats eiser"  //7
// "eiser wonende te woonplaats eiser"  //8
// "eiseres"  //95
// "eiseres sub"  //37
// "eiseres te y eiser"  //7
// "eisers"  //25
// "eiswijziging"  //12
// "ek"  //9
// "en"  //129
// "en alvorens verder te beslissen"  //7
// "enof"  //13
// "f"  //32
// "fed"  //6
// "feit"  //260
// "feit en"  //7
// "feit parketnummer"  //6
// "feit primair"  //36
// "feit primair poging tot doodslag"  //6
// "feitelijke gang van zaken"  //15
// "feitelijke uitgangspunten"  //10
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en"));  //9
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en het geding in feitelijke instantie"));  //29
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en het geding in feitelijke instanties"));  //153
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en het geschil"));  //6
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en omstandigheden"));  //199
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten en omstandigheden in conventie en in reconventie"));  //11
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in beide zaken"));  //28
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in conventie en in reconventie"));  //56
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in conventie en reconventie"));  //17
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in conventie en voorwaardelijke reconventie"));  //7
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in de hoofdzaak en in de vrijwaringszaak"));  //8
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten in het incident"));  //27
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("feiten voor zover van belang in het incident"));  //16
// "formaliteiten met betrekking tot het bewijs in alle zaken"  //8
// "formele voorvragen"  //543
// "g"  //15
// "gang van zaken"  //15
// "garantie als bedoeld in artikel eerste lid olw"  //16
// "garantie als bedoeld in artikel eerste lid van de olw"  //34
// "gedaagde"  //536
// "gedaagde sub"  //229
// "gedaagden"  //15
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding in cassatie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding in eerste aanleg"));
// "geding in eerste aanleg zaaknr"  //55
// "geding in eerste aanleg zaaknr c ha za"  //31
// "geding in eerste aanleg zaaknr c kg za"  //37
// "geding in eerste aanleg zaaknr cha za"  //92
// "geding in eerste aanleg zaaknr chaza"  //28
// "geding in eerste aanleg zaaknr ckg za"  //56
// "geding in eerste aanleg zaaknr cv"  //12
// "geding in eerste aanleg zaaknr cv expl"  //198
// "geding in eerste aanleg zaaknr ha za"  //204
// "geding in eerste aanleg zaaknr haza"  //34
// "geding in eerste aanleg zaaknr kg za"  //23
// "geding in eerste aanleg zaaknr rolnr"  //34
// "geding in eerste aanleg zaaknr rolnr cv expl"  //8
// "geding in eerste aanleg zaaknr vv expl"  //8
// "geding in eerste aanleg zaaknrrolnr ha za"  //10
// "geding in eerste aanleg zaaknummer"  //8
// "geding in eerste aanleg zaaknummer c ha za"  //7
// "geding in eerste aanleg zaaknummer cha za"  //15
// "geding in eerste aanleg zaaknummer ckg za"  //10
// "geding in eerste aanleg zaaknummer cv expl"  //82
// "geding in eerste aanleg zaaknummer ha za"  //23
// "geding in eerste aanleg zaaknummer rolnummer"  //42
// "geding in eerste aanleg zaaknummer rolnummer ha za"  //11
// "geding in eerste aanleg zaaknummer vv expl"  //7
// "geding in eerste aanleg zaaknummerrolnummer ha za"  //28
// "geding in eerste aanleg zaakrolnr"  //14
// "geding in eerste aanleg zaakrolnr c ha za"  //7
// "geding in eerste aanleg zaakrolnr cha za"  //6
// "geding in eerste aanleg zaakrolnr ckg za"  //6
// "geding in eerste aanleg zaakrolnr cv expl"  //16
// "geding in eerste aanleg zaakrolnr ha za"  //23
// "geding in eerste aanleg zaakrolnummer"  //11
// "geding in eerste aanleg zaakrolnummer cha za"  //7
// "geding in eerste aanleg zaakrolnummer ckg za"  //6
// "geding in eerste aanleg zaakrolnummer cv expl"  //11
// "geding in eerste instantie"  //102
// "geding in feitelijke instantie"  //198
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding in feitelijke instanties"));
// "geding in feitelijke instanties en in cassatie"  //7
// "geding in het principaal en het incidenteel hoger beroep"  //56
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geding in hoger beroep"));
// "geding na cassatie"  //26
// "geding na verwijzing"  //15
// "geding na verwijzing door de hoge raad"  //12
// "geding voor de rechtbank en het hof"  //20
// "gedingen in hoger beroep"  //16
// "gedoogbeleid"  //7
// "geintimeerde"  //24
// "geintimeerde sub"  //17
// "geintimeerde wonende te woonplaats"  //14
// "gelast dat de verdachte ter beschikking wordt gesteld"  //7
// "geldboete van"  //10
// "geldigheid dagvaarding"  //13
// "geldigheid dagvaarding en bevoegdheid rechtbank"  //7
// "geldigheid van de dagvaarding"  //50
// "geldigheid van de inleidende dagvaarding"  //8
// "gemeenschappelijk hof van justitie"  //6
// "gemeente leiden"  //7
// "gemeente rotterdam"  //8
// "genoegzaamheid van het eab"  //7
// "gentimeerde"  //463
// "gentimeerde sub"  //182
// "gentimeerde sub en"  //14
// "gentimeerde sub wonende te woonplaats"  //6
// "gentimeerde wonende te woonplaats"  //82
// "gentimeerde wonende te woonplaats duitsland"  //7
// "gentimeerden"  //9
// "gerechtshof amsterdam"  //13
// "gerechtshof arnhemleeuwarden"  //58
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("gerechtshof den haag"));
// "gerechtshof sgravenhage"  //42
// "gerechtshof shertogenbosch"  //25
// "gerechtshof te sgravenhage"  //12
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geschil"));
// "geschil alsmede standpunten en conclusies van partijen"  //374
// "geschil de standpunten en conclusies van partijen"  //692
// "geschil en de procedure in eerste aanleg"  //7
// "geschil en standpunten"  //28
// "geschil en standpunten van partijen"  //73
// "geschil in conventie"  //208
// "geschil in conventie en in reconventie"  //38
// "geschil in conventie en reconventie"  //6
// "geschil in de hoofdzaak"  //47
// "geschil in de hoofdzaak en in het incident"  //6
// "geschil in de incidenten"  //7
// "geschil in de vrijwaringszaak"  //6
// "geschil in eerste aanleg"  //7
// "geschil in het incident"  //73
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CASE.matches("geschil in hoger beroep"));
// "geschil in hoger beroep en incidenteel hoger beroep"  //10
// "geschil in hoger beroep en standpunten en conclusies van partijen"  //12
// "geschil in hoger beroep en standpunten van partijen"  //113
// "geschil in hoger beroep na verwijzing"  //17
// "geschil in principaal en incidenteel hoger beroep"  //9
// "geschil in reconventie"  //177
// "geschil in voorwaardelijke reconventie"  //25
// "geschil na verwijzing"  //8
// "geschil na verwijzing en standpunten van partijen"  //35
// "geschil standpunten en conclusies"  //30
// "geschil standpunten en conclusies van partijen"  //24
// "geschillen"  //31
// "gevangenisstraf voor de duur van dagen"  //9
// "gevangenisstraf voor de duur van jaren"  //9
// "gevangenisstraf voor de duur van maanden"  //17
// "gevoerde verweren"  //17
// "gezag"  //8
// "gezagsuitoefening"  //14
// "grief i"  //6
// "grieven"  //131
// "griffierecht"  //11
// "gronden"  //14
// "gronden van de beslissing"  //44
// "grondslag en inhoud van het eab"  //190
// "grondslag van de vordering"  //15
// "grondslag van de vordering en het verweer"  //7
// "grondslag van het geschil"  //265
// "h"  //22
// "handelen in strijd met artikel eerste lid van de wet wapens en munitie"  //49
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("hd"));
// "heropening van het onderzoek"  //13
// "hetgeen de rechtbank bewezen acht"  //99
// "hof"  //26
// "hof wijst het beklag af"  //9
// "hoger beroep"  //656
// "hoofdzaak"  //17
// "identiteit van de opgeiste persoon"  //200
// "identiteit veroordeelde"  //6
// "ij"  //220
// "immaterile schadevergoeding"  //26
// "in aanmerking nemende dat"  //7
// "in beslag genomen goederen"  //24
// "in beslag genomen voorwerpen"  //34
// "in conventie"  //91
// "in conventie en in reconventie"  //45
// "in conventie en reconventie"  //9
// "in de hoofdzaak"  //37
// "in de zaak met nummer"  //8
// "in de zaak met parketnummer"  //10
// "in de zaak met zaaknummer"  //10
// "in elk geval zijnde telkens handelingen waarvan hij enof zijn mededaders"  //6
// "in het incident"  //12
// "in het principaal en incidenteel appel"  //8
// "in reconventie"  //92
// "inbeslaggenomen goederen"  //133
// "inbeslaggenomen voorwerpen"  //60
// "inboedel"  //6
// "incident tot tussenkomst"  //26
// "incident tot tussenkomst cq voeging"  //8
// "incident tot tussenkomst dan wel voeging"  //12
// "incident tot tussenkomst subsidiair voeging"  //6
// "incident tot voeging"  //7
// "ingangsdatum"  //28
// "inhoud van de tenlastelegging"  //596
// "inhoud van de vordering"  //14
// "inhoud van het bezwaarschrift"  //12
// "inhoud van het verzoek"  //16
// "inhoud van het verzoekschrift"  //9
// "inkoopadministratie"  //6
// "inleidende beschouwing"  //6
// "inleidende beschouwingen"  //8
// "inleidende klacht"  //7
// "inleidende opmerkingen"  //8
// "inleiding"  //480
// "inspecteur van de belastingdienstbelastingen kantoor te p verweerder"  //6
// "inspecteur van de belastingdienstte p verweerder"  //28
// "internationale kinderontvoering"  //49
// "inzake"  //6
// "j"  //11
// "jl"  //80
// "js"  //39
// "juridisch kader"  //16
// "jurisprudentie"  //12
// "k"  //7
// "kantonrechter"  //11
// "kinderalimentatie"  //31
// "klaagster"  //11
// "klacht"  //53
// "klacht en het verweer"  //9
// "klacht en het verweer daartegen"  //14
// "klager"  //18
// "komen overeen dat"  //6
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("kosten"));
// "kosten en griffierecht"  //12
// "kostenveroordeling"  //13
// "kwalificatie"  //291
// "kwalificatie en strafbaarheid van de feiten"  //127
// "kwalificatie en strafbaarheid van het bewezenverklaarde"  //44
// "kwalificatie en strafbaarheid van het feit"  //122
// "kwalificatie van het bewezen verklaarde"  //8
// "kwalificatie van het bewezenverklaarde"  //559
// "kwalificaties"  //99
// "l"  //12
// "legt op de volgende straffen"  //7
// "lid onder"  //9
// "literatuur"  //9
// "loop van het geding"  //67
// "loop van het geding in hoger beroep"  //392
// "loop van het geding na verwijzing"  //11
// "m"  //10
// "maatregel"  //8
// "maatregel van schadevergoeding van eur subsidiair dagen hechtenis"  //22
// "maatregel van schadevergoeding van subsidiair dagen hechtenis"  //33
// "machtiging tot uithuisplaatsing"  //13
// "machtiging tot uithuisplaatsing in een accommodatie voor gesloten jeugdzorg"  //6
// "man"  //6
// "medeplegen"  //7
// "medeplegen en medeplichtigheid"  //6
// "medeplegen van doodslag"  //8
// "medeplegen van oplichting meermalen gepleegd"  //9
// "medeplegen van poging tot zware mishandeling"  //8
// "meer subsidiair"  //16
// "meest subsidiair"  //7
// "mensenhandel"  //12
// "mensenhandel meermalen gepleegd"  //7
// "met betrekking tot de grieven"  //18
// "met betrekking tot feit"  //17
// "michael david ilhan van waveren"  //6
// "middel"  //49
// "middel van de benadeelde partij"  //6
// "minister van onderwijs cultuur en wetenschap verweerder"  //6
// "mishandeling"  //41
// "mishandeling meermalen gepleegd"  //8
// "mishandeling terwijl het feit zwaar lichamelijk letsel ten gevolge heeft"  //6
// "mk"  //122
// "moeder"  //11
// "mondelinge behandeling van het wrakingsverzoek"  //103
// "motivering"  //46
// "motivering van de sancties"  //6
// "mr rlh ijzerman"  //7
// "n"  //6
// "naam"  //215
// "naam betrokkene hierna betrokkene"  //7
// "naam eiser"  //15
// "naam gedaagde"  //23
// "naam van de verdachte"  //15
// "naam verdachte"  //47
// "naam verzoeker"  //13
// "naam wonende te woonplaats"  //16
// "naamloze vennootschap"  //9
// "naamloze vennootschap sns bank nv gevestigd te utrecht"  //6
// "nadere bewijsoverweging"  //73
// "nadere feiten"  //6
// "naheffingsaanslag beschikking bezwaar en geding in eerste aanleg"  //8
// "naheffingsaanslag bezwaar en geding in eerste aanleg"  //8
// "naheffingsaanslag boetebeschikking bezwaar en geding in eerste aanleg"  //6
// "naheffingsaanslagen beschikkingen bezwaar en geding in eerste aanleg"  //7
// "navorderingsaanslag beschikking bezwaar en geding in eerste aanleg"  //6
// "navorderingsaanslagen beschikkingen bezwaar en geding in eerste aanleg"  //9
// "navorderingsaanslagen kwijtscheldingsbesluiten boetebeschikkingen en bezwaar"  //38
// "nk"  //253
// "noot verbalisanten"  //18
// "ntfr"  //6
// "nw"  //41
// "officier van justitie"  //10
// "officier van justitie bij het arrondissementsparket oostnederland"  //8
// "officier van justitie heeft aangevoerd verkort en zakelijk weergegeven"  //34
// "omschrijving geschil en standpunten van partijen"  //28
// "omschrijving geschil in hoger beroep en standpunten van partijen"  //287
// "omschrijving van het geschil"  //8
// "omschrijving verzoek"  //12
// "omvang hoger beroep"  //7
// "omvang van het appel"  //7
// "omvang van het geschil"  //333
// "omvang van het geschil in hoger beroep"  //6
// "omvang van het hoger beroep"  //51
// "onder parketnummer"  //7
// "ondergetekenden"  //10
// "onderlinge waarborgmaatschappij"  //6
// "ondertoezichtstelling"  //9
// "onderzoek"  //10
// "onderzoek op de terechtzitting"  //643
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("onderzoek ter terechtzitting"));
// "onderzoek ter zitting"  //7
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("onderzoek van de zaak"));
// "onderzoek wagner"  //10
// "onrechtmatigheid ontruiming"  //6
// "onschuldverweer"  //21
// "ontbinding"  //7
// "onttrekking aan het verkeer"  //18
// "onttrekking aan het verkeer van de inbeslaggenomen goederen te weten"  //6
// "ontvankelijkheid"  //125
// "ontvankelijkheid in hoger beroep"  //7
// "ontvankelijkheid officier van justitie"  //14
// "ontvankelijkheid openbaar ministerie"  //30
// "ontvankelijkheid van de officier van justitie"  //73
// "ontvankelijkheid van de verdachte in het hoger beroep"  //12
// "ontvankelijkheid van het beroep"  //9
// "ontvankelijkheid van het cassatieberoep"  //32
// "ontvankelijkheid van het hoger beroep"  //167
// "ontvankelijkheid van het ingestelde hoger beroep"  //8
// "ontvankelijkheid van het openbaar ministerie"  //174
// "ontvankelijkheid van het openbaar ministerie in de strafvervolging"  //6
// "ontvankelijkheid van het openbaar ministerie in de vervolging"  //20
// "ontvankelijkheid van het openbaar ministerie in zijn vervolging"  //6
// "ontvankelijkheid van het verzet"  //13
// "ontvankelijkheid van het verzoek"  //40
// "ontvankelijkheid van het wrakingsverzoek"  //6
// "ontvankelijkheid van klager in het hoger beroep"  //7
// "oordeel"  //8
// "oordeel hof"  //6
// ""  //8
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("oordeel van het hof"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.JUDGMENT.matches("oordeel van de kantonrechter"));
// ""  //23
// "op te leggen maatregel"  //9
// "op te leggen straf"  //18
// "op te leggen straf of maatregel"  //430
// "openbaar ministerie"  //7
// "openlijk in vereniging geweld plegen tegen personen"  //31
// "oplegging van de maatregel"  //8
// "oplegging van een maatregel"  //6
// "oplegging van maatregel"  //6
// "oplegging van straf"  //551
// "oplegging van straf en maatregel"  //97
// "oplegging van straf en maatregelen"  //8
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("oplegging van straf enof maatregel"));
// "oplegging van straf of maatregel"  //60
// "oplegging van straffen"  //66
// "oplegging van straffen en maatregel"  //18
// "oplichting"  //7
// "oplichting meermalen gepleegd"  //9
// "opmerking vooraf"  //6
// "overig"  //12
// "overige verweren"  //13
// "overtreding van artikel eerste lid van de wegenverkeerswet"  //11
// "overtreding van artikel van de wegenverkeerswet"  //20
// "overweegt"  //29
// "overwegende dat"  //7
// "overweging"  //17
// "overweging met betrekking tot het bewijs"  //173
// "overweging met betrekking tot het bewijs van feit"  //11
// "overweging omtrent het bewijs"  //6
// "overweging van de rechtbank"  //6
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("overwegingen"));
// "overwegingen ten aanzien van straf enof maatregel"  //7
// "overzicht"  //60
// "p verweerder"  //14
// "parketnummer"  //82
// "partile nietontvankelijkheid van het openbaar ministerie in de vervolging"  //8
// "partile vrijspraak"  //16
// "partneralimentatie"  //33
// "pleegouders"  //7
// "poging tot doodslag"  //35
// "poging tot doodslag meermalen gepleegd"  //6
// "poging tot moord"  //8
// "poging tot zware mishandeling"  //22
// "prejudicile procedure"  //20
// "prejudicile vraag"  //7
// "prejudicile vragen"  //9
// "primair"  //54
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("procedure"));
// "procedure in conventie en in reconventie"  //10
// "procedure in de hoofdzaak"  //53
// "procedure in de vrijwaringszaak"  //43
// "procedure in de zaak"  //49
// "procedure in eerste aanleg"  //24
// "procedure in hoger beroep"  //7
// "procedures"  //10
// "procesgang"  //8
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("proceskosten"));
// "proceskosten en griffierecht"  //264
// "proceskosten en griffierechten"  //29
// "proceskosten en schadevergoeding"  //11
// "proceskostenvergoeding"  //6
// "proceskostenveroordeling"  //26
// "processtukken"  //6
// "procesverbaal van de mondelinge uitspraak van de enkelvoudige kamer van"  //29
// "procesverbaal van de mondelinge uitspraak van de enkelvoudige kamer van november in de zaak tussen"  //8
// "procesverbaal van de mondelinge uitspraak van de enkelvoudige kamer van oktober in de zaak tussen"  //6
// "procesverbaal van de mondelinge uitspraak van de voorzieningenrechter op"  //6
// "procesverloop"  //87
// "procureurgeneraal bij de hoge raad der nederlanden"  //16
// "qh"  //156
// "raadsman"  //6
// "rb"  //78
// "reactie van de kantonrechter"  //6
// "reactie van de officier van justitie"  //7
// "reactie van de rechter"  //56
// "reactie van de rechters"  //24
// "reactie van het openbaar ministerie"  //7
// "recapitulatie"  //8
// "rechtbank"  //169
// "rechtbank amsterdam"  //82
// "rechtbank amsterdamkort geding"  //9
// "rechtbank den haag"  //88
// "rechtbank gelderland"  //278
// "rechtbank haarlem"  //6
// "rechtbank leeuwarden"  //13
// "rechtbank limburg"  //97
// "rechtbank middennederland"  //73
// "rechtbank noordholland"  //120
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("rechtbank noordnederland"));
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("rechtbank oostbrabant"));
// "rechtbank overijssel"  //242
// "rechtbank overweegt als volgt"  //13
// "rechtbank overweegt het volgende"  //7
// "rechtbank rechtdoende"  //6
// "rechtbank rotterdam"  //17
// "rechtbank zeelandwestbrabant"  //24
// "rechtdoende"  //17
// "rechthebbende"  //14
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("rechtsmiddel"));//TODO
// "rechtsmiddel tegen deze uitspraak kan binnen vier weken na de dag van verzending daarvan hoger beroep worden ingesteld bij de afdeling bestuursrechtspraak van de raad van state"  //12
// "rechtsmiddel tegen deze uitspraak kan binnen zes weken na de dag van verzending daarvan hoger beroep worden ingesteld bij de centrale raad van beroep"  //6
// "rechtsmiddel tegen deze uitspraak staat geen rechtsmiddel open"  //7
// "recidivegevaar"  //6
// "redelijke termijn"  //6
// "redengeving bewezenverklaring"  //74
// "regelgeving"  //6
// "regelgeving wetsgeschiedenis jurisprudentie en literatuur"  //10
// "relevante regelgeving"  //14
// "relevante teksten en toelichtingen van de gn"  //7
// "relevante wet en regelgeving"  //8
// "relevante wetgeving"  //8
// "relevante wettelijke bepalingen"  //14
// "rg"  //16
// "rh"  //35
// "rk"  //52
// "rol van de verdachte"  //8
// "samenstelling raadkamer en uitspraakdatum"  //25
// "samenstelling rechtbank en uitspraakdatum"  //6
// "schade van benadeelde"  //10
// "schade van benadeelden"  //227
// "schadevergoeding"  //72
// "schadevergoeding nabestaande"  //6
// "schadevergoedingsmaatregel"  //81
// "schadevergoedingsmaatregel benadeelde"  //13
// "schadevergoedingsmaatregel minderjarige zaak"  //10
// "schatting van de hoogte van het wederrechtelijk verkregen voordeel"  //10
// "schatting van het wederrechtelijk verkregen voordeel"  //26
// "scheiding"  //15
// "schorsing vervolging"  //8
// "schriftelijke ronde standpunten vorderingen schadevergoeding"  //6
// "situatie zonder ongeval"  //6
// "slachtoffer"  //29
// "spoedeisend belang"  //11
// "staat der nederlanden"  //15
// "staat der nederlanden ministerie van financin"  //7
// "staat der nederlanden ministerie van veiligheid en justitie"  //35
// "staatssecretaris van veiligheid en justitie verweerder"  //6
// "standpunt officier van justitie"  //7
// "standpunt van a"  //16
// "standpunt van appellante"  //11
// "standpunt van belanghebbende"  //12
// "standpunt van belanghebbenden"  //29
// "standpunt van de advocaatgeneraal"  //16
// "standpunt van de gemeente"  //7
// "standpunt van de gerechtsdeurwaarder"  //47
// "standpunt van de gerechtsdeurwaarders"  //8
// "standpunt van de gewraakte rechter"  //8
// "standpunt van de gewraakte rechters"  //9
// "standpunt van de ind en van de officier van justitie"  //18
// "standpunt van de inrichting"  //14
// "standpunt van de kandidaatnotaris"  //8
// "standpunt van de kantonrechter"  //41
// "standpunt van de kbvg"  //21
// "standpunt van de kinderrechter"  //9
// "standpunt van de moeder"  //6
// "standpunt van de notaris"  //127
// "standpunt van de notarissen"  //19
// "standpunt van de officier van justitie"  //203
// "standpunt van de oudnotaris"  //19
// "standpunt van de raadsman"  //12
// "standpunt van de rechter"  //105
// "standpunt van de rechtercommissaris"  //10
// "standpunt van de rechters"  //13
// "standpunt van de reclassering"  //13
// "standpunt van de toegevoegd kandidaatgerechtsdeurwaarder"  //15
// "standpunt van de verdediging"  //381
// "standpunt van eiser"  //19
// "standpunt van eiseres"  //9
// "standpunt van eisers"  //7
// "standpunt van gedaagde"  //26
// "standpunt van het bft"  //9
// "standpunt van het openbaar ministerie"  //246
// "standpunt van klaagster"  //71
// "standpunt van klager"  //86
// "standpunt van klagers"  //43
// "standpunt van partijen"  //16
// "standpunt van verzoeker"  //167
// "standpunt van verzoekers"  //9
// "standpunt van verzoekster"  //29
// "standpunt verdediging"  //16
// "standpunten"  //113
// "standpunten dexia"  //11
// "standpunten partijen"  //10
// "standpunten van de officier van justitie en de verdediging"  //28
// "standpunten van partijen"  //489
// "standpunten van partijen in conventie en in reconventie"  //9
// "standpunten van partijen in hoger beroep"  //67
// "stellingen van partijen"  //22
// "stelt als algemene voorwaarden dat de veroordeelde"  //16
// "stelt als bijzondere voorwaarden"  //10
// "stelt als bijzondere voorwaarden dat"  //7
// "stelt als bijzondere voorwaarden dat de veroordeelde"  //16
// "stichting"  //6
// "stichting bureau jeugdzorg friesland"  //9
// "stichting pensioenfonds metaal en techniek"  //6
// "stichting william schrikker jeugdbescherming en jeugdreclassering"  //7
// "straf"  //68
// "straf enof de maatregel"  //29
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid feit"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van de dader"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van de feiten en van verdachte"));
// "strafbaarheid feit"  //44
// "strafbaarheid feiten"  //42
// "strafbaarheid feiten vermeld op bijlage bij de olw"  //16
// "strafbaarheid van de dader"  //6
// "strafbaarheid van de feiten"  //556
// "strafbaarheid van de feiten en van verdachte"  //10
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van de verdachte"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van het bewezen verklaarde"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van het bewezenverklaarde"));
// "strafbaarheid van het bewezenverklaarde en de kwalificatie"  //243
// "strafbaarheid van het bewezenverklaarde en van de verdachte"  //20
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van het feit"));
// "strafbaarheid van het feit en van verdachte"  //8
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van verdachte"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid van het feit en van verdachte"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafbaarheid verdachte"));
// "strafbaarheid verdachte"  //91
// "strafmaatregel"  //47
        assertTrue(TitlePatterns.TitlesNormalizedMatchesLowConf.PUNISHMENT.matches("strafoplegging"));
// "stukken"  //41
// "stukken van het geding"  //309
// "subsidiair"  //60
// "taakstraf bestaande uit het verrichten van uren onbetaalde arbeid"  //8
// "tav feit"  //28
// "tav feit maatregel van schadevergoeding van subsidiair dagen hechtenis"  //7
// "tav feit subsidiair"  //9
// "tav parketnummer"  //33
// "tegen deze uitspraak staat geen rechtsmiddel open"  //19
// "tegenwoordig"  //7
// "tekst gewijzigde tenlastelegging"  //24
// "tekst tenlastelegging"  //53
// "ten aanzien van de benadeelde partij"  //32
// "ten aanzien van de benadeelde partij en de schadevergoedingsmaatregel"  //232
// "ten aanzien van de benadeelde partijen en de schadevergoedingsmaatregel"  //23
// "ten aanzien van de feiten"  //63
// "ten aanzien van de ontvankelijkheid"  //6
// "ten aanzien van de tenlastelegging"  //11
// "ten aanzien van feit"  //63
// "ten aanzien van feit van"  //9
// "ten aanzien van het onder ten laste gelegde"  //8
// "ten aanzien van parketnummer"  //15
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("tenlastelegging"));//TODO
// "tenlastelegging aan de verdachte is na wijziging van de tenlastelegging ter terechtzitting ten laste gelegd dat"  //7
// "tenlastelegging aan de verdachte is ten laste gelegd dat"  //33
// "tenlastelegging aan verdachte is ten laste gelegd dat"  //7
// "tenlasteleggingen"  //67
// "tenuitvoerlegging voorwaardelijke veroordeling"  //77
// "tenuitvoerlegging voorwaardelijke veroordelingen"  //7
// "ter beschikking gestelde heeft verklaard kort en zakelijk weergegeven"  //15
// "ter zake het verzoekschrift ex artikel a sv"  //9
// "ter zake het verzoekschrift ex artikel sv"  //9
// "terbeschikkinggestelde"  //215
// "terbeschikkinggestelde heeft verklaard kort en zakelijk weergegeven"  //24
// "terbeschikkinggestelde heeft verklaard verkort en zakelijk weergegeven"  //10
// "terechtzitting"  //73
// "teruggave"  //7
// "tm"  //143
// "toegepaste wetsartikelen"  //27
// "toegepaste wettelijke bepalingen"  //581
// "toegepaste wettelijke voorschriften"  //465
// "toelichting"  //7
// "toepasselijk recht"  //16
// "toepasselijk wettelijk voorschrift"  //21
// "toepasselijke recht"  //11
// "toepasselijke regelgeving"  //7
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("toepasselijke wetsartikelen"));
// "toepasselijke wetsbepalingen"  //90
// "toepasselijke wettelijke bepaling"  //15
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("toepasselijke wettelijke voorschriften"));  //2555
// "toepasselijkheid wettelijke voorschriften"  //150
// "toepassing van de wetsartikelen"  //8
// "toepassing van wetsartikelen"  //502
// "totaal wederrechtelijk verkregen voordeel"  //6
// "tussen partijen vaststaande feiten"  //263
// "tussenarrest van de meervoudige kamer voor strafzaken"  //14
// "tussenarrest van december"  //9
// "tussenarrest van februari"  //7
// "tussenarrest van januari"  //6
// "tussenarrest van juli"  //11
// "tussenarrest van juni"  //6
// "tussenarrest van november"  //8
// "tussenarrest van oktober"  //9
// "tussenarrest van september"  //15
// "tweede geding in cassatie"  //117
// "tweede middel"  //71
// "tweede middelfaalt"  //6
// "uitgangspunten"  //113
// "uitgangspunten in cassatie"  //136
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("uitspraak"));  //3002 // TODO?
// "uitspraak dd april"  //25
// "uitspraak dd augustus"  //24
// "uitspraak dd december"  //27
// "uitspraak dd februari"  //15
// "uitspraak dd januari"  //17
// "uitspraak dd juli"  //37
// "uitspraak dd juni"  //38
// "uitspraak dd maart"  //27
// "uitspraak dd mei"  //31
// "uitspraak dd november"  //16
// "uitspraak dd oktober"  //31
// "uitspraak dd september"  //24
// "uitspraak van april"  //82
// "uitspraak van augustus"  //12
// "uitspraak van de accountantskamer"  //82
// "uitspraak van de enkelvoudige kamer in de zaak tussen"  //41
// "uitspraak van de enkelvoudige kamer in het geschil tussen"  //11
// "uitspraak van de rechtbank"  //188
// "uitspraak van de rechtbank luidt"  //254
// "uitspraak van de rechtbank luidt rechtdoende"  //74
// "uitspraak van de voorzieningenrechter in de zaak tussen"  //12
// "uitspraak van december"  //11
// "uitspraak van februari"  //10
// "uitspraak van januari"  //25
// "uitspraak van juli"  //22
// "uitspraak van juni"  //33
// "uitspraak van maart"  //23
// "uitspraak van mei"  //21
// "uitspraak van november"  //11
// "uitspraak van oktober"  //14
// "uitspraak waarvan herziening is gevraagd"  //79
// "uitspraken van de rechtbank"  //9
// "um"  //103
// "vader"  //14
// "valsheid in geschrift meermalen gepleegd"  //10
// "van het plegen van witwassen een gewoonte maken"  //7
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.FACTS.matches("vaststaande feiten"));  //3357
// "vaststaande feiten en de procedure in eerste aanleg"  //13
// "vaststaande feiten in beide zaken"  //6
// "vaststaande feiten in conventie en in reconventie"  //7
// "vaststelling feiten"  //13
// "vaststelling van het wederrechtelijk verkregen voordeel"  //25
// "vennootschap onder firma"  //9
// "verbeurdverklaring"  //13
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("verdachte"));  //3315
// "verdediging"  //12
// "verder verloop van de procedure"  //29
// "verder verloop van het geding"  //45
// "verder verloop van het geding in hoger beroep"  //10
// "verdere beoordeling"  //9
// "verdere beoordeling van het hoger beroep"  //22
// "verdere feiten"  //13
// "verdere geding"  //24
// "verdere geding in hoger beroep"  //27
// "verdere loop van de procedure"  //8
// "verdere loop van het geding"  //30
// "verdere loop van het geding in hoger beroep"  //21
// "verdere procedure"  //72
// "verdere verloop van de procedure"  //260
// "verdere verloop van de procedure in hoger beroep"  //8
// "verdere verloop van het geding"  //134
// "verdere verloop van het geding in cassatie"  //6
// "verdere verloop van het geding in hoger beroep"  //674
// "verduistering meermalen gepleegd"  //8
// "verklaring rechtsvermoeden van overlijden"  //8
// "verklaring van verdachte ter terechtzitting van juni"  //22
// "verkort arrest van de economische kamer"  //21
// "verkort arrest van de meervoudige kamer voor strafzaken"  //308
// "verkort vonnis"  //61
// "verkrachting"  //8
// "verlenging ondertoezichtstelling en verlenging machtiging tot uithuisplaatsing"  //20
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.PROCEEDINGS.matches("verloop van de procedure"));  //1631
// "verloop van de procedure blijkt uit"  //10
// "verloop van de procedure in hoger beroep"  //8
// "verloop van de procedures"  //7
// "verloop van het geding"  //584
// "verloop van het geding in hoger beroep"  //116
// "verloop van het onderzoek"  //6
// "verloop van het proces"  //30
// "vermeerdering van eis"  //17
// "vermogensmaatregel"  //11
// "vernietigt het vonnis waarvan beroep en doet opnieuw recht"  //30
// "veroordeelde"  //90
// "veroordeelt de verdachte tot een gevangenisstraf voor de duur van"  //24
// "veroordeelt de verdachte tot een gevangenisstraf voor de duur van maanden"  //8
// "veroordeelt de verdachte tot een gevangenisstraf voor de duur van n dag"  //7
// "veroordeelt de verdachte tot een gevangenisstraf voor de duur van n jaar"  //6
// "veroordeelt de verdachte tot een gevangenisstraf voor de duur van n week"  //7
// "verordening"  //20
// "verordeningen"  //6
// "verplichting tot betaling"  //7
// "verplichting tot betaling aan de staat"  //30
// "verschenen"  //7
// "verslag van de advocaatgeneraal"  //20
// "vervolg van de procedure"  //6
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("verweer"));  //701//TODO
// "verweer en het tegenverzoek"  //10
// "verweer en zelfstandig verzoek"  //11
// "verweer in conventie"  //43
// "verweer in reconventie"  //43
// "verweer op het zelfstandig verzoek"  //13
// "verweer tevens zelfstandig verzoek"  //13
// "verweer van de gerechtsdeurwaarder"  //12
// "verweer van gedaagde"  //9
// "verweerder"  //88
// "verweerster"  //42
// "verweren"  //26
// "verweren strekkende tot bewijsuitsluiting"  //7
// "verweren van de verdediging"  //6
// "verwijzingsarrest"  //12
// "verwijzingsopdracht"  //37
// "verzet"  //9
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("verzoek"));  //840//TODO
// "verzoek en de grondslag daarvan"  //25
// "verzoek en het standpunt van de ind"  //8
// "verzoek en het verweer"  //230
// "verzoek en het verweer daartegen"  //95
// "verzoek en verweer"  //228
// "verzoek tot uitlevering"  //6
// "verzoek tot verbetering"  //13
// "verzoeken"  //27
// "verzoeker"  //166
// "verzoeker en verzoekster"  //8
// "verzoeker hierna te noemen verzoeker"  //6
// "verzoeker sub"  //12
// "verzoekers"  //6
// "verzoekster"  //79
// "verzonden dd"  //6
// "vierde middel"  //18
// "vijfde middel"  //7
// "vof vof gevestigd te vestigingsplaats"  //6
// "voldoening op aangifte bezwaar en beroep"  //10
// "vonnis"  //238
// "vonnis in de hoofdzaak"  //6
// "vonnis in de strafzaak van"  //104
// "vonnis in de zaak van"  //40
// "vonnis in het kort geding van"  //10
// "vonnis in kort geding in de zaak van"  //6
// "vonnis in kort geding van de kantonrechter"  //12
// "vonnis van de kantonrechter"  //97
// "vonnis van de kantonrechter in kort geding"  //16
// "vonnis van de kantonrechter van juli"  //7
// "vonnis van oktober"  //7
// "vonnis waartegen het hoger beroep is gericht"  //10
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("vonnis waarvan beroep"));  //1188//TODO
// "voor een proceskostenveroordeling bestaat geen aanleiding"  //17
// "vooraf"  //8
// "voorbedachte raad"  //8
// "voorgeschiedenis"  //27
// "voorhanden stukken"  //15
// "voorlopige hechtenis"  //46
// "voortgang van de behandeling van de zaak"  //7
// "voortgezette handeling van"  //8
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("voorvragen"));  //3060//TODO
// "voorwaardelijk verzoek"  //9
// "voorwaardelijke incidentele beroep"  //9
// "voorwaardelijke verzoeken"  //7
// "vordering"  //645
// "vordering benadeelde partij"  //53
// "vordering benadeelde partij en schadevergoedingsmaatregel"  //66
// "vordering benadeelde partij schadevergoedingsmaatregel"  //12
// "vordering en de grondslag daarvan"  //11
// "vordering en de standpunten van partijen"  //28
// "vordering en het geschil"  //15
// "vordering en het verweer"  //173
// "vordering en het verweer in conventie"  //24
// "vordering en het verweer in het incident"  //11
// "vordering en het verweer in reconventie"  //18
// "vordering en het verweer samengevat en zakelijk weergegeven"  //8
// "vordering en verweer"  //111
// "vordering en verweer in conventie"  //19
// "vordering en verweer in reconventie"  //13
// "vordering grondslag en verweer"  //7
// "vordering herroeping voorwaardelijke invrijheidstelling"  //9
// "vordering in conventie"  //98
// "vordering in de hoofdzaak"  //41
// "vordering in het incident"  //30
// "vordering in reconventie"  //80
// "vordering in voorwaardelijke reconventie"  //16
// "vordering na voorwaardelijke veroordeling"  //97
// "vordering officier van justitie"  //311
// "vordering tenuitvoerlegging"  //177
// "vordering tenuitvoerlegging voorwaardelijke veroordeling"  //12
// "vordering tot herroeping van de voorwaardelijke invrijheidsstelling"  //7
// "vordering tot herroeping van de voorwaardelijke invrijheidstelling"  //12
// "vordering tot opheffing van de schorsing van de voorlopige hechtenis"  //10
// "vordering tot schadevergoeding benadeelde partij"  //19
// "vordering tot tenuitvoerlegging"  //81
// "vordering tot tenuitvoerlegging in de zaak met parketnummer"  //6
// "vordering van benadeelde partij slachtoffer"  //14
// "vordering van de advocaatgeneraal"  //33
// "vordering van de benadeelde partij"  //187
// "vordering van de benadeelde partij aangeefster"  //32
// "vordering van de benadeelde partij aangever"  //36
// "vordering van de benadeelde partij bedrijf"  //7
// "vordering van de benadeelde partij benadeelde"  //522
// "vordering van de benadeelde partij benadeelde partij"  //300
// "vordering van de benadeelde partij betrokkene"  //25
// "vordering van de benadeelde partij bp bedrijf"  //6
// "vordering van de benadeelde partij de schadevergoedingsmaatregel"  //108
// "vordering van de benadeelde partij en de schadevergoedingsmaatregel"  //12
// "vordering van de benadeelde partij mbt het onder bewezen verklaarde"  //27
// "vordering van de benadeelde partij museum catharijneconvent"  //8
// "vordering van de benadeelde partij persoon"  //16
// "vordering van de benadeelde partij slachtoffer"  //675
// "vordering van de benadeelde partij slachtoffer feit"  //19
// "vordering van de benadeelde partij slachtoffer nummer"  //11
// "vordering van de benadeelde partij verbalisant"  //16
// "vordering van de benadeelde partijbenadeelde"  //18
// "vordering van de benadeelde partijen"  //15
// "vordering van de benadeelde partijslachtoffer"  //27
// "vordering van de officier van justitie"  //691
// "vordering van de procureurgeneraal"  //6
// "vordering van het openbaar ministerie"  //90
// "vorderingen"  //57
// "vorderingen benadeelde partijen"  //35
// "vorderingen en grondslagen in de hoofdzaak"  //12
// "vorderingen en het verweer"  //8
// "vorderingen na voorwaardelijke veroordeling"  //11
// "vorderingen tenuitvoerlegging"  //7
// "vorderingen tot tenuitvoerlegging"  //13
// "vorderingen van de benadeelde partijen"  //82
// "vorderingen van de benadeelde partijen de schadevergoedingsmaatregel"  //11
// "vorderingen van de benadeelde partijen en de schadevergoedingsmaatregel"  //13
// "vraagstelling"  //7
// "vragen van uitleg"  //7
// "vrijspraak"  //639
// "vrijspraak feit"  //34
// "vrijspraak feit primair"  //7
// "vrijspraak ten aanzien van feit"  //12
// "vrijspraak ten aanzien van feit slachtoffer"  //7
// "vrijspraak van feit"  //6
// "vrijspraak van het onder ten laste gelegde"  //6
// "vrijspraak van het primair ten laste gelegde"  //7
// "vrijspraken"  //24
// "vrouw"  //7
// "waardering bewijs"  //6
// "waardering van de bewijsmiddelen"  //8
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("waardering van het bewijs"));  //1032
// "waardering van het bewijs ten aanzien van feit"  //9
// "waarvan het hof uitgaat"  //14
// "waarvan in hoger beroep moet worden uitgegaan"  //6
// "wao"  //9
// "wederrechtelijk verkregen voordeel"  //11
// "wederspannigheid"  //12
// "weigeringsgrond als bedoeld in artikel eerste lid aanhef en onder a olw"  //9
// "weigeringsgrond als bedoeld in artikel eerste lid onder a olw"  //19
// "weigeringsgrond als bedoeld in artikel eerste lid onder a van de olw"  //10
// "weigeringsgrond als bedoeld in artikel olw"  //22
// "werknemer"  //9
// "wet en regelgeving"  //7
// "wetgeving jurisprudentie en literatuur"  //8
// "wetgeving wetsgeschiedenis jurisprudentie en literatuur"  //8
// "wettelijk kader"  //52
// "wettelijk kader en wetsgeschiedenis"  //6
// "wettelijke rente"  //7
//assertTrue(NamePatterns.OnNormalizedText.ROLE_UNKOWN.find("wettelijke voorschriften"));  //795//TODO
// "wia"  //27
// "wijziging van eis"  //22
// "wijziging van omstandigheden"  //14
// "witwassen"  //9
// "wjm schram"  //6
// "wrakingskamer"  //16
// "wrakingsverzoek"  //208
// "wrakingsverzoek en het standpunt van de rechter"  //7
// "wrakingsverzoek en het verweer"  //12
// "ww"  //6
// "wwb"  //13
// "x"  //35
// "x bv gevestigd te z belanghebbende"  //9
// "x bv statutair gevestigd te z belanghebbende"  //18
// "x bv te z belanghebbende"  //33
// "x te z belanghebbende"  //361
// "x te z hierna belanghebbende"  //21
// "x wonende te z belanghebbende"  //25
// "x wonende te z eiser"  //6
// "x wonende te z eiser gemachtigde a"  //12
// "x wonende te z hierna belanghebbende"  //17
// "y"  //8
// "zitting"  //132
// "zitting hebben"  //13
// "zorgregeling"  //10
// "zw"  //21
// "zware mishandeling"  //7
    }

    @Test
    public void testConsiderations() {
        // overwegingen
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("achtergronden van de zaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("algemene bewijsoverwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("algemene overwegingen in alle zaken"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("ambtshalve beoordeling van de bestreden uitspraak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling door de rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling en de gronden daarvoor"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in beide zaken"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in conventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in conventie en in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in conventie en in voorwaardelijke reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in conventie en reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in de hoofdzaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in de incidenten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in de vrijwaringszaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in het incident"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in het incident en in de hoofdzaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in het incident ex art rv"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in het incident tot verzet tegen de eiswijziging"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in het principaal en incidenteel appel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling in voorwaardelijke reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de aanvraag"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de door belanghebbende voorgestelde middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de door de staatssecretaris voorgestelde middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de geschillen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de geschillen in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de grieven"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de grieven en de vordering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de gronden van het verzet"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de hoger beroepen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de in het incidentele beroep voorgestelde middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de in het principale beroep voorgestelde middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de incidentele vordering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de klacht"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de klachten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de middelen in het principale beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de middelen in het principale en in het incidentele beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de middelen voor het overige"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de namens de verdachte voorgestelde middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de ontvankelijkheid"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de ontvankelijkheid van het beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de ontvankelijkheid van het beroep in cassatie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de ontvankelijkheid van het verzoek tot herziening"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de overige middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de standpunten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de ten laste gelegde feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de verzoeken"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de vordering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de vorderingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van de zaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het achtste middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het beklag"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het beroep na verwijzing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het bezwaar"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het cassatieberoep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het cassatiemiddel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het derde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het door belanghebbende voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het door de staatssecretaris voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het eerste en het tweede middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het eerste het tweede en het derde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het eerste het tweede het derde en het vierde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het eerste middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het eerste namens de verdachte voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het geschil"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het geschil in conventie en in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het geschil in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het geschil vaststaande feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het geschil wijziging van eis"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep en het incidenteel hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep en het incidentele hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep in de zaak met zaaknummer"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep na verwijzing"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het hoger beroep zaaknummer"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het in het incidentele beroep voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het in het principale beroep voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het incident"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het incidentele beroep in cassatie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het middel in het incidentele beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het middel in het principale beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het namens de benadeelde partij voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het negende middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het principaal en incidenteel hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het principale en het incidentele hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het ten laste gelegde"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het tiende middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het tweede en het derde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het tweede middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het tweede namens de verdachte voorgestelde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het verzet"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het verzochte"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het verzoek"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het verzoek tot het vaststellen van een dwangakkoord"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het verzoek zaaknummer"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het vierde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het vijfde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het wrakingsverzoek"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het zesde middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling van het zevende middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beoordeling vaststaande feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beschouwing en beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beschouwing en beoordeling van de middelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("beschouwing en beoordeling van het middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijs en bewijsoverwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijsmiddelen en de beoordeling daarvan"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijsmotivering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijsoverwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijsoverwegingen met betrekking tot zaaksdossier adres"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bewijsoverwegingen ten aanzien van feit"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("bijzondere overwegingen omtrent het bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("feiten en achtergronden"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("geschil en beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("geschil en de beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("geschil en de beoordeling daarvan"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("geschil en de beoordeling in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("grieven en beoordeling in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("grieven en de beoordeling in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van het hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van het verzet"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van het verzoek"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van het wrakingsverzoek"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van het wrakingsverzoek en het standpunt van verzoeker"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("gronden van wraking"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("inhoudelijke beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("inleidende overwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering straf"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de bewezenverklaring"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de hoofdelijkheid"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de maatregel onttrekking aan het verkeer"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de sanctie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de sancties"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straf"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straf en maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straf en maatregelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straffen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straffen en maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de straffen en maatregelen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van de verbeurdverklaring"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering van straf of maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("motivering vrijspraak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("nadere beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("nadere beoordeling van het hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("nadere beoordeling van het middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("nadere bewijsmotivering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("nadere bewijsoverwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("op te leggen straf of maatregel en de gronden daarvoor"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen en oordeel van het hof"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen met betrekking tot het bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen omtrent het geschil"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen ten aanzien van het bewijs"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen ten aanzien van straf enof maatregel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen van de kantonrechter"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen van de rechtbank"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("overwegingen van het hof"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("rechtsoverwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("standpunten van partijen en de beoordeling daarvan"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("strafmotivering"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("tenlastelegging en motivering van de gegeven vrijspraak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("uitgangspunten voor de beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("vaststellingen en overwegingen"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling in conventie en in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling in de hoofdzaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling in reconventie"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling van de zaak"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling van het geschil"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling van het geschil in hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling van het hoger beroep"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling van het middel"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verdere beoordeling vaststaande feiten"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verzoek en de beoordeling"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verzoek en de beoordeling daarvan"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("verzoek en de gronden daarvan"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("vordering en beoordeling daarvan in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("vordering en beoordeling in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("vordering en de beoordeling in eerste aanleg"));
        assertTrue(TitlePatterns.TitlesNormalizedMatchesHighConf.CONSIDERATIONS.matches("vorderingen en beoordeling in eerste aanleg"));
    }

    @Test
    public void testTitleContains() {
        assertTrue(PreBlockQuotePattrns.Unnormalized.END_W_COLON.matches("vorderingen en beoordeling in eerste aanleg:"));
        assertFalse(PreBlockQuotePattrns.Unnormalized.END_W_COLON.matches("vorderingen en beoordeling in eerste aanleg"));
    }
}
