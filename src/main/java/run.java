import contract.Abi_table;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.util.concurrent.ExecutionException;

public class run {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        myWeb3 w3 = new myWeb3();
        String result = null;
        try {
            //result = w3.getContractAddress("manage");
            //result = w3.setUserData("hello","QmQy6xmJhrcC5QLboAcGFcAE1tC8CrwDVkrHdEYJkLscrQ");
            //result = w3.getUserData("0x61bEa2058e8d5a01F1f9898E49F53Cc3cc8E6520", "hello");
            //result = w3.getPublicData("data1");
            result = w3.getPublicDataDhKey("dataTest");
            //result = w3.setUserDHkey("hello", "QmbsPcceqURmvYHWFHjo4PfmGbRgEaCBVc6BoNjSHF4Rru");
            //result = w3.getUserDHkey("0x61bEa2058e8d5a01F1f9898E49F53Cc3cc8E6520","hello");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
