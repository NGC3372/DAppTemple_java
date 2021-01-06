import contract.Abi_table;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class myWeb3 {
    private Admin w3;
    private String url = "https://ropsten.infura.io/v3/83b3315113a246e88abb1268847b4a5b";

    public myWeb3(){
        w3 = Admin.build(new HttpService(url));
    }

    public myWeb3(String new_url){
        w3 = Admin.build(new HttpService(new_url));
    }

    public String transaction(String from , String privateKey , String to) throws ExecutionException, InterruptedException {
        Credentials credentials = Credentials.create(privateKey);
        RawTransaction transaction = RawTransaction.
                createEtherTransaction(getNonce(from), BigInteger.valueOf(1000000000),
                        BigInteger.valueOf(300000),to,BigInteger.valueOf(100000000000000000L));
        byte[] signedMessage = TransactionEncoder.signMessage(transaction,credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = w3.ethSendRawTransaction(hexValue).sendAsync().get();
        return ethSendTransaction.getTransactionHash();
    }

    public BigInteger getNonce(String address) throws ExecutionException, InterruptedException {
        EthGetTransactionCount get  = null;
        get = w3.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = get.getTransactionCount();
        return nonce;
    }

    public void callContract() throws Exception {
        Credentials credentials = Credentials.create("7b4c51a5ccd307aa0cb5c0577744d3c8280916d4cb0552e1b2d10f42a000206f");
        ContractGasProvider provider = new DefaultGasProvider();
        Abi_table table = Abi_table.load("0x489F157C67583cF895F9011783422f421F8D85bD"
                ,w3, credentials, provider);
        System.out.println("result:" + table.scecrtKeyContractAddress().send());
    }

    public void useContact() throws Exception {
        /*Credentials credentials = Credentials.create("7b4c51a5ccd307aa0cb5c0577744d3c8280916d4cb0552e1b2d10f42a000206f");
        ContractGasProvider provider = new StaticGasProvider(new BigInteger("100000"),new BigInteger("200000"));
        helloContract contract = helloContract.load("0xBa1Be0a85734CEbaEad994662C762Da40b40cb3b",
                w3, credentials, provider);
        System.out.println("result:" + contract.transaction("helo!!").send());*/
    }
}
