import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Encryptor {

    /**
     * Take plain text and run through column transposition twice to get cipher text
     * @param plainText
     * @param key1 key used to transpose to get ciphertext 1/ matrix 1
     * @param key2 key used to transpose to get ciphertext 2/ matrix 2
     * @return final ciphered text
     */
    public String createCipher(String plainText, String key1, String key2)
    {
        int rowCount1 = roundUpDiv(plainText.length(),key1.length());
        int columnCount1 = key1.length();
        int[] keyArray1 = makeKey(key1);
        Character[][] cipherTextMatrix1 = makeMatrix(plainText,columnCount1, rowCount1);
        Character[][] round1TransposeMatrix = transpose(cipherTextMatrix1, keyArray1, columnCount1, rowCount1);
        String cipherText1 = generateCipherText(round1TransposeMatrix, columnCount1, rowCount1);

        System.out.println("Ciphertext after key1: " + cipherText1);

        int rowCount2 = roundUpDiv(cipherText1.length(),key2.length());
        int columnCount2 = key2.length();
        int[] keyArray2 = makeKey(key2);
        Character[][] cipherTextMatrix2 = makeMatrix(cipherText1,columnCount2, rowCount2);
        Character[][] round2TransposeMatrix = transpose(cipherTextMatrix2, keyArray2, columnCount2, rowCount2);
        String cipherText2 = generateCipherText(round2TransposeMatrix, columnCount2, rowCount2);

        return cipherText2;
    }

    /**
     * Takes key which takes string word, and reorders is in alphabetical order, and return the key to
     * transpose
     * @param key key word
     * @return key to transpose
     */
    public int[] makeKey(String key)
    {
        Character[] key1Split = key.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int[] numberedKey = new int[key.length()];

        // putting key into hashmap, and then using treemap to re-order
        Map<Character,Integer> keyUnordered = new HashMap<Character,Integer>();
        for(int i = 0; i < key1Split.length; i++)
        {
            keyUnordered.put(key1Split[i],i);
        }
        Map<Character, Integer> keyOrdered = new TreeMap<Character, Integer>(keyUnordered);

        //finally putting key into array for transposing
        int count = 0;
        for(Character k : keyOrdered.keySet())
        {
            numberedKey[count] = keyOrdered.get(k);
            System.out.println("key: " + numberedKey[count]);
            count++;
        }

        return numberedKey;
    }

    /**
     * Create matrix base on text, and key
     * @param plainText to insert in matrix
     * @param columnCount key for column length
     * @param rowCount plain text count divided by key to get row length( plus 1 if not exact value)
     * @return character matrix which will be used to transpose using the key
     */
    public Character[][] makeMatrix(String plainText, int columnCount, int rowCount)
    {

        int ptCount = 0;
        Character[][] cipherTextMatrix1 = new Character[columnCount][rowCount];
        Character[] ptSplit1 = plainText.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < columnCount; j++)
            {
                if(ptCount < ptSplit1.length) {
                    cipherTextMatrix1[j][i] = ptSplit1[ptCount];
                }
                else
                {
                    cipherTextMatrix1[j][i] = ' ';
                }
                ptCount++;
            }
        }
        System.out.println('\n');
        System.out.println("make matrix");
        System.out.println('\n');
        for(int i = 0; i < rowCount; i++)
        {
            String tempRow = "";
            for(int j = 0; j < columnCount; j++)
            {
                tempRow = tempRow + cipherTextMatrix1[j][i];
            }
            System.out.println("|" + tempRow + "|");
        }

        return cipherTextMatrix1;
    }

    /**
     * Take key and character matrix, and transpose to create ciphered matrix
     * @param initialMatrix
     * @param key key used for transposing matrix
     * @param columnCount length of key
     * @param rowCount plaintext / key
     * @return ciphered matrix which will be used by another function to output first round or final round of ciphered text
     */
    public Character[][] transpose(Character[][] initialMatrix, int[] key, int columnCount, int rowCount)
    {
        Character[][] transposedM = new Character[columnCount][rowCount];

        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < columnCount; j++)
            {
                transposedM[j][i] = initialMatrix[key[j]][i];
            }
        }

        System.out.println('\n');
        System.out.println("tpose");
        System.out.println('\n');

        for(int i = 0; i < rowCount; i++)
        {
            String tempRow = "";
            for(int j = 0; j < columnCount; j++)
            {
                tempRow = tempRow + transposedM[j][i];
            }
            System.out.println("|" + tempRow + "|");
        }
        return transposedM;
    }

    /**
     * takes the ciphered matrix and outputs a ciphered text
     * @param cipherMatrix self explanatory
     * @param columnCount
     * @param rowCount
     * @return first round or final rounds ciphered text
     */
    public String generateCipherText(Character[][] cipherMatrix, int columnCount, int rowCount)
    {
        String tempCText = "";
        for(int i = 0; i < columnCount; i++)
        {
            for(int j = 0; j < rowCount; j++)
            {
                tempCText = tempCText + cipherMatrix[i][j];
            }
        }
        return tempCText;
    }

    /**
     * used to return row length based on irregular matrix, one with padding full of blank spaces
     * @param x plain text
     * @param y key
     * @return row length
     */
    public int roundUpDiv(int x, int y)
    {
        if(x%y == 0)
        {
            return x/y;
        }
        else
        {
            return x/y+1;
        }
    }
}
