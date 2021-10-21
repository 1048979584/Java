package 常用类;

/**
 * 将一个字符串进行反转，将指定部分进行进行反转，比如“abcdefg”反转为“abfedcg"
 */

public class StringReverse {
    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        String str = "abcdefg";
        String str2= stringReverse.reverse(str,2,5);
        String str3= stringReverse.reverse2(str,2,5);
        String str4= stringReverse.reverse3(str,2,5);
        String str5= stringReverse.reverse3(str,2,5);
        System.out.println("原字符串："+str);
        System.out.println("方式一反转："+str2);
        System.out.println("方式二反转："+str3);
        System.out.println("方式三反转："+str4);
        System.out.println("方式四反转："+str5);
    }
    //方式一：转换为char[]
    public String reverse(String str , int startIndex,int endIndex){
        if(str!=null &&str.length()!=0){
            char[] arr = str.toCharArray();
            for(int x= startIndex,y=endIndex;x<y;x++,y--){
                char temp = arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);   //字符数组转换为字符串的方法
        }
        return null;
    }
    //方式二：使用string拼接  拼接字符串str.substring ,拼接str.charAt
    public String reverse2(String str , int startIndex,int endIndex){
        if(str!=null){
            //第一部分
            String reverseStr = str.substring(0,startIndex);
            //第二部分
            for(int i=endIndex;i>=startIndex;i--){
                reverseStr+=str.charAt(i);
            }
            //第三部分
            reverseStr+=str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }
    //方式三：使用stringBulider提高效率
    public String reverse3(String str,int startIndex,int endIndex){
        StringBuilder stringBuilder =new StringBuilder(str.length());
        if(str!=null){
            //第一部分
            stringBuilder.append(str.substring(0,startIndex));
            //第二部分
            for(int i=endIndex ;i>=startIndex;i--){
                stringBuilder.append(str.charAt(i));
            }
            //第三部分
            stringBuilder.append(str.substring(endIndex+1));
            return stringBuilder.toString();
        }
        return null;
    }
    //方式四：使用stringBulider提高效率
    public String reverse4(String str,int startIndex,int endIndex){
        StringBuffer stringBuffer =new StringBuffer(str.length());
        if(str!=null){
            //第一部分
            stringBuffer.append(str.substring(0,startIndex));
            //第二部分
            for(int i=endIndex ;i>=startIndex;i--){
                stringBuffer.append(str.charAt(i));
            }
            //第三部分
            stringBuffer.append(str.substring(endIndex+1));
            return stringBuffer.toString();
        }
        return null;
    }

}
