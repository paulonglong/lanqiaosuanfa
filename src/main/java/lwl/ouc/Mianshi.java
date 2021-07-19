package lwl.ouc;

public class Mianshi {
    public static void main(String[] args) {
        // String[] aStrings = {"1qqq","2www","3eee","4rrr","5ttterror","6yyy","7uuu","8iii"};
        // String[] bStrings = {"1qqq","2wwwerror","3eee","4rrr","5ttt","6yyy","7uuu","8iii"};
        // List<ArrayList<String>> aLists = new ArrayList<ArrayList<String>>(2);
        // aLists.add(new ArrayList<String>());
        // aLists.add(new ArrayList<String>());
        //
        // List<ArrayList<String>> bLists = new ArrayList<ArrayList<String>>(2);
        // bLists.add(new ArrayList<String>());
        // bLists.add(new ArrayList<String>());
        //
        // for (int i = 0; i < aStrings.length; i++) {
        // int index = (aStrings[i].hashCode() & Integer.MAX_VALUE)%2;
        // aLists.get(index).add(aStrings[i]);
        // int index2 = (bStrings[i].hashCode() & Integer.MAX_VALUE)%2;
        // bLists.get(index2).add(bStrings[i]);
        // }
        //
        // System.out.println(aLists);
        // System.out.println(bLists);
        
        String a = "http:\\imgtest.ucaigou.net/image/20210508/1620458378894062434.png";
        String cdnHost = "http:\\imgtest.ucaigou.net/";
        System.out.println(a.substring(cdnHost.length()));
    }
}
