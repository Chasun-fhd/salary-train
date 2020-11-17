package binarytree;

/**
 * @author: haidong.feng
 * @createdAt: 2020/10/12
 * @description:
 **/
public class BinaryTreeOps {

    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1, t = T.length() - 1;
        int skipS = 0, skipT = 0;
        //从字符串尾部开始查找，遇到 # 往前跳一步, 如果不是 #,那么移动下表 s--
        //有一个#就对应要删除一个非 #字符，那么最后skipS == 0时，则表示已经没有需要删除的字符，
        //此时直接比较剩余字符串的对应位字符，看是否相等即可。
        while ( s >=0 || s >= 0) {
            while (s >= 0) {
                char ch = S.charAt(s);
                if (ch == '#') {
                    skipS++;
                    s--;
                } else if(skipS > 0) {
                    skipS--;
                    s--;
                } else {
                    break;
                }
            }

            while ( t>= 0) {
                char ch = T.charAt(t);
                if (ch == '#') {
                    skipT++;
                    t--;
                } else if(skipT > 0) {
                    skipT--;
                    t--;
                } else {
                    break;
                }
            }

            if ( s >= 0 && t >= 0) {
                if (S.charAt(s) != T.charAt(t)) {
                    return false;
                }
            } else if (s >= 0 || t >= 0) {
                return false;
            }
            s--;
            t--;
        }
        return true;
    }

    public static void main(String[] args) {
        new BinaryTreeOps().backspaceCompare("a#b", "a##b");
    }
}
