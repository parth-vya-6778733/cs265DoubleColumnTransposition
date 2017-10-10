import java.util.List;

public class Decryptor {
    public Encryptor e = new Encryptor();

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
