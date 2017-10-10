import org.paukov.combinatorics3.PermutationGenerator;
import org.paukov.combinatorics3.Generator;
import java.util.stream.Collectors;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String cipherText = "";
        String plainText = "";
        String originaPlainText = "onceuponatimeinthelandoftheforgotten";
        String testHint = "onceuponatimeinthelandoftheforgotten";
        String puzzleText = "ONAEHTISHLAEAILOHINEBLRFSDWAAAWDCAEUYAIHGINUMUBEOMEHELATWMHFFOHRSMORDSUEOERDTMOUESNNAIIDHRPLDTSRHAHIENTCAPEEWNHOROEFTTDSERNONAHERVLNOELAHSSAMTGUFEDDOTINNEIOOLTTIRMMWSCSISWOHISAVHRIMOHENTOISIETTENQUEREWYNIKYLEACLOYHTETATEOROOSUWTOOLAWMEGIOUDALEBNUFIHRBRBNNKLOHANRLEUSLNUTEOERSUIITHILATTETHOMIAFFIEDSIEEASSYITINAWMTEREAOCASTSNDYNCBEBBHBSSNDOAHWAFTTTMOSWITICETATTEOMBGNOSEMRHAFEEOWMPTSTFIGEEMMHLSSINETRRBTGEAOINTMNNUESOSRSEDNNYARPSNNUMEOINFEUIALHDRWARTWWRNLHSNEESHSOHYNEROHHTTEWEIREANALEFNPDEEDCHOEOOIOMTDCEITNIEAMNMISIOSRARRYMLO";
        String key1 = "journey";
        String key2 = "wonder";
        String puzzleText2 = "UDUOSETINENATARLNRTEEDCEMWESCNERWHTIRTRCOIVEHRHEDSFFONDDSIDSHYHMSSIERSOLDTOHSSMLCOIMAINTRBITMTURWLIGOEHHHEOFMXOOPHWTRHFLFSSVHPLDEANCANREESOIIIOLONROEIGEOWSOIEDAOEETFESASWRIIOHLIWNTMTNSENHEBISFEEFOOSITFASBRTCNNOUDMNPEUAROTTPEEOEUOMLWIIOPMNMNIAESWYAETHBAEUITOSICCEGIIELIOUOFSCNNASRENOIUENAORHWAEOLFFNHUETMRTFAEBLAEKIAAAEENDNFLMIEEOASLEOAHIAKOUOYFRCSIHEEELLNEMTNSWFOTTNLYNDAOGESSTALYPIITNISFDSRBMSODVYAIEEDTADENECIACARHSATYHAHIIMEGGHOEOOGWEIHKHBECTETABRFRSSTASNSCANFBGDTNPIRNGRSEMCFYDTLISREOMKLHIELTOTFINIMIROEDNSESBULLNPDIIBEEDRAOTHHNEGEOBESIETTRGAHLUFEYGTAISDHOCUYTVEUEHAEAEEOUCSIEMOHEWTTSTOEAEDGIMHRDOEEAABBDLTAOOKNOFWYFENNSDRNMSTROONFTFWOEORKOUREDSTCHTCRUA";
        String puzzleHint = "FINDSHIMSELFMASTEROFHISOWNESTABLISHMENTWERESUFFICIENTTOABSORBALLMYATTENTIONWHILEHOLMESWHOLOATHEDEVERYFORMOFSOCIETYWITHHISWHOLEBOHEMIANSOULREMAINEDINOURLODGINGSINBAKERSTREETBURIEDAMONGHISOLDBOOKS";
        int puzzlekey1Length = 13;
        int puzzlekey2Length = 16;
        int testKey1 = key1.length();
        int testKey2 = key2.length();
        String attackedText = "";
        Encryptor e = new Encryptor();
        Decryptor d = new Decryptor();
        Attacker a = new Attacker();

//        List<List<Integer>> permutations =
//                Generator.permutation(1, 2, 3,4,5,6,7,8,9,10,11)
//                        .simple()
//                        .stream()
//                        .collect(Collectors.<List<Integer>>toList());
//
//        permutations.stream().forEach(System.out::println);

//        System.out.println("Length of puzzle: " + puzzleText2.length());
//        System.out.println("Length of hint: " + puzzleHint.length());
//        System.out.println("difference : " + (puzzleText2.length() - puzzleHint.length()));

//         First we encode
//        cipherText = e.createCipher(originaPlainText,key1,key2);
//        System.out.println("Your Ciphered text is: " + cipherText);
//        System.out.println("\n");

//        Then we decode
//        plainText = d.deCipher(cipherText,key1,key2);
//        System.out.println("Your Plain text is: " + plainText);
//        System.out.println("\n");

//        And now we attack!
        System.out.println("\n");
        System.out.println("Initiate Attack: ");
        attackedText = a.attackCipher(puzzleText2.toLowerCase(),puzzlekey1Length,puzzlekey2Length,puzzleHint.toLowerCase());
        System.out.println(attackedText);
//
//        //And now we attack!
//        System.out.println("\n");
//        System.out.println("Initiate Attack: ");
//        attackedText = a.attackCipher(cipherText,testKey1,testKey2,testHint);
//        System.out.println(attackedText);


    }




}
