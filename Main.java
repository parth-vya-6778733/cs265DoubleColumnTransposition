

public class Main {

    public static void main(String[] args) throws Exception{
        String cipherText = "";
        String plainText = "";
//        String originaPlainText = "onceuponatimeinthelandoftheforgotten";
        String originaPlainText = "ingospeltruthitsbeenalwaystoldthatsacredlifeiscreatedbythechapelonceuponatimeinthelandoftheforgotten";
        String hint = "beenalwaystoldthatsacred";
        String key1 = "sore";
        String key2 = "water";
        String attackedText = "";
        String puzzleText1 = "ONAEHTISHLAEAILOHINEBLRFSDWAAAWDCAEUYAIHGINUMUBEOMEHELATWMHFFOHRSMORDSUEOERDTMOUESNNAIIDHRPLDTSRHAHIENTCAPEEWNHOROEFTTDSERNONAHERVLNOELAHSSAMTGUFEDDOTINNEIOOLTTIRMMWSCSISWOHISAVHRIMOHENTOISIETTENQUEREWYNIKYLEACLOYHTETATEOROOSUWTOOLAWMEGIOUDALEBNUFIHRBRBNNKLOHANRLEUSLNUTEOERSUIITHILATTETHOMIAFFIEDSIEEASSYITINAWMTEREAOCASTSNDYNCBEBBHBSSNDOAHWAFTTTMOSWITICETATTEOMBGNOSEMRHAFEEOWMPTSTFIGEEMMHLSSINETRRBTGEAOINTMNNUESOSRSEDNNYARPSNNUMEOINFEUIALHDRWARTWWRNLHSNEESHSOHYNEROHHTTEWEIREANALEFNPDEEDCHOEOOIOMTDCEITNIEAMNMISIOSRARRYMLO";
        String puzzleText2 = "UDUOSETINENATARLNRTEEDCEMWESCNERWHTIRTRCOIVEHRHEDSFFONDDSIDSHYHMSSIERSOLDTOHSSMLCOIMAINTRBITMTURWLIGOEHHHEOFMXOOPHWTRHFLFSSVHPLDEANCANREESOIIIOLONROEIGEOWSOIEDAOEETFESASWRIIOHLIWNTMTNSENHEBISFEEFOOSITFASBRTCNNOUDMNPEUAROTTPEEOEUOMLWIIOPMNMNIAESWYAETHBAEUITOSICCEGIIELIOUOFSCNNASRENOIUENAORHWAEOLFFNHUETMRTFAEBLAEKIAAAEENDNFLMIEEOASLEOAHIAKOUOYFRCSIHEEELLNEMTNSWFOTTNLYNDAOGESSTALYPIITNISFDSRBMSODVYAIEEDTADENECIACARHSATYHAHIIMEGGHOEOOGWEIHKHBECTETABRFRSSTASNSCANFBGDTNPIRNGRSEMCFYDTLISREOMKLHIELTOTFINIMIROEDNSESBULLNPDIIBEEDRAOTHHNEGEOBESIETTRGAHLUFEYGTAISDHOCUYTVEUEHAEAEEOUCSIEMOHEWTTSTOEAEDGIMHRDOEEAABBDLTAOOKNOFWYFENNSDRNMSTROONFTFWOEORKOUREDSTCHTCRUA";
        String puzzleHint = "FINDSHIMSELFMASTEROFHISOWNESTABLISHMENTWERESUFFICIENTTOABSORBALLMYATTENTIONWHILEHOLMESWHOLOATHEDEVERYFORMOFSOCIETYWITHHISWHOLEBOHEMIANSOULREMAINEDINOURLODGINGSINBAKERSTREETBURIEDAMONGHISOLDBOOKS";
        int puzzlekey1Length = 13;
        int puzzlekey2Length = 16;
        int testKey1 = key1.length();
        int testKey2 = key2.length();
        Encryptor e = new Encryptor();
        Decryptor d = new Decryptor();
        Attacker a = new Attacker();

//      First we encode
        System.out.println("\n");
        cipherText = e.createCipher(originaPlainText,key1,key2);
        System.out.println("\n");
        System.out.println("Your Plain text was: " + originaPlainText);
        System.out.println("\n");
        System.out.println("Your first key is: " + key1);
        System.out.println("\n");
        System.out.println("Your second key is: " + key2);
        System.out.println("\n");
        System.out.println("Your Ciphered text is: " + cipherText);
        System.out.println("\n");

//      Then we decode
        plainText = d.deCipher(cipherText,key1,key2);
        System.out.println("Your Cipher text was: " + cipherText);
        System.out.println("\n");
        System.out.println("Your Plain text is: " + plainText);
        System.out.println("\n");


//        And now we attack! This is the puzzle cipher text, which runs out of memory DCT Part 2 since we use hint text
//        System.out.println("\n");
//        System.out.println("Initiate Attack: ");
//        attackedText = a.attackCipher(puzzleText2.toLowerCase(),puzzlekey1Length,puzzlekey2Length,puzzleHint.toLowerCase());
//        System.out.println(attackedText);
//
//        //And now we attack! This is a test attack with smaller keys and a hint text.
            System.out.println("\n");
            System.out.println("Initiate Attack: ");
            attackedText = a.attackCipher(cipherText,testKey1,testKey2,hint);
            System.out.println(attackedText);



    }




}
