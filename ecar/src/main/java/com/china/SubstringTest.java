package com.china;

public class SubstringTest {
    public static void main(String[] args) {
        /*String outputStr = "长沙市天心区高云路77号龙湾国际三期测试小区 ";
        //如果返回地址是以小区为结尾的，则去掉小区两个字
        if(outputStr.trim().endsWith("小区")){
            outputStr=outputStr.substring(0,outputStr.indexOf("小区"));
        }
        System.out.println(outputStr);*/
        /*String str= "0小区为空";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1));*/

        /*String xmlTest =  "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<PGK>\n" +
                "  <DATA><![CDATA[<?xml version=\"1.0\" encoding =\"GBK\"?><CBSERPPGK><INFO><ERPTYP>H</ERPTYP><ERRMSG></ERRMSG><FUNNAM>ERQRYTRS</FUNNAM><RETCOD>0000000</RETCOD></INFO><EREXPTRSZ><ACTBAL>-98218.00</ACTBAL><ACTNAM>123412341234</ACTNAM><ACTNBR>123412341234</ACTNBR><BNKFLW>123412341234</BNKFLW><BNKTIM>2021-06-01 17:16:02.0</BNKTIM><BNKTYP></BNKTYP><CCYNBR>10</CCYNBR><CLTSEQ>123412341234</CLTSEQ><DTLSEQ>2479824</DTLSEQ><ITMDIR>1</ITMDIR><OTHACT>1234qwer</OTHACT><OTHNAM>一个客商</OTHNAM><OTHOPN>招行</OTHOPN><TRSBAL>100000.00</TRSBAL><UPDTIM>2021-06-01 17:16:27.869</UPDTIM><VCDSTS>1</VCDSTS><VLTDAT>2021-06-01</VLTDAT><WHRFRM>U</WHRFRM></EREXPTRSZ></CBSERPPGK>]]></DATA>\n" +
                "  <CHECKCODE>Z929CAAF3</CHECKCODE>\n" +
                "</PGK>";
        String result = xmlTest.substring(xmlTest.indexOf("CDATA[")+6,xmlTest.indexOf("]]"));
        System.out.println(result);*/
        String payStr = "银行存款账户||厦门望润资产管理有限公司||9020510030010000105962||1300.0||2021/06/23 00:00:00,厦门望润资产管理有限公司-银行存款账户||厦门望润资产管理有限公司||129910100100608603||500.0||2021/06/25 00:00:00\n";
        String []payAccount = payStr.split(",");
        for(String payAcc:payAccount){
            String[] payaccount =payAcc.split("\\|\\|");
            for (String acc:payaccount){
                System.out.println(acc);
            }
        }
        //System.out.println(payAccount[0]);
        //System.out.println(payAccount[1]);
    }
}
