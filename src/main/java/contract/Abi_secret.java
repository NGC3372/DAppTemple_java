package contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.7.0.
 */
@SuppressWarnings("rawtypes")
public class Abi_secret extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_ADDUSER_DHKEY = "addUser_DHKey";

    public static final String FUNC_CALLER = "caller";

    public static final String FUNC_CREATEDATA_DHKEY = "createData_DHKey";

    public static final String FUNC_DEPLOYER = "deployer";

    public static final String FUNC_GETMANAGE_DHKEY = "getManage_DHKey";

    public static final String FUNC_GETUSER_DHKEY = "getUser_DHKey";

    public static final String FUNC_SETCALLER = "setCaller";

    @Deprecated
    protected Abi_secret(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Abi_secret(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Abi_secret(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Abi_secret(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addUser_DHKey(String dataName, String _userKey) {
        final Function function = new Function(
                FUNC_ADDUSER_DHKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(dataName), 
                new org.web3j.abi.datatypes.Utf8String(_userKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> caller() {
        final Function function = new Function(FUNC_CALLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createData_DHKey(String dataName, String _manageKey) {
        final Function function = new Function(
                FUNC_CREATEDATA_DHKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(dataName), 
                new org.web3j.abi.datatypes.Utf8String(_manageKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> deployer() {
        final Function function = new Function(FUNC_DEPLOYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getManage_DHKey(String dataName) {
        final Function function = new Function(FUNC_GETMANAGE_DHKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(dataName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getUser_DHKey(String user, String dataName) {
        final Function function = new Function(FUNC_GETUSER_DHKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, user), 
                new org.web3j.abi.datatypes.Utf8String(dataName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setCaller(String addr) {
        final Function function = new Function(
                FUNC_SETCALLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Abi_secret load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi_secret(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Abi_secret load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi_secret(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Abi_secret load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Abi_secret(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Abi_secret load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Abi_secret(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
