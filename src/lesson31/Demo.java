package lesson31;

public class Demo {
    public static void main(String[] args) {

        System.out.println(Solution.countSymbols("ab1c, a2bc !!! bcd 3    d% ff"));

        System.out.println(Solution.countSymbols(""));

        System.out.println(Solution.words("aaa% abc aaa bbb bbb d vv   gh34r "));

        System.out.println(Solution.words(""));

        System.out.println("---Solution2---");

        System.out.println(Solution2.countSymbols("ab1c, a2bc !!! bcd 3    d% ff"));

        System.out.println(Solution2.countSymbols(""));

        System.out.println(Solution2.words("aaa% abc aaa bbb bbb d vv   gh34r "));

        System.out.println(Solution2.words(""));

    }
}
