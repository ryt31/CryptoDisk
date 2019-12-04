import java.util.*;

public class CryptoDisk {

    public static void main(String[] args) {
        String plainText = "hello"; // 平文
        List<String> plainSplitList = SplitText(plainText); // 平文を１文字ずつ分けたリスト
        String encryptedText = ""; // 暗号化された文
        int randomNumber = 0; // 引いた乱数を最終的にプリント
        Random randomNum = new Random(); // Randomクラスのインスタンスを生成

        ///////////// 暗号円盤 /////////////
        // 外側の文字列
        List<String> outerText =
                new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"));
        // 内側の文字列
        List<String> innerText =
                new ArrayList<>(Arrays.asList("b","h","i","m","e","p","k","n","j","a","o","d","l","c","g","f"));
        ///////////// 内側の文字列の追加 /////////////
        List<String> innerText2 =
                new ArrayList<>(Arrays.asList("c","g","k","i","x","z","y","p","q","a","l","t","u","v","z","d"));

        List<String> innerText3 =
                new ArrayList<>(Arrays.asList("d","z","v","u","t","l","a","q","p","i","z","x","y","c","k","g"));
        ///////////////////////////////////////////

        // 平文１文字ずつのリストの文字と外側の文字列を照らし合わせリストの要素番号を取得する
        List<Integer> indexList = GetIndexList(plainSplitList,outerText);

        randomNumber = randomNum.nextInt(3) + 1; // 乱数を出す

        // 暗号化された文を求める
        // 乱数で３通りの内側の文字列を選ぶ
        if(randomNumber == 1) {
            randomNumber = 1;
            encryptedText = GetEncryptedText(encryptedText, indexList, innerText);
        }else if(randomNumber == 2){
            randomNumber = 2;
            encryptedText = GetEncryptedText(encryptedText, indexList, innerText2);
        }else if(randomNumber == 3){
            randomNumber = 3;
            encryptedText = GetEncryptedText(encryptedText, indexList, innerText3);
        }else {
            System.out.println("やり直してください");
        }

        // 結果をプリント
        System.out.println(encryptedText);
        System.out.println("引いた乱数の値は：" + randomNumber);

    }

    // 平文１文字ずつ分けてリストに格納
    private static List<String> SplitText(String plainText){
        List<String> charList = new ArrayList<>();

        for(int i=0;i < plainText.length();i++){
            charList.add(String.valueOf(plainText.charAt(i)));
        }
        return charList;
    }

    // 平文１文字ずつのリストの文字と外側の文字列を照らし合わせリストの要素番号を取得するメソッド
    private  static List<Integer> GetIndexList(List<String> plainSplitList, List<String> outerText){
        List<Integer> indexList = new ArrayList<>();
        for(int i=0;i<plainSplitList.size();i++){
            if(outerText.contains(plainSplitList.get(i))){
                indexList.add(outerText.indexOf(plainSplitList.get(i)));
            }
        }
        return indexList;
    }

    // 暗号化された文を求めるメソッド
    private static String GetEncryptedText(String encryptedText,List<Integer> indexList,List<String> innerText){
        StringBuilder stringBuilder = new StringBuilder(encryptedText);

        for(int i=0;i < indexList.size();i++){
            stringBuilder.append(innerText.get(indexList.get(i)));
        }

        return  stringBuilder.toString();
    }

}
