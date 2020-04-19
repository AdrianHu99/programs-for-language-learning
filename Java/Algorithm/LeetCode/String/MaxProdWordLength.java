public class MaxProdWordLength {
    public int maxProduct(String[] words) {
        int ans = 0;
        int l = words.length;
        int hash = 0;
        for( int i = 0; i < l; i++){
            int leng = words[i].length();
            for(int k = 0; k < leng; k++){
                int a = words[i].charAt(k)-'a';
                hash |= (1<<a);
            }
            for(int j = i+1;j < l; j++){
                int le = words[j].length();
                int cont = 0;
                for(int k = 0; k < le; k++){
                    int b = words[j].charAt(k) - 'a';
                    if((hash&(1<<b)) > 0){
                        cont = 1;
                        break;
                    }
                }
                if(cont == 1){
                    continue;
                }else{
                    ans = Math.max(ans, leng*le);
                }
            }
            hash = 0;
        }
        return ans;
    }
}