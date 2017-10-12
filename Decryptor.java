import java.util.List;

public class Decryptor {
    /**
     * some shared functions reused from encryptor
     */
    public Encryptor e = new Encryptor();

    /**
     * take cipher text and keys and work backwards to get plain text
     * @param cipher final ciphered text
     * @param key1 key used first round of ciphering
     * @param key2 key used second round of ciphering
     * @return final plain text
     */
    public String deCipher(String cipher, String key1, String key2)
    {
        int rowCount2 = e.roundUpDiv(cipher.trim().length(),key2.length());
        int columnCount2 = key2.length();
        int[] keyArray2 = e.makeKey(key2);
        Character[][] cipherTextMatrix2 = makeInvertedMatrix(cipher,columnCount2, rowCount2);
        Character[][] round2TransposeMatrix = inverseTranspose(cipherTextMatrix2, keyArray2, columnCount2, rowCount2);
        String cipherText2 = generateInverseCipherText(round2TransposeMatrix, columnCount2, rowCount2);

//        System.out.println("Ciphertext after key1: " + cipherText2);

        int rowCount1 = e.roundUpDiv(cipherText2.trim().length(),key1.length());
        int columnCount1 = key1.length();
        int[] keyArray1 = e.makeKey(key1);
        Character[][] cipherTextMatrix1 = makeInvertedMatrix(cipherText2,columnCount1, rowCount1);
        Character[][] round1TransposeMatrix = inverseTranspose(cipherTextMatrix1, keyArray1, columnCount1, rowCount1);
        String cipherText1 = generateInverseCipherText(round1TransposeMatrix, columnCount1, rowCount1);



        return cipherText1;
    }

    /**
     * takes ciphered text, and puts in matrix column first
     * @param plainText actually ciphered text, just havent renamed it
     * @param columnCount key length
     * @param rowCount text divided by key
     * @return matrix which will be inversely transposed using given key in sep function
     */
    public Character[][] makeInvertedMatrix(String plainText, int columnCount, int rowCount)
    {

        int ptCount = 0;
        Character[][] cipherTextMatrix1 = new Character[columnCount][rowCount];
        Character[] ptSplit1 = plainText.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        System.out.println('\n');
        System.out.println("invert");
        System.out.println('\n');
        for(int i = 0; i < columnCount; i++)
        {
            for(int j = 0; j < rowCount; j++)
            {
                if(ptCount < ptSplit1.length) {
                    cipherTextMatrix1[i][j] = ptSplit1[ptCount];
                }
                else
                {
                    cipherTextMatrix1[i][j] = ' ';
                }
                ptCount++;
            }
        }

        for(int i = 0; i < rowCount; i++)
        {
            String tempRow = "";
            for(int j = 0; j < columnCount; j++)
            {
                tempRow = tempRow + cipherTextMatrix1[j][i];
            }
//            System.out.println("|" + tempRow + "|");
        }

        return cipherTextMatrix1;
    }

    /**
     * Takes inverted matrix, and key, and transposes it to get plain text, or first round cipher text
     * @param initialMatrix inverted matrix
     * @param key key used to transpose inversely(list)
     * @param columnCount length of key
     * @param rowCount text divided by key
     * @return either first round of transposing, or final plain text matrix
     */
    public Character[][] inverseTranspose(Character[][] initialMatrix, List<Integer> key, int columnCount, int rowCount)
    {
        Character[][] transposedM = new Character[columnCount][rowCount];

        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < columnCount; j++)
            {
                transposedM[key.get(j)][i] = initialMatrix[j][i];
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
            //System.out.println("|" + tempRow + "|");
        }
        return transposedM;
    }

    /**
     * Same as above, but overrided with diff input param for key
     * @param initialMatrix
     * @param key
     * @param columnCount
     * @param rowCount
     * @return
     */
    public Character[][] inverseTranspose(Character[][] initialMatrix, int[] key, int columnCount, int rowCount)
    {
        Character[][] transposedM = new Character[columnCount][rowCount];

        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < columnCount; j++)
            {
                transposedM[key[j]][i] = initialMatrix[j][i];
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
            //System.out.println("|" + tempRow + "|");
        }
        return transposedM;
    }

    /**
     * takes inverted matrix and generates cipher text after round 1, or final plain text
     * @param cipherMatrix matrix used to generate text
     * @param columnCount
     * @param rowCount
     * @return
     */
    public String generateInverseCipherText(Character[][] cipherMatrix, int columnCount, int rowCount)
    {
        String tempCText = "";
        for(int i = 0; i < rowCount; i++)
        {
            for(int j = 0; j < columnCount; j++)
            {
                tempCText = tempCText + cipherMatrix[j][i];
            }

        }
        return tempCText;
    }


}
