import contract.Abi_table;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.concurrent.ExecutionException;

public class run {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*myWeb3 w3 = new myWeb3();

        try {
            w3.callContract();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Admin w3 = Admin.build(new HttpService("https://ropsten.infura.io/v3/83b3315113a246e88abb1268847b4a5b"));
        ContractGasProvider provider = new DefaultGasProvider();
        Credentials credentials = Credentials.create("7b4c51a5ccd307aa0cb5c0577744d3c8280916d4cb0552e1b2d10f42a000206f");
        Abi_table table = Abi_table.load("0x489F157C67583cF895F9011783422f421F8D85bD"
                ,w3, credentials, provider);
        try {
            String result = table.scecrtKeyContractAddress().send();
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
