package io.apicurio.hub.api.codegen.jaxrs;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.Operation;
import io.apicurio.datamodels.models.openapi.OpenApiPathItem;
import io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter;
import io.apicurio.datamodels.models.visitors.TraversalContext;
import io.apicurio.datamodels.models.visitors.TraversingVisitor;
import io.apicurio.datamodels.util.NodeUtil;

public abstract class TraversingOpenApi30VisitorAdapter extends OpenApi30VisitorAdapter implements TraversingVisitor {

    protected static final JsonNodeFactory factory = JsonNodeFactory.instance;

    protected TraversalContext traversalContext;

    /**
     * @see io.apicurio.datamodels.models.visitors.TraversingVisitor#setTraversalContext(io.apicurio.datamodels.models.visitors.TraversalContext)
     */
    @Override
    public void setTraversalContext(TraversalContext context) {
        this.traversalContext = context;
    }

    protected String getPathTemplate(OpenApiPathItem pathItem) {
        if (NodeUtil.isDefinition(pathItem)) {
            return null;
        } else {
            return getMappedNodeName(pathItem);
        }
    }

    protected String getOperationMethod(Operation operation) {
        return (String) this.traversalContext.getMostRecentStep().getValue();
    }

    protected String getMappedNodeName(Node node) {
        return (String) this.traversalContext.getMostRecentStep().getValue();
    }

}
