import contract.Abi_manage;
import contract.Abi_secret;
import contract.Abi_storage;
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
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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

    private Abi_table tableContract;
    private Abi_manage manageContract;
    private Abi_secret secretContract;
    private Abi_storage storageContract;


    public myWeb3(){
        w3 = Admin.build(new HttpService(url));
        //ContractGasProvider provider  = new DefaultGasProvider();
        ContractGasProvider provider = new StaticGasProvider(new BigInteger("100000"),new BigInteger("200000"));
        Credentials user = Credentials.create("0d64c5cd990153ce7d79ab5a0c4255b9f34ea17862ded1bd53f4408eb6ebe4d9");
        tableContract = Abi_table.load("0x489F157C67583cF895F9011783422f421F8D85bD",
                w3, user, provider);
        manageContract = Abi_manage.load("0x52B49a8DF0F9A03C0a35BC5c8Db3e7888B60E400",
                w3, user, provider);
        secretContract = Abi_secret.load("0xCA0D34C770835A58340CC7731b484c0Ae1e9a2d6",
                w3, user, provider);
        storageContract = Abi_storage.load("0x26AAA1C996324a56F2755726cAC15FEaA618FD21",
                w3, user, provider);

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

    public String getContractAddress(String contractName) throws Exception {
        String address = "" ;
        switch (contractName){
            case "storage":address = tableContract.dataStorageContractAddress().send();
                break;
            case "manage": address = tableContract.dataManageContractAddress().send();
                break;
            case "secret": address = tableContract.scecrtKeyContractAddress().send();
        }
        return address;
    }

    public String getUserDHkey(String address, String dataName) throws Exception {
        String key = secretContract.getUser_DHKey(address, dataName).send();
        return key;
    }

    public String getUserData(String address , String dataName) throws Exception {
        String data = storageContract.getUserData(address, dataName).send();
        return data;
    }

    public String getPublicData(String dataName) throws Exception {
        String content = storageContract.getPublicData(dataName).send();
        return content;
    }

    public String getPublicDataDhKey(String dataName) throws Exception {
        String key = secretContract.getManage_DHKey(dataName).send();
        return key;
    }

    public String setUserData(String dataName, String content) throws Exception {
        TransactionReceipt hash = manageContract.setUserData(dataName, content).send();
        return hash.getTransactionHash();
    }

    public String setUserDHkey(String dataName, String DHkey) throws Exception {
        TransactionReceipt hash = secretContract.addUser_DHKey(dataName, DHkey).send();
        return hash.getTransactionHash();
    }


}
