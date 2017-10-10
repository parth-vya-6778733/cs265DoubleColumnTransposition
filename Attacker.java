import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Attacker {
    public Encryptor e = new Encryptor();
    public Decryptor d = new Decryptor();
    public ArrayList<String> cipherTextList = new ArrayList<String>();


    public String attackCipher(String cipherText, int keyLength1, int keyLength2, String hintText)
    {
        int rowCount2 = e.roundUpDiv(cipherText.length(),keyLength2);
        int columnCount2 = keyLength2;
        List<List<Integer>> permKeyList = makePermutedKey(keyLength2);



        Character[][] cipherTextMatrix2 = d.makeInvertedMatrix(cipherText,columnCount2, rowCount2);
        System.out.println("First Round");
        for(List<Integer> permKeyArray : permKeyList)
        {
            Character[][] round2TransposeMatrix = d.inverseTranspose(cipherTextMatrix2, permKeyArray, columnCount2, rowCount2);
            cipherTextList.add(d.generateInverseCipherText(round2TransposeMatrix, columnCount2, rowCount2));
        }

        List<List<Integer>> permKeyList2 = makePermutedKey(keyLength1);
        for(String cipherText2 : cipherTextList)
        {
            int rowCount1;
            System.out.println("Round 1 Cipher text : " + cipherText2);
            rowCount1 = e.roundUpDiv(cipherText2.trim().length(), keyLength1);

            int columnCount1 = keyLength1;

            Character[][] cipherTextMatrix1 = d.makeInvertedMatrix(cipherText2, columnCount1, rowCount1);

            for(List<Integer> permKeyArray : permKeyList2) {
                System.out.println("Second Round");
                Character[][] round1TransposeMatrix = d.inverseTranspose(cipherTextMatrix1, permKeyArray, columnCount1, rowCount1);
                String cipherText1 = d.generateInverseCipherText(round1TransposeMatrix, columnCount1, rowCount1);
                System.out.println("PT Text: " + cipherText1);
                if(cipherText1.contains(hintText))
                {
                    System.out.println("Cipher Text length: " + cipherText.length());
                    System.out.println("Plain Text length: " + cipherText1.length());
                    return "Attacked Plain Text is: " + cipherText1;
                }
            }

        }


        return "Attacked but not found!";
    }

    public List<List<Integer>> makePermutedKey(int keyLength)
    {
        List<Integer> numberedKey = new ArrayList<Integer>();
        for(int i = 0; i < keyLength; i++)
        {
            numberedKey.add(i);
        }

        return Generator.permutation(numberedKey)
                        .simple()
                        .stream()
                        .collect(Collectors.<List<Integer>>toList());

       // permute(numberedKey,keyLength);

    }
// using heaps algo for permutations
//    private void permute(int[] a, int l) {
//        if (l == 1) {
//            int[] val = new int[a.length];
//            int counter = 0;
//            for(int i : a) {
//                val[counter] = i;
//                counter++;
//            }
//            permutedList.add(val);
//            return;
//        }
//        for (int i = 0; i < l; i++)
//        {
//            permute(a, l - 1);
//            if (l % 2 == 1)
//            {
//                swap(a, 0, l - 1);
//            }
//            else
//            {
//                swap(a, i, l - 1);
//            }
//        }
//    }
//
//    private void swap(int[] a, int i, int j) {
//        int x = a[i];
//        a[i] = a[j];
//        a[j] = x;
//    }

}
