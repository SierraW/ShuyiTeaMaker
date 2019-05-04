package shuyi.operation;

import shuyi.operation.operations.Amount;

import java.util.ArrayList;
import java.util.Collection;

public class OperationList extends ArrayList<Operation> {

    @Override
    public boolean add(Operation operation) {
        boolean status = false;
        for(Operation op: this) {
            if (operation.getIngredient() == null || op.getIngredient() == null) {
                continue;
            }
            if (operation.getIngredient().equals(op.getIngredient()) && operation.isAtDefaultAmount()) {
                op.addAmount(operation);
                status = true;
            }
        }
        if (!status) {
            super.add(operation);
        }
        return status;
    }

    public boolean addAll (Collection<? extends Operation> c, String pourFrom) {
        for(Operation operation: c) {
            if (operation.prefix == null) {
                operation.setPrefix("from:"+pourFrom);
            } else {
                operation.setPrefix("from:" + pourFrom + " *" + operation.prefix);
            }

        }
        super.addAll(c);
        return true;
    }
}
