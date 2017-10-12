import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Attacker {
    public Encryptor e = new Encryptor();
    public Decryptor d = new Decryptor();
    public ArrayList<String> cipherTextList = new ArrayList<String>();
    public ArrayList<int[]> permutedList = new ArrayList<>();

    /**
     * takes the cipher text, key lengths, and hint text if given to find plain text
     * @param cipherText
     * @param keyLength1
     * @param keyLength2
     * @param hintText
     * @return the final plain text
     */
    public String attackCipher(String cipherText, int keyLength1, int keyLength2, String hintText)
    {
        int rowCount2 = e.roundUpDiv(cipherText.length(),keyLength2);
        int columnCount2 = keyLength2;
        permutedList = new ArrayList<>();
        makePermutedKey(keyLength2);


        Character[][] cipherTextMatrix2 = d.makeInvertedMatrix(cipherText,columnCount2, rowCount2);
        System.out.println("First Round");
        for(int[] permKeyArray : permutedList)
        {
            Character[][] round2TransposeMatrix = d.inverseTranspose(cipherTextMatrix2, permKeyArray, columnCount2, rowCount2);
            cipherTextList.add(d.generateInverseCipherText(round2TransposeMatrix, columnCount2, rowCount2));
        }

        permutedList = new ArrayList<>();
        makePermutedKey(keyLength1);
        for(String cipherText2 : cipherTextList)
        {
            int rowCount1;
            System.out.println("Round 1 Cipher text : " + cipherText2);
            rowCount1 = e.roundUpDiv(cipherText2.trim().length(), keyLength1);

            int columnCount1 = keyLength1;

            Character[][] cipherTextMatrix1 = d.makeInvertedMatrix(cipherText2, columnCount1, rowCount1);

            for(int[] permKeyArray : permutedList) {
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

    /**
     * takes key length, generates list of permuted keys
     * problem when key size is > 10, running into out of heap memory
     * @param keyLength
     * @return
     */
    public void makePermutedKey(int keyLength)
    {
        List<Integer> numberedKey = new ArrayList<Integer>();
        int[] numbkey = new int[keyLength];
        String val = "";
        for(int i = 0; i < keyLength; i++)
        {
            numbkey[i] = i;
        }


        permute(numbkey,keyLength);


    }
// using heaps algo for permutations
    private void permute(int[] a, int l) {
        if (l == 1) {
            int[] val = new int[a.length];
            int counter = 0;
            for(int i : a) {
                val[counter] = i;
                counter++;
            }
            this.permutedList.add(val);
            return;
        }
        for (int i = 0; i < l; i++)
        {
            permute(a, l - 1);
            if (l % 2 == 1)
            {
                swap(a, 0, l - 1);
            }
            else
            {
                swap(a, i, l - 1);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

}
