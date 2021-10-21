package 枚举类与注解;

public class ColorEnum {
    public static void main(String[] args) {
        System.out.println(isRead(Color.RED));
        System.out.println(isRead(Color.BLANK));

        descripColor(Color.BLANK);
    }

    public enum Color{
        RED,BLANK,BLUE,GREEN;
    }

     static boolean isRead(Color color){
        if(color.RED.equals(color)){
            return true;
        }else return false;
     }

     static void descripColor(Color color){
        switch (color){
            case RED:
                System.out.println("红色");
                return;
            case BLANK:
                System.out.println("黑色");
                return;
            case GREEN:
                System.out.println("绿色");
        }
     }
}
