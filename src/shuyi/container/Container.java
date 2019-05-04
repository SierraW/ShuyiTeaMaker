package shuyi.container;

import shuyi.operation.Operation;
import shuyi.operation.OperationList;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Container implements Serializable, PrintableContainer {
    private OperationList operationList;

    public Container() {
        empty();
        operationList = new OperationList();
    }

    public void operate(Operation operation) {
        operationList.add(operation);
    }

    public void pourIn(ArrayList<Operation> operations, Container source) {
        this.operationList.addAll(operations,source.getName());
    }

    public void empty() {
        operationList = new OperationList();
    }

    public OperationList getOperationList() {
        return operationList;
    }

    protected String getDescriptions() {
        if (operationList.size() == 0) {
            return "\nnone\n";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (Operation op: operationList) {
            stringBuilder.append(op.getDescriptions());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return operationList.size() == 0;
    }

    public abstract String getName();
}
