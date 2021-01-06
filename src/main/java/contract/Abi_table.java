package contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class Abi_table extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_CALLER = "caller";

    public static final String FUNC_DATAMANAGECONTRACTADDRESS = "dataManageContractAddress";

    public static final String FUNC_DATASTORAGECONTRACTADDRESS = "dataStorageContractAddress";

    public static final String FUNC_DEPLOYER = "deployer";

    public static final String FUNC_SCECRTKEYCONTRACTADDRESS = "scecrtKeyContractAddress";

    public static final String FUNC_SETCALLER = "setCaller";

    public static final String FUNC_SETDATAMANAGECONTRACTADDRESS = "setDataManageContractAddress";

    public static final String FUNC_SETDATASTORAGECONTRACTADDRESS = "setDataStorageContractAddress";

    public static final String FUNC_SETSCECRTKEYCONTRACTADDRESS = "setScecrtKeyContractAddress";

    @Deprecated
    protected Abi_table(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Abi_table(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Abi_table(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Abi_table(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> caller() {
        final Function function = new Function(FUNC_CALLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> dataManageContractAddress() {
        final Function function = new Function(FUNC_DATAMANAGECONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> dataStorageContractAddress() {
        final Function function = new Function(FUNC_DATASTORAGECONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> deployer() {
        final Function function = new Function(FUNC_DEPLOYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> scecrtKeyContractAddress() {
        final Function function = new Function(FUNC_SCECRTKEYCONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setCaller(String addr) {
        final Function function = new Function(
                FUNC_SETCALLER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDataManageContractAddress(String addr) {
        final Function function = new Function(
                FUNC_SETDATAMANAGECONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDataStorageContractAddress(String addr) {
        final Function function = new Function(
                FUNC_SETDATASTORAGECONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setScecrtKeyContractAddress(String addr) {
        final Function function = new Function(
                FUNC_SETSCECRTKEYCONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Abi_table load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi_table(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Abi_table load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi_table(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Abi_table load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Abi_table(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Abi_table load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Abi_table(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
